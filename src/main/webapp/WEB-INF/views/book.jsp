<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@include file="/WEB-INF/views/templates/header.jsp" %>

<br>
<!-- Page Content -->
<div class="container-wrapper" ng-app="cartApp" ng-controller="cartCtrl">


    <div class="container ">
        <div class="row">
            <div class="col-sm-8 col-md-10">
                <div class="page-header">
                    <h1>All our Books
                        <small>                              Choose what you like</small>
                    </h1>
                </div>
            </div>
        </div>
        <!-- Title -->
        <br>
        <!-- Page Features -->
        <div class="row text-center">

            <c:forEach items="${list_books}" var="book">
                <div class="col-md-3 col-sm-6 hero-feature">
                    <div class="thumbnail">
                        <img src="<c:url value="/resources/book_images/${book.book_id}.png" />"
                             alt="${book.firstName}">
                        <hr>
                        <div class="caption">
                            <p class="book-name"><b>${book.firstName}</b></p>


                            <p>
                                <a href="<spring:url value="/book/BookDetails/${book.book_id}" />"
                                   class="btn btn-info">
                                    Details <span class="glyphicon glyphicon-info-sign"></span>
                                </a>
                                <c:if test="${pageContext.request.userPrincipal.name != null}">
                                    <a href="#" class="btn btn-primary" ng-click="download(${book.book_id})" data-toggle="modal" data-target="#myModal">
                                        Download <span class="glyphicon glyphicon-download"></span>
                                    </a>
                                </c:if>
                                <c:if test="${pageContext.request.userPrincipal.name == null}">
                                    <a href="<c:url value="/login"/>" class="btn btn-primary">
                                        Download <span class="glyphicon glyphicon-download"></span>
                                    </a>
                                </c:if>
                            </p>
                        </div>
                    </div>
                </div>
            </c:forEach>


        </div>
        <!-- /.row -->
    </div>
    <!-- /.container -->
</div>



<script src="/resources/js/controller.js" type="text/javascript"></script>
<%@include file="/WEB-INF/views/templates/footer.jsp" %>
