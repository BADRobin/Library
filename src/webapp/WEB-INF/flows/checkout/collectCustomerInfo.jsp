<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/templates/header.jsp" %>


<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <div class="col-md-6"></div>
            <br>
            <h1 class="alert alert-success"> Информация о заявителе <small>  (убедитесь, что ваша информация верна)</small></h1>
            <hr>


            <form:form commandName="order" class="form ">
                <h3>Информация о пользователе: </h3>
                <div class="form-group">
                    <label for="name">Имя</label>
                    <form:input path="cart.people.people_name" id="name" class="form-Control" tabindex="1"/>
                </div>
                <div class="form-group">
                    <label for="email"> Электронная почта </label>
                    <form:input path="cart.people.people_email" id="email" class="form-control" tabindex="2"/>
                </div>
                <div class="form-group">
                    <label for="phone"> Телефон (10 цифр) </label>
                    <form:input path="cart.people.people_phone" id="phone" class="form-control" tabindex="3"/>
                </div>
                <hr>
                <h3 class="alert alert-warning">Регистрация информации об карте: </h3>
                <div class="form-group">
                    <label for="card_holder">Карточка владельца (кредитная / дебетовая)</label>
                    <form:input path="cart.people.billingAddress.card_holder" id="card_holder"
                                class="form-control" onkeydown="upperCaseF(this)"
                                tabindex="4"/>
                </div>
                <div class="form-group">
                    <label for="card_number">Номер карты</label>
                    <form:input path="cart.people.billingAddress.card_number" id="card_number"
                                class="form-control" maxlength="19"
                                tabindex="5"/>
                </div>
                <div class="form-group">
                    <label for="date_expiration">Дата истечения срока действия</label>
                    <form:input path="cart.people.billingAddress.date_expiration" id="date_expiration"
                                class="form-control" maxlength="5"
                                tabindex="6"/>
                </div>
                <div class="form-group">
                    <label for="security_code">Защитный код</label>
                    <form:input path="cart.people.billingAddress.security_code" id="security_code"
                                class="form-control" maxlength="3"
                                tabindex="7"/>
                </div>
                <input type="hidden" name="_flowExecutionKey"/>
                <br><br>

                <%-- CANCEL/NEXT  ===========--%>
                <button class="btn btn-danger" tabindex="9" name="_eventId_cancel"> Отменить</button>
                <input type="submit" value="Continue" class="btn btn-primary" tabindex="8"
                       name="_eventId_peopleInfoCollected">


            </form:form>


        </div>
    </div>
</div>

<%@include file="/WEB-INF/views/templates/footer.jsp" %>

