<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fwt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@include file="/WEB-INF/views/templates/header.jsp" %>
<jsp:useBean id="now" class="java.util.Date"/>


<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <div class="col-md-6"></div>
            <br>
            <h1 class="alert alert-success text-center">Приобретение</h1>
        </div>

        <div class="container">
            <div class="row">


                <form:form commandName="order" class="form-horizontal">
                    <div class="well col-xs-10 col-sm-10 col-md-6 col-xs-offset-1 col-sm-offset-1 col-md-offset-3">
                        <div class="text-center">
                            <h1>Получение</h1>
                            <hr>
                        </div>
                        <div class="row">
                            <div class="col-xs-6 col-sm-6 col-md-6">
                                <address>
                                    <b>Информация о доставке</b>
                                    <br>
                                        ${order.cart.people.shippingAddress.street}, ${order.cart.people.shippingAddress.number_apartment}
                                    <br>
                                        ${order.cart.people.shippingAddress.division}, ${order.cart.people.shippingAddress.city}
                                    <br>
                                        ${order.cart.people.shippingAddress.country}, ${order.cart.people.shippingAddress.zip}
                                </address>
                            </div>
                            <div class="col-xs-6 col-sm-6 col-md-6 text-right">
                                <p><b>Дата доставки</b><br><fwt:formatDate type="date" value="${now}"/></p>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-xs-6 col-sm-6 col-md-6">
                                <address>
                                    <b>Сбор данных</b>
                                    <br>
                                        ${order.cart.people.billingAddress.card_holder}, ${order.cart.people.billingAddress.card_number}
                                    <br>
                                        ${order.cart.people.billingAddress.date_expiration}, ${order.cart.people.billingAddress.security_code}
                                    <br>
                                </address>
                            </div>
                        </div>
                        <div class="row">
                            <table class="table table-hoover table-condensed">
                                <thead>
                                <tr>
                                    <th>Продукт</th>
                                    <th>#</th>
                                    <th class="text-center">Цена</th>
                                    <th class="text-center">Ввсего</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="cartItem" items="${order.cart.cart_items}">
                                    <tr>
                                        <td class="col-md-9"><em>${cartItem.book.firstName}</em></td>
                                        <td class="col-md-1 text-center">${cartItem.quantity}</td>


                                    </tr>
                                </c:forEach>
                                <tr>

                                    <td colspan="2" class="text-right">
                                        <h4><strong>Общий итог: </strong></h4>
                                    </td>

                                </tr>
                                </tbody>
                            </table>
                        </div>

                        <input type="hidden" name="_flowExecutionKey"/>

                        <br><br>
                            <%-- BACK/CANCELAR/NEXT  ===========--%>

                        <button class="btn btn-danger" tabindex="13" name="_eventId_cancel">
                            Отмана
                        </button>
                        <input type="submit" value="Заказать" class="btn btn-success" tabindex="12"
                               name="_eventId_orderConfirmed">

                        <br>
                        <button class="btn btn-default" style="margin-top: 15px;" tabindex="14"
                                name="_eventId_backToCollectShippingDetail"> Возврат
                        </button>
                    </div>
                </form:form>
            </div>

        </div>
    </div>
</div>


<%@include file="/WEB-INF/views/templates/footer.jsp" %>

