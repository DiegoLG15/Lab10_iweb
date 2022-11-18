<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.lab10_iweb.Dtos.CantidadContratosDto" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:useBean type="java.util.ArrayList<com.example.lab10_iweb.Dtos.CantidadContratosDto>" scope="request" id="listaCantContratos"/>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel='stylesheet' href='https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css'/>
    <title>LAB 10</title>
</head>
<body>
<jsp:include page="/includes/navbar.jsp"/>
<div class='container'>
    <div class="row mb-5 mt-4">
        <div class="col-lg-6">
            <h1 class=''> Cantidad de contratos por estado</h1>
        </div>

    </div>
    <table class="table">
        <tr>
            <th>Estado</th>
            <th>Cantidad</th>
        </tr>
        <%
            for (CantidadContratosDto cantContrato : listaCantContratos) { %>
        <tr>
            <td><%=cantContrato.getEstado()%></td>
            <td><%=cantContrato.getCantidadPorEstado()%></td>
        </tr>
        <%
            }
        %>
    </table>
</div>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
</body>
</html>