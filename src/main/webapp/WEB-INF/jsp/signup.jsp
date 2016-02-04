<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
	<title>Albert Twitter</title>
	<link type="text/css" rel="stylesheet" 
		href="<spring:url value="/css/style.css"/>">
	<link type="text/css" rel="stylesheet" 
		href="<spring:url value="/css/signup.css"/>">
</head>
<body>
	<br>
	<div id="loginFormContainer">
		<b>&nbsp;Sign Up:</b>
		<br>
		<hr>
		<form:form commandName="registrationForm" id="login" 
				action="signup.html" method="POST">
			<table>
				<tr>
					<td align="right">
						<form:label path="username" cssErrorClass="errorLabel">Username:</form:label>
					</td>
					<td>
						<form:input path="username" cssErrorClass="errorField"/><br>
						<form:errors path="username" element="span" cssClass="errorMessage"/>
					</td>
				</tr>
				<tr>
					<td align="right">
						<form:label path="password" cssErrorClass="errorLabel">Password:</form:label>
					</td>
					<td>
						<form:password path="password" cssErrorClass="errorField"/><br>
						<form:errors path="password" element="span" cssClass="errorMessage"/>
					</td>
				</tr>
				<tr>
					<td align="right">
						<form:label path="password2" cssErrorClass="errorLabel">Repeat Password:</form:label>
					</td>
					<td>
						<form:password path="password2" cssErrorClass="errorField"/><br>
						<form:errors path="password2" element="span" cssClass="errorMessage"/>
					</td>
				</tr>
				<tr>
					<td colspan="2" align="right"><input type="submit" value="Login"/></td>
				</tr>
			</table>
		</form:form>
		<hr>
		<span id="loginMsg">&nbsp;Already a member? <a href="login.html">Log In</a></span>
	</div>
</body>
</html>