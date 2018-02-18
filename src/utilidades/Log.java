
package utilidades;

import vistas.Clase10Control;
import vistas.Vista10Control;

/**
 * Esta clase escribe un log en la interface gráfica del programa {@link Vista10Control}
 * Recurso compratido por los hilos Filósofos,
 * Se crea una única instancia
 * 
 * @author José Francisco Sánchez Portillo
 */
public class Log {
   /**
    * Este método es un monitor al cual van accediendo los hilos para escribir sus acciones
    * en el log del programa, este componente puede ser activado o no desde la interface gráfica.
    * 
    * @param log Mensaje que recibe el método para que sea añadido al componente gráfico en la interface
    * @throws InterruptedException Error y su descripción
    */
    public synchronized void escribirLog(String log) throws InterruptedException{
        Clase10Control.setjTextArea_Info(log);
    }
    
}
