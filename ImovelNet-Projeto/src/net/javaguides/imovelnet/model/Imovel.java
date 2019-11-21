package net.javaguides.imovelnet.model;

public class Imovel {
    protected int idImovel;
    protected Boolean Alugado;
    protected int idDono;
    protected float preçoVenda;
    protected String descrição;
    protected String endereço;
    protected float preçoAluguel;
    protected Boolean vendido;

    public Imovel(int idImovel, float preço, String descricao, String endereco, int idDono, String tipo) {
        this.idImovel = idImovel;
        if (tipo == "aluguel") { this.preçoAluguel = preço; }
        else { this.preçoVenda = preço; }
        this.descrição = descricao;
        this.endereço = endereco;
        this.idDono = idDono;
    }

    public Imovel(int idImovel, String endereço, String descrição, float preçoAluguel, float preçoVenda, int idDono) {
        this.idImovel = idImovel;
        this.descrição = descrição;
        this.endereço = endereço;
        this.idDono = idDono;
        this.preçoAluguel = preçoAluguel;
        this.preçoVenda = preçoVenda;
    };


    public int getIdImovel() {
        return idImovel;
    }

    public void setIdImovel(int idImovel) {
        this.idImovel = idImovel;
    }

    public Boolean getAlugado() {
        return Alugado;
    }

    public void setAlugado(Boolean alugado) {
        Alugado = alugado;
    }

    public int getIdDono() {
        return idDono;
    }

    public void setIdDono(int idDono) {
        this.idDono = idDono;
    }

    public float getPreçoVenda() {
        return preçoVenda;
    }

    public void setPreçoVenda(float preçoVenda) {
        this.preçoVenda = preçoVenda;
    }

    public String getDescrição() {
        return descrição;
    }

    public void setDescrição(String descrição) {
        this.descrição = descrição;
    }

    public String getEndereço() {
        return endereço;
    }

    public void setEndereço(String endereço) {
        this.endereço = endereço;
    }

    public float getPreçoAluguel() {
        return preçoAluguel;
    }

    public void setPreçoAluguel(float preçoAluguel) {
        this.preçoAluguel = preçoAluguel;
    }

    public Boolean getVendido() {
        return vendido;
    }

    public void setVendido(Boolean vendido) {
        this.vendido = vendido;
    }
}
