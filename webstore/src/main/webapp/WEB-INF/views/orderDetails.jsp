<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page contentType="text/html; charset=UTF-8" %>

<!doctype html>

<html lang="en">

<head>
  <meta charset="utf-8">

  <title>The HTML5 Herald</title>
  <meta name="description" content="The HTML5 Herald">
  <meta name="author" content="SitePoint">

<link rel="stylesheet" type="text/css" href="/webstore/resources/css/css.css">
  <!--[if lt IE 9]>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/html5shiv/3.7.3/html5shiv.js"></script>
    
  <![endif]-->
</head>

<body>
  <div class="orderTitle">
    <h3>Chi tiết hóa đơn</h3>
  </div>
  <div class="insideContainer">

<!--
    <div class="blTitle">
      <p> Your order has been received and is now being processed. Your order details are shown below for your reference:</p>
    </div>
    -->
  <div class="orderNum">
    <h3>Order: #${order.orderId}<h3>
  </div>

  <div class="orderTable">

  <div class="product-detail">
  
    <h3>Sản phẩm</h3>
    <h3>Số lượng </h3>
    <h3>Giá </h3>
  </div>

  <div>
  <c:forEach items="${order.cart.cartItems}" var="cartItem">
  <div class="product-detail">
    <h3>${cartItem.product.name}</h3>
    <h3>${cartItem.quantity}</h3>
    <h3>${cartItem.totalPrice} </h3>
   </div>
</c:forEach>
  </div>

    <div class="order-bl-detail">
      <h3>Giỏ hàng:</h3>
      <h3> ${order.cart.grandTotal} </h3>
    </div>
    <div class="order-bl-detail">
      <h3>Giao hàng :</h3>
      <h3> miễn phí </h3>
    </div>
    <div class="order-bl-detail">
      <h3>Tổng đơn hàng:</h3>
      <h3> ${order.cart.grandTotal} </h3>
    </div>
  </div>

  <div class="orderNum">
    <h3>Thông tin khách hàng: <h3>
  </div>

  <div class="customerDetail">
  	  <p> <span> Họ tên: </span> ${order.customer.name} </p>
      <p> <span> Email: </span> ${order.customer.email} </p>
      <p> <span> Tel: </span> ${order.customer.phoneNumber}</p>
  </div>

  <div class="bill-ship">

<!-- 
  <div class="billContainer">
    <h3>Billing address</h3>
      <p> Walter White</p>
      <p> 308 Negra Arroyo Lane</p>
      <p>Albuquerque, New Mexico 87104</p>
  </div>
 -->
  <div class="shipContainer">
    <h3>Địa chỉ giao hàng</h3>
    <p>Tỉnh/Thành phố:  ${order.shippingDetail.shippingAddress.state} </p>
    <p>Quận/Huyện: ${order.shippingDetail.shippingAddress.district} </p>
    <p>Địa chỉ: ${order.shippingDetail.shippingAddress.address}</p>
  </div>

</div>
  </div>
</body>
</html>
