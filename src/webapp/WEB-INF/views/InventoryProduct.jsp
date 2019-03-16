<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@include file="templates/header.jsp" %>


<div class="container-wrapper">
    <div class="container">
        <h1 style="text-align: center">Инвентарь</h1>
        <hr>
        <br>

        <h1>Производить</h1>
        <div class="table-responsive">
            <table class="table table-custom table-hover table-condensed">
                <thead>
                <tr class="bg-success">
                    <th>Номер Фото</th>
                    <th>Имя</th>
                    <th>Производство</th>
                    <th>Категория</th>
                    <th>Состояние</th>
                    <th>Цена</th>
                    <th></th>
                    <th></th>
                    <th></th>
                </tr>
                </thead>
                <c:forEach items="${list_Book}" var="book">
                    <tr>
                        <td><img src="<c:url value="/resources/Book_images/${book.Book_id}.png" />" alt="image"></td>
                        <td>${book.firstName}</td>
                        <td>${book.author}</td>
                        <td>${book.category}</td>
                        <%--<td>${book.condition}</td>--%>

                        <td>
                            <!-- Book INFORMATION-->
                            <a href="<spring:url value="/book/BookDetails/${book.Book_id}" />"
                               class="btn btn-info">
                                Детали <span class=" glyphicon glyphicon-info-sign"></span>
                            </a>
                        </td>
                        <td>
                            <!-- EDIT Book -->
                            <a href="<spring:url value="/admin/inventory/edit/${book.Book_id}" />"
                               class="btn btn-success">
                                Редактировать <span class="glyphicon glyphicon-pencil"></span>
                            </a>
                        </td>
                        <td>
                            <!-- ELIMINATE Book-->
                            <a href="<spring:url value="/admin/inventory/remove/${book.Book_id}" />"
                               class="btn btn-danger">
                                Удаление <span class="glyphicon glyphicon-remove"></span>
                            </a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <a class="btn btn-primary" href="<spring:url value="/admin/inventory/add" />">Добавить продукт</a>
        <br>
        <div class="pager">
            <br>
            <li>
                <a href="<c:url value="/admin"/>">
                    <span class="glyphicon glyphicon-backward"></span> Возвращение
                </a>
            </li>
        </div>
    </div>
</div>

<%@include file="templates/footer.jsp" %>