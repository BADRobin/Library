<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ include file="/WEB-INF/views/templates/header.jsp" %>

<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>User list</h1>
        </div>

        <table class="table table-striped table-hover">
            <thead>
            <tr class="bg-success">
                <th>Name</th>
                <th>Email</th>
                <th>Phone number</th>
                <th>User Name</th>
                <th>Status</th>
            </tr>
            </thead>
            <c:forEach items="${peopleList}" var="people">
                <tr>
                    <td>${people.people_name}</td>
                    <td>${people.people_email}</td>
                    <td>${people.people_phone}</td>
                    <td>${people.people_username}</td>
                    <c:if test="${people.enabled == true}">
                        <td>active</td>
                    </c:if>
                    <c:if test="${people.enabled == false}">
                        <td>inactive</td>
                    </c:if>

                </tr>
            </c:forEach>
        </table>
        <div class="pager">
            <br>
            <li>
                <a href="<c:url value="/admin"/>">
                    <span class="glyphicon glyphicon-backward"></span> Back to
                </a>
            </li>
        </div>

<%@ include file="/WEB-INF/views/templates/footer.jsp" %>