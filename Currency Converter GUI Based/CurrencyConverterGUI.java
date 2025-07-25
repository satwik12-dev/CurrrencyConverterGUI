import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONObject;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class CurrencyConverterGUI extends JFrame {

    private JComboBox<String> baseCurrencyBox, targetCurrencyBox;
    private JTextField amountField;
    private JLabel resultLabel;

    @SuppressWarnings("unused")
    public CurrencyConverterGUI() {
        setTitle("Currency Converter");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(6, 1, 10, 10));

        String[] currencies = {"USD", "INR", "EUR", "GBP", "JPY", "CAD", "AUD", "CNY"};

        baseCurrencyBox = new JComboBox<>(currencies);
        targetCurrencyBox = new JComboBox<>(currencies);
        amountField = new JTextField();
        resultLabel = new JLabel("Converted Amount: ");

        JButton convertButton = new JButton("Convert");

        convertButton.addActionListener(e -> {
            String base = (String) baseCurrencyBox.getSelectedItem();
            String target = (String) targetCurrencyBox.getSelectedItem();
            String input = amountField.getText();

            try {
                double amount = Double.parseDouble(input);
                double rate = getExchangeRate(base, target);
                double converted = amount * rate;
                resultLabel.setText(String.format("Converted Amount: %.2f %s", converted, target));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Enter a valid number.");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error fetching exchange rate.");
            }
        });

        add(new JLabel("Base Currency:"));
        add(baseCurrencyBox);
        add(new JLabel("Target Currency:"));
        add(targetCurrencyBox);
        add(new JLabel("Amount:"));
        add(amountField);
        add(convertButton);
        add(resultLabel);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private double getExchangeRate(String base, String target) throws IOException {
        String apiKey = "6bfe811b4d4a5c80313033e5"; // your API key
        String url = "https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/" + base;

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(url).build();
        Response response = client.newCall(request).execute();

        String jsonData = response.body().string();
        JSONObject json = new JSONObject(jsonData);

        if (!json.getString("result").equals("success")) {
            throw new IOException("API returned error");
        }

        JSONObject rates = json.getJSONObject("conversion_rates");
        return rates.getDouble(target);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(CurrencyConverterGUI::new);
    }
}
