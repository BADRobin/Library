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
                <c:forEach items="${list_products}" var="product">
                    <tr>
                        <td><img src="<c:url value="/resources/product_images/${product.product_id}.png" />" alt="image"></td>
                        <td>${product.firstName}</td>
                        <td>${product.manufacturing}</td>
                        <td>${product.category}</td>
                        <%--<td>${product.condition}</td>--%>
                        <td><p class="price"><fmt:formatNumber type="currency">${product.price}</fmt:formatNumber> MXN</p></td>
                        <td>
                            <!-- PRODUCT INFORMATION-->
                            <a href="<spring:url value="/products/productDetails/${product.product_id}" />"
                               class="btn btn-info">
                                Детали <span class=" glyphicon glyphicon-info-sign"></span>
                            </a>
                        </td>
                        <td>
                            <!-- EDIT PRODUCT -->
                            <a href="<spring:url value="/admin/inventory/edit/${product.product_id}" />"
                               class="btn btn-success">
                                Редактировать <span class="glyphicon glyphicon-pencil"></span>
                            </a>
                        </td>
                        <td>
                            <!-- ELIMINATE PRODUCT-->
                            <a href="<spring:url value="/admin/inventory/remove/${product.product_id}" />"
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