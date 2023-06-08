<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.tictactoe.Sign" %>

<!DOCTYPE html>
<html>
<head>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <script src="<c:url value="/static/jquery-3.6.0.min.js"/>"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM"
          crossorigin="anonymous">
    <link href="static/main.css" rel="stylesheet">
    <title>Tic-Tac-Toe</title>
</head>
<body>
<div class="container-fluid">
    <h1 class="display-3">Tic-Tac-Toe</h1>

    <table class="table table-bordered border-primary table-fixed d-flex">
        <tr>
            <td onclick="window.location='/logic?click=0'">${data.get(0).getSign()}</td>
            <td onclick="window.location='/logic?click=1'">${data.get(1).getSign()}</td>
            <td onclick="window.location='/logic?click=2'">${data.get(2).getSign()}</td>
        </tr>
        <tr>
            <td onclick="window.location='/logic?click=3'">${data.get(3).getSign()}</td>
            <td onclick="window.location='/logic?click=4'">${data.get(4).getSign()}</td>
            <td onclick="window.location='/logic?click=5'">${data.get(5).getSign()}</td>
        </tr>
        <tr>
            <td onclick="window.location='/logic?click=6'">${data.get(6).getSign()}</td>
            <td onclick="window.location='/logic?click=7'">${data.get(7).getSign()}</td>
            <td onclick="window.location='/logic?click=8'">${data.get(8).getSign()}</td>
        </tr>
    </table>

    <c:set var="CROSSES" value="<%=Sign.CROSS%>"/>
    <c:set var="NOUGHTS" value="<%=Sign.NOUGHT%>"/>

    <c:if test="${winner == CROSSES}">
        <h1>
            <span class="badge bg-success-subtle border border-success-subtle text-success-emphasis rounded-pill">
                CROSSES WIN!
            </span>
        </h1>
        <br>
        <button class="btn btn-primary" onclick="restart()">Start again</button>
    </c:if>
    <c:if test="${winner == NOUGHTS}">
        <h1>
            <span class="badge bg-danger-subtle border border-danger-subtle text-danger-emphasis rounded-pill">
                NOUGHTS WIN!
            </span>
        </h1>
        <br>
        <button class="btn btn-primary" onclick="restart()">Start again</button>
    </c:if>
    <c:if test="${draw}">
        <h1>
            <span class="badge bg-info-subtle border border-info-subtle text-info-emphasis rounded-pill">I
                T'S A DRAW
            </span>
        </h1>
        <br>
        <button class="btn btn-primary" onclick="restart()">Start again</button>
    </c:if>


</div>



<script>
    function restart() {
        $.ajax({
            url: '/restart',
            type: 'POST',
            contentType: 'application/json;charset=UTF-8',
            async: false,
            success: function () {
                location.reload();
            }
        });
    }
</script>

</body>
</html>
