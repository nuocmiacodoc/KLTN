<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title><tiles:insertAttribute name="title" /></title>

<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="/webstore/resources/css/css.css">
<link rel="stylesheet" type="text/css" href="/webstore/resources/css/slick.css">
<link rel="stylesheet" type="text/css" href="/webstore/resources/css/slick-theme.css">
<link rel="stylesheet" type="text/css" href="/webstore/resources/css/font-awesome/css/font-awesome.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.1/angular.min.js"></script>

<script src="/webstore/resources/js/cartcontroller.js"></script>
<script src="/webstore/resources/js/admindashboardcontroller.js"></script>
<script src="/webstore/resources/js/productscontroller.js"></script>
<script src="/webstore/resources/js/userrating.js"></script>
<script src="//ajax.googleapis.com/ajax/libs/angularjs/1.5.3/angular.js"></script>
<script
	src="//ajax.googleapis.com/ajax/libs/angularjs/1.5.3/angular-animate.js"></script>
<script
	src="//angular-ui.github.io/bootstrap/ui-bootstrap-tpls-1.3.3.js"></script>


<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="/webstore/resources/js/slick.js"></script>

<script>angular.module("app", ["cartApp", "productsController","adminDashBoard", "userRating"]);</script>

<script>
   function formatMoney(num) {
       var p = num.toFixed(2).split(".");
       return p[0].split("").reverse().reduce(function(acc, num, i, orig) {
           return  num=="-" ? acc : num + (i && !(i % 3) ? "," : "") + acc;
       }, "") + " VNĐ";
   }
   
   function changeFormatMoney() {
      var x = document.getElementsByClassName("formatMoney");
      var i = 0;
      for (i = 0; i < x.length; i++) {
         x[i].innerHTML = formatMoney(parseInt(x[i].innerHTML, 10));
      }
   }
   
</script>

<script>
    $(document).ready(function(){
       $(".dropdown-toggle").dropdown();

       $("#reg").click(function(){
            $('.regwrap').toggle('fast', function() {
                                 });
            $(".srchwrap").hide();
       });

       $("#srch").click(function(){
            $('.srchwrap').toggle('fast', function() {
       });
            $(".regwrap").hide();
       });

       $("#btn-sign-up").click(function(){
            $(".regwrap").hide();
       })

    });



</script>

<sec:authorize access="isAuthenticated()">
    <sec:authentication property="principal.username" var="username" />
</sec:authorize>

<sec:authorize access="!isAuthenticated()">
    <sec:authentication property="principal" var="username" />
</sec:authorize>
<%-- <p>${username}</p> --%>
</head>

