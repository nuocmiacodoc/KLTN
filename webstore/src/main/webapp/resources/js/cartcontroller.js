var cartApp = angular.module('cartApp', []);

cartApp.directive('myRepeatDirective', function() {
	  return function(scope, element, attrs) {
		    angular.element(element).css('color','blue');
		    if (scope.$last){
		    	$('.same-category-slider').slick({
					infinite: true,
					slidesToShow: 4,
					slidesToScroll: 3,
					autoplay: true,
					autoplaySpeed: 3000,
				});
		    }
		  };
		});

cartApp.controller("cartCtrl", function($scope, $http, $window) {
	 $scope.cartCount = 0;
	 $scope.className = "cart-countnumber-none"
	
    $scope.refreshCart = function(cartId) {
        $http.get('/webstore/rest/cart/' + $scope.cartId)
            .success(function(data) {
                $scope.cart = data;
                $scope.countCartItems();
            });
    };
    
    $scope.countCartItems = function() {
        $http.get('/webstore/rest/cart/count')
            .success(function(data) {
            	//alert(data);
                $scope.cartCount = data;
                if ($scope.cartCount == 0) {
                	$scope.className = "cart-countnumber-none"
                } else {
                	$scope.className = "cart-countnumber-block"
                };
                
            });
    };

    $scope.clearCart = function() {
        $http.delete('/webstore/rest/cart/' + $scope.cartId)
            .success(function(data) {
                $scope.refreshCart($scope.cartId);
            });
    };

    $scope.initCartId = function(cartId) {
        $scope.cartId = cartId;
        $scope.refreshCart($scope.cartId);
    };

    $scope.addToCart = function(productId) {
        $http.put('/webstore/rest/cart/add/' + productId)
            .success(function(data) {
            	$scope.countCartItems()
                alert("Đã thêm thành công sản phẩm vào giỏ hàng");
            	$window.location.reload();
            });
    };
    $scope.removeFromCart = function(productId) {
        $http.put('/webstore/rest/cart/remove/' + productId)
            .success(function(data) {
                $scope.refreshCart($scope.cartId);
            });
        
    };
    $scope.getProductsByCategory = function(categoryId) {
        $http.get('/webstore/market/rest/products/' + categoryId)
            .success(function(data) {
                $scope.productsCategoryData = data;
                var a = [];
                for (var i=0; i < $scope.productsCategoryData.totalPages; i++) {
                    a.push(i+1);
                  }
                $scope.totalPages = a;
                
                for (var i=0; i < $scope.productsCategoryData.listproducts.length; i++) {
                    var num = parseInt($scope.productsCategoryData.listproducts[i].unitPrice, 10);
                    var p = num.toFixed(2).split(".");
                    $scope.productsCategoryData.listproducts[i].unitPrice = p[0].split("").reverse().reduce(function(acc, num, i, orig) {
                        return  num=="-" ? acc : num + (i && !(i % 3) ? "," : "") + acc;
                    }, "") + " VNĐ";
                    
                }
            });
    };
    
    $scope.getProductsRecommendation = function(productId, categoryId, unitPrice) {
        $http.get('/webstore/rest/products/recommendation?productId=' + productId + '&categoryId=' + categoryId + '&unitPrice=' + unitPrice)
        .success(function(data) {
        	$scope.productsCategoryData = data;
        });
    }
    
    
});
