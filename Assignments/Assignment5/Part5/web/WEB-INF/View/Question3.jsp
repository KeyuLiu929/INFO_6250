<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/3/6
  Time: 6:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Question 3</title>
</head>
<body>
<h1>Question 3: ${question.question}</h1>
<form method="post">
    A. <input type="radio" name="option" value="A"/>${question.optionA}<br/>
    B. <input type="radio" name="option" value="B"/>${question.optionB}<br/>
    C. <input type="radio" name="option" value="C"/>${question.optionC}<br/>
    D. <input type="radio" name="option" value="D"/>${question.optionD}<br/>
    <input type="submit" name="_target1" value="Previous"/>
    <input type="submit" name="_target3" value="Next"/>
</form>
</body>
</html>
