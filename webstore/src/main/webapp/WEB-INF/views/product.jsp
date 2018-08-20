<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>



<style>
.fa {
    font-size: 25px;

}

.glyphicon
{
 color: orange;
}

.checked {
    color: orange;
}
</style>


<section>
	<section class="container detail-product" style="background-image: url(<c:url value="/img/header/f-bg.png"></c:url>);">
		<div class="name-category" style="background-image: url(<c:url value="/img/header/shizzle-dark.png"></c:url>);">
			<a class="category" style="background-image: url(<c:url value="/img/header/f-bg.png"></c:url>);">${product.name}</a>
		</div>
		<div>
			<div class="col-md-6 slider-thumb" style="background-image: url(<c:url value="/img/${product.productId}.png"></c:url>);">
			</div>

			<div class="col-md-6 product-info-big-slider padding-top-7">
				<h1>${product.name}</h1>
				<div style>${product.description}</div>
				<div>
					<strong>Mã sản phẩm: </strong><span class="label label-warning">${product.productId}</span>
				</div>
				<div>
					<strong>Nhà sản xuất: </strong>${product.manufacturer}
				</div>
				<div>
					<strong>Thư mục: </strong> ${product.category}
				</div>
				<div>
					<strong>Số lượng trong kho: </strong> ${product.unitsInStock}
				</div>
				<div>
					<strong>Được đánh giá: </strong> 
					<span class="fa fa-star checked"></span> 
					<span class="fa fa-star checked"></span> 
					<span class="fa fa-star checked"></span> 
					<span class="fa fa-star checked"></span> 
					<span class="fa fa-star"></span>
				</div>
				
				<h4 class="price"><span>Giá: </span>
					<fmt:formatNumber type = "number" maxFractionDigits = "2" value = "${product.unitPrice}" /> VNĐ
				</h4>
				<div ng-controller="cartCtrl">
					<a href="<spring:url value="/market/products" />"
						class="btn btn-default"> <span
						class="glyphicon-hand-left glyphicon"></span> Quay Lại
					</a> <a href="#" class="btn btn-warning btn-large"
						ng-click="addToCart('${product.productId}')"> <span
						class="glyphicon-shopping-cart glyphicon"></span> Mua Ngay
					</a> <a href="<spring:url value="/cart" />" class="btn btn-default">
						<span class="glyphicon-hand-right glyphicon"></span> Xem Giỏ
					</a>

				</div>
			</div>
		</div>
	</section>

	<section ng-controller="RatingCtrl" ng-init="initUserRating('${username}', '${product.productId}')">
		<div class="container detail-product"
			style="background-image: url(<c:url value="/img/header/f-bg.png"></c:url>);">
			<div class="fa">
			<b> Đánh giá của bạn: </b>
				<uib-rating n ng-change="changeRate(point, '${username}', '${product.productId}')" ng-model="point"
					rating-states="ratingStates"> </uib-rating>
				<b>({{point}} <i>Sao</i>)
				</b>
			</div>
		</div>
	</section>

	<section class="slider-products" style="background-image: url(<c:url value="/img/header/f-bg.png"></c:url>);">
		<section class="detail-slider container" ng-controller="cartCtrl">
				<div class="name-category" style="background-image: url(<c:url value="/img/header/shizzle-dark.png"></c:url>);">
					<a class="category" href=" <spring:url value="/market/products/Smartphone" /> " style="background-image: url(<c:url value="/img/header/f-bg.png"></c:url>);">Các sản phẩm có liên quan</a>
				</div>
				<div class="same-category-slider" ng-init="getProductsRecommendation('${product.productId}','${product.category}','${product.unitPrice}')">
					<div class="products-slider" ng-repeat="item in productsCategoryData.listproducts" my-repeat-directive>
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

<!-- <script type="text/javascript">
	runSlider();
</script> -->
