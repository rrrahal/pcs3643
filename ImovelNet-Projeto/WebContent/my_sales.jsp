<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>ImovelNet - Minhas Compras</title>

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
            <c:forEach var="sale" items="${sales}">
                <div class="col-md">
                    <div class="card houseCard">
                        <div class="card-body">
                            <h3 class="card-title">id da Locação: ${sale.getIdVenda()}</h3>
                            <p class="card-text">Endereço do Imovel: ${sale.getHouse().getEndereco()}</p>
                            <p class="card-text">Valor de Entrada: ${sale.getValorEntrada()}</p>
                            <p class="card-text">Valor das Parcelas: ${sale.getValorParcelas()}</p>
                            <p class="card-text">Número de Parcelas: ${sale.getnParcelas()}</p>
                            <p class="card-text">Parcelas Pagas: ${sale.getParcelasPagas()}</p>
                            <c:if test="${sale.getParcelasPagas() eq sale.getnParcelas()}">
                                <p class="card-text"> Compra Finalizada!</p>
                            </c:if>
                            <c:if test="${sale.getParcelasPagas() ne sale.getnParcelas()}">
                                <a class="btn btn-dark" role="button" href="pay_sale?idVenda=${sale.getIdVenda()}">Pagar Parcela</a>
                            </c:if>
                        </div>
                    </div>
                </div>
            </c:forEach>
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
