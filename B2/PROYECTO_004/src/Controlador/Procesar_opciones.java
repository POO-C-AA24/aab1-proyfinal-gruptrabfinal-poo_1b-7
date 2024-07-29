package Controlador;

import javax.swing.JCheckBox;

public class Procesar_opciones {
    private JCheckBox[] checkboxes;
 

    public Procesar_opciones(JCheckBox... checkboxes) {
        this.checkboxes = checkboxes;
    }

    public void preparar_opciones(JCheckBox selectedCheckbox) {
        
        for (JCheckBox checkbox : checkboxes) {
            if (checkbox != selectedCheckbox) {
                checkbox.setSelected(false);
            }
        }
        
    }


}