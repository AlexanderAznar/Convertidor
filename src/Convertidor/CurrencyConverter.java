package Convertidor;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * La clase CurrencyConverter proporciona métodos estáticos para convertir cantidades de una moneda a otra utilizando una API de tasas de cambio.
 * También permite obtener la fecha de las tasas de cambio más recientes.
 */
public class CurrencyConverter {
    private static final String API_KEY = "9593648af573df638918cadb0bb2c749";
    private static final String BASE_URL = "http://api.exchangeratesapi.io/v1/latest";
    private static final String SYMBOLS = "USD,EUR,GBP,JPY,KRW,CNY,ARS,CLP,BOB,PEN,UYU,MXN";
    private static final String FORMAT = "1";

    /**
     * Convierte una cantidad de una moneda a otra.
     *
     * @param fromCurrency La moneda de origen en formato de tres letras (por ejemplo, "USD" para dólares estadounidenses).
     * @param toCurrency   La moneda de destino en formato de tres letras (por ejemplo, "EUR" para euros).
     * @param amount       La cantidad que se va a convertir.
     * @return El valor convertido en la moneda de destino.
     * @throws IOException            Si ocurre un error de entrada/salida durante la solicitud HTTP.
     * @throws ParseException         Si ocurre un error al analizar la respuesta JSON de la API.
     * @throws InterruptedException    Si se interrumpe la solicitud HTTP.
     */
    public static double convert(String fromCurrency, String toCurrency, double amount) throws IOException, ParseException, InterruptedException {
        // Construye la URL con los parámetros requeridos por la API
        String urlString = BASE_URL +
                "?access_key=" + API_KEY +
                "&symbols=" + SYMBOLS +
                "&format=" + FORMAT;

        URI uri = URI.create(urlString);

        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(uri).build();

        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            String responseBody = response.body();

            JSONParser parser = new JSONParser();
            JSONObject jsonResponse = (JSONObject) parser.parse(responseBody);
            JSONObject rates = (JSONObject) jsonResponse.get("rates");

            // Obtener la tasa de conversión de la moneda de origen a EUR
            double fromCurrencyToEUR = ((Number) rates.get(fromCurrency)).doubleValue();

            // Obtener la tasa de conversión de EUR a la moneda de destino
            double eurToDestCurrency = ((Number) rates.get(toCurrency)).doubleValue();

            // Realizar la conversión
            double convertedAmount = (amount / fromCurrencyToEUR) * eurToDestCurrency;

            // Redondear el resultado a dos decimales
            return Math.round(convertedAmount * 100.0) / 100.0;
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * Obtiene la fecha de las tasas de cambio más recientes.
     *
     * @return La fecha de las tasas de cambio en formato de cadena (por ejemplo, "2023-09-08").
     * @throws IOException            Si ocurre un error de entrada/salida durante la solicitud HTTP.
     * @throws ParseException         Si ocurre un error al analizar la respuesta JSON de la API.
     * @throws InterruptedException    Si se interrumpe la solicitud HTTP.
     */
    public static String getDate() throws IOException, ParseException, InterruptedException {
        // Construye la URL con los parámetros requeridos por la API.
        String urlString = BASE_URL +
                "?access_key=" + API_KEY +
                "&symbols=" + SYMBOLS +
                "&format=" + FORMAT;

        URI uri = URI.create(urlString);

        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(uri).build();

        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            String responseBody = response.body();

            JSONParser parser = new JSONParser();
            JSONObject jsonResponse = (JSONObject) parser.parse(responseBody);
            String date = (String) jsonResponse.get("date");

            return date;
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            throw e;
        }
    }
}
