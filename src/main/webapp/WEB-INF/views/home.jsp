<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Data Management System</title>
</head>
<body>
.........Welcome On DMA........

<form name='f' action="<c:url value='j_spring_security_check' />"method='POST'>
          <input name="j_username" type="text" class="inputfield" value="" placeholder="Email" required="true"/>
          <input name="j_password" type="password" class="inputfield" value="" placeholder="Password" required="true"/>
          <input name="submit" type="submit" class="login-btn" value="Login" />
        </form>
        
</body>
</html>