<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" %>

<script>
	function topFunction() {
	    document.body.scrollTop = 0;
	    document.documentElement.scrollTop = 0;
	}

/* 	function runSlider() {
		$('.same-category-slider').slick({
			infinite: true,
			slidesToShow: 4,
			slidesToScroll: 3,
			autoplay: true,
			autoplaySpeed: 3000,
		});
	}; */
</script>

 <!-- version 3 -->

<section style="background-image: url(<c:url value="/img/header/f-bg.png"></c:url>);">
	<section class="container">
	
	   <div class="name-category" style="background-image: url(<c:url value="/img/header/shizzle-dark.png"></c:url>);">
	   		<center>
	   			<a class="category"" style="background-image: url(<c:url value="/img/header/f-bg.png"></c:url>);">${categoryId} ${brand}</a>
	   		</center>
		</div>
	
	   <div ng-controller="productsCtrl" style="background-image: url(<c:url value="/img/header/f-bg.png"></c:url>);">
	      <p ng-init="getProductsByCategoryBrandPricePage('${categoryId}', '${brand}', '${lowprice}', '${highprice}')"></p>
	      <div class="show-product-by-category row">
	         <div ng-repeat="item in productsCategoryData.listproducts" class="col-md-3">
	            <div class="polaroid">
						<center>
							<a href=" <spring:url value="/market/product?id={{item.productId}}" /> ">
								<div class="thumb" style="background-image: url(<c:url value="/img/{{item.productId}}.png"></c:url>);">
								</div>
							</a>
						</center>
	
						<div class="caption">
							<p>{{item.name}}</p>
							<p class="price formatMoney">{{item.unitPrice}}</p>
						</div>
					</div>
	         </div>
	      </div>
	
	      <center>
	         <ul class="pagination">          
	            <li ng-repeat="item in totalPages">
	               <a ng-click="getProductsByCategoryBrandPricePage('${categoryId}', '${brand}', '${lowprice}', '${highprice}', item)" onclick="topFunction()">
	                  {{item}}
	               </a>
	            </li>          
	         </ul>
	      </center>
	   </div>
	</section>
	
	<section class="slider-products" style="background-image: url(<c:url value="/img/header/f-bg.png"></c:url>);">
		<section class="detail-slider container" ng-controller="productsCtrl">
				<div class="name-category" style="background-image: url(<c:url value="/img/header/shizzle-dark.png"></c:url>);">
					<a class="category" href=" <spring:url value="/market/products/Smartphone" /> " style="background-image: url(<c:url value="/img/header/f-bg.png"></c:url>);">Các sản phẩm có liên quan</a>
				</div>
				<div class="same-category-slider" ng-init="getProductsByCategory('${categoryId}')">
					<div class="products-slider" ng-repeat="item in productsCategoryData.listproducts" category-directive>
						<div class="polaroid">
							<center>
								<a href=" <spring:url value="/market/product?id={{item.productId}}" /> ">
									<div class="thumb" style="background-image: url(<c:url value="/img/{{item.productId}}.png"></c:url>);">
									</div>
								</a>
							</center>
		
							<div class="caption">
								<p>{{item.name}}</p>
								<p class="price formatMoney">{{item.unitPrice}}</p>
							</div>
						</div>
					</div>
				</div>
			</section>
		</section>
	</section>
	<!-- 
	<script type="text/javascript">
		runSlider();
	</script> -->
</section>