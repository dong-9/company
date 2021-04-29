<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Board Page</title>
    <style>
        h2 {text-align: center}
        div {text-align: center}
    </style>
</head>
<body>
    <h2>Board Update</h2>
    <form:form action="/board/update" method="post" modelAttribute="boardVO">
    <table border="1" align="center">
        <form:hidden path="seq" />
        <tr>
            <th>ID</th>
            <td><form:input path="id" readonly="true"/></td>
        </tr>
        <tr>
            <th>TITLE</th>
            <td>
                <form:input path="title" />
                <form:errors path="title" />
            </td>
        </tr>
        <tr>
            <th>CONTENT</th>
            <td>
                <form:textarea path="content"/>
                <form:errors path="content" />
            </td>
        </tr>
    </table>
    <div>
        <input type="submit" value="UPDATE">
    </div>
    </form:form>
</body>
</html>