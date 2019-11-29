package net.javaguides.imovelnet.model;

public class Visita {
    protected int idVisita;
    protected String data;
    protected int idImovel;
    protected int idUsuario;
    protected String hora;

    public Visita(int idUsuario, int idImovel, String data, String hora) {
        this.idUsuario = idUsuario;
        this.idImovel = idImovel;
        this.data = data;
        this.hora = hora;
    }

    public int getIdVisita() {
        return idVisita;
    }

    public void setIdVisita(int idVisita) {
        this.idVisita = idVisita;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
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
