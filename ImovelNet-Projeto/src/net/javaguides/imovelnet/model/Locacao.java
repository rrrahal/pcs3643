package net.javaguides.imovelnet.model;

public class Locacao {
    protected int idLocacao;
    protected int idUsuario;
    protected String dataInicio;
    protected int idImovel;
    protected String dataFinal;
    protected float precoLocacao;
    protected Usuario user;
    protected Imovel house;

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

    public Locacao(int idUsuario, String dataInicio, int idImovel, String dataFinal, float precoLocacao) {
        this.idUsuario = idUsuario;
        this.dataInicio = dataInicio;
        this.idImovel = idImovel;
        this.dataFinal = dataFinal;
        this.precoLocacao = precoLocacao;
    }

    public Locacao(int idLocacao, int idUsuario, String dataInicio, int idImovel, String dataFinal, Float precoLocacao, Usuario user){
        this.idLocacao = idLocacao;
        this.idUsuario = idUsuario;
        this.dataInicio = dataInicio;
        this.idImovel = idImovel;
        this.dataFinal = dataFinal;
        this.precoLocacao = precoLocacao;
        this.user = user;
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

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public int getIdImovel() {
        return idImovel;
    }

    public void setIdImovel(int idImovel) {
        this.idImovel = idImovel;
    }

    public String getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(String dataFinal) {
        this.dataFinal = dataFinal;
    }

    public float getPrecoLocacao() {
        return precoLocacao;
    }

    public void setPrecoLocacao(float precoLocacao) {
        this.precoLocacao = precoLocacao;
    }
}
