<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>ImovelNet - Relatórios</title>

    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

</head>

<body>

<!-- Navigation -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
        <a class="navbar-brand" href=" ">ImovelNet</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item">
                    <a class="nav-link" href="rent">Alugar
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="sale">Vender</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="reports">Relatórios</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="my_rents">Meus Alugueis</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="my_sales">Minhas Compras</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="login">Login</a>
                </li>
            </ul>
        </div>
    </div>
</nav>

<!-- Header - set the background image for the header in the line below -->
<header class="py-5 bg-image-full" style="background-image: url('https://unsplash.it/1900/1080?image=1076');">
</header>

<!-- Content section -->
<section class="py-5">
    <div class="container">
        <h1>ImovelNet</h1>
        <p class="lead">A sua plataforma para alugar ou vender imóveis.</p>
        <div class="input-group mb-3">
            <form action="${pageContext.request.contextPath}/generate_rent_reports" method="get">
                <br/>
                Data início: <input type="date" name="dataInicio"/>
                <br/>
                <input type="submit" class="btn btn-dark" href="generate_rent_reports" value="Gerar relatórios de aluguel"/>
            </form>
            <form action="${pageContext.request.contextPath}/generate_sale_reports" method="get">
                <br/>
                Data início: <input type="date" name="dataInicio"/>
                <br/>
                <input type="submit" class="btn btn-dark" href="generate_sale_reports" value="Gerar relatórios de Venda"/>
            </form>

        </div>
    </div>
</section>



<!-- Footer -->
<footer class="py-5 bg-dark">
    <div class="container">
    </div>
    <!-- /.container -->
</footer>
<footer class="py-5 bg-dark">
    <div class="container">
    </div>
    <!-- /.container -->
</footer>
<footer class="py-5 bg-dark">
    <div class="container">
    </div>
    <!-- /.container -->
</footer>

<!-- Bootstrap core JavaScript -->
<script src="vendor/jquery/jquery.min.js"></script>
<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

</body>

</html>
