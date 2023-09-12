package Convertidor;

import javax.swing.*;

/**
 * La clase LongitudConversionPanel representa un panel de conversión de unidades para longitudes.
 * Permite convertir valores entre diferentes unidades de longitud, como metros, pulgadas, pies, yardas y millas.
 */
@SuppressWarnings("serial")
public class LongitudConversionPanel extends ConversionPanel {
    private static final String[] UNIDADES = {
        "Metro", "Pulgada", "Pie", "Yarda", "Milla"
    };

    private static final double[] CONVERSION_RATES = {
        1.0,         // Metro a Metro (1 Metro)
        0.0254,      // Pulgada a Metro (1 Pulgada = 0.0254 Metros)
        0.3048,      // Pie a Metro (1 Pie = 0.3048 Metros)
        0.9144,      // Yarda a Metro (1 Yarda = 0.9144 Metros)
        1609.34      // Milla a Metro (1 Milla = 1609.34 Metros)
    };

    /**
     * Crea un nuevo panel de conversión de longitud.
     *
     * @param app La instancia de la clase ConvertidorApp que controla la aplicación.
     */
    public LongitudConversionPanel(ConvertidorApp app) {
        super(app);

        unidadOrigenComboBox.setModel(new DefaultComboBoxModel<>(UNIDADES));
        unidadDestinoComboBox.setModel(new DefaultComboBoxModel<>(UNIDADES));
    }

    /**
     * Realiza una conversión de longitud utilizando las unidades seleccionadas y el valor proporcionado.
     *
     * @param valor El valor a convertir.
     * @return El resultado de la conversión.
     */
    public double convertir(double valor) {
        int origenIndex = unidadOrigenComboBox.getSelectedIndex();
        int destinoIndex = unidadDestinoComboBox.getSelectedIndex();
        return valor * CONVERSION_RATES[origenIndex] / CONVERSION_RATES[destinoIndex];
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
     * Obtiene el nombre del panel de conversión de longitud.
     *
     * @return El nombre del panel, que es "Longitud".
     */
    public String getNombre() {
        return "Longitud";
    }
}
