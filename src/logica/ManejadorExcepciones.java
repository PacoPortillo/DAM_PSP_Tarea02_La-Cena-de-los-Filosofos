
package logica;

import utilidades.Log;
import java.util.logging.Level;
import java.util.logging.Logger;
import vistas.Clase10Control;

/**
 * Esta clase maneja las excepciones que puedan ser provocadas por la ejecución de los hilos
 * 
 * @author José Francisco Sánchez Portillo
 */
//manejador de excepciones para toda la aplicación
public class ManejadorExcepciones implements Thread.UncaughtExceptionHandler {
    //implementa el método uncaughtException()
    @Override
    public void uncaughtException(Thread t, Throwable e){
        System.out.printf("Thread que lanzó la excepción: %s \n", t.getName());
        //muestra en consola el hilo que produce la exceción
        e.printStackTrace();
        //muestra en consola la pila de llamadas
        
        // Añado este código para que los saque en el Log de la interface gráfica
        if (Clase10Control.getjTextArea_Log()!=null) try {
            log.escribirLog("\n Thread que lanzó la excepción: " + t.getName() + "\n");
            log.escribirLog(e.toString() + "\n\n");
        } catch (InterruptedException ex) {
            Logger.getLogger(ManejadorExcepciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        // Fin Añado este código
    }
    // Añado este código: Un Constructor que recibe la clase Log que es la que escribe en la interface gráfica
    /**
     * 
     * @param log Clase Log que escribe en la Interface Gráfica
     */
    public ManejadorExcepciones(Log log) {
        this.log = log;
    }
    // Variable que recibe la clase Log
    Log log;
    // Fin Añado este código
}
