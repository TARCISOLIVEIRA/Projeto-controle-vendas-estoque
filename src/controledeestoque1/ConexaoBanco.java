

package controledeestoque1;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;


    

public class ConexaoBanco {

    private static final String url =
    "jdbc:mysql://localhost:3306/controlemateriais1?useSSL=false&serverTimezone=UTC";

    private static final String usuario = "root";
    private static final String senha = "T$1532m$B*CA";

    public Connection pegarConexao(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(url, usuario, senha);
        }catch(Exception erro){
            JOptionPane.showMessageDialog(null,"Erro banco: " + erro.getMessage());
            return null;
        }
    }
}

    

