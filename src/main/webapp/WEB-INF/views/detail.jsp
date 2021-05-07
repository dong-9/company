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
            <td>${boardInfo.id}</td>
        </tr>
        <tr>
            <th>TITLE</th>
            <td>${boardInfo.title}</td>
        </tr>
        <tr>
            <th>CONTENT</th>
            <td>${boardInfo.content}</td>
        </tr>
        <tr>
            <th>DATE</th>
            <td>
                <c:if test="${boardInfo.boardUpdateTime == null}">
                    ${boardInfo.boardInsertTime}
                </c:if>
                <c:if test="${boardInfo.boardUpdateTime != null}">
                    ${boardInfo.boardUpdateTime}
                </c:if>
            </td>
        </tr>
    </table>
    <div>
        <button><a href="/board/update?seq=${boardInfo.seq}">UPDATE</a></button>
    </div>
    <h3>REPLY</h3>
    <form:form action="/board/insertReply" method="post" modelAttribute="boardReplyVO">
        <input type="hidden" name="seq" value="${boardInfo.seq}">
        <textarea name="reply"></textarea>
        <c:if test="${msg != null}">
            <span>${msg}</span>
        </c:if>
        <input type="submit" value="reply">
    </form:form>

    <c:if test="${boardInfo.boardReplyVO.get(0).idx != 0}">
        <c:forEach var="list" items="${boardInfo.boardReplyVO}" >
        <div style="border: 1px solid black; padding-left: ${list.step*30}px;">
            <h5>${list.reply}</h5>
            <button><a href="updateReply?idx=${list.idx}&seq=${list.seq}">수정</a></button>
            <form action="deleteReply" method="post">
                <input type="hidden" name="idx" value="${list.idx}">
                <input type="hidden" name="seq" value="${list.seq}">
                <input type="hidden" name="indent" value="${list.indent}">
                <input type="hidden" name="root" value="${list.root}">
                <input type="submit" value="삭제">
            </form>
            <form action="/board/insertReply" method="post">
                <input type="hidden" name="seq" value="${list.seq}">
                <input type="hidden" name="root" value="${list.root}">
                <input type="hidden" name="indent" value="${list.indent}">
                <input type="hidden" name="step" value="${list.step}">
                <textarea name="reply"></textarea>
                <input type="submit" value="답글달기">
            </form>
        </div>
            <br><br>
        </c:forEach>
    </c:if>
</body>
</html>