<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" %>

<script>
	setTimeout(function(){
		$('.slideshow-container').slick({
			infinite: true,
			slidesToShow: 1,
			slidesToScroll: 1,
			autoplay: true,
			autoplaySpeed: 3000,
		});}, 1000)
</script>

<section class="container">
	<div class="row" style="display: flex;">
		<div class="slideshow-container col-md-12" style="background-image: url(<c:url value="/img/header/f-bg.png"></c:url>);">
			<a href=" <spring:url value="/market/product?id=P2014" /> ">
				<div class="img-full-width">
					<img src="<c:url value="/img/big-slidebar/GALAXY-A8.jpg"/>"/>
				</div>
			</a>
			<a href=" <spring:url value="/market/product?id=P2015" /> ">
				<div class="img-full-width">
					<img src="<c:url value="/img/big-slidebar/HUAWEI-2I.jpg"/>"/>
				</div>
			</a>
			<a href=" <spring:url value="/market/product?id=P2016" /> ">
				<div class="img-full-width">
					<img src="<c:url value="/img/big-slidebar/IPHONE-X.jpg"/>"/>
				</div>
			</a>
			<a href=" <spring:url value="/market/product?id=P2017" /> ">
				<div class="img-full-width">
					<img src="<c:url value="/img/big-slidebar/OPPO-F5.jpg"/>"/>
				</div>
			</a>
			<a href=" <spring:url value="/market/product?id=P2018" /> ">
				<div class="img-full-width">
					<img src="<c:url value="/img/big-slidebar/VIVO-V7.jpg"/>"/>
				</div>
			</a>
		</div>
	</div><!-- row -->
	<script type="text/javascript">
		runBigSlider();
	</script>
</section>