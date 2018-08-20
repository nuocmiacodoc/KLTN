angular.module('userRating', ['ngAnimate','ui.bootstrap']);
angular.module('userRating').controller('RatingCtrl',['$scope', '$http', function ($scope, $http) {
  $scope.rate = 5;
  $scope.max = 5;
  $scope.isReadonly = false;
  $scope.username = "";
  $scope.productId = "";

  $scope.ratingStates = [
    {stateOn: 'glyphicon-star', stateOff: 'glyphicon-star-empty'},
    {stateOn: 'glyphicon-star', stateOff: 'glyphicon-star-empty'},
    {stateOn: 'glyphicon-star', stateOff: 'glyphicon-star-empty'},
    {stateOn: 'glyphicon-star', stateOff: 'glyphicon-star-empty'},
    {stateOn: 'glyphicon-star', stateOff: 'glyphicon-star-empty'}
  ];
  $scope.point=0;
  $scope.changeRate = function(r, username, productId){
	  $scope.username = username;
	  $scope.productId = productId;
	  if (username=="") {
		  $scope.point=0;
		  alert("Bạn phải đăng nhập để sử dụng chức năng này!");
	  }
	  else {
		  $scope.point=r;
		  $scope.pushReviewToDB($scope.point, $scope.username, $scope.productId);
	  }
  };
  
  $scope.pushReviewToDB = function(point, username, productId) {
      $http.put('/webstore/rest/userrating/add?point=' + point + '&username=' + username +  '&productId=' + productId)
          .success(function(data) {
          });
  };
  
  $scope.initUserRating = function(username, productId) {
      $http.get('/webstore/rest/userrating?username=' + username +  '&productId=' + productId)
          .success(function(data) {
        	  if (data != null) {
        		  $scope.point = data;
        	  }
          });
  };
  
}]);