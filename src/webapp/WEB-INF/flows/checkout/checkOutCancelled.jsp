<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/views/templates/header.jsp" %>

<div class="container-wrapper">
    <div class="container">
        <div>
            <br>
            <section>
                <div class="row text">
                    <div class="col-md-8">
                        <h1 class="alert alert-danger"><strong>Отменить заказ!</strong></h1>
                        <p>Вы можете продолжать заказывать, если хотите.</p>
                    </div>
                </div>
            </section>
            <section>
                <p>
                    <a href="<spring:url value="/products"/>" class="btn btn-primary">Все товары</a>
                </p>
            </section>
        </div>
    </div>
</div>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<script src="/resources/js/controller.js" type="text/javascript"></script>
<%@include file="/WEB-INF/views/templates/footer.jsp" %>