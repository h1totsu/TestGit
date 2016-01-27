<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page import="net.tanesha.recaptcha.ReCaptcha"%>
<%@ page import="net.tanesha.recaptcha.ReCaptchaFactory"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="<c:url value="/resources/stylesheet.css" />" rel="stylesheet">
    <title>Service</title>
    <script src='https://www.google.com/recaptcha/api.js'></script>
</head>
<body>
    <s:actionerror/>
    <s:form action="edit" method="POST">
        <s:if test="%{type == 'edit'}">
             <tr>
                <td colspan="2"><h3>Edit</h3></td>
             </tr>
        </s:if>
        <s:else>
             <tr>
                <td colspan="2"><h3>Add</h3></td>
             </tr>
        </s:else>
        <s:if test="%{type == 'edit'}">
            <s:textfield label="Login" name="login" readonly="true"/>
        </s:if> 
        <s:else>
            <s:textfield label="Login" name="login" readonly="false"/>
        </s:else>
        <s:password value="%{password}" showPassword="true" label="Password"
            name="password" />
        <s:password value="%{password}" showPassword="true" label="Re-Password"
            name="rePassword" />
        <s:textfield label="E-mail" name="email" />
        <s:textfield label="Firstname" name="firstname" />
        <s:textfield label="Lastname" name="lastname" />
        <s:textfield label="Birthday" name="birthday" />
        <td class="tdLabel">Role</td>
        <td> 
           <select name="role">
              <s:if test="%{role == 'ROLE_ADMIN'}">
                  <option selected="selected">ADMIN</option>
                  <option>USER</option>
              </s:if>
              <s:elseif test="%{role != 'ROLE_ADMIN'}">
                  <option>ADMIN</option>
                  <option selected="selected">USER</option>
              </s:elseif>
          </select>
        </td>
       <s:hidden name="id" value="%{id}" />
       <s:hidden name="type" value="%{type}" />
       <tr>
            <td colspan="2">
                <input type="submit" value="Save"> 
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <a href="user"><button 
                    type="button">Cancel</button></a>
            </td>
        </tr>
    </s:form>
</body>
</html>