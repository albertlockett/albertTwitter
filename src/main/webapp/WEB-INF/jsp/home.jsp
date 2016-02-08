<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="alberttwitter" uri="/WEB-INF/taglib/alberttwitter.tld" %>

<html>
<head>
	<title>Albert Twitter</title>
	<link type="text/css" rel="stylesheet" 
		href="<spring:url value="/css/style.css"/>">
	<link type="text/css" rel="stylesheet" 
		href="<spring:url value="/css/tweets.css"/>">
</head>
<body>
	<a href="login.html">Logout</a>

	<div id="newTweetContainer">
		<br>
		<form id="newTweetForm" action="newTweet.html" method="POST">
			<table>
				<tr>
					<td><b>Tweet:</b></td>
				</tr>
				<tr>
					<td>
						<textarea id="tweetContent" name="content" 
							placeholder="141 char max"maxlength="141"
							rows="2" cols="78"></textarea>
					</td>
				</tr>
				<tr>
					<td align="right">
						<input id="tweetButton" type="submit" value="Tweet"/>
					</td>
				</tr>
			</table> 
		</form>
	</div> 
	<br><br>
	<div id="tweetsContainer>">
		<c:forEach items="${tweets}" var="tweet">
			<table class="tweetTable">
				<tr>
					<td>
						<span class="username">@${tweet.user.username}</span>
						<span class="time">${tweet.time}</span>
					</td>
				</tr>
				<tr>
					<td><span class="content">
						<alberttwitter:TweetContent
							>${tweet.content}</alberttwitter:TweetContent>
					</span></td>
				</tr>
			</table>
		</c:forEach>
	
	</div>
</body>
</html>