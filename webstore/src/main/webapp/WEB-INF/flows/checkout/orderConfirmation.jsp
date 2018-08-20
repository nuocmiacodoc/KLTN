<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page contentType="text/html; charset=UTF-8" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset="utf-8">
<link rel="stylesheet"
   href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Order Confirmation</title>
</head>

<body>

   <section>
      <div class="jumbotron">
         <div class="container">
            <h1>Đơn hàng</h1>
            <p>Xác nhận đơn hàng</p>
         </div>
      </div>
   </section>
   <div class="container">
      <div class="row">
         <form:form modelAttribute="order" class="form-horizontal">
            <input type="hidden" name="_flowExecutionKey"
               value="${flowExecutionKey}" />

            <div
               class="well col-xs-10 col-sm-10 col-md-6 col-xs-offset-1 col-sm-offset-1 col-md-offset-3">
               <div class="text-center">
                  <h1>Hóa đơn</h1>
               </div>
               <div class="row">
                  <div class="col-xs-6 col-sm-6 col-md-6">
                     <address>
                        <strong>Thông tin nhận hàng</strong> <br>
                        <span title="State">Tỉnh/Thành phố: </span>
                        <strong> ${order.shippingDetail.shippingAddress.state} </strong>
                        <br>
                       <span title="District">Quận/Huyện:</span>
                        <strong> ${order.shippingDetail.shippingAddress.district} </strong>
                        <br>
                        <span title="address">Địa chỉ:</span>
                        <strong> ${order.shippingDetail.shippingAddress.address} </strong>
                        <br>
                     </address>
                  </div>
                  <div class="col-xs-6 col-sm-6 col-md-6 text-right">
                     <p>
                        <em>Thời gian nhận:
                            <strong>  ${order.shippingDetail.shippingDate}  </strong></em>
                     </p>
                  </div>
               </div>
               <div class="row">
                  <div class="col-xs-6 col-sm-6 col-md-6">
                     <address>
                        <strong>Thông tin khách hàng</strong> <br>
                        <span title="Name"> Họ và tên:</span>
                        <strong> ${order.customer.name} </strong><br>
                        <span title="Phone">Số điện thoại:</span>
                        <strong> ${order.customer.phoneNumber} </strong> <br>
                         <span title="Email">Email: </span>
                        <strong> ${order.customer.email} </strong>
                        <br>
                     </address>
                  </div>

               </div>
               <div class="row">

                  <table class="table table-hover">
                     <thead>
                        <tr>
                           <th>Sản phẩm</th>
                           <th class="text-center">Số lượng</th>
                           <th class="text-center">Giá thành</th>
                           <th class="text-center">Tổng cộng</th>
                        </tr>
                     </thead>
                     <tbody>
                        <c:forEach var="cartItem" items="${order.cart.cartItems}">
                           <tr>
                              <td class="col-md-9"><em>${cartItem.product.name}</em></td>
                              <td class="col-md-1" style="text-align: center">
                                 ${cartItem.quantity}</td>
                              <td class="col-md-1 text-center">${cartItem.product.unitPrice}</td>
                              <td class="col-md-1 text-center">${cartItem.totalPrice}</td>
                           </tr>
                        </c:forEach>

                        <tr>
                               <td class="text-right"><h4>
                                 <strong>Tổng đơn hàng: </strong>
                              </h4></td>
                           <td class="text-left text-danger"><h4>
                                 <strong>${order.cart.grandTotal}</strong>
                              </h4></td>
                               <td class="text-left text-danger"><h4>
                                 <strong>VNĐ</strong>
                              </h4></td>
                        </tr>
                        
                                <tr>
                           <td class="text-right"><h4>
                                 <strong>Điểm thưởng tích lũy: </strong>
                              </h4></td>
                           <td class="text-left text-danger"><h4>
                                 <strong>${order.pointOfOrder}</strong>
                              </h4>
                        </tr>
                        
                        <tr>
                           <td class="text-right"><h4>
                                 <strong>Tổng đơn hàng sau khi giảm giá: </strong>
                              </h4></td>
                           <td class="text-left text-danger"><h4>
                                 <strong>${order.finalPrice}</strong>
                              </h4></td>
                               <td class="text-left text-danger"><h4>
                                 <strong>VNĐ</strong>
                              </h4></td>
                        </tr>
                     </tbody>
                  </table>
                  <button id="back" class="btn btn-default"
                     name="_eventId_backToCollectCustomerInfo">Quay lại</button>

                  <button type="submit" class="btn btn-success"
                     name="_eventId_orderConfirmed">
                     Xác nhận   <span class="glyphicon glyphicon-chevron-right"></span>
                  </button>
                  <button id="btnCancel" class="btn btn-default"
                     name="_eventId_cancel">Hủy</button>
               </div>
            </div>
         </form:form>
      </div>
   </div>
</body>
</html>
