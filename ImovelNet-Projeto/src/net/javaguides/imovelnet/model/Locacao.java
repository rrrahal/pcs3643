package net.javaguides.imovelnet.model;

public class Locacao {
    protected int idLocacao;
    protected int idUsuario;
    protected String dataInicio;
    protected int idImovel;
    protected String dataFinal;
    protected float preçoLocacao;

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

    public float getPreçoLocacao() {
        return preçoLocacao;
    }

    public void setPreçoLocacao(float preçoLocacao) {
        this.preçoLocacao = preçoLocacao;
    }
}
