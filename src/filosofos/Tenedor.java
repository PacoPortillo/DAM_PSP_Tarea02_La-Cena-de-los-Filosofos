// Clase pasiva: Recurso compartido
package filosofos;

import java.util.Random;
import utilidades.Log;
import vistas.Clase10Control;

/**
 * Recurso compratido por los hilos Filósofos,
 * Se crean 5 instancias con n-1 comensales donde n es el número de filósofoscon el total de los tenedores,
 * Cada tenedor tiene su ID y a cada filósofo le corresponde 2 tenedores concretos.
 * 
 * @author José Francisco Sánchez Portillo
 */
public class Tenedor {
    // Variable para generar números aleatorios:
    private Random random = new Random();
    // ID del Tenedor
    private int id;
    // Está ocupado el tenedor o no?:
    private boolean libre = true;
    
    /**
     * Constructo de la clase Tenedor
     * 
     * @param id ID del Tenedor
     */
    public Tenedor(int id){
        this.id = id;
    }
    
    // Crear métodos synchronized => Monitores
    // Solo puede acceder un Thread a la vez.
    /**
     * Monitor para coger el tenedor derecho y poder seguir el proceso de ejecución de los filósofos.
     * 
     * @param id_f ID del Filósofo
     * @param log Clase Log para escribir el log en la interface gráfica
     * @throws InterruptedException Posibles errores
     */
    public synchronized void cogerTenedor(int id_f, Log log) throws InterruptedException{
        while(!libre) 
            this.wait();
        System.out.println("El Filósofo " + (id_f+1) + " coge el tenedor " + (id+1));
        // Siempre se valora si el log es distinto a null, si lo es se ecribe en la interface gráfica:
        if (Clase10Control.getjTextArea_Log()!=null) log.escribirLog(" El Filósofo " + (id_f+1) + " coge el tenedor " + (id+1));
        libre = false;
    }
    /**
     * Monitor para coger el tenedor izquierdo y poder seguir el proceso de ejecución de los filósofos,
     * Pero si no consigue cogerlo en un tiempo x retornará false y tendra que salir a pensar y no podra comer,
     * Tendrá que volver a empezar el proceso de comer.
     * 
     * @param id_f ID del Filósofo
     * @param log Clase Log para escribir el log en la interface gráfica
     * @return Boolean True: puede continuar tiene los dos tenedores Y False: tiene que volver a empezar el proceso
     * @throws InterruptedException Posibles errores
     */
    public synchronized boolean cogerTenedorIzqdo(int id_f, Log log) throws InterruptedException{
        while(!libre){
            this.wait(random.nextInt(1000) + 500); // Sólo espera aleatoriamente entre 0.5 y 1 seg y si no, retorna false
            return false;
        } 
        System.out.println("El Filósofo " + (id_f+1) + " coge el tenedor " + (id+1));
        // Siempre se valora si el log es distinto a null, si lo es se ecribe en la interface gráfica:
        if (Clase10Control.getjTextArea_Log()!=null) log.escribirLog(" El Filósofo " + (id_f+1) + " coge el tenedor " + (id+1));
        libre = false;
        return true;
    }
    /**
     * Monitor para soltar un tenedor izquierdo o derecho y salir a pensar.
     * 
     * @param id_f ID del Filósofo
     * @param log Clase Log para escribir el log en la interface gráfica
     * @throws InterruptedException Posibles errores
     */
    public synchronized void soltarTenedor(int id_f, Log log) throws InterruptedException {
        libre = true;
        System.out.println("El Filósofo " + (id_f+1) + " suelta el tenedor " + (id+1));
        // Siempre se valora si el log es distinto a null, si lo es se ecribe en la interface gráfica:
        if (Clase10Control.getjTextArea_Log()!=null) log.escribirLog(" El Filósofo " + (id_f+1) + " suelta el tenedor " + (id+1));
        this.notify();
    }
}
