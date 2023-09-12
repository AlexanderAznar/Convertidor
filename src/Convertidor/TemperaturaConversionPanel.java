package Convertidor;

import javax.swing.*;

/**
 * La clase TemperaturaConversionPanel representa un panel de conversión de unidades para temperatura.
 * Permite convertir valores entre diferentes escalas de temperatura, como Celsius, Fahrenheit y Kelvin.
 */
@SuppressWarnings("serial")
public class TemperaturaConversionPanel extends ConversionPanel {
    private static final String[] UNIDADES = {
        "Celsius", "Fahrenheit", "Kelvin"
    };

    /**
     * Crea un nuevo panel de conversión de temperatura.
     *
     * @param app La instancia de la clase ConvertidorApp que controla la aplicación.
     */
    public TemperaturaConversionPanel(ConvertidorApp app) {
        super(app);

        unidadOrigenComboBox.setModel(new DefaultComboBoxModel<>(UNIDADES));
        unidadDestinoComboBox.setModel(new DefaultComboBoxModel<>(UNIDADES));
    }

    /**
     * Realiza una conversión de temperatura utilizando las unidades seleccionadas y el valor proporcionado.
     *
     * @param valor El valor a convertir.
     * @return El resultado de la conversión.
     */
    public double convertir(double valor) {
        String unidadOrigen = getUnidadOrigen();
        String unidadDestino = getUnidadDestino();

        if (unidadOrigen.equals("Celsius")) {
            if (unidadDestino.equals("Fahrenheit")) {
                return (valor * 9.0 / 5.0) + 32.0;
            } else if (unidadDestino.equals("Kelvin")) {
                return valor + 273.15;
            }
        } else if (unidadOrigen.equals("Fahrenheit")) {
            if (unidadDestino.equals("Celsius")) {
                return (valor - 32.0) * 5.0 / 9.0;
            } else if (unidadDestino.equals("Kelvin")) {
                return (valor - 32.0) * 5.0 / 9.0 + 273.15;
            }
        } else if (unidadOrigen.equals("Kelvin")) {
            if (unidadDestino.equals("Celsius")) {
                return valor - 273.15;
            } else if (unidadDestino.equals("Fahrenheit")) {
                return (valor - 273.15) * 9.0 / 5.0 + 32.0;
            }
        }

        return valor; // Si las unidades son iguales, no hay conversión.
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
     * Obtiene el nombre del panel de conversión de temperatura.
     *
     * @return El nombre del panel, que es "Temperatura".
     */
    public String getNombre() {
        return "Temperatura";
    }
}
