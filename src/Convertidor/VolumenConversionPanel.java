package Convertidor;

import javax.swing.*;

/**
 * La clase VolumenConversionPanel representa un panel de conversión de unidades para volumen.
 * Permite convertir valores entre diferentes unidades de volumen, como litros, galones y mililitros.
 */
@SuppressWarnings("serial")
public class VolumenConversionPanel extends ConversionPanel {
    private static final String[] UNIDADES = {
        "Litros", "Galones", "Mililitros"
    };

    /**
     * Matriz de tasas de conversión entre unidades de volumen.
     * Cada fila representa la tasa de conversión desde una unidad de origen a las unidades de destino.
     */
    private static final double[][] CONVERSION_RATES = {
        {1.0, 0.264172, 1000.0},    // Litros a Litros, Galones, Mililitros
        {3.78541, 1.0, 3785.41},    // Galones a Litros, Galones, Mililitros
        {0.001, 0.000264172, 1.0}  // Mililitros a Litros, Galones, Mililitros
    };

    /**
     * Crea un nuevo panel de conversión de volumen.
     *
     * @param app La instancia de la clase ConvertidorApp que controla la aplicación.
     */
    public VolumenConversionPanel(ConvertidorApp app) {
        super(app);

        unidadOrigenComboBox.setModel(new DefaultComboBoxModel<>(UNIDADES));
        unidadDestinoComboBox.setModel(new DefaultComboBoxModel<>(UNIDADES));
    }

    /**
     * Realiza una conversión de volumen utilizando las unidades seleccionadas y el valor proporcionado.
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
     * Obtiene el nombre del panel de conversión de volumen.
     *
     * @return El nombre del panel, que es "Volumen".
     */
    public String getNombre() {
        return "Volumen";
    }
}
