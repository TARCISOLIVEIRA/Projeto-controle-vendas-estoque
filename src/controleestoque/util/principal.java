/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controleestoque.util;
import java.sql.Connection;

/**
 *
 * @author Tarciso
 */
public class principal {
    
    public static void main(String[] args) {
        
    ConexaoBanco c = new ConexaoBanco();
    Connection conn = c.pegarConexao();

    if(conn != null){
        System.out.println("✅ Conectado com sucesso!");
    }else{
        System.out.println("❌ Erro na conexão");
    }    
                
    }
    
}
