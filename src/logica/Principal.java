
package logica;

import utilidades.Log;
import filosofos.Filosofo;
import filosofos.Tenedor;
import filosofos.Portero_del_Comedor;
import javax.swing.JLabel;
import javax.swing.JTextField;
import vistas.Clase10Control;
import vistas.Vista10Control;

/**
 * Esta clase genera las instancias de los 5 hilos Filósofos {@link Filosofo} ,
 * Estos 5 hilos se ejecutan de manera concurrente gestionados por monitores ,
 * La finalidad del programa es crear un algoritmo que permita que los filósofos coman y piensen,
 * para ello, el problema se resuelve que siempre haya un filósofo como mínimo comiendo,
 * lo ideal que haya dos. 
 * El algoritmo tiene un recurso compartido {@link Portero_del_Comedor} el cual deja pasar a
 * n-1 filósofos y después otro recurso {@link Tenedor} que es necesario tener por duplicado para
 * que cada filósofo pueda comer. Además el algoritmo se completa creando una regla en la que si un
 * filósofo no consigue el segundo tenedor en x tiempo aleatorio, éste debe abandonar su turno de comida,
 * salir y ponerse a la cola.
 * Además si se selecciona crear un Log en el área de texto de la interface gráfica {@link Vista10Control}
 * todos los hilos de manera concurrente tendran que ir escribiendo en el log sus acciones, con lo cual 
 * puede relentizar un poco la ejecución del programa.
 * 
 * @author José Francisco Sánchez Portillo
 */
public class Principal {
    
    private JLabel[] jLabel_F = new JLabel[5];
    private JLabel[] jLabel_T = new JLabel[5];
    private JTextField[] jTextField_C = new JTextField[5];

    /**
     * Se generan las instancias de 5 de {@link Filosofo}, 5 {@link Tenedor}, 
     * una de {@link Portero_del_Comedor}, una de {@link Log} y una de {@link ManejadorExcepciones},
     * Y se ponen en funcionamiento los hilos filósofos.
     * 
     * @param clase10Control Contiene todos los elemnetos de la interface gráfica
     */
    public Principal(Clase10Control clase10Control) { 
        this.jLabel_F = clase10Control.getjLabel_F();
        this.jLabel_T = clase10Control.getjLabel_T();
        this.jTextField_C = clase10Control.getjTextField_C();
        
 
        
        // Se crea el Array para contener las 5 instancias de Tenedores:
        Tenedor[] tenedor = new Tenedor[5];
        // Se crea el Array para contener las 5 instancias de Filósofos:
        Filosofo[] filosofo = new Filosofo[5];
        // Se crea una sola instancia de Portero_del_Comedor:
        Portero_del_Comedor comensal = new Portero_del_Comedor();
        // Se crea una sola instancia de Log:
        Log log = new Log();
        // Se crea la instancia del manejeador de excepciones para los Thread:
        ManejadorExcepciones manejador=new ManejadorExcepciones(log);
        
        // Se crean las 5 instancias de Tenedores:
        for(int i=0; i<tenedor.length; i++){
            tenedor[i] = new Tenedor(i);
        }
        
        // Se crean las 5 instancias de Filósofos:
        for(int i=0; i<filosofo.length; i++){
            /* El filósofo coge el tenedor de la izquierda 
            *  y el de la derecha se contabiliza con el módulo(%)
            *  porque cuando llega a cuatro el siguiente es cero
            */
            // Ahora al filósofo se le pasa: un ID, un tenedor Dercho, un tenedor Izdo, el comensal, los componentes gráficos correspondientes y un log
            filosofo[i] = new Filosofo(i, tenedor[i], tenedor[(i+1)%5], comensal, jLabel_F[i], jLabel_T[i], jLabel_T[(i+1)%5], log, jTextField_C[i]);
        }
        
        // Se echa a andar todos los Filósofos:
        for(int i=0; i<filosofo.length; i++){
            filosofo[i].setUncaughtExceptionHandler(manejador);
            filosofo[i].start();
        }
    }

    
}
