    
package utilitario;

import javax.swing.JTextField;
import java.awt.Component;
import javax.swing.JPanel;

public class Utilitarios {
    public void LimpaTela(JPanel container){
        Component conponents[] = container.getComponents();
        for(Component component : conponents){
          if(component instanceof JTextField){
            ((JTextField)component).setText(null);
    }
    }
    
    }
}