<%--
  Created by IntelliJ IDEA.
  User: Zulu Warrior
  Date: 5/31/2017
  Time: 11:14 PM
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

<c:if test="${not empty requestScope.messages}">
    <div class="alert alert-success">
        <c:forEach items="${requestScope.messages}" var="message">
            <strong><fmt:message key="info"/></strong> <fmt:message key="${message}"/><br>
        </c:forEach>
    </div>
</c:if>

<div class="container">
    <div class="row col-md-10 col-md-offset-1 custyle">
        <div class="panel-title text-center">
            <h1 class="title"><fmt:message key="your.accounts"/></h1>
            <hr/>
        </div>
        <c:choose>
            <c:when test="${not empty requestScope.accounts}">
                <table class="table table-striped custab">
                    <thead>
                    <tr>
                        <th><fmt:message key="account.number"/></th>
                        <th><fmt:message key="account.balance"/></th>
                        <th><fmt:message key="account.status"/></th>
                        <th><fmt:message key="account.action"/></th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="account" items="${requestScope.accounts}">
                        <tr>
                            <td><c:out value="${account.getAccountNumber()}"/></td>
                            <td><c:out value="${account.getBalance()}"/></td>
                            <td><c:out value="${account.getStatus()}"/></td>
                            <td>
                                <c:if test="${account.isActive()}">
                                <form action="${pageContext.request.contextPath}/site/user/accounts/block" method="POST">
                                    <input type="hidden" name="account" value="${account.getAccountNumber()}">
                                    <button type="submit" class='btn btn-info btn-xs'>
                                        <fmt:message key="account.block"/>
                                    </button>
                                </form>
                                </c:if>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </c:when>
            <c:otherwise>
                <div class="alert alert-info">
                    <strong><fmt:message key="info"/></strong> <fmt:message key="account.no.matches"/>
                </div>
            </c:otherwise>
        </c:choose>

    </div>
</div>

<jsp:include page="/WEB-INF/views/snippets/footer.jsp"/>
</body>
</html>
