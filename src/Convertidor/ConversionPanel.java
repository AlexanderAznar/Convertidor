package Convertidor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * La clase abstracta ConversionPanel proporciona una plantilla para paneles de conversión de unidades en la aplicación.
 * Los paneles de conversión heredan de esta clase para implementar conversiones específicas de unidades.
 */
@SuppressWarnings("serial")
public abstract class ConversionPanel extends JPanel {
    protected JComboBox<String> unidadOrigenComboBox;
    protected JComboBox<String> unidadDestinoComboBox;
    protected JTextField valorInputField;
    protected JLabel resultadoLabel;
    protected ConvertidorApp app;
    
    /**
     * Constructor de ConversionPanel.
     * Configura la interfaz de usuario y establece el diseño del panel.
     *
     * @param app La instancia de la aplicación ConvertidorApp.
     */
    public ConversionPanel(ConvertidorApp app) {
        this.app = app;

        setLayout(new GridBagLayout());

        unidadOrigenComboBox = new JComboBox<>();
        unidadDestinoComboBox = new JComboBox<>();
        valorInputField = new JTextField();
        resultadoLabel = new JLabel("Resultado:");

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 5, 5, 5);

        add(new JLabel("Unidad de Origen:"), gbc);

        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(unidadOrigenComboBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new JLabel("Unidad de Destino:"), gbc);

        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(unidadDestinoComboBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        add(new JLabel("Introducir valor:"), gbc);

        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(valorInputField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        add(createStyledButton("Convertir", Color.decode("#3E4A5C")), gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        add(resultadoLabel, gbc);

        JButton convertirButton = (JButton) getComponent(6);
        convertirButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                convertirYMostrarResultado();
            }
        });

        JButton volverButton = createStyledButton("Volver al Menú Principal", Color.darkGray);
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.CENTER;
        add(volverButton, gbc);

        volverButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                app.showPanel("MainMenu");
            }
        });
    }

    /**
     * Método abstracto para realizar la conversión de unidades.
     *
     * @param valor El valor a convertir.
     * @return El resultado de la conversión.
     */
    public abstract double convertir(double valor);

    /**
     * Convierte el valor ingresado y muestra el resultado en la etiqueta de resultado.
     * Captura errores de formato en la entrada.
     */
    public void convertirYMostrarResultado() {
        try {
            double valor = Double.parseDouble(valorInputField.getText());
            double resultado = convertir(valor);
            resultadoLabel.setText("Resultado: " + resultado);
        } catch (NumberFormatException e) {
            resultadoLabel.setText("Resultado: Error al convertir");
        }
    }

    /**
     * Método abstracto para obtener la unidad de origen seleccionada.
     *
     * @return La unidad de origen.
     */
    public abstract String getUnidadOrigen();

    /**
     * Método abstracto para obtener la unidad de destino seleccionada.
     *
     * @return La unidad de destino.
     */
    public abstract String getUnidadDestino();

    /**
     * Método abstracto para obtener el nombre del tipo de conversión (por ejemplo, "Longitud").
     *
     * @return El nombre del tipo de conversión.
     */
    public abstract String getNombre();

    /**
     * Crea un botón con estilo personalizado.
     *
     * @param text  El texto del botón.
     * @param color El color de fondo del botón.
     * @return El botón configurado con estilo.
     */
    private JButton createStyledButton(String text, Color color) {
        JButton button = new JButton(text);
        button.setForeground(Color.WHITE);
        button.setBackground(color);
        button.setFocusPainted(false);
        button.setFont(button.getFont().deriveFont(Font.BOLD));
        return button;
    }
}
