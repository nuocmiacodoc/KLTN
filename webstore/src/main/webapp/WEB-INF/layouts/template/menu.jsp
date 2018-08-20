<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page contentType="text/html; charset=UTF-8" %>

<nav class="navbar navbar-default" role="navigation">
  	<div class="navbar-header">
	    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
		    <span class="sr-only">Toggle navigation</span>
		    <span class="icon-bar"></span>
		    <span class="icon-bar"></span>
		    <span class="icon-bar"></span>
	    </button>
	    <a class="navbar-brand" href="#">Menu</a>
  	</div>
  <!--/.navbar-header-->

  <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">

	<div class="col-sm-2" style="margin-top: 1%; padding-top: 2px; font-size: 16px">
	    <ul id="multicol-menu" style="list-style-type: none;">
		    <li class="dropdown">
		        <a href="#" class="dropdown-toggle" data-toggle="dropdown">Điện thoại
		        	<b class="caret" style="margin-left: 5px"></b>
		        </a>
		        <ul class="dropdown-menu">
		            <li>
		                <div class="row" style="width: 600px; padding-left: 5%; padding-right: 5%">
		                    <div class="col-md-4">
		                    	<h4>Hãng sản xuất</h4>
		                    	<ul class="list-unstyled">
			                        <li><a href="#">Dell</a></li>
			                        <li><a href="#">HP</a></li>
			                        <li><a href="#">Apple</a></li>
			                        <li><a href="#">Asus</a></li>
			                        <li><a href="#">Sony</a></li>
			                    </ul>
		                    </div>
		                    
		                    <div class="col-md-4">
		                    	<h4>Mức giá</h4>
		                    	<ul class="list-unstyled">
			                        <li><a href="<spring:url value="http://localhost:8080/webstore/market/products/Laptop?price=gia-_tu-2-den-5-trieu"/>">Dưới 2 triệu</a></li>
			                        <li><a href="#">Từ 2 - 5 triệu</a></li>
			                        <li><a href="#">Từ 5- 8 triệu</a></li>
			                        <li><a href="#">Trên 8 triệu</a></li>
			                    </ul>
		                    </div>

		                    <div class="col-md-4">
		                    	<h4>Bán chạy nhất</h4>
		                    	<ul class="list-unstyled">
			                        <li><a href="#">Sản phẩm 1-1</a></li>
			                        <li><a href="#">Sản phẩm 1-2</a></li>
			                        <li><a href="#">Sản phẩm 1-3</a></li>
			                    </ul>
		                    </div>
		                </div>
		            </li>
		        </ul>
		    </li>
		</ul>
	</div>

	<div class="col-sm-2" style="margin-top: 1%; padding-top: 2px; font-size: 16px">
		<ul id="multicol-menu" style="list-style-type: none;">
		    <li class="dropdown">
		        <a href="#" class="dropdown-toggle" data-toggle="dropdown">Labtop
		        	<b class="caret" style="margin-left: 5px"></b>
		        </a>
		        <ul class="dropdown-menu">
		            <li>
		                <div class="row" style="width: 600px; padding-left: 5%; padding-right: 5%">
		                    <div class="col-md-4">
		                    	<h4>Hãng sản xuất</h4>
		                    	<ul class="list-unstyled">
			                        <li><a href="#">Dell</a></li>
			                        <li><a href="#">HP</a></li>
			                        <li><a href="#">Apple</a></li>
			                        <li><a href="#">Asus</a></li>
			                        <li><a href="#">Sony</a></li>
			                    </ul>
		                    </div>
		                    
		                    <div class="col-md-4">
		                    	<h4>Mức giá</h4>
		                    	<ul class="list-unstyled">
			                        <li><a href="#">Dưới 10 triệu</a></li>
			                        <li><a href="#">Từ 10 - 15 triệu</a></li>
			                        <li><a href="#">Từ 15- 20 triệu</a></li>
			                        <li><a href="#">Trên 20 triệu</a></li>
			                    </ul>
		                    </div>

		                    <div class="col-md-4">
		                    	<h4>Bán chạy nhất</h4>
		                    	<ul class="list-unstyled">
			                        <li><a href="#">Sản phẩm 1-1</a></li>
			                        <li><a href="#">Sản phẩm 1-2</a></li>
			                        <li><a href="#">Sản phẩm 1-3</a></li>
			                    </ul>
		                    </div>
		                </div>
		            </li>
		        </ul>
		    </li>
		</ul>
	</div>

	<div class="col-sm-2" style="margin-top: 1%; padding-top: 2px; font-size: 16px">
		<ul id="multicol-menu" style="list-style-type: none;">
		    <li class="dropdown">
		        <a href="#" class="dropdown-toggle" data-toggle="dropdown">Tablet
		        	<b class="caret" style="margin-left: 5px"></b>
		        </a>
		        <ul class="dropdown-menu">
		            <li>
		                <div class="row" style="width: 600px; padding-left: 5%; padding-right: 5%">
		                    <div class="col-md-4">
		                    	<h4>Hãng sản xuất</h4>
		                    	<ul class="list-unstyled">
			                        <li><a href="#">Nokia</a></li>
			                        <li><a href="#">Samsung</a></li>
			                        <li><a href="#">Apple</a></li>
			                        <li><a href="#">LG</a></li>
			                        <li><a href="#">Xiaomi</a></li>
			                    </ul>
		                    </div>
		                    
		                    <div class="col-md-4">
		                    	<h4>Mức giá</h4>
		                    	<ul class="list-unstyled">
			                        <li><a href="#">Dưới 2 triệu</a></li>
			                        <li><a href="#">Từ 2 - 5 triệu</a></li>
			                        <li><a href="#">Từ 5- 8 triệu</a></li>
			                        <li><a href="#">Trên 8 triệu</a></li>
			                    </ul>
		                    </div>

		                    <div class="col-md-4">
		                    	<h4>Bán chạy nhất</h4>
		                    	<ul class="list-unstyled">
			                        <li><a href="#">Sản phẩm 1-1</a></li>
			                        <li><a href="#">Sản phẩm 1-2</a></li>
			                        <li><a href="#">Sản phẩm 1-3</a></li>
			                    </ul>
		                    </div>
		                </div>
		            </li>
		        </ul>
		    </li>
		</ul>
	</div>

	<div class="col-sm-2" style="margin-top: 1%; padding-top: 2px; font-size: 16px">
		<ul id="multicol-menu" style="list-style-type: none;">
		    <li class="dropdown">
		        <a href="#" class="dropdown-toggle" data-toggle="dropdown">Máy đổi trả
		        	<b class="caret" style="margin-left: 5px"></b>
		        </a>
		        <ul class="dropdown-menu">
		            <li>
		                <div class="row" style="width: 573px; padding-left: 5%; padding-right: 5%">
		                    <div class="col-md-4">
		                    	<h4>Hãng sản xuất</h4>
		                    	<ul class="list-unstyled">
			                        <li><a href="#">Nokia</a></li>
			                        <li><a href="#">Samsung</a></li>
			                        <li><a href="#">Apple</a></li>
			                        <li><a href="#">LG</a></li>
			                        <li><a href="#">Xiaomi</a></li>
			                    </ul>
		                    </div>
		                    
		                    <div class="col-md-4">
		                    	<h4>Mức giá</h4>
		                    	<ul class="list-unstyled">
			                        <li><a href="#">Dưới 2 triệu</a></li>
			                        <li><a href="#">Từ 2 - 5 triệu</a></li>
			                        <li><a href="#">Từ 5- 8 triệu</a></li>
			                        <li><a href="#">Trên 2 triệu</a></li>
			                    </ul>
		                    </div>

		                    <div class="col-md-4">
		                    	<h4>Bán chạy nhất</h4>
		                    	<ul class="list-unstyled">
			                        <li><a href="#">Sản phẩm 1-1</a></li>
			                        <li><a href="#">Sản phẩm 1-2</a></li>
			                        <li><a href="#">Sản phẩm 1-3</a></li>
			                    </ul>
		                    </div>
		                </div>
		            </li>
		        </ul>
		    </li>
		</ul>
	</div>

	<div class="col-sm-2" style="margin-top: 1%; padding-top: 2px; font-size: 16px">
		<ul id="multicol-menu" style="list-style-type: none;">
		    <li class="dropdown">
		        <a href="#" class="dropdown-toggle" data-toggle="dropdown">Phụ kiện
		        	<b class="caret" style="margin-left: 5px"></b>
		        </a>
		        <ul class="dropdown-menu">
		            <li>
		                <div style="width: 370px; padding-left: 5%; padding-right: 5%">
		                	<div class="row">
		                		<h4 style="margin-left: 15px">Các sản phẩm phụ kiện</h4>
		                	</div>

		                	<div class="row">
			                    <div class="col-md-6">
			                    	<ul class="list-unstyled">
				                        <li><a href="#">Tai nghe</a></li>
				                        <li><a href="#">Sạc dự phòng</a></li>
				                        <li><a href="#">Bao da, ốp lưng</a></li>
				                        <li><a href="#">Thẻ nhớ</a></li>
				                        <li><a href="#">Cáp sạc</a></li>
				                    </ul>
			                    </div>
			                    
			                    <div class="col-md-6">
			                    	<ul class="list-unstyled">
				                        <li><a href="#">Chuột</a></li>
				                        <li><a href="#">Bàn phím</a></li>
				                        <li><a href="#">Loa bluetooth</a></li>
				                        <li><a href="#">USB - ổ cứng</a></li>
				                    </ul>
			                    </div>
			                </div>
		                </div>
		            </li>
		        </ul>
		    </li>
		</ul>
	</div>


  </div>
  <!--/.navbar-collapse-->
</nav>
<!--/.navbar-->