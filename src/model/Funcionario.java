
package model;


public class Funcionario extends Clientes{
    
    private String senha;
    private String cargo;
    private String nivel;

    public Funcionario() {
        super();
    }
   
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

}
