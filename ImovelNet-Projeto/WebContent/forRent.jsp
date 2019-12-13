<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="css/ImoveisParaAlugar.css" />
<html lang="en">
  <head>
    <title>ImóvelNet - Imóveis para alugar</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous"/>
      <link href="css/ImoveisParaAlugar.css" rel="stylesheet">

  </head>
  <body>
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
    <div class="row m-5">

    <c:forEach var="house" items="${houses}">
        <div class="col-md">
            <div class="card houseCard">
                <div class="card-body">
                    <h3 class="card-title">Endereco: ${house.endereco}</h3>
                    <p class="card-text">${house.descricao}</p>
                    <p class="card-text">Aluguel: R$ ${house.precoAluguel}</p>
                    <a class="btn btn-dark" href="house?id=${house.idImovel}" role="button">Detalhes</a>
                </div>
            </div>
        </div>
    </c:forEach>
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
  </body>
</html>'