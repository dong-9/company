<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <h2>Board Info</h2>
    <table border="1" align="center">
        <tr>
            <th>#</th>
            <td>${boardInfo.seq}</td>
        </tr>
        <tr>
            <th>ID</th>
            <td>${boardInfo}</td>
        </tr>
        <tr>
            <th>TITLE</th>
            <td>${boardInfo}</td>
        </tr>
        <tr>
            <th>CONTENT(detail에 넣기)</th>
            <td>${boardInfo}</td>
        </tr>
        <tr>
            <th>regdate</th>
            <td>${boardInfo}</td>
        </tr>
    </table>
</body>
</html>