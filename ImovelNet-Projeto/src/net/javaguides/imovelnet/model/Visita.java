package net.javaguides.imovelnet.model;

public class Visita {
    protected int idVisita;
    protected String data;
    protected int idImovel;

    public int getIdVisita() {
        return idVisita;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getIdImovel() {
        return idImovel;
    }

    public void setIdImovel(int idImovel) {
        this.idImovel = idImovel;
    }
}
