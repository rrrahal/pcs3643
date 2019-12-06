package net.javaguides.imovelnet.model;

import java.sql.Date;

public class Locacao {
    protected int idLocacao;
    protected int idUsuario;
    protected Date dataInicio;
    protected int idImovel;
    protected Date dataFinal;
    protected float precoLocacao;
    protected Usuario user;
    protected Imovel house;
    protected int parcelasRestantes;

    public int getParcelasRestantes() {
        return parcelasRestantes;
    }

    public void setParcelasRestantes(int parcelasRestantes) {
        this.parcelasRestantes = parcelasRestantes;
    }

    public void setIdLocacao(int idLocacao) {
        this.idLocacao = idLocacao;
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    public Imovel getHouse() {
        return house;
    }

    public void setHouse(Imovel house) {
        this.house = house;
    }

    public Locacao(int idUsuario, Date dataInicio, int idImovel, Date dataFinal, float precoLocacao) {
        this.idUsuario = idUsuario;
        this.dataInicio = dataInicio;
        this.idImovel = idImovel;
        this.dataFinal = dataFinal;
        this.precoLocacao = precoLocacao;
    }

    public Locacao(int idLocacao, int idUsuario, Date dataInicio, int idImovel, Date dataFinal, Float precoLocacao, Usuario user){
        this.idLocacao = idLocacao;
        this.idUsuario = idUsuario;
        this.dataInicio = dataInicio;
        this.idImovel = idImovel;
        this.dataFinal = dataFinal;
        this.precoLocacao = precoLocacao;
        this.user = user;
    }
    public Locacao(int idLocacao, int idUsuario, Date dataInicio, int idImovel, Date dataFinal, Float precoLocacao, Usuario user, int parcelasRestantes){
        this.idLocacao = idLocacao;
        this.idUsuario = idUsuario;
        this.dataInicio = dataInicio;
        this.idImovel = idImovel;
        this.dataFinal = dataFinal;
        this.precoLocacao = precoLocacao;
        this.user = user;
        this.parcelasRestantes = parcelasRestantes;
    }

    public int getIdLocacao() {
        return idLocacao;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public int getIdImovel() {
        return idImovel;
    }

    public void setIdImovel(int idImovel) {
        this.idImovel = idImovel;
    }

    public Date getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(Date dataFinal) {
        this.dataFinal = dataFinal;
    }

    public float getPrecoLocacao() {
        return precoLocacao;
    }

    public void setPrecoLocacao(float precoLocacao) {
        this.precoLocacao = precoLocacao;
    }
}
