<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/views/templates/header.jsp" %>

<!-- Page Content -->
<div class="container" ng-app="cartApp" ng-controller="cartCtrl">

    <!-- Portfolio Item Heading -->
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">${book.firstName}

            </h1>
        </div>
    </div>
    <!-- /.row -->

    <!-- Portfolio Item Row -->
    <div class="row">

        <div class="col-md-6">
            <img class="img-responsive detalles"
                 src="<c:url value="/resources/book_images/${book.book_id}.png" />"
                 alt="${book.firstName}">
        </div>

        <div class="col-md-6">

            <h3 class="text-info">Book Details</h3>
            <table class="table table-hover table-condensed">
                <thead>
                <tr>
                    <td></td>
                    <td></td>
                </tr>
                </thead>
                <tr>
                    <td><h4>Author</h4></td>
                    <td><h4>${book.author}</h4></td>
                </tr>
                <tr>
                    <td><h4>Genre</h4></td>
                    <td><h4>${book.category}</h4></td>
                </tr>

                <tr>

                    <td><h3 class="text-info">Short description</h3></td>
                    <td><p>${book.description}</p></td>
                </tr>
                    <%-- the rowspan attr is used as a hack to override the table-hover effect --%>
                    <td rowspan="2">
                        <div class="pager">
                            <li>
                                <a href="javascript:history.back()">
                                    <span class="glyphicon glyphicon-backward"></span> Back to
                                </a>
                            </li>
                        </div>
                    </td>
                    <td rowspan="2">
                        <c:if test="${pageContext.request.userPrincipal.name != null}">
                            <a href="#" class="btn btn-primary" ng-click="addToCart(${book.book_id})"
                               data-toggle="modal" data-target="#myModal">
                                Download <span class="glyphicon glyphicon-download"></span></a>
                        </c:if>
                        <c:if test="${pageContext.request.userPrincipal.name == null}">
                            <button type="button" href="<spring:url value="/login"/>" class="btn btn-primary">
                                Download <span class="glyphicon glyphicon-download"></span></button>
                        </c:if>
                    </td>
                </tr>
            </table>
        </div>
    </div>
</div>




<script src="/resources/js/controller.js" type="text/javascript"></script>
<%@include file="/WEB-INF/views/templates/footer.jsp" %>
