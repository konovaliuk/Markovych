<%--
  Created by IntelliJ IDEA.
  User: Zulu Warrior
  Date: 5/31/2017
  Time: 11:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<fmt:setLocale value="${sessionScope.locale}"/>
<fmt:setBundle basename="i18n.lang"/>

<html>
<head>
    <jsp:include page="/WEB-INF/views/snippets/header.jsp"/>
    <style>
        .custab {
            border: 1px solid #ccc;
            padding: 5px;
            margin: 5% 0;
            box-shadow: 3px 3px 2px #ccc;
            transition: 0.5s;
        }

        .custab:hover {
            box-shadow: 3px 3px 0px transparent;
            transition: 0.5s;
        }
    </style>
</head>
<body>
<jsp:include page="/WEB-INF/views/snippets/navbar.jsp"/>

<div class="container">
    <div class="row col-md-10 col-md-offset-1 custyle">
        <div class="panel-title text-center">
            <h1 class="title"><fmt:message key="your.cards"/></h1>
            <hr/>
        </div>
        <c:choose>
            <c:when test="${not empty requestScope.cards}">
                <table class="table table-striped custab">
                    <thead>
                    <tr>
                        <th><fmt:message key="card.number"/></th>
                        <th><fmt:message key="card.account"/></th>
                        <th><fmt:message key="card.type"/></th>
                        <th><fmt:message key="card.exp.date"/> </th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="card" items="${requestScope.cards}">
                        <tr>
                            <td><c:out value="${card.getCardNumber()}"/></td>
                            <td><c:out value="${card.getAccount().getAccountNumber()}"/></td>
                            <td><c:out value="${card.getType()}"/></td>
                            <td>
                                <fmt:formatDate type = "date" value="${card.getExpireDate()}"/>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </c:when>
            <c:otherwise>
                <div class="alert alert-info">
                    <strong><fmt:message key="info"/></strong> <fmt:message key="card.no.matches"/>
                </div>
            </c:otherwise>
        </c:choose>

    </div>
</div>

<jsp:include page="/WEB-INF/views/snippets/footer.jsp"/>
</body>
</html>
