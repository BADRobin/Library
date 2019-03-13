<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="templates/header.jsp" %>


<div class="container-wrapper">
    <div class="container">
        <h1>Изменить продукт</h1>
        <br>
        <br>

        <form:form action="${pageContext.request.contextPath}/admin/inventory/edit"
                   method="post" commandName="product" enctype="multipart/form-data">
            <form:hidden path="product_id" value="${product.product_id}"/>

            <div class="form-group">
                <label for="firstName"> Название продукта</label> <form:errors path="firstName" cssStyle="color: red"/>
                <form:input path="firstName" id="firstName" class="form-control" value="${product.firstName}"/>
            </div>

            <div class="form-group">
                <label for="manufacturing"> Производство </label>
                <form:input path="manufacturing" id="manufacturing" class="form-control"
                            value="${product.manufacturing}"/>
            </div>

            <div class="form-group">
                <label for="category"> Категория </label> <form:errors path="category" cssStyle="color: red"/>
                <form:select path="category" id="category" class="form-control" items="${category_list}"/>
            </div>

            <div class="form-group">
                <label for="description"> Описание продукта</label>
                <form:textarea path="description" id="description" class="form-control"
                               value="${product.description}"/>
            </div>

            <%--<div class="form-group">--%>
                <%--<label for="condition"> Состояние продукта</label>--%>
                <%--<br>--%>
                <%--<label class="checkbox-inline">--%>
                    <%--<form:radiobutton path="condition" id="condition" value="New"/> Новый </label>--%>
                <%--<label class="checkbox-inline">--%>
                    <%--<form:radiobutton path="condition" id="condition" value="Old"/> Используемый </label>--%>
            <%--</div>--%>

            <div class="form-group">
                <label for="price"> Цена $ MXN</label> <form:errors path="price" cssStyle="color: red"/>
                <form:input path="price" id="price" class="form-control" value="${product.price}"/>
            </div>

            <div class="form-group">
                <label for="units_in_existence"> Доступные единицы </label> <form:errors
                    path="units_in_existence" cssStyle="color: red"/>
                <form:input path="units_in_existence" id="units_in_existence" class="form-control"
                            value="${product.units_in_existence}"/>
            </div>

            <%-- UPLOAD PRODUCT IMAGE  ===================--%>
            <div class="form-group">
                <label class="control-label" for="image">Загрузить изображение</label>
                <form:input path="image" id="image" type="file" class="form:input-large"/>
            </div>

            <%-- SUBMIT/CANCEL BUTTON  ===========--%>
            <a href="<c:url value="/admin/inventory" />" class="btn btn-default"> Отменить </a>
            <input type="submit" value="Save" class="btn btn-primary">
        </form:form>

    </div>
</div>

<%@include file="templates/footer.jsp" %>
