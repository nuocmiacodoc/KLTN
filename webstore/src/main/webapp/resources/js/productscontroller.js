var productsController = angular.module('productsController', []);

productsController.directive('laptopDirective', function() {
	  return function(scope, element, attrs) {
		    angular.element(element).css('color','blue');
		    if (scope.$last){
		    	$('.laptop-products-slider').slick({
					infinite: true,
					slidesToShow: 4,
					slidesToScroll: 3,
					autoplay: true,
					autoplaySpeed: 3000,
				});

				/*$('.smartphone-products-slider').slick({
					infinite: true,
					slidesToShow: 4,
					slidesToScroll: 3,
					autoplay: true,
					autoplaySpeed: 3000,
				});

				$('.tablet-products-slider').slick({
					infinite: true,
					slidesToShow: 4,
					slidesToScroll: 3,
					autoplay: true,
					autoplaySpeed: 3000,
				});*/
		    }
		  };
		});

productsController.directive('smartphoneDirective', function() {
	  return function(scope, element, attrs) {
		    angular.element(element).css('color','blue');
		    if (scope.$last){

				$('.smartphone-products-slider').slick({
					infinite: true,
					slidesToShow: 4,
					slidesToScroll: 3,
					autoplay: true,
					autoplaySpeed: 3000,
				});
		    }
		  };
		});

productsController.directive('tabletDirective', function() {
	  return function(scope, element, attrs) {
		    angular.element(element).css('color','blue');
		    if (scope.$last){

		    	$('.tablet-products-slider').slick({
					infinite: true,
					slidesToShow: 4,
					slidesToScroll: 3,
					autoplay: true,
					autoplaySpeed: 3000,
				});
		    }
		  };
		});

productsController.directive('categoryDirective', function() {
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


productsController.controller('productsCtrl', function($scope, $http) {
	
    $scope.getAllProducts = function() {
        $http.get('/webstore/market/rest/products')
            .success(function(data) {
                $scope.productsData = data;
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
    
    $scope.getProductsByCategoryBrandPricePage = function(categoryId, brand, lowprice, highprice, page) {
        var temp = {
            brand: brand,
            lowprice: lowprice,
            highprice: highprice,
            page: page
        }
        
        var url = '';
        
        for (filter in temp){
        	if (temp[filter]) {
        		url += filter + '=' + temp[filter] + '&';
        	}
        }

		$http.get('/webstore/market/rest/products/' + categoryId + '/?' + url)
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
    
    $scope.getProductsById = function(productsId) {
        $http.get('/webstore/market/rest/products/product?id=' + productsId)
            .success(function(data) {
                $scope.productsIdData = data;
            });
    };
    
    $scope.getProductsByCategoryForSlider = function(categoryId) {
        $http.get('/webstore/market/rest/products/' + categoryId)
            .success(function(data) {
                $scope.productsCategoryDataForSlider = data;
            });
    };
});
