
package vistas;

import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * Esta clase contiene todos los elementos de la Interface Gráfica para que
 * puedan ser manejados desde las otras clases del programa.
 * 
 * @author José Francisco Sánchez Portillo
 */
public class Clase10Control {
    // Se crean los arrays de elementos y los elementos:
    private JLabel[] jLabel_F = new JLabel[5];
    private JLabel[] jLabel_T = new JLabel[5];
    private static JTextArea jTextArea_Log;
    private JTextField[] jTextField_C = new JTextField[5];
    public static int[] filoCount = new int[5];
    

    /**
     * 
     * @param jLabel_Filo01 Filósofo
     * @param jLabel_Filo02 Filósofo
     * @param jLabel_Filo03 Filósofo
     * @param jLabel_Filo04 Filósofo
     * @param jLabel_Filo05 Filósofo
     * @param jLabel_Ten01 Tenedor
     * @param jLabel_Ten02 Tenedor
     * @param jLabel_Ten03 Tenedor
     * @param jLabel_Ten04 Tenedor
     * @param jLabel_Ten05 Tenedor
     * @param jTextArea_Log Area para el Log
     * @param jTextField_Cont01 Contadores
     * @param jTextField_Cont02 Contadores
     * @param jTextField_Cont03 Contadores
     * @param jTextField_Cont04 Contadores
     * @param jTextField_Cont05  Contadores
     */
    public Clase10Control(JLabel jLabel_Filo01, JLabel jLabel_Filo02, JLabel jLabel_Filo03, JLabel jLabel_Filo04, JLabel jLabel_Filo05, 
            JLabel jLabel_Ten01, JLabel jLabel_Ten02, JLabel jLabel_Ten03, JLabel jLabel_Ten04, JLabel jLabel_Ten05,
            JTextArea jTextArea_Log,
            JTextField jTextField_Cont01, JTextField jTextField_Cont02, JTextField jTextField_Cont03, JTextField jTextField_Cont04, JTextField jTextField_Cont05) {

        // Se asignan los valores a las variables:
        this.jLabel_F[0] = jLabel_Filo01;
        this.jLabel_F[1] = jLabel_Filo02;
        this.jLabel_F[2] = jLabel_Filo03;
        this.jLabel_F[3] = jLabel_Filo04;
        this.jLabel_F[4] = jLabel_Filo05;
        
        this.jLabel_T[0] = jLabel_Ten01;
        this.jLabel_T[1] = jLabel_Ten02;
        this.jLabel_T[2] = jLabel_Ten03;
        this.jLabel_T[3] = jLabel_Ten04;
        this.jLabel_T[4] = jLabel_Ten05;
        
        this.jTextArea_Log = jTextArea_Log;
        
        this.jTextField_C[0] = jTextField_Cont01;
        this.jTextField_C[1] = jTextField_Cont02;
        this.jTextField_C[2] = jTextField_Cont03;
        this.jTextField_C[3] = jTextField_Cont04;
        this.jTextField_C[4] = jTextField_Cont05;

        Clase10Control.filoCount[0] = 0;
        Clase10Control.filoCount[1] = 0;
        Clase10Control.filoCount[2] = 0;
        Clase10Control.filoCount[3] = 0;
        Clase10Control.filoCount[4] = 0;
        
        /*for (int i : filoCount){
            Clase10Control.filoCount[i] = 0;
        }*/

    }

    // Getters: Se establecen los Getters para que puedan ser llamados desde el programa
    public JLabel[] getjLabel_F() {
        return jLabel_F;
    }
    
    public JLabel[] getjLabel_T() {
        return jLabel_T;
    }

    public JTextField[] getjTextField_C() {
        return jTextField_C;
    }

    
    public static JTextArea getjTextArea_Log() {
        return jTextArea_Log;
    }

    // Único Setters
    public static void setjTextArea_Info(String mensaje) {
        Clase10Control.jTextArea_Log.append(mensaje + "\n");
        Clase10Control.jTextArea_Log.setCaretPosition(Clase10Control.jTextArea_Log.getDocument().getLength()); 
    }
    
}
