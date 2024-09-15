# Currency Converter CLI

This is a simple Command Line Interface (CLI) application that converts currencies using the ExchangeRate API.

## Features

- Convert between any supported currencies using real-time exchange rates.
- View conversion history during the session.
- Simple and interactive interface.

## Prerequisites

Before running the project, ensure you have the following installed:

- [Java 21+](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html)
- [Maven](https://maven.apache.org/download.cgi)

You will also need an API key for the [ExchangeRate API](https://exchangerate-api.com/).


## Installation

1. Clone the repository:
    ```bash
    git clone https://github.com/pecodigos/currency-converter.git
    cd currency-converter
    ```

2. Build the project using Maven:
    ```bash
    mvn clean install
    ```

## Usage

1. Run the application:
    ```bash
    java -jar target/currency-converter.jar
    ```

2. Once running, you will see the following options:
    ```
    ************************************************
    
    -------------- CURRENCY CONVERTER --------------
    
                  1- Convert currency.
                  2- Show history.
                  0- Exit the program.
    
    ------------------------------------------------
    
    ************************************************
    ```

3. Follow the on-screen prompts to either:
    - Convert a currency.
    - View your conversion history.
    - Exit the program.

## Program Structure

- The main class (`CurrencyConverter`) manages the application's user interface and interactions.
- The `UI` class handles the logic for converting currencies (`convertCurrency`) and displaying conversion history (`showHistory`).

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

---

Made with ❤️ by [Pecodigos](https://github.com/pecodigos)
