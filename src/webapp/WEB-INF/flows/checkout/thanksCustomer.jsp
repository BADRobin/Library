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
                        <h1 style="text-shadow: 1px 1px 2px dodgerblue "><strong>Благодарим за заявку!</strong></h1>
                        <h3>Заявка выполнена успешно. Ожидайте</h3>
                        <img class="img-responsive" src="resources/site-images/delivery.jpg"/>
                    </div>
                </div>
            </section>
            <section>
                <br>
                <p>
                    <a href="<spring:url value="/"/>" class="btn btn-primary"><span class="glyphicon glyphicon-share-alt"></span> Возврат</a>
                </p>
            </section>
        </div>
    </div>
</div>
<br>
<br>
<br>
<br>

<script src="/resources/js/controller.js" type="text/javascript"></script>
<%@include file="/WEB-INF/views/templates/footer.jsp" %>