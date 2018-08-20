var adminDashBoard = angular.module('adminDashBoard', []);

adminDashBoard.controller('adminDashBoardCtrl', function($scope, $http) {
	
	
	$scope.productCategory = ["All","Laptop","Smartphone","MicroSD","Headphone","Tablet"];
	$scope.orderFilter = ["Tất cả","dưới 3 triệu","từ 3-5 triệu","từ 6-10 triệu","trên 11 triệu"];
	$scope.selectedItem;
	
    $scope.refreshDashBoard = function(categoryID) {
        $http.get('/webstore/rest/admin/' + $scope.categoryID)
            .success(function(data) {
                $scope.dashboardData = data;
            });
    };

    $scope.initCategoryID = function(categoryID) {
        $scope.categoryID = categoryID;
        $scope.refreshDashBoard($scope.categoryID);
    };

    $scope.removeFromCategory = function(memberId, categoryID, pageName) {
        $http.delete('/webstore/rest/admin/' + categoryID + '/' + memberId)
            .success(function(data) {
            	//alert(pageName);
            		$scope.categoryID = categoryID;
            		if(pageName === "Update product")
            			alert("Đã cập nhật thành công!");
            		else
            			alert("Đã xóa thành công!");
            		$scope.refreshDashBoard($scope.categoryID);
            });
    };
    
    $scope.getDataByFilter = function() {
    	$http.get('/webstore/rest/admin/' + $scope.categoryID +'/'+ $scope.selectedItem)
        .success(function(data) {
            $scope.dashboardData = data;
        });
    }
    
    $scope.dropboxitemselected = function(item)
    {
    	$scope.selectedItem = item;
    	$scope.getDataByFilter();
    };
});
