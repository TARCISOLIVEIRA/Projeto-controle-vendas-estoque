
package model;


public class MateriaPrima {
    private int id;
    private String descricao;
    private String unidadeMedida;
    private double estoque;
    private double estoqueMinimo;
    private double valorUnitario;

    public MateriaPrima() {
    }

    public MateriaPrima(int id, String descricao, String unidadeMedida, double estoque, double estoqueMinimo, double valorUnitario) {
        this.id = id;
        this.descricao = descricao;
        this.unidadeMedida = unidadeMedida;
        this.estoque = estoque;
        this.estoqueMinimo = estoqueMinimo;
        this.valorUnitario = valorUnitario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getUnidadeMedida() {
        return unidadeMedida;
    }

    public void setUnidadeMedida(String unidadeMedida) {
        this.unidadeMedida = unidadeMedida;
    }

    public double getEstoque() {
        return estoque;
    }

    public void setEstoque(double estoque) {
        this.estoque = estoque;
    }

    public double getEstoqueMinimo() {
        return estoqueMinimo;
    }

    public void setEstoqueMinimo(double estoqueMinimo) {
        this.estoqueMinimo = estoqueMinimo;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }
    
    
    
    
    
}
