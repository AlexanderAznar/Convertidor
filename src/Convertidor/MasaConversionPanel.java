package Convertidor;

import javax.swing.*;

/**
 * La clase MasaConversionPanel representa un panel de conversión de unidades para masas.
 * Permite convertir valores entre diferentes unidades de masa, como gramos, kilogramos, libras y onzas.
 */
@SuppressWarnings("serial")
public class MasaConversionPanel extends ConversionPanel {
    private static final String[] UNIDADES = {
        "Gramos", "Kilogramos", "Libras", "Onzas"
    };

    private static final double[][] CONVERSION_RATES = {
        {1.0, 0.001, 0.00220462, 0.035274},
        {1000.0, 1.0, 2.20462, 35.274},
        {453.592, 0.453592, 1.0, 16.0},
        {28.3495, 0.0283495, 0.0625, 1.0}
    };

    /**
     * Crea un nuevo panel de conversión de masa.
     *
     * @param app La instancia de la clase ConvertidorApp que controla la aplicación.
     */
    public MasaConversionPanel(ConvertidorApp app) {
        super(app);

        unidadOrigenComboBox.setModel(new DefaultComboBoxModel<>(UNIDADES));
        unidadDestinoComboBox.setModel(new DefaultComboBoxModel<>(UNIDADES));
    }

    /**
     * Realiza una conversión de masa utilizando las unidades seleccionadas y el valor proporcionado.
     *
     * @param valor El valor a convertir.
     * @return El resultado de la conversión.
     */
    public double convertir(double valor) {
        int origenIndex = unidadOrigenComboBox.getSelectedIndex();
        int destinoIndex = unidadDestinoComboBox.getSelectedIndex();
        return valor * CONVERSION_RATES[origenIndex][destinoIndex];
    }

    /**
     * Obtiene la unidad de origen seleccionada en el panel.
     *
     * @return La unidad de origen seleccionada.
     */
    public String getUnidadOrigen() {
        return (String) unidadOrigenComboBox.getSelectedItem();
    }

    /**
     * Obtiene la unidad de destino seleccionada en el panel.
     *
     * @return La unidad de destino seleccionada.
     */
    public String getUnidadDestino() {
        return (String) unidadDestinoComboBox.getSelectedItem();
    }

    /**
     * Obtiene el nombre del panel de conversión de masa.
     *
     * @return El nombre del panel, que es "Masa".
     */
    public String getNombre() {
        return "Masa";
    }
}
