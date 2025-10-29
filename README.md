# Credit Card Validator

This project is a Java-based credit card validator that can parse credit card information from various file formats, validate the card numbers, and identify the card type.

## Features

-   Parses credit card data from CSV, JSON, and XML files.
-   Validates credit card numbers for major brands:
    -   Visa
    -   MasterCard
    -   American Express
    -   Discover
-   Identifies the card type based on the card number.
-   Handles invalid card numbers.
-   Outputs the results to a file, indicating the card type or if the card is invalid.

## Design Patterns Used

This project utilizes the following design patterns:

### Strategy Pattern

The Strategy pattern is used to handle different input file formats (CSV, JSON, XML). The `FileFormat` class acts as the context, and the `FileStrategy` interface defines the common interface for parsing files. The concrete strategies (`CsvParser`, `JsonParser`, and `XmlParser`) implement the file-specific parsing logic. This allows for easy extension to support new file formats without modifying the core application logic.

### Factory Pattern

The Factory pattern is used to create credit card validator objects. The `ValidatorFactory` class provides a static `checkCard` method that takes a card number as input and returns the appropriate validator object (e.g., `VisaValidator`, `MasterCardValidator`, `AmericanExpressValidator`, `DiscoverValidator`). This encapsulates the object creation logic and decouples the client code from the concrete validator classes.

## Getting Started

### Prerequisites

-   Java Development Kit (JDK) 8 or higher.
-   A Java IDE (e.g., IntelliJ IDEA, Eclipse) or a text editor and command-line tools.

### Building and Running the Project

1.  **Clone the repository:**
    ```bash
    git clone https://github.com/gopinathsjsu/individual-project-cmpe202-03-pragnesh16.git
    ```
2.  **Navigate to the project directory:**
    ```bash
    cd individual-project-cmpe202-03-pragnesh16
    ```
3.  **Compile the Java files:**
    ```bash
    javac -d out/production/individual-project-cmpe202-03-pragnesh16-main $(find . -name "*.java")
    ```
4.  **Run the application:**
    ```bash
    java -cp out/production/individual-project-cmpe202-03-pragnesh16-main Main
    ```

**Note:** The `Main.java` file currently uses a hardcoded path to the input file. You will need to modify the `csvPath` variable in `Main.java` to point to the desired input file on your local machine.

## Usage

To use the application, you need to provide an input file in one of the supported formats (CSV, JSON, or XML). The application will then process the file, validate the credit card numbers, and generate an output file with the results.

## Supported Input Formats

The application supports the following input file formats:

### CSV (`.csv`)

```csv
cardNumber,expirationDate,cardHolderName
5567894523129089,08/26,John Doe
...
```

### JSON (`.json`)

```json
{
  "cards": [
    {
      "cardNumber": "5567894523129089",
      "expirationDate": "08/26",
      "cardHolderName": "John Doe"
    },
    ...
  ]
}
```

### XML (`.xml`)

```xml
<CARDS>
  <CARD>
      <CARD_NUMBER>5567894523129089</CARD_NUMBER>
      <EXPIRATION_DATE>08/26</EXPIRATION_DATE>
      <CARD_HOLDER_NAME>John DoE</CARD_HOLDER_NAME>
  </CARD>
  ...
</CARDS>
```

## Class Diagram

![alt text](https://github.com/pragneshbagary/Credit-Card-Validator/blob/main/images/Class%20Diagram1.png)
