
# 🪙 Java Currency Converter GUI

A modern and user-friendly Java desktop application to convert currency values using real-time exchange rates via the [ExchangeRate-API](https://www.exchangerate-api.com/). The app features a clean Swing-based GUI where users can select base and target currencies, input an amount, and get instant conversion results.

---

## 📸 Screenshot
![Currency Converter GUI](CC.png)

---

## 🚀 Features

- ✅ Real-time currency conversion
- ✅ Easy-to-use GUI with dropdown selection and input validation
- ✅ Integration with ExchangeRate-API (free tier)
- ✅ Supports major currencies: USD, INR, EUR, GBP, JPY, AUD, CAD, etc.
- ✅ Error handling for invalid input and API failures

---

## 🧱 Requirements

- Java 8 or later  
- Internet connection (for live rates)
- External `.jar` libraries:

| Library     | Version   | Download Link |
|-------------|-----------|----------------|
| OkHttp      | 3.14.9    | [Download](https://repo1.maven.org/maven2/com/squareup/okhttp3/okhttp/3.14.9/okhttp-3.14.9.jar) |
| Okio        | 1.17.5    | [Download](https://repo1.maven.org/maven2/com/squareup/okio/okio/1.17.5/okio-1.17.5.jar) |
| org.json    | 20240303  | [Download](https://repo1.maven.org/maven2/org/json/json/20240303/json-20240303.jar) |

---

## 📁 Project Structure

```
CurrencyConverter/
│
├── CurrencyConverterGUI.java
├── lib/
│   ├── okhttp-3.14.9.jar
│   ├── okio-1.17.5.jar
│   └── json-20240303.jar
└── README.md
```

---

## ⚙️ Setup Instructions

### 1. Clone the Repository

```bash
git clone https://github.com/your-username/CurrencyConverter.git
cd CurrencyConverter
```

### 2. Add Required Libraries

Download the `.jar` files listed above and place them in the `lib/` folder.

### 3. Compile the Application

#### On Windows:
```bash
javac -cp ".;lib/*" CurrencyConverterGUI.java
```

#### On Linux/macOS:
```bash
javac -cp ".:lib/*" CurrencyConverterGUI.java
```

### 4. Run the Application

#### On Windows:
```bash
java -cp ".;lib/*" CurrencyConverterGUI
```

#### On Linux/macOS:
```bash
java -cp ".:lib/*" CurrencyConverterGUI
```

---

## 🔑 API Key Setup

1. Go to [ExchangeRate-API](https://www.exchangerate-api.com/)
2. Sign up for a free account and get your API key
3. In the code, replace:

```java
String apiKey = "YOUR_API_KEY";
```

---

## 📊 Example

**Input:**

- Base: USD  
- Target: INR  
- Amount: 100  

**Output:**

```
Converted Amount: 8335.10 INR
```

---

## 📌 License

MIT License — free to use, modify, and distribute with attribution.

---

## ✨ Author

**Ashish Saxena**  
Connect with me on [LinkedIn](https://www.linkedin.com/in/satwik-12-dev)
