<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<section class="container">
	<div ng-controller="cartCtrl" ng-init="initCartId('${cartId}')">

		<div>
			<a class="btn btn-danger pull-left" ng-click="clearCart()"> <span
				class="glyphicon glyphicon-remove-sign"></span> Xóa giỏ hàng
			</a> <a href="<spring:url value="/checkout?cartId=${cartId}"/>"
				class="btn btn-success pull-right"> <span
				class="glyphicon-shopping-cart glyphicon"></span> Đặt hàng
			</a>
		</div>
		<table class="table table-hover">
			<tr>
				<th>Sản Phẩm</th>
				<th>Giá trên sản phẩm</th>
				<th>Số lượng</th>
				<th>Giá</th>
				<th>Thao tác</th>
			</tr>
			<tr ng-repeat="item in cart.cartItems">
				<td>{{item.product.productId}}-{{item.product.name}}</td>
				<td>{{item.product.unitPrice}}</td>
				<td>{{item.quantity}}</td>
				<td>{{item.totalPrice}}</td>
				<td><a href="#" class="label label-danger"
					ng-click="removeFromCart(item.product.productId)"> <span
						class="glyphicon glyphicon-remove" /></span> Xóa
				</a></td>
			</tr>
			<tr>
				<th></th>
				<th></th>
				<th>Tổng giá</th>
				<th>{{cart.grandTotal}}</th>
				<th></th>
			</tr>
		</table>

		<a href="<spring:url value="/market/products" />"
			class="btn btn-default"> <span
			class="glyphicon-hand-left glyphicon"></span> Tiếp tục mua hàng
		</a>
	</div>
</section>