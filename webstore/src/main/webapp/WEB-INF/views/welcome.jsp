<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
     <head>
          <meta charset="utf-8">
          <meta http-equiv="X-UA-Compatible" content="IE=edge">
          <meta name="viewport" content="width=device-width, initial-scale=1">
          
          <title>Welcome</title>
          
          <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
          
     </head>
     
     <body>
          <div class="jumbotron">
                  <h1> ${greeting} </h1>
                  <p> ${tagline} </p>
          </div>
          
        <script>
	$(document).ready(function(){
		$('.slideshow-container').slick({
			infinite: true,
			slidesToShow: 1,
			slidesToScroll: 1,
			autoplay: true,
			autoplaySpeed: 3000,
		});

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
	});
</script>

<section class="container">
<div class="slideshow-container">
	<c:forEach items="${products}" var="product">
			<div>
				<div class="col-md-6 slider-thumb" style="background-image: url(<c:url value="/img/${product.productId}.png"></c:url>);">
				</div>

				<div class="col-md-6">
					<h3>${product.name}</h3>
					<p>${product.description}</p>
					<h4 class="price">$ ${product.unitPrice}USD</h4>
					<p ng-controller="cartCtrl">
						<a href=" <spring:url value="/market/product?id=${product.productId}" /> "
							class="btn btn-primary"> <span
							class="glyphicon-info-sign glyphicon" /></span> Details
						</a>
					</p>
				</div>
			</div>
	</c:forEach>
</div>

<div>
	
</div>

</section>
     </body>
</html>
