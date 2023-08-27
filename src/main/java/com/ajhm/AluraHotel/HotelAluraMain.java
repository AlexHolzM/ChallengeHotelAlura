/**
 * La clase HotelAluraMain es la clase principal que inicia la aplicación del Hotel Alura.
 * Esta clase crea una instancia de la interfaz gráfica MenuPrincipal y la hace visible.
 *
 * @author AlexHolzM
 * @version 1.0
 * @since 2023-08-26
 */
package com.ajhm.AluraHotel;

import java.awt.EventQueue;	
import com.ajhm.AluraHotel.view.MenuPrincipal;

public class HotelAluraMain {

    /**
     * @author AlexHolzM
     * @since 2023-08-26
     * @version 1.0
     * 
     * El método main es el punto de entrada de la aplicación Hotel Alura.
     * Inicia la interfaz de usuario en un hilo de despacho de eventos.
     *
     * @param args Los argumentos de línea de comandos. No se utilizan en esta aplicación.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            /**
             * El método run contiene el código que se ejecutará en el hilo de despacho de eventos.
             * Crea una instancia de MenuPrincipal y la hace visible en la pantalla.
             * En caso de excepción, se imprimirá la traza de la excepción.
             */
            public void run() {
                try {
                    MenuPrincipal frame = new MenuPrincipal();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}

