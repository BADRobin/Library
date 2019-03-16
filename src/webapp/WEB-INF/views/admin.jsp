<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/views/templates/header.jsp" %>
<br>
<br>
<div class="container">
    <br>
    <div class="list-group">
        <p class="list-group-item active">
            Операции
        </p>
        <a class="list-group-item" href="<c:url value="/admin/inventory" />">
            <span class="glyphicon glyphicon-th-list"></span>
            ПРОДУКЦИЯ
        </a>
        <a class="list-group-item" href="<c:url value="/admin/people" /> ">
            <span class="glyphicon glyphicon-user"></span>
            Список пользователей</a>
        <a class="list-group-item" href="<c:url value="/admin/peopleorder" /> ">
            <span class="glyphicon glyphicon-th-list"></span>
            Заказы</a>
    </div>
    <%--INSERT INTO  users VALUES (1,0,true,'admin','admin');--%>
    <%--INSERT INTO authorities VALUES (1,'ROLE_ADMIN','admin');--%>
</div>
<br><br><br><br><br><br><br>
<%@include file="/WEB-INF/views/templates/footer.jsp" %>

