<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ include file="/WEB-INF/views/templates/header.jsp" %>

<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Список пользователей</h1>
        </div>

        <table class="table table-striped table-hover">
            <thead>
            <tr class="bg-success">
                <th>имя</th>
                <th>Email</th>
                <th>телефон</th>
                <th>Имя пользователя</th>
                <th>состояние</th>
            </tr>
            </thead>
            <c:forEach items="${customerList}" var="customer">
                <tr>
                    <td>${customer.customer_name}</td>
                    <td>${customer.customer_email}</td>
                    <td>${customer.customer_phone}</td>
                    <td>${customer.customer_username}</td>
                    <c:if test="${customer.enabled == true}">
                        <td>активный</td>
                    </c:if>
                    <c:if test="${customer.enabled == false}">
                        <td>неактивный</td>
                    </c:if>

                </tr>
            </c:forEach>
        </table>
        <div class="pager">
            <br>
            <li>
                <a href="<c:url value="/admin"/>">
                    <span class="glyphicon glyphicon-backward"></span> Возврат
                </a>
            </li>
        </div>

<%@ include file="/WEB-INF/views/templates/footer.jsp" %>