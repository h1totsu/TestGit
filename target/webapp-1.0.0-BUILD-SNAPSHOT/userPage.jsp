<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="mytag" uri="/WEB-INF/tag.tld" %>
<!DOCTYPE html>
<html>
<head>
    <link href="<c:url value="/resources/stylesheet.css" />" rel="stylesheet">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>User page</title>
</head>
<body>
    <security:authorize access="hasRole('ROLE_ADMIN')">
        <div id="panel-right">
            Admin ${username} (<a  href="<c:url value="j_spring_security_logout"/>">Logout</a>)
        </div>
        <br><br>
        <a id="panel-left" href="<c:url value="/service"/>">Add new user</a>
        <mytag:usertable users="${userList}" cssClass="users-table"/>
    </security:authorize>
    
    <security:authorize access="hasRole('ROLE_USER')">
        <div class="login">
            <h1>Hello, ${username} </h1>
            <p>Click <a href="<c:url value="j_spring_security_logout"/>">here</a> to logout</p>
        </div>
    </security:authorize>
</body>
</html>