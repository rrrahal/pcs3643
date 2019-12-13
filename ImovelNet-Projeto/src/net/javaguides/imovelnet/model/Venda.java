package net.javaguides.imovelnet.model;

import java.sql.Date;

public class Venda {
    protected int idVenda;
    protected float valorParcelas;
    protected int nParcelas;
    protected float valorEntrada;
    protected Date dataInicio;
    protected Date dataFim;
    protected int idUsuario;
    protected Imovel house;
    protected int parcelasPagas;

    public Venda(Date dataInicio, Date dataFim, float valorEntrada, int nParcelas, float valorParcelas, int idUsuario, int idImovel) {
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.valorEntrada = valorEntrada;
        this.nParcelas = nParcelas;
        this.valorParcelas = valorParcelas;
        this.idUsuario = idUsuario;
        this.idImovel = idImovel;
    }

    public Venda(int idVenda, Date dataInicio, Date dataFim, float valorEntrada, int nParcelas, float valorParcelas, int idUsuario, int idImovel, Imovel house, int parcelasPagas) {
        this.idVenda = idVenda;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.valorEntrada = valorEntrada;
        this.nParcelas = nParcelas;
        this.valorParcelas = valorParcelas;
        this.idUsuario = idUsuario;
        this.idImovel = idImovel;
        this.house = house;
        this.parcelasPagas = parcelasPagas;
    }


    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdVenda() {
        return idVenda;
    }

    public float getValorParcelas() {
        return valorParcelas;
    }

    public void setValorParcelas(float valorParcelas) {
        this.valorParcelas = valorParcelas;
    }

    public int getnParcelas() {
        return nParcelas;
    }

    public void setnParcelas(int nParcelas) {
        this.nParcelas = nParcelas;
    }

    public float getValorEntrada() {
        return valorEntrada;
    }

    public void setValorEntrada(float valorEntrada) {
        this.valorEntrada = valorEntrada;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public int getIdImovel() {
        return idImovel;
    }

    public void setIdImovel(int idImovel) {
        this.idImovel = idImovel;
    }

    protected int idImovel;

    public Imovel getHouse() {
        return house;
    }

    public void setHouse(Imovel house) {
        this.house = house;
    }

    public int getParcelasPagas() {
        return parcelasPagas;
    }

    public void setParcelasPagas(int parcelasPagas) {
        this.parcelasPagas = parcelasPagas;
    }

}
