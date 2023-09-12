package Convertidor;

import javax.swing.*;
import javax.swing.UIManager.LookAndFeelInfo;
import java.awt.*;

/**
 * La clase ConvertidorApp es la aplicación principal del Convertidor de Unidades.
 * Proporciona una interfaz gráfica de usuario para convertir diferentes tipos de unidades.
 */
public class ConvertidorApp {
    private JFrame frame;
    private JPanel cardPanel;
    private MainMenuPanel mainMenuPanel;
    private MonedasConversionPanel monedasPanel;
    private MasaConversionPanel masaPanel;
    private LongitudConversionPanel longitudPanel;
    private TemperaturaConversionPanel temperaturaPanel;
    private VolumenConversionPanel volumenPanel;

    /**
     * Constructor de la clase ConvertidorApp.
     * Crea la ventana principal de la aplicación y configura su apariencia.
     * También inicializa los paneles de conversión y el panel de menú principal.
     */
    public ConvertidorApp() {
        frame = new JFrame("Convertidor de Unidades");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Establece el Look and Feel Nimbus
        try {
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(frame, 
                    "Nimbus no está disponible. Se utilizará el aspecto predeterminado.", 
                    "Error de Look and Feel", JOptionPane.WARNING_MESSAGE);
        }

        cardPanel = new JPanel(new CardLayout());

        mainMenuPanel = new MainMenuPanel(this);
        monedasPanel = new MonedasConversionPanel(this);
        masaPanel = new MasaConversionPanel(this);
        longitudPanel = new LongitudConversionPanel(this);
        temperaturaPanel = new TemperaturaConversionPanel(this);
        volumenPanel = new VolumenConversionPanel(this);

        cardPanel.add(mainMenuPanel, "MainMenu");
        cardPanel.add(monedasPanel, "Monedas");
        cardPanel.add(masaPanel, "Masa");
        cardPanel.add(longitudPanel, "Longitud");
        cardPanel.add(temperaturaPanel, "Temperatura");
        cardPanel.add(volumenPanel, "Volumen");

        frame.getContentPane().add(cardPanel);
        showPanel("MainMenu"); // Muestra el menú principal al inicio
        frame.pack();
        frame.setVisible(true);
    }

    /**
     * Muestra el panel especificado en la ventana principal.
     *
     * @param panelName El nombre del panel que se va a mostrar.
     */
    public void showPanel(String panelName) {
        CardLayout cardLayout = (CardLayout) cardPanel.getLayout();
        cardLayout.show(cardPanel, panelName);
    }

    /**
     * Método principal que inicia la aplicación Convertidor de Unidades.
     *
     * @param args Argumentos de la línea de comandos (no se utilizan).
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ConvertidorApp();
            }
        });
    }
}
