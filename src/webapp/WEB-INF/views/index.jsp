<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/views/templates/header.jsp" %>


<!-- Carousel
================================================== -->
<div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
        <li data-target="#myCarousel" data-slide-to="1"></li>
        <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>
    <div class="carousel-inner" role="listbox">
        <div class="item active">
            <img class="first-slide base-image"
                 src="resources/site-images/cover1.jpg"
                 alt="First slide">
            <div class="container">
                <div class="carousel-caption">
                    <h1>Добро пожаловать в приложение!</h1>
                    <p>Найдите необходимые книги тут.</p>

                </div>
            </div>
        </div>
        <div class="item">
            <img class="second-slide base-image"
                 src="resources/site-images/cover-4.jpg"
                 alt="Second slide">
            <div class="container">
                <div class="carousel-caption">
                    <h1>Большой выбор литературы!</h1>
                    <p>Все жанры.</p>
                </div>
            </div>
        </div>
        <div class="item">
            <img class="third-slide base-image"
                 src="resources/site-images/cover-8.jpg"
                 alt="Third slide">
            <div class="container">
                <div class="carousel-caption">
                    <h1>А вот тут было лень писать!</h1>
                    <p>И что-то еще придумывать. Всё равно еще доделывать и редактировать.</p>
                </div>
            </div>
        </div>
    </div>
    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
        <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
        <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
    </a>
</div>
<!-- /.carousel -->


<!-- Marketing messaging and featurettes
================================================== -->

</div>
<br>
<br>
<!-- /.container -->

<%@include file="/WEB-INF/views/templates/footer.jsp" %>