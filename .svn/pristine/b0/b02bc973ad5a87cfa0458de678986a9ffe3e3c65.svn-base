<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
<head>
    <title>Home</title>
    <link href="<c:url value="/resources/stylesheet.css" />" rel="stylesheet">
    <s:head/>
</head>
<body>
   <div class="login">
        <c:if test="${not empty param.error}">
             <h4>Login or password are incorrect</h4>
         </c:if>
        <s:actionmessage/>
        <form name="loginForm" action="login" method="post" 
            id="log-form">
            <div>
                <label for="login">Login:</label>
                <input type="text" id="login" name="login" required />
            </div>
            <br>
            <div>
                <label for="pass">Password:</label>
                <input type="password" id="pass" name="password" required />
            </div>
            <br>
            <input type="hidden" name="command" value="login" />
            <input type="submit" value="Log in" />
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
        </form>
        <form name="regForm" action="registration" method="post">
            <input type="submit" value="Registration" />
        </form>
    </div>
</body>
</html>

