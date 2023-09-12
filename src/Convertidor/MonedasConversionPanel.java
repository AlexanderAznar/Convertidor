package Convertidor;

import javax.swing.*;
import org.json.simple.parser.ParseException;
import java.io.IOException;

/**
 * La clase MonedasConversionPanel representa un panel de conversión de unidades para monedas.
 * Permite convertir valores entre diferentes monedas internacionales, como USD, EUR, GBP, etc.
 */
@SuppressWarnings("serial")
public class MonedasConversionPanel extends ConversionPanel {
    private static final String[] UNIDADES = {
        "USD", "EUR", "GBP", "JPY", "KRW", "CNY",
        "ARS", "CLP", "BOB", "PEN", "UYU", "MXN"
    };

    /**
     * Crea un nuevo panel de conversión de monedas.
     *
     * @param app La instancia de la clase ConvertidorApp que controla la aplicación.
     */
    public MonedasConversionPanel(ConvertidorApp app) {
        super(app);
        unidadOrigenComboBox.setModel(new DefaultComboBoxModel<>(UNIDADES));
        unidadDestinoComboBox.setModel(new DefaultComboBoxModel<>(UNIDADES));
    }

    /**
     * Realiza una conversión de moneda utilizando las unidades seleccionadas y el valor proporcionado.
     *
     * @param valor El valor a convertir.
     * @return El resultado de la conversión.
     */
    public double convertir(double valor) {
        String unidadOrigen = getUnidadOrigen();
        String unidadDestino = getUnidadDestino();

        try {
            return CurrencyConverter.convert(unidadOrigen, unidadDestino, valor);
        } catch (IOException | ParseException | InterruptedException e) {
            e.printStackTrace();
            return 0.0;
        }
    }

    /**
     * Obtiene el nombre del panel de conversión de monedas.
     *
     * @return El nombre del panel, que es "Monedas".
     */
    public String getNombre() {
        return "Monedas";
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
     * Obtiene la unidad de origen seleccionada en el panel.
     *
     * @return La unidad de origen seleccionada.
     */
    public String getUnidadOrigen() {
        return (String) unidadOrigenComboBox.getSelectedItem();
    }
}
