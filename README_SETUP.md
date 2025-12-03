# ATM Console Application

A fully functional console-based ATM system with MySQL database integration.

## Project Structure

```
ATM-Console-App/
├── src/
│   ├── main/
│   │   ├── java/com/atm/
│   │   │   ├── model/          # Data models
│   │   │   ├── service/        # Business logic
│   │   │   ├── util/           # Utility classes
│   │   │   └── ui/             # User interface
│   │   └── resources/          # Configuration files
│   └── test/
│       └── java/com/atm/test/  # Unit tests
├── SQL/
│   └── database_setup.sql      # Database schema
├── pom.xml                     # Maven configuration
└── README.md
```

## Features

- ✓ Account authentication (Account number + PIN)
- ✓ Check balance
- ✓ Deposit money
- ✓ Withdraw money
- ✓ Transaction logging
- ✓ Input validation
- ✓ Error handling
- ✓ Unit testing

## Prerequisites

- Java 11 or higher
- Maven 3.6.0 or higher
- MySQL 5.7 or higher

## Setup Instructions

### 1. Database Setup

```bash
mysql -u root -p < SQL/database_setup.sql
```

This will create:
- `atm_db` database
- `accounts` table
- `transactions` table
- Sample test accounts

### 2. Build the Project

```bash
mvn clean install
```

### 3. Run the Application

```bash
mvn exec:java -Dexec.mainClass="com.atm.ui.ATMInterface"
```

Or run the JAR file:

```bash
java -jar target/atm-console-app.jar
```

## Test Accounts

After running the database setup, you can login with:

- **Account 1**: Number: 123456, PIN: 1111
- **Account 2**: Number: 789012, PIN: 2222

## Configuration

Update the following files with your database credentials:

- `src/main/java/com/atm/util/DatabaseConnection.java` - Database URL, username, password
- `src/main/resources/application.properties` - Additional settings

## Running Tests

```bash
mvn test
```

## Code Architecture

### Package Structure

- **com.atm.model** - Contains data models (Account, Transaction)
- **com.atm.service** - Contains business logic (AccountService)
- **com.atm.util** - Contains utility classes (DatabaseConnection)
- **com.atm.ui** - Contains user interface (ATMInterface)

### Design Patterns

- **Separation of Concerns** - Clear separation between UI, business logic, and data access
- **Single Responsibility** - Each class has a single, well-defined purpose
- **Error Handling** - Comprehensive exception handling throughout

## Future Enhancements

- [ ] View transaction history
- [ ] Change PIN functionality
- [ ] Transfer between accounts
- [ ] Currency support
- [ ] Multi-language support
- [ ] Enhanced security (encryption, biometric)
- [ ] GUI interface (Swing/JavaFX)

## Troubleshooting

### "MySQL JDBC Driver not found"
- Ensure MySQL connector JAR is in the classpath
- Run `mvn clean install` to download dependencies

### "Connection refused"
- Verify MySQL server is running
- Check database URL, username, and password
- Ensure `atm_db` database exists

### "Invalid account number or PIN"
- Verify you're using correct test credentials
- Check that database setup was executed successfully

## License

This project is provided as-is for educational purposes.

## Support

For issues or questions, please refer to the code documentation and comments.
