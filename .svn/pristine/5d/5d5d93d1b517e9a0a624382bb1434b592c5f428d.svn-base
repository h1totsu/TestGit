<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page import="net.tanesha.recaptcha.ReCaptcha"%>
<%@ page import="net.tanesha.recaptcha.ReCaptchaFactory"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<c:url value="/resources/stylesheet.css" />"
    rel="stylesheet">
<title>Registration</title>
<script src='https://www.google.com/recaptcha/api.js'></script>
</head>
<body>
    <s:form action="registrate" method="POST">
        <tr>
            <td colspan="2"><h3>Registration</h3></td>
        </tr>
        <s:textfield label="Login" name="login" readonly="false" />
        <s:password value="%{password}" showPassword="true" label="Password"
            name="password" />
        <s:password value="%{password}" showPassword="true"
            label="Re-Password" name="rePassword" />
        <s:textfield label="E-mail" name="email" />
        <s:textfield label="Firstname" name="firstname" />
        <s:textfield label="Lastname" name="lastname" />
        <s:textfield label="Birthday" name="birthday" />
        <s:hidden key="role" value="ROLE_USER" /> 
        <s:hidden name="id" value="%{id}" />
        <tr>
            <td colspan="2">
                <div class="g-recaptcha"
                    data-sitekey="6Lda9xQTAAAAABaMoXMzqiuWFk2IpoO4Rtmz0N1J"></div>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="Save"> 
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <a href="j_spring_security_logout"><button 
                    type="button">Cancel</button></a>
            </td>
        </tr>
    </s:form>
</body>
</html>