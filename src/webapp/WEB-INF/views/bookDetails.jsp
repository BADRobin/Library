<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/views/templates/header.jsp" %>

<!-- Page Content -->
<div class="container" ng-app="cartApp" ng-controller="cartCtrl">

    <!-- Portfolio Item Heading -->
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">${book.firstName}
                <small> ${book.author}</small>
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

            <h3 class="text-info">Сведения о книге</h3>
            <table class="table table-hover table-condensed">
                <thead>
                <tr>
                    <td></td>
                    <td></td>
                </tr>
                </thead>
                <tr>
                    <td><h4>Автор</h4></td>
                    <td><h4>${book.author}</h4></td>
                </tr>
                <tr>
                    <td><h4>Жанр</h4></td>
                    <td><h4>${book.category}</h4></td>
                </tr>

                <tr>

                    <td><h3 class="text-info">Краткое описание</h3></td>
                    <td><p>${book.description}</p></td>
                </tr>
                    <%-- the rowspan attr is used as a hack to override the table-hover effect --%>
                    <td rowspan="2">
                        <div class="pager">
                            <li>
                                <a href="javascript:history.back()">
                                    <span class="glyphicon glyphicon-backward"></span> Назад
                                </a>
                            </li>
                        </div>
                    </td>
                    <td rowspan="2">
                        <c:if test="${pageContext.request.userPrincipal.name != null}">
                            <a href="#" class="btn btn-primary" ng-click="addToCart(${book.book_id})"
                               data-toggle="modal" data-target="#myModal">
                                Скачать <span class="glyphicon glyphicon-download"></span></a>
                        </c:if>
                        <c:if test="${pageContext.request.userPrincipal.name == null}">
                            <button type="button" href="<spring:url value="/login"/>" class="btn btn-primary">
                                Скачать <span class="glyphicon glyphicon-download"></span></button>
                        </c:if>
                    </td>
                </tr>
            </table>
        </div>
    </div>
</div>


<!-- Modal -->
<%--<div class="modal fade" id="myModal" role="dialog">--%>
    <%--<div class="modal-dialog">--%>

        <%--<!-- Modal content-->--%>
        <%--<div class="modal-content">--%>
            <%--<div class="modal-header">--%>
                <%--<button type="button" class="btn btn-danger pull-right" data-dismiss="modal">Близко</button>--%>
                <%--<h3 class="modal-title" style="text-shadow: 1px 1px 2px dodgerblue"> Успешная работа</h3>--%>
            <%--</div>--%>
            <%--<div class="modal-body">--%>
                <%--<h3 style="text-shadow: 1px 1px 2px darkorchid">Продукт добавлен в вашу заявку с успехом.</h3>--%>
                <%--<br>--%>
            <%--</div>--%>
        <%--</div>--%>

    <%--</div>--%>
<%--</div>--%>

<!-- /.row -->

<script src="/resources/js/controller.js" type="text/javascript"></script>
<%@include file="/WEB-INF/views/templates/footer.jsp" %>
