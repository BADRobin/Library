<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="templates/header.jsp" %>


<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <div class="col-md-6"></div>
            <h1><span class="label label-info"> Register to be able to download books! </span></h1>
            <br>
            <br>
            <h1> User registration </h1>
        </div>
        <form:form action="${pageContext.request.contextPath}/registry"
                   method="post" commandName="people">
            <h3>User Information: </h3>

            <div class="form-group">
                <label for="name"> Name  </label> <form:errors path="people_name" cssStyle="color: red"/>
                <form:input path="people_name" id="name" class="form-control" tabindex="1"/>
            </div>

            <div class="form-group">
                <label for="email"> Email </label> <span style="color: #ff0000">${people_email}</span>
                <form:input path="people_email" id="email" class="form-control" tabindex="2"/>
            </div>

            <div class="form-group">
                <label for="phone"> Phone number (10 digits) </label> <form:errors path="people_phone"
                                                                                cssStyle="color: red"/>
                <form:input path="people_phone" id="phone" class="form-control" tabindex="3"/>
            </div>

            <div class="form-group">
                <label for="username"> Login to the system</label> <span
                    style="color: #ff0000">${people_username}</span>
                <form:input path="people_username" id="username" class="form-control" tabindex="4"/>
            </div>

            <div class="form-group">
                <label for="password"> Password </label> <form:errors path="people_password"
                                                                             cssStyle="color: red"/>
                <form:password path="people_password" id="password" class="form-control" tabindex="5"/>
            </div>

            <br>
            <%-- SUBMIT/CANCEL BUTTON  ===========--%>
            <a href="<c:url value="/" />" class="btn btn-default" tabindex="19"> Cancel </a>
            <input type="submit" value="Add" class="btn btn-primary" tabindex="18">
        </form:form>

    </div>
</div>


<%@include file="templates/footer.jsp" %>
