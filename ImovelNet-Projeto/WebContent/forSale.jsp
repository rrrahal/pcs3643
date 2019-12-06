<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<head>
    <title>ImóvelNet - Imóveis para venda</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

</head>
<body>

<nav class="navbar navbar-expand navbar-dark bg-dark">
    <ul class="nav navbar-nav">
        <li class="nav-item active">
            <a class="nav-link" href="#">ImóvelNet - Imóveis para venda <span class="sr-only">(current)</span></a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="#">ImóvelNet - Página Inicial</a>
        </li>
    </ul>
</nav>
<div class="row m-5">

    <c:forEach var="house" items="${houses}">
    <div class="col-md">
        <div class="card houseCard">
            <div class="card-body">
                <h3 class="card-title">Endereco: ${house.endereco}</h3>
                <p class="card-text">${house.descricao}</p>
                <p class="card-text">Preco: R$ ${house.precoVenda}</p>
                <a class="btn btn-dark" href="house?id=${house.idImovel}" role="button">Detalhes</a>
            </div>
        </div>
    </div>
    </c:forEach>
    <!--
          <div class="col-md">
            <div class="card houseCard">
              <img src="assets/ap2.png" class="card-img-top" alt="ap2" />
              <div class="card-body">
                <h3 class="card-title">Apartamento 2</h3>
                <p class="card-text">Apartamento em Santana com 2 Quartos e 1 banheiro.</p>
                <p class="card-text">Aluguel: R$ 2500.000</p>
                <a class="btn btn-dark" href="#" role="button">Alugar</a>
              </div>
            </div>
          </div>
          <div class="col-md">
              <div class="card houseCard">
                  <img src="assets/ap3.png" class="card-img-top" alt="ap3" />
                <div class="card-body">
                  <h3 class="card-title">Apartamento 3</h3>
                  <p class="card-text">Apartamento em Perdizes com 1 Quartos e 1 banheiro.</p>
                <p class="card-text">Aluguel: R$ 2700.000</p>
                <a class="btn btn-dark" href="#" role="button">Alugar</a>
                </div>
              </div>
            </div>
        </div>


        <div class="row">
            <div class="col-md">
              <div class="card houseCard">
                  <img src="assets/ap4.png" class="card-img-top" alt="ap4" />
                <div class="card-body">
                  <h3 class="card-title">Apartamento 4</h3>
                  <p class="card-text">Apartamento nos Jardins com 2 Quartos e 1 banheiro.</p>
                <p class="card-text">Aluguel: R$ 10500.000</p>
                <a class="btn btn-dark" href="#" role="button">Alugar</a>
                </div>
              </div>
            </div>
            <div class="col-md">
              <div class="card houseCard">
                  <img src="assets/ap5.png" class="card-img-top" alt="ap5" />
                <div class="card-body">
                  <h3 class="card-title">Apartamento 5</h3>
                  <p class="card-text">Apartamento no Butanta com 2 Quartos e 1 banheiro.</p>
                <p class="card-text">Aluguel: R$ 1000.000</p>
                <a class="btn btn-dark" href="#" role="button">Alugar</a>
                </div>
              </div>
            </div>
            <div class="col-md">
                <div class="card houseCard">
                    <img src="assets/ap6.png" class="card-img-top" alt="ap6" />
                  <div class="card-body">
                      <h3 class="card-title">Apartamento 6</h3>
                      <p class="card-text">Apartamento na Berrini com 1 Quartos e 1 banheiro.</p>
                    <p class="card-text">Aluguel: R$ 3000.000</p>
                    <a class="btn btn-dark" href="#" role="button">Alugar</a>
                  </div>
                </div>
              </div>
          </div>

          <div class="row">
              <div class="col-md">
                <div class="card houseCard">
                    <img src="assets/ap3.png" class="card-img-top" alt="ap7" />
                  <div class="card-body">
                      <h3 class="card-title">Apartamento 7</h3>
                      <p class="card-text">Apartamento em Santana com 1 Quartos e 1 banheiro.</p>
                    <p class="card-text">Aluguel: R$ 1500.000</p>
                    <a class="btn btn-dark" href="#" role="button">Alugar</a>
                  </div>
                </div>
              </div>
              <div class="col-md">
                <div class="card houseCard">
                    <img src="assets/ap2.png" class="card-img-top" alt="ap8" />
                  <div class="card-body">
                      <h3 class="card-title">Apartamento 8</h3>
                      <p class="card-text">Apartamento em Pinheiros com 2 Quartos e 1 banheiro.</p>
                    <p class="card-text">Aluguel: R$ 2500.000</p>
                    <a class="btn btn-dark" href="#" role="button">Alugar</a>
                  </div>
                  </div>
              </div>
              <div class="col-md">
                  <div class="card houseCard">
                      <img src="assets/ap4.png" class="card-img-top" alt="ap9" />
                    <div class="card-body">
                        <h3 class="card-title">Apartamento 9</h3>
                        <p class="card-text">Apartamento em Pinheiros com 2 Quartos e 2 banheiro.</p>
                      <p class="card-text">Aluguel: R$ 3500.000</p>
                      <a class="btn btn-dark" href="#" role="button">Alugar</a>
                    </div>
                  </div>
                </div>
            </div>


            <div class="row">
                <div class="col-md">
                  <div class="card houseCard">
                      <img src="assets/ap1.png" class="card-img-top" alt="ap10" />
                    <div class="card-body">
                        <h3 class="card-title">Apartamento 10</h3>
                        <p class="card-text">Apartamento em Pinheiros com 5 Quartos e 4 banheiro.</p>
                      <p class="card-text">Aluguel: R$ 8500.000</p>
                      <a class="btn btn-dark" href="#" role="button">Alugar</a>
                    </div>
                  </div>
                </div>
                <div class="col-md">
                  <div class="card houseCard">
                      <img src="assets/ap2.png" class="card-img-top" alt="ap11" />
                    <div class="card-body">
                        <h3 class="card-title">Apartamento 11</h3>
                        <p class="card-text">Apartamento em Pinheiros com 1 Quartos e 1 banheiro.</p>
                      <p class="card-text">Aluguel: R$ 1500.000</p>
                      <a class="btn btn-dark" href="#" role="button">Alugar</a>
                    </div>
                  </div>
                </div>
                <div class="col-md">
                    <div class="card houseCard">
                        <img src="assets/ap3.png" class="card-img-top" alt="ap12" />
                      <div class="card-body">
                          <h3 class="card-title">Apartamento 12</h3>
                          <p class="card-text">Apartamento no Butanta com 1 Quartos e 1 banheiro.</p>
                        <p class="card-text">Aluguel: R$ 1500.000</p>
                        <a class="btn btn-dark" href="#" role="button">Alugar</a>
                      </div>
                    </div>
                  </div>
              </div>
        -->
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>'