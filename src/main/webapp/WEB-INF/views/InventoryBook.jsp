<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@include file="templates/header.jsp" %>


<div class="container-wrapper">
    <div class="container">
        <h1 style="text-align: center">Library</h1>
        <hr>
        <br>

        <h1>List of</h1>
        <div class="table-responsive">
            <table class="table table-custom table-hover table-condensed">
                <thead>
                <tr class="bg-success">
                    <th>Book cover</th>
                    <th>Title</th>
                    <th>Author</th>
                    <th>Genre</th>

                    <th></th>
                    <th></th>
                    <th></th>
                </tr>
                </thead>
                <c:forEach items="${list_books}" var="book">
                    <tr>
                        <td><img src="<c:url value="/resources/book_images/${book.book_id}.png" />" alt="image"></td>
                        <td>${book.firstName}</td>
                        <td>${book.author}</td>
                        <td>${book.category}</td>


                        <td>
                            <!-- Book INFORMATION-->
                            <a href="<spring:url value="/book/BookDetails/${book.book_id}" />"
                               class="btn btn-info">
                                Details <span class=" glyphicon glyphicon-info-sign"></span>
                            </a>
                        </td>
                        <td>
                            <!-- EDIT Book -->
                            <a href="<spring:url value="/admin/inventory/edit/${book.book_id}" />"
                               class="btn btn-success">
                                Edit <span class="glyphicon glyphicon-pencil"></span>
                            </a>
                        </td>
                        <td>
                            <!-- ELIMINATE Book-->
                            <a href="<spring:url value="/admin/inventory/remove/${book.book_id}" />"
                               class="btn btn-danger">
                                Delete <span class="glyphicon glyphicon-remove"></span>
                            </a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <a class="btn btn-primary" href="<spring:url value="/admin/inventory/add" />">Add book</a>
        <br>
        <div class="pager">
            <br>
            <li>
                <a href="<c:url value="/admin"/>">
                    <span class="glyphicon glyphicon-backward"></span> Back to
                </a>
            </li>
        </div>
    </div>
</div>

<%@include file="templates/footer.jsp" %>