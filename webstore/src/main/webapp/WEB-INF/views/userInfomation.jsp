<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!-- <link href="//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.min.css" rel="stylesheet">

<p>  ${userpoint} </p>
<p>${userorders}</p>
<div class="container">
	<div class="row">
		<div class="col-md-offset-2 col-md-8 col-lg-offset-3 col-lg-6">
    	 <div class="well profile">
            <div class="col-sm-12">
                <div class="col-xs-12 col-sm-8">
                    <h2>Nicole Pearson</h2>
                    <p><strong>About: </strong> Web Designer / UI. </p>
                    <p><strong>Hobbies: </strong> Read, out with friends, listen to music, draw and learn new things. </p>
                    <p><strong>Skills: </strong>
                        <span class="tags">html5</span> 
                        <span class="tags">css3</span>
                        <span class="tags">jquery</span>
                        <span class="tags">bootstrap3</span>
                    </p>
                </div>             
                <div class="col-xs-12 col-sm-4 text-center">
                    <figure>
                        <img src="http://www.localcrimenews.com/wp-content/uploads/2013/07/default-user-icon-profile.png" alt="" class="img-circle img-responsive">
                        <figcaption class="ratings">
                            <p>Ratings
                            <a href="#">
                                <span class="fa fa-star"></span>
                            </a>
                            <a href="#">
                                <span class="fa fa-star"></span>
                            </a>
                            <a href="#">
                                <span class="fa fa-star"></span>
                            </a>
                            <a href="#">
                                <span class="fa fa-star"></span>
                            </a>
                            <a href="#">
                                 <span class="fa fa-star-o"></span>
                            </a> 
                            </p>
                        </figcaption>
                    </figure>
                </div>
            </div>            
            <div class="col-xs-12 divider text-center">
                <div class="col-xs-12 col-sm-4 emphasis">
                    <h2><strong> 20,7K </strong></h2>                    
                    <p><small>Followers</small></p>
                    <button class="btn btn-success btn-block"><span class="fa fa-plus-circle"></span> Follow </button>
                </div>
                <div class="col-xs-12 col-sm-4 emphasis">
                    <h2><strong>245</strong></h2>                    
                    <p><small>Following</small></p>
                    <button class="btn btn-info btn-block"><span class="fa fa-user"></span> View Profile </button>
                </div>
                <div class="col-xs-12 col-sm-4 emphasis">
                    <h2><strong>43</strong></h2>                    
                    <p><small>Snippets</small></p>
                    <div class="btn-group dropup btn-block">
                      <button type="button" class="btn btn-primary"><span class="fa fa-gear"></span> Options </button>
                      <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown">
                        <span class="caret"></span>
                        <span class="sr-only">Toggle Dropdown</span>
                      </button>
                      <ul class="dropdown-menu text-left" role="menu">
                        <li><a href="#"><span class="fa fa-envelope pull-right"></span> Send an email </a></li>
                        <li><a href="#"><span class="fa fa-list pull-right"></span> Add or remove from a list  </a></li>
                        <li class="divider"></li>
                        <li><a href="#"><span class="fa fa-warning pull-right"></span>Report this user for spam</a></li>
                        <li class="divider"></li>
                        <li><a href="#" class="btn disabled" role="button"> Unfollow </a></li>
                      </ul>
                    </div>
                </div>
            </div>
    	 </div>                 
		</div>
	</div>
</div> -->

<section class="container">
    <div class="name-category" style="background-image: url(<c:url value="/img/header/shizzle.png"></c:url>);">
        <span class="category" style="background-image: url(<c:url value="/img/header/bodybg.png"></c:url>);">Thông tin tài khoản</span>
    </div>

    <div class="row">
        <div class="col-md-10 col-md-offset-1">
            <div class="col-md-3 col-md-offset-1 avatar" style="background-image: url(<c:url value="/img/avatar/shannon.jpg"></c:url>);"></div>
            <div class="col-md-6 col-md-offset-1 det-desc">
                <div class="infospan">
                    Tên đăng nhập
                    <span>
                        ${username}
                    </span>
                </div>
                <div class="infospan">
                    Điểm thưởng
                    <span>
                        ${userpoint}
                    </span>
                </div>
                <div class="average">
                    <form role="form">
                    <div class="form-group">
                        <div class="rate">
                            <span class="lbl">Customer Level</span>
                            <div class="starwrap">
                                <div id="score" title="regular" style="width: 150px;">
                                    <img src=<c:url value="/img/star/star-on.png"></c:url> alt="1" title="regular">&nbsp;
                                    <img src=<c:url value="/img/star/star-on.png"></c:url> alt="2" title="regular">&nbsp;
                                    <img src=<c:url value="/img/star/star-on.png"></c:url> alt="3" title="regular">&nbsp;
                                    <img src=<c:url value="/img/star/star-off.png"></c:url> alt="4" title="regular">&nbsp;
                                    <img src=<c:url value="/img/star/star-off.png"></c:url> alt="5" title="regular">
                                    <input type="hidden" name="score" value="3" readonly="readonly">
                                </div>
                            </div>
                        <div class="clearfix"></div>
                    </div>
                    </form>
                    </div>
                </div>
            </div>
        </div>        
    </div>

    <div class="order-history-container">

        <div class="name-category" style="background-image: url(<c:url value="/img/header/shizzle.png"></c:url>);">
            <span class="category" style="background-image: url(<c:url value="/img/header/bodybg.png"></c:url>);">Lịch sử mua hàng</span>
        </div>  

        <table class="table table-striped order-history">
            <thead>
                <tr>
                    <th>Mã đơn hàng</th>
                    <th>Số lượng sản phẩm</th>
                    <th>Tổng đơn hàng</th>
                    <th>Tổng thanh toán</th>
                    <th>Ngày giao hàng</th>
                    <th>Chi tiết</th>
                </tr>
            </thead>

            <tbody>
                <c:forEach items="${userorders}" var="order">
                    <tr>
                        <td>${order.orderId}</td>
                        <td>Thêm sau</td>
                        <td>
                            <fmt:formatNumber type = "number" maxFractionDigits = "2" value = "${order.cart.grandTotal}" />
                        </td>
                        <td>
                            <fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${order.finalPrice}" />
                        </td>
                        <td>${order.shippingDetail.shippingDate}</td>
                        <td>
                            <span>
                                <a href="<spring:url value="/orders/details?id=${order.orderId}" />" class="label label-success" >  
                                    <span class="glyphicon-info-sign glyphicon"></span>
                                    Chi tiết
                                </a>
                            </span></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</section>

<div style="border-bottom: 1px dashed #c2cbd3;"></div>