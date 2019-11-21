package net.javaguides.imovelnet.model;

public class Fotos {
    protected int idFoto;
    protected int idImovel;
    protected String url;

    public int getIdFoto() {
        return idFoto;
    }

    public int getIdImovel() {
        return idImovel;
    }

    public void setIdImovel(int idImovel) {
        this.idImovel = idImovel;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
