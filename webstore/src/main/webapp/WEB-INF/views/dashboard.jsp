<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<script>
$(document).ready(function(){
	 $("#products").hide().trigger("hide");
	 $("#orders").hide().trigger("hide");
	 $("#customers").hide().trigger("hide");
	var categoryId = "${categoryId}";
    $("#"+categoryId).show().trigger("show");
    $("#nav_"+categoryId).addClass("active").trigger("addClass")

    
});
</script>
			<section class="container">
			
			
		<nav class="navbar navbar-light bg-faded">
		  <div class="header">
		    <ul class="nav nav-pills pull-left">
		     <li id = "nav_products"><a href="<spring:url value="/admin/dashboard/products"/>">Sản Phẩm</a></li>
				<li id = "nav_orders"><a href="<spring:url value="/admin/dashboard/orders"/>">Ðơn Hàng</a></li>
				<li id = "nav_customers"><a href="<spring:url value="/admin/dashboard/customers"/>">Khách Hàng</a></li>
		    </ul>
		  </div>
		</nav>

			<div ng-controller="adminDashBoardCtrl" ng-init="initCategoryID('${categoryId}')">
			<div id = "table_records">
<div id = "products">
				<div>
		<a href="" class="btn btn-primary"><span
						class="glyphicon glyphicon-remove-sign"></span> Xóa chọn</a>				
						
		  <a href="<spring:url value="/admin/dashboard/products/add?id="/>" class="btn btn-success"><span
						class="glyphicon  glyphicon-plus"></span> Thêm mới</a>
		  <a href="" class="btn btn-info"><span
						class="glyphicon  glyphicon-circle-arrow-down"></span> Danh sách đã xóa</a> 
			  <span class="dropdown">
    <button class="btn btn-warning dropdown-toggle" type="button" data-toggle="dropdown"><span
						class="glyphicon glyphicon-chevron-down
						"></span> Lọc
   </button>
    <ul class="dropdown-menu">
      <li ng-repeat="a in productCategory"><a ng-click="dropboxitemselected(a)">{{a}}</a></li>
    </ul>
  </span>	 			
				</div>
				<table class="table table-hover text-center">
					<tr>
					<th>Chọn</th>
						<th class = "text-center">Mã sản phẩm</th>
						<th class = "text-center">Tên sản phẩm</th>
						<th class = "text-center">Giá đơn vị</th>
						<th class = "text-center">Số lượng trong kho</th>
						<th class = "text-center">Nhà sản xuất</th>
						<th class = "text-center">Thao tác</th>
					</tr>
					<tr ng-repeat="item in dashboardData">
					<td><input type="checkbox" /></td>
						<td>{{item.productId}}</td>
						<td>{{item.name}} </td>
						<td>{{item.unitPrice}}</td>
						<td>{{item.unitsInStock}}</td>
						<td>{{item.manufacturer}}</td>
						<td><span> <a href="#" class="label label-danger"
							ng-click="removeFromCategory(item.productId, '${categoryId}', '-1')"> <span
								class="glyphicon glyphicon-remove" /></span> Xóa
						</a>
						</span>
						<span>
							<a href="<spring:url value="/admin/dashboard/products/add?id={{item.productId}}" />" 
							class="label label-primary" > <span class="glyphicon glyphicon-cog"
							></span> Cập nhật
						</a>
						</span>
						<span>
							<a href="<spring:url value="/market/product?id={{item.productId}}" />" 
							class="label label-success" > <span class="glyphicon-info-sign glyphicon"
							></span> Chi tiết
						</a>
						</span>
						</td>
					</tr>
				</table>
				</div>
				
				<div id ="orders">
				<div>
				<a href="" class="btn btn-primary"><span
						class="glyphicon glyphicon-remove-sign"></span> Xóa chọn</a>				
		  <a href="" class="btn btn-info"><span
						class="glyphicon  glyphicon-circle-arrow-down"></span>Danh sách đã xóa</a>
	
				  <span class="dropdown">
    <button class="btn btn-warning dropdown-toggle" type="button" data-toggle="dropdown"><span
						class="glyphicon glyphicon-chevron-down
						"></span> Lọc
   </button>
    <ul class="dropdown-menu">
      <li ng-repeat="a in orderFilter"><a ng-click="dropboxitemselected(a)">{{a}}</a></li>
    </ul>
  </span>
	  
				</div>
				<table class="table table-hover text-center" >
					<tr>
					<th>Chọn</th>
						<th class = "text-center">Mã đơn hàng</th>
						<th class = "text-center">Tên khách hàng</th>
						<th class = "text-center">Số lượng sản phẩm</th>
						<th class = "text-center">Ngày giao hàng</th>
						<th class = "text-center">Tổng đơn giá</th>
						<th class = "text-center">Xem chi tiết</th>
						<th class = "text-center">Thao tác</th>
					</tr>
					<tr ng-repeat="item in dashboardData">
					<td><input type="checkbox" /></td>
						<td>{{item.orderId}}</td>
						<td>{{item.customer.name}} </td>
						<td>{{item.cart.cartItems[0].quantity}}</td>
						<td>{{item.shippingDetail.shippingDate}}</td>
						<td>{{item.cart.grandTotal}} đồng</td>
						<td><span>
							<a href="<spring:url value="/orders/details?id={{item.orderId}}" />" 
							class="label label-success" > <span class="glyphicon-info-sign glyphicon"
							></span> Chi tiết
						</a>
						</span></td>
						<td><span> <a href="#" class="label label-danger"
							ng-click="removeFromCategory(item.orderId, '${categoryId}', '-1')"> <span
								class="glyphicon glyphicon-remove" /></span> Xóa
						</a>
						</span>
						</td>
					</tr>
				</table>
				</div>
				
				</div>
				
				<div id ="customers">
				<a href="" class="btn btn-primary"><span
						class="glyphicon glyphicon-remove-sign"></span> Xóa chọn</a>				
		  <a href="" class="btn btn-info"><span
						class="glyphicon  glyphicon-circle-arrow-down"></span>Danh sách đã xóa</a>
		  <a href="" class="btn btn-warning"><span
						class="glyphicon glyphicon-chevron-down
						"></span> Lọc</a>   
				 	
					<table class="table table-hover text-center" >
					<tr>
					<th>Chọn</th>
						<th class = "text-center">Mã khách hàng</th>
						<th class = "text-center">Tên khách hàng</th>
						<th class = "text-center">Số điện thoại</th>
						<th class = "text-center">Địa chỉ email</th>
						<th class = "text-center">Thao tác</th>
					</tr>
					<tr ng-repeat="item in dashboardData">
					<td><input type="checkbox" /></td>
						<td>{{item.customerId}}</td>
						<td>{{item.name}} </td>
						<td>{{item.phoneNumber}}</td>
						<td>{{item.email}}</td>
						<td><span> <a href="#" class="label label-danger"
							ng-click="removeFromCategory(item.customerId, '${categoryId}','-1')"> <span
								class="glyphicon glyphicon-remove" /></span> Xóa
						</a>
						</span>
						</td>
					</tr>
				</table>	 	
				 	
				 			
				</div>
				</div>
		</section>
