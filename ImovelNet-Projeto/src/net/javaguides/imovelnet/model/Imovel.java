package net.javaguides.imovelnet.model;

public class Imovel {
    protected int idImovel;
    protected Boolean Alugado;
    protected int idDono;
    protected float precoVenda;
    protected String descricao;
    protected String endereco;
    protected float precoAluguel;
    protected Boolean vendido;
    protected Boolean paraVender;
    protected Boolean paraAlugar;

    public Imovel(int idImovel, float preco, String descricao, String endereco, int idDono, String tipo, int paraVender, int paraAlugar) {
        this.idImovel = idImovel;
        if (tipo == "aluguel") { this.precoAluguel = preco; }
        else { this.precoVenda = preco; }
        this.descricao = descricao;
        this.endereco = endereco;
        this.idDono = idDono;
        if (paraVender == 1) { this.paraVender = true; }
        else if ( paraVender == 0) { this.paraVender = false; }
        if (paraAlugar == 1) { this.paraAlugar = true; }
        else if ( paraAlugar == 0) { this.paraAlugar = false; }
    }

    public Imovel(int idImovel, String endereco, String descricao, float precoAluguel, float precoVenda, int idDono, int paraVender, int paraAlugar) {
        this.idImovel = idImovel;
        this.descricao = descricao;
        this.endereco = endereco;
        this.idDono = idDono;
        this.precoAluguel = precoAluguel;
        this.precoVenda = precoVenda;
        if (paraVender == 1) { this.paraVender = true; }
        else if ( paraVender == 0) { this.paraVender = false; }
        if (paraAlugar == 1) { this.paraAlugar = true; }
        else if ( paraAlugar == 0) { this.paraAlugar = false; }
    };

    public Boolean getParaVender() {
        return paraVender;
    }

    public void setParaVender(Boolean paraVender) {
        this.paraVender = paraVender;
    }

    public Boolean getParaAlugar() {
        return paraAlugar;
    }

    public void setParaAlugar(Boolean paraAlugar) {
        this.paraAlugar = paraAlugar;
    }


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

    public float getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(float precoVenda) {
        this.precoVenda = precoVenda;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public float getPrecoAluguel() {
        return precoAluguel;
    }

    public void setPrecoAluguel(float precoAluguel) {
        this.precoAluguel = precoAluguel;
    }

    public Boolean getVendido() {
        return vendido;
    }

    public void setVendido(Boolean vendido) {
        this.vendido = vendido;
    }
}
