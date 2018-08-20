<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<!-- <script>
		
	function runSlider(){

		$('.laptop-products-slider').slick({
			infinite: true,
			slidesToShow: 4,
			slidesToScroll: 3,
			autoplay: true,
			autoplaySpeed: 3000,
		});

		$('.smartphone-products-slider').slick({
			infinite: true,
			slidesToShow: 4,
			slidesToScroll: 3,
			autoplay: true,
			autoplaySpeed: 3000,
		});

		$('.tablet-products-slider').slick({
			infinite: true,
			slidesToShow: 4,
			slidesToScroll: 3,
			autoplay: true,
			autoplaySpeed: 3000,
		});
	};
</script> -->

<section  class="slider-products" style="background-image: url(<c:url value="/img/header/f-bg.png"></c:url>);">
	<section id="Laptop" ng-controller="productsCtrl" class="container">
		<div class="name-category" style="background-image: url(<c:url value="/img/header/shizzle-dark.png"></c:url>);">
			<a class="category" href=" <spring:url value="/market/products/Laptop" /> " style="background-image: url(<c:url value="/img/header/f-bg.png"></c:url>);">Laptop</a>
		</div>
		<div class="laptop-products-slider" ng-init="getProductsByCategory('Laptop')">
			<div class="products-slider" ng-repeat="item in productsCategoryData.listproducts" laptop-directive>
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

	<section id="Smartphone" class="products-slider container" ng-controller="productsCtrl">
		<div class="name-category" style="background-image: url(<c:url value="/img/header/shizzle-dark.png"></c:url>);">
			<a class="category" href=" <spring:url value="/market/products/Smartphone" /> " style="background-image: url(<c:url value="/img/header/f-bg.png"></c:url>);">Smartphone</a>
		</div>
		<div class="smartphone-products-slider" ng-init="getProductsByCategory('Smartphone')">
			<div class="products-slider" ng-repeat="item in productsCategoryData.listproducts" smartphone-directive>
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

	<section id="Tablet" class="products-slider container" ng-controller="productsCtrl">
		<div class="name-category" style="background-image: url(<c:url value="/img/header/shizzle-dark.png"></c:url>);">
			<a class="category" href=" <spring:url value="/market/products/Tablet" /> " style="background-image: url(<c:url value="/img/header/f-bg.png"></c:url>);">Tablet</a>
		</div>
		<div class="tablet-products-slider" ng-init="getProductsByCategory('Tablet')">
			<div class="products-slider" ng-repeat="item in productsCategoryData.listproducts" tablet-directive>
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
<!-- 	<script type="text/javascript">
		runSlider();
	</script> -->
</section>

