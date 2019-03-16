<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/views/templates/header.jsp" %>


<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <div class="col-md-6"></div>
            <br>
            <h1 class="alert alert-success">Данные о доставке <small>Введите желаемую информацию о местоположении для доставки.</small></h1>
        </div>

        <form:form commandName="order" class="form">
            <h3>Регистрация информации о доставке: </h3>

            <div class="form-group">
                <label for="shipping_street">Улица</label>
                <form:input path="cart.people.shippingAddress.street" id="shipping_street"
                            class="form-control"
                            tabindex="1"/>
            </div>
            <div class="form-group">
                <label for="number_apartment">No.Квартиры</label>
                <form:input path="cart.people.shippingAddress.number_apartment" id="number_apartment"
                            class="form-control"
                            tabindex="2"/>
            </div>
            <div class="form-group">
                <label for="shipping_division">Отдел / Группа</label>
                <form:input path="cart.people.shippingAddress.division" id="shipping_division"
                            class="form-control"
                            tabindex="3"/>
            </div>
            <div class="form-group">
                <label for="shipping_city">Город</label>
                <form:input path="cart.people.shippingAddress.city" id="shipping_city"
                            class="form-control"
                            tabindex="4"/>
            </div>
            <div class="form-group">
                <label for="shipping_state">Область</label>
                <form:input path="cart.people.shippingAddress.state" id="shipping_state"
                            class="form-control"
                            tabindex="5"/>
            </div>
            <div class="form-group">
                <label for="shipping_country">Страна</label>
                <form:input path="cart.people.shippingAddress.country" id="shipping_country" class="form-control"
                            tabindex="6"/>
            </div>
            <div class="form-group">
                <label for="shipping_zip">Почтовый индекс</label>
                <form:input path="cart.people.shippingAddress.zip" id="shipping_zip" class="form-control"
                            tabindex="7"/>
            </div>
            <input type="hidden" name="_flowExecutionKey"/>

            <br><br>
            <%-- BACK/CANCELAR/NEXT  ===========--%>

            <button class="btn btn-danger" tabindex="9" name="_eventId_cancel"> Отменить</button>
            <input type="submit" value="Continue" class="btn btn-primary" tabindex="8"
                   name="_eventId_shippingDetailCollected">
            <br>
            <button class="btn btn-default" style="margin-top:15px;" tabindex="10"
                    name="_eventId_backToCollectpeopleInfo"> Возврат
            </button>

        </form:form>

    </div>
</div>


<%@include file="/WEB-INF/views/templates/footer.jsp" %>

