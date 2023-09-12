package Convertidor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * La clase MainMenuPanel representa el panel de menú principal de la aplicación Convertidor de Unidades.
 * Proporciona botones para acceder a diferentes conversores de unidades.
 */
@SuppressWarnings("serial")
public class MainMenuPanel extends JPanel {
    /**
     * Crea un nuevo panel de menú principal.
     *
     * @param app La instancia de la clase ConvertidorApp que controla la aplicación.
     */
    public MainMenuPanel(ConvertidorApp app) {
        setLayout(new GridLayout(5, 1));

        JLabel bienvenidaLabel = new JLabel("¡Bienvenido al Convertidor de Unidades!");
        JLabel espacioLabel = new JLabel(" ");
        JButton buttonMonedas = new JButton("Conversor de Monedas");
        JButton buttonMasa = new JButton("Conversor de Masa");
        JButton buttonTemperatura = new JButton("Conversor de Temperatura");
        JButton buttonVolumen = new JButton("Conversor de Volumen");
        JButton buttonLongitud = new JButton("Conversor de Longitud");

        buttonMonedas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                app.showPanel("Monedas");
            }
        });

        buttonMasa.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                app.showPanel("Masa");
            }
        });

        buttonTemperatura.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                app.showPanel("Temperatura");
            }
        });

        buttonVolumen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                app.showPanel("Volumen");
            }
        });

        buttonLongitud.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                app.showPanel("Longitud");
            }
        });

        add(bienvenidaLabel);
        add(espacioLabel);
        add(buttonMonedas);
        add(buttonMasa);
        add(buttonTemperatura);
        add(buttonVolumen);
        add(buttonLongitud);
    }
}
