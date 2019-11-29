package net.javaguides.imovelnet.model;

public class Venda {
    protected int idVenda;
    protected float valorParcelas;
    protected int nParcelas;
    protected float valorEntrada;
    protected String dataInicio;
    protected String dataFim;
    protected int idUsuario;

    public Venda(String dataInicio, String dataFim, float valorEntrada, int nParcelas, float valorParcelas, int idUsuario, int idImovel) {
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.valorEntrada = valorEntrada;
        this.nParcelas = nParcelas;
        this.valorParcelas = valorParcelas;
        this.idUsuario = idUsuario;
        this.idImovel = idImovel;
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

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDataFim() {
        return dataFim;
    }

    public void setDataFim(String dataFim) {
        this.dataFim = dataFim;
    }

    public int getIdImovel() {
        return idImovel;
    }

    public void setIdImovel(int idImovel) {
        this.idImovel = idImovel;
    }

    protected int idImovel;

}
