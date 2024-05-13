<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="templates/header.jsp" %>


<div class="container-wrapper">
    <div class="container">
        <h1>Modify</h1>
        <br>
        <br>

        <form:form action="${pageContext.request.contextPath}/admin/inventory/edit"
                   method="post" commandName="book" enctype="multipart/form-data">
            <form:hidden path="book_id" value="${book.book_id}"/>

            <div class="form-group">
                <label for="firstName"> Book title</label> <form:errors path="firstName" cssStyle="color: red"/>
                <form:input path="firstName" id="firstName" class="form-control" value="${book.firstName}"/>
            </div>

            <div class="form-group">
                <label for="author"> Author </label>
                <form:input path="author" id="author" class="form-control"
                            value="${book.author}"/>
            </div>

            <div class="form-group">
                <label for="category"> Genre </label> <form:errors path="category" cssStyle="color: red"/>
                <form:select path="category" id="category" class="form-control" items="${category_list}"/>
            </div>

            <div class="form-group">
                <label for="description"> Brief description </label>
                <form:textarea path="description" id="description" class="form-control"
                               value="${book.description}"/>
            </div>







            <%-- UPLOAD Book IMAGE  ===================--%>
            <div class="form-group">
                <label class="control-label" for="image">Upload image</label>
                <form:input path="image" id="image" type="file" class="form:input-large"/>
            </div>
            <div class="form-group">
                <label class="control-label" for="bookfile">Download Book</label>
                <form:input path="bookFile" id="bookfile" type="file" class="form:input-large"/>
            </div>

            <%-- SUBMIT/CANCEL BUTTON  ===========--%>
            <a href="<c:url value="/admin/inventory" />" class="btn btn-default"> Cancel </a>
            <input type="submit" value="Save" class="btn btn-primary">
        </form:form>

    </div>
</div>

<%@include file="templates/footer.jsp" %>
