<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/4/16
  Time: 13:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>

<style>
    .col-center-block {
        float: none;
        display: block;
        margin-left: auto;
        margin-right: auto;
    }
</style>

<body class="bg-light">
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
    <div class="navbar-header">
        <a class="navbar-brand" href="/main">KSearch</a>
    </div>
</nav>

<div class="container">
    <br/>
    <h1 class="text-center">Log In to KSearch</h1>
    <h6 class="text-center">
        New to KSearch? <a href="/signup">Sign Up</a>
    </h6>
    <div class="row">
        <div class="col-xs-6 col-md-4 col-center-block">
            <br/>
            <form>
                <div class="form-group">
                    <input class="form-control" type="text" name="email" placeholder="Enter Email"/><br/>
                    <input class="form-control" type="password" name="password" placeholder="Enter Password"/><br/>
                    <input class="btn btn-primary btn-block" type="submit" name="submit" value="Login"/>
                </div>
            </form>
            <p class="text-right">New to KSearch? <a href="/signup">Sign Up</a></p>
        </div>
    </div>
</div>
</body>
</html>
