<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.lab10_iweb.Beans.Contratos" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:useBean type="com.example.lab10_iweb.Beans.Clientes" scope="request" id="cliente"/>

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
            <h1 class=''> Mis Datos</h1>
        </div>
    </div>

    <div class="row mb-5 mt-4">
        <div class="col-lg-6">
            <h2 class=''> Nombre: <%=cliente.getNombreCliente()%></h2>
        </div>
    </div>
    <div class="row mb-5 mt-4">
        <div class="col-lg-6">
            <h2 class=''> Edad: <%=cliente.getEdad()%></h2>
        </div>
    </div>
    <div class="row mb-5 mt-4">
        <div class="col-lg-6">
            <h2 class=''> Tipo de persona: <%=cliente.getTipoCliente()%></h2>
        </div>
    </div>
    <div class="row mb-5 mt-4">
        <div class="col-lg-6">
            <h2 class=''> Nro documento: <%=cliente.getNumeroDocumento()%></h2>
        </div>
    </div>


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