<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset="utf-8">
<link rel="stylesheet"
   href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Customer</title>
</head>
<sec:authorize access="isAuthenticated()">
    <sec:authentication property="principal.username" var="username" />
</sec:authorize>

<sec:authorize access="!isAuthenticated()">
    <sec:authentication property="principal" var="username" />
</sec:authorize>

<script>
</script>

<body>
   <section>
      <div class="jumbotron">
         <div class="container">
            <h1>Customer</h1>
            <p>Customer details</p>
         </div>
      </div>
   </section>
   <section class="container">
      <form:form modelAttribute="order" class="form-horizontal">
       <jsp:setProperty name="order" property="username" value= "${username}"/>
         <fieldset>
            <legend class="text-primary">Thông tin khách hàng</legend>

            <div class="form-group">
               <label class="control-label col-lg-2" for="name">Họ và tên</label>
               <div class="col-xs-3">
                  <form:input id="name" path="customer.name" type="text" class="form-control" />
               </div>
            </div>

            <div class="form-group">
               <label class="control-label col-lg-2" for="email">Địa chỉ Email</label>
               <div class="col-xs-3">
                  <form:input id="email" path="customer.email" type="text"
                     class="form-control" />
               </div>
            </div>
            
            <div class="form-group">
               <label class="control-label col-lg-2" for="phoneNumber">Số điện thoại</label>
               <div class="col-xs-3">
                  <form:input id="phoneNumber" path="customer.phoneNumber" type="text"
                     class="form-control" />
               </div>
            </div>
            
            
            <legend class="text-primary">Thông tin giao hàng</legend>
            
            <div class="form-group">
               <label class="control-label col-lg-2" for="state">Tỉnh/Thành phố</label>
               <div class="col-xs-3">
                  <form:input id="state" path="shippingDetail.shippingAddress.state" type="text"
                     class="form-control"  />
               </div>
            </div>

            <div class="form-group">
               <label class="control-label col-lg-2" for="district">Quận/Huyện</label>
               <div class="col-xs-3">
                  <form:input id="district" path="shippingDetail.shippingAddress.district" type="text"
                     class="form-control" />
               </div>
            </div>

            <div class="form-group">
               <label class="control-label col-lg-2" for="address">Địa chỉ </label>
               <div class="col-xs-3">
                  <form:input id="address" path="shippingDetail.shippingAddress.address" type="text"
                     class="form-control" />
               </div>
            </div>
            
                  <div class="form-group">
               <label class="control-label col-lg-2 col-lg-2" for="shippingDate" >Ngày giao hàng (dd/mm/yyyy)</label>
               <div class="col-xs-3">
                  <form:input id="shippingDate" path="shippingDetail.shippingDate" type="text" class="form-control" />
               </div>
            </div>
            
            <input type="hidden" name="_flowExecutionKey" value="${flowExecutionKey}"/>
            
            <div class="form-group">
               <div class="col-lg-offset-2 col-lg-10">
                  <input type="submit" id="btnAdd" class="btn btn-primary" onclick="validateForm()"
                     value="Thêm" name="_eventId_customerInfoCollected" />
                  <button id="btnCancel" class="btn btn-default" name="_eventId_cancel">Hủy</button>
               </div>
            </div>

         </fieldset>
      </form:form>
   </section>
</body>
</html>
