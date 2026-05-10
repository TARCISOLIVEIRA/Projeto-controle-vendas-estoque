
package model;


public class Fornecedor extends Clientes {
    
    private String cnpj;

     public Fornecedor() {
        super();
    }
    
    
    public Fornecedor(String cnpj) {
        this.cnpj = cnpj;
    }

   
  public String getNome() {
        return super.getNome();
    }
    

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    @Override
    public String toString(){
         return this.getNome();
    }
    
    
    
    
}