<body ng-app="app" style="background-image: url(<c:url value="/img/header/bodybg.png"></c:url>);">

   <div class="ws-header" style="background-image: url(<c:url value="/img/header/header-bg.png"></c:url>);">
      <div class="container ws-container">
         <div class="row">
            <div class="col-xs-6 col-md-4 main-logo">
               <!-- <a href="index.html"><img src="images/logo.png" alt="logo" class="logo img-responsive"></a> -->
               <div class="logo" style="background-image: url(<c:url value="/img/header/logo.png"></c:url>);"> </div>
            </div>
            <div class="col-md-8">
               <div class="pushright">
                  <div class="top">
                  
                           <c:choose>
                            <c:when test="${username=='anonymousUser'}">
                                <a id="reg" class="btn btn-default btn-dark" href="<spring:url value="/login"/>">Login<span>-- Or --</span>Register</a>
                            </c:when>    
                            <c:otherwise>
                              <span class="dropdown">
                                 <a id="reg" class="btn btn-default btn-dark dropdown-toggle" data-toggle="dropdown">${username}</a>
                                 
                                   <ul class="dropdown-menu">
                                     <li><a style="color: black" href="<spring:url value="/user/info"/>">Thông tin</a></li>
                                     <li><a style="color: black" href="<spring:url value="/logout"/>">Logout</a></li>
                                   </ul>  
                              </span>
                           </c:otherwise>
                       </c:choose>
                     
                     <%-- <div class="regwrap" style="display: none; background-image: url(<c:url value="/img/header/f-bg.png"></c:url>);">
                        <div class="row">
                           <div class="col-md-6 regform">
                              <div class="title-widget-bg" style="background-image: url(<c:url value="/img/header/shizzle-dark.png"></c:url>);">
                                 <div class="title-widget" style="background-image: url(<c:url value="/img/header/f-bg.png"></c:url>);">Login</div>
                              </div>
                              <form role="form">
                                 <div class="form-group">
                                    <input type="text" class="form-control" id="username" placeholder="Username">
                                 </div>
                                 <div class="form-group">
                                    <input type="password" class="form-control" id="password" placeholder="password">
                                 </div>
                                 <div class="form-group">
                                    <button class="btn btn-default btn-red btn-sm">Sign In</button>
                                 </div>
                              </form>
                           </div>
                           <div class="col-md-6">
                              <div class="title-widget-bg" style="background-image: url(<c:url value="/img/header/shizzle-dark.png"></c:url>);">
                                 <div class="title-widget" style="background-image: url(<c:url value="/img/header/f-bg.png"></c:url>);">Register</div>
                              </div>
                              <p>
                                 Người dùng mới? Bằng cách tạo một tài khoản bạn có thể mua sắm nhanh hơn, cập nhật về tình trạng của đơn đặt hàng...
                              </p>
                              <button class="btn btn-default btn-yellow" id="btn-sign-up" data-toggle="modal" data-target="#sign-up-Modal">Register Now</button>
                           </div>
                        </div>
                     </div> --%>
                     <div class="srch-wrap">
                        <a id="srch" class="btn btn-default btn-search"><i class="fa fa-search"></i></a>
                     </div>
                     <div class="srchwrap" style="display: none;">
                        <div class="row">
                           <div class="col-md-12">
                              <form class="form-horizontal" role="form">
                                 <div class="form-group">
                                    <label for="search" class="col-sm-2 control-label">Search</label>
                                    <div class="col-sm-10">
                                       <input type="text" class="form-control" id="search">
                                    </div>
                                 </div>
                              </form>
                           </div>
                        </div>
                     </div>
                  </div>
               </div>
            </div>
         </div>
      </div>
        <div class="dashed" style="background-image: url(<c:url value="/img/header/dashed.png"></c:url>);"></div>
      </div>

<!-- Sign Up -->

<div class="modal fade sign-up-modal" id="sign-up-Modal" role="dialog">
   <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content" style="background-image: url(<c:url value="/img/header/f-bg.png"></c:url>);">
         <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal">&times;</button>
            <h2 class="modal-title">Sign Up</h2>
         </div>
         <div class="modal-body sign-up">
            <p>
               <label for="Email" class="floatLabel">User Name</label>
               <input id="Email" name="Email" type="text">
            </p>
            <p>
               <label for="password" class="floatLabel">Password</label>
               <input id="password" name="password" type="password">
               <span style="display: none">Enter a password longer than 8 characters</span>
            </p>
            <p>
               <label for="confirm_password" class="floatLabel">Confirm Password</label>
               <input id="confirm_password" name="confirm_password" type="password">
               <span style="display: none">Your passwords do not match</span>
            </p>
            <p style="overflow: auto;">
               <button type="button" class="btn btn-default" data-dismiss="modal" style="float: right;">Cancel</button>
               <button id="submit" type="button" class="btn btn-success" style="float: right; margin-right: 15px;">Create My Account</button>
            </p>
         </div>
      </div>
   </div>
</div>

<!-- version 2 -->
<div id="container">
   <div>
      <tiles:insertAttribute name="menu" />
   </div>
      
   <div id="body">
   
      <div>
         <tiles:insertAttribute name="big-slider" />
      </div>
   
      <div>
         <tiles:insertAttribute name="content" />
      </div>
 
   </div>
   
<%--    <div style="background-image: url(<c:url value="/img/header/bodybg.png"></c:url>);">
      <div class="footer" style="background-image: url(<c:url value="/img/header/bodybg.png"></c:url>);">
         <tiles:insertAttribute name="footer" />
      </div>
   </div> --%>
   
</div>




</body>
</html>
