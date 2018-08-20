<!-- menu -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page contentType="text/html; charset=UTF-8" %>

<div class="main-nav">
	<div class="navbar navbar-default ws-navbar-default navbar-static-top" style="margin-top: 0px; background-image: url(<c:url value="/img/header/menu-bg.png"></c:url>);">
         <div class="container ws-container">
            <div class="row">
               <div class="col-md-10">
                  <div class="navbar-header">
                     <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target=".navbar-collapse">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                     </button>
                  </div>
                  <div class="navbar-collapse collapse" style="height: 1px;">
                     <ul class="nav navbar-nav"> <!-- navbar menu -->
                        <li>
                           <a href="/webstore/market/products" class="active" style="background-image: url(<c:url value="/img/header/noise.png"></c:url>); background-color: #FFC513">Home</a>
                         </li>
                        <li class="dropdown menu-large nav-item">
                           <a class="dropdown-toggle mouse-point menu-icon" data-toggle="dropdown"
                           >
                            <img src="<c:url value="/img/menu/dienthoai.png"/>"/>
                            Điện Thoại
                           </a>
                           <ul class="dropdown-menu megamenu container row">
                              <li class="col-sm-5">
                                 <h4>Hãng Sản Xuất</h4>
                                 <ul>
                                    <li>
                                       <a href="<spring:url value="/market/products/Smartphone"/>">
                                          Tất cả
                                       </a>
                                    </li>
                                    <li>
                                       <a href="<spring:url value="/market/products/Smartphone?brand=Samsung"/>">
                                          Samsung
                                       </a>
                                    </li>
                                    <li>
                                       <a href="<spring:url value="/market/products/Smartphone?brand=Oppo"/>">
                                          Oppo
                                       </a>
                                    </li>
                                    <li>
                                       <a href="<spring:url value="/market/products/Smartphone?brand=Apple"/>">
                                          Apple
                                       </a>
                                    </li>
                                    <li>
                                       <a href="<spring:url value="/market/products/Smartphone?brand=Asus"/>">
                                          Asus
                                       </a>
                                    </li>
                                    <li>
                                       <a href="<spring:url value="/market/products/Smartphone?brand=Xaomi"/>">
                                          Xiaomi
                                       </a>
                                    </li>
                                 </ul>
                                 <div class="dashed-nav"></div>
                              </li>
                              <li class="col-sm-7">
                                 <h4>Giá</h4>
                                 <ul>
                                    <li>
                                      <a href="<spring:url value="/market/products/Laptop?highprice=2000000"/>">
                                      Dưới 2 triệu
                                      </a>
                                    </li>
                                    <li>
                                      <a href="<spring:url value="/market/products/Smartphone?lowprice=2000000&highprice=5000000"/>">
                                      Từ 2 - 5 triệu
                                      </a>
                                    </li>
                                    <li>
                                      <a href="<spring:url value="/market/products/Smartphone?lowprice=5000000&highprice=8000000"/>">
                                      Từ 5- 8 triệu
                                      </a>
                                    </li>
                                    <li>
                                      <a href="<spring:url value="/market/products/Smartphone?lowprice=8000000"/>">
                                      Trên 8 triệu
                                      </a>
                                    </li>
                                 </ul>
                                 <div class="dashed-nav"></div>
                              </li>
                           </ul>
                        </li>

                        <li class="dropdown menu-large nav-item">
                           <a class="dropdown-toggle mouse-point" data-toggle="dropdown">
                           <img src="<c:url value="/img/menu/laptop.png"/>"/>
                           Máy Tính
                           </a>
                           <ul class="dropdown-menu megamenu container row">
                              <li class="col-sm-5">
                                 <h4>Hãng Sản Xuất</h4>
                                 <ul>
                                    <li>
                                       <a href="<spring:url value="/market/products/Laptop"/>">
                                          Tất cả
                                       </a>
                                    </li>
                                    <li>
                                       <a href="<spring:url value="/market/products/Laptop?brand=Dell"/>">
                                          Dell
                                       </a>
                                    </li>
                                    <li>
                                       <a href="<spring:url value="/market/products/Laptop?brand=HP"/>">
                                          HP
                                       </a>
                                    </li>
                                    <li>
                                       <a href="<spring:url value="/market/products/Laptop?brand=Apple"/>">
                                          Apple
                                       </a>
                                    </li>
                                    <li>
                                       <a href="<spring:url value="/market/products/Laptop?brand=Asus"/>">
                                          Asus
                                       </a>
                                    </li>
                                    <li>
                                       <a href="<spring:url value="/market/products/Laptop?brand=Sony"/>">
                                          Sony
                                       </a>
                                    </li>
                                 </ul>
                                 <div class="dashed-nav"></div>
                              </li>
                              <li class="col-sm-7">
                                 <h4>Giá</h4>
                                 <ul>
                                    <li>
                                      <a href="<spring:url value="/market/products/Laptop?highprice=8000000"/>">
                                      Dưới 8 triệu
                                      </a>
                                    </li>
                                    <li>
                                      <a href="<spring:url value="/market/products/Laptop?lowprice=8000000&highprice=12000000"/>">
                                      Từ 8- 12 triệu
                                      </a>
                                    </li>
                                    <li>
                                      <a href="<spring:url value="/market/products/Laptop?lowprice=12000000&highprice=15000000"/>">
                                      Từ 12- 15 triệu
                                      </a>
                                    </li>
                                    <li>
                                      <a href="<spring:url value="/market/products/Laptop?lowprice=15000000&highprice=20000000"/>">
                                      Từ 15- 20 triệu
                                      </a>
                                    </li>
                                    <li>
                                      <a href="<spring:url value="/market/products/Laptop?lowprice=20000000"/>">
                                      Trên 20 triệu
                                      </a>
                                    </li>
                                 </ul>
                                 <div class="dashed-nav"></div>
                              </li>
                           </ul>
                        </li>

                        <li class="dropdown menu-large nav-item">
                           <a class="dropdown-toggle mouse-point" data-toggle="dropdown">
                           <img src="<c:url value="/img/menu/tablet.png"/>"/>
                           Tablet
                           </a>
                           <ul class="dropdown-menu megamenu container row">
                              <li class="col-sm-5">
                                 <h4>Hãng Sản Xuất</h4>
                                 <ul>
                                    <li>
                                       <a href="<spring:url value="/market/products/Tablet"/>">
                                          Tất cả
                                       </a>
                                    </li>
                                    <li>
                                       <a href="<spring:url value="/market/products/Tablet?brand=Lenovo"/>">
                                          Lenovo
                                       </a>
                                    </li>
                                    <li>
                                       <a href="<spring:url value="/market/products/Tablet?brand=Google"/>">
                                          Google
                                       </a>
                                    </li>
                                    <li>
                                       <a href="<spring:url value="/market/products/Tablet?brand=Apple"/>">
                                          Apple
                                       </a>
                                    </li>
                                    <li>
                                       <a href="<spring:url value="/market/products/Tablet?brand=Asus"/>">
                                          Asus
                                       </a>
                                    </li>
                                    <li>
                                       <a href="<spring:url value="/market/products/Tablet?brand=Sony"/>">
                                          Sony
                                       </a>
                                    </li>
                                 </ul>
                                 <div class="dashed-nav"></div>
                              </li>
                              <li class="col-sm-7">
                                 <h4>Giá</h4>
                                 <ul>
                                    <li>
                                      <a href="<spring:url value="/market/products/Tablet?highprice=2000000"/>">
                                      Dưới 2 triệu
                                      </a>
                                    </li>
                                    <li>
                                      <a href="<spring:url value="/market/products/Tablet?lowprice=2000000&highprice=5000000"/>">
                                      Từ 2 - 5 triệu
                                      </a>
                                    </li>
                                    <li>
                                      <a href="<spring:url value="/market/products/Tablet?lowprice=5000000&highprice=8000000"/>">
                                      Từ 5- 8 triệu
                                      </a>
                                    </li>
                                    <li>
                                      <a href="<spring:url value="/market/products/Tablet?lowprice=8000000"/>">
                                      Trên 8 triệu
                                      </a>
                                    </li>
                                 </ul>
                                 <div class="dashed-nav"></div>
                              </li>
                           </ul>
                        </li>
                        
                        <li class="dropdown menu-large nav-item">
                           <a class="dropdown-toggle mouse-point" data-toggle="dropdown">
                           <img src="<c:url value="/img/menu/headphone.png"/>"/>
                           Headphone
                           </a>
                           <ul class="dropdown-menu megamenu container row">
                              <li class="col-sm-5">
                                 <h4>Hãng Sản Xuất</h4>
                                 <ul>
                                    <li>
                                       <a href="<spring:url value="/market/products/Headphone"/>">
                                          Tất cả
                                       </a>
                                    </li>
                                    <li>
                                       <a href="<spring:url value="/market/products/Headphone?brand=Sony"/>">
                                          Sony
                                       </a>
                                    </li>
                                    <li>
                                       <a href="<spring:url value="/market/products/Headphone?brand=Microlab"/>">
                                          Microlab
                                       </a>
                                    </li>
                                    <li>
                                       <a href="<spring:url value="/market/products/Headphone?brand=Yison"/>">
                                          Yison
                                       </a>
                                    </li>
                                    <li>
                                       <a href="<spring:url value="/market/products/Headphone?brand=Senicc"/>">
                                          Senicc
                                       </a>
                                    </li>
                                 </ul>
                                 <div class="dashed-nav"></div>
                              </li>
                              <li class="col-sm-7">
                                 <h4>Giá</h4>
                                 <ul>
                                    <li>
                                      <a href="<spring:url value="/market/products/Headphone?highprice=100000"/>">
                                      Dưới 100 nghìn
                                      </a>
                                    </li>
                                    <li>
                                      <a href="<spring:url value="/market/products/Headphone?lowprice=100000&highprice=150000"/>">
                                      Từ 100- 150 nghìn
                                      </a>
                                    </li>
                                    <li>
                                      <a href="<spring:url value="/market/products/Headphone?lowprice=150000&highprice=200000"/>">
                                      Từ 150- 200 nghìn
                                      </a>
                                    </li>
                                    <li>
                                      <a href="<spring:url value="/market/products/Headphone?lowprice=200000"/>">
                                      Trên 200 nghìn
                                      </a>
                                    </li>
                                 </ul>
                                 <div class="dashed-nav"></div>
                              </li>
                           </ul>
                        </li>
                     </ul>
                  </div>
               </div>
               <div class="col-md-2 machart cart-icon-with-countnumber" ng-controller="cartCtrl" ng-init="countCartItems()">
               	<a href="<spring:url value="/cart" />">
                 <button id="popcart" class="btn btn-default btn-chart btn-sm ">
                 	<span class="mychart chart-icon"  style="background-image: url(<c:url value="/img/header/cartsmall-bl.png"></c:url>); background-position: left; background-repeat: no-repeat; width: 69px; height: 21px">
                 		Cart
                 		<div class="cartCount {{className}}">{{cartCount}}</div>
					</span >
				
				</button>
               	</a>
          	</div>
       </div>
    </div>
</div>
</div>
<!-- <script>
	setTimeout(function(){showCartCount(), 10000})
</script> -->
   


