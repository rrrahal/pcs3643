<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<head>
    <title>ImóvelNet - Página do Imóvel</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

</head>
<body>

<nav class="navbar navbar-expand navbar-dark bg-dark">
    <ul class="nav navbar-nav">
        <li class="nav-item active">
            <a class="nav-link" href="#">ImóvelNet <span class="sr-only">(current)</span></a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="#">ImóvelNet - Página Inicial</a>
        </li>
    </ul>
</nav>
<div class="row m-5">
    <div class="col-md">
        <div class="card houseCard">
            <div class="card-body">
                <h3 class="card-title">Endereco: ${house.endereco}</h3>
                <p class="card-text">${house.descricao}</p>
                <p class="card-text">Preco: R$ ${house.precoVenda}</p>
                <p class="card-text">Aluguel: R$ ${house.precoAluguel}</p>
                <c:if test="${house.paraVender eq true}">
                    <a class="btn btn-dark" role="button" href="make_sale?idImovel=${house.idImovel}">Comprar</a>
                </c:if>
                <c:if test="${house.paraAlugar eq true}">
                    <a class="btn btn-dark" role="button" href="make_rent?idImovel=${house.idImovel}">Alugar</a>
                </c:if>
                <a type="button" class="btn btn-secondary" href="schedule_visit?imovelId=${house.idImovel}">Marcar Visita</a>
            </div>
        </div>
    </div>


    <!-- Modal -->
    <div class="modal fade" id="modalExemplo" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Título do modal</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Fechar">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    chama
                </div>
                <div class="modal-footer">
                    <a type="button" class="btn btn-secondary" data-dismiss="modal" href="id?id=${house.idImovel}">Alugar</a>
                    <a type="button" class="btn btn-primary" href="schedule_visit?imovelId=${house.idImovel}">Marcar Visita</a>
                </div>
            </div>
        </div>
    </div>


    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>'