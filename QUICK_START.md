# Quick Start Guide - ATM Console App

## Prerequisites
- Java 11+ installed
- Maven 3.6+ installed
- MySQL Server running

## Step 1: Setup Database

```bash
# Open MySQL command line or MySQL Workbench
mysql -u root -p

# Then run:
source SQL/database_setup.sql
```

This creates:
- Database: `atm_db`
- Tables: `accounts`, `transactions`
- Test Accounts: 
  - Account: 123456, PIN: 1111 (Balance: $5000.00)
  - Account: 789012, PIN: 2222 (Balance: $1500.50)

## Step 2: Build Project

```bash
mvn clean compile
```

## Step 3: Run Application

### Option A: Using Maven (Recommended)
```bash
mvn exec:java -Dexec.mainClass="com.atm.ui.ATMInterface"
```

### Option B: Using JAR
```bash
java -jar target/atm-console-app.jar
```

### Option C: Direct Compilation
```bash
javac -cp "src/main/java" src/main/java/com/atm/ui/ATMInterface.java
java -cp "src/main/java" com.atm.ui.ATMInterface
```

## Step 4: Test Login

Try logging in with one of the test accounts:
- Account Number: **123456**
- PIN: **1111**

## Available Operations

1. **Check Balance** - View current account balance
2. **Deposit** - Add money to account
3. **Withdraw** - Withdraw money from account
4. **View Transactions** - See transaction history (coming soon)
5. **Exit** - Logout and return to login screen

## Run Unit Tests

```bash
mvn test
```

Expected Output:
```
Tests run: 6, Failures: 0, Errors: 0, Skipped: 0
```

## Troubleshooting

### Error: "MySQL JDBC Driver not found"
- Run: `mvn clean compile` to download dependencies

### Error: "Connection refused" 
- Ensure MySQL server is running
- Check credentials in `src/main/java/com/atm/util/DatabaseConnection.java`

### Error: "Invalid account number or PIN"
- Ensure database setup was completed successfully
- Check that you're using correct test credentials

## Project Structure

```
src/
├── main/
│   ├── java/com/atm/
│   │   ├── model/Account.java         # Account data model
│   │   ├── service/AccountService.java # Business logic
│   │   ├── util/DatabaseConnection.java # DB utilities
│   │   └── ui/ATMInterface.java        # Main application
│   └── resources/                      # Configuration files
└── test/
    └── java/com/atm/test/AccountTest.java # Unit tests

SQL/
└── database_setup.sql                  # Database schema & sample data

target/
└── atm-console-app.jar                 # Compiled application
```

## Configuration Files

Edit these files to customize behavior:

- **DatabaseConnection.java** - Database credentials
- **application.properties** - App settings
- **logback.xml** - Logging configuration

## Next Steps

1. ✅ Customize database credentials
2. ✅ Add more test accounts
3. ✅ Explore the code in `src/main/java`
4. ✅ Run all tests with `mvn test`
5. ✅ Build production JAR with `mvn package`

## For Developers

### Generate New Executable JAR
```bash
mvn clean package
```

### View Dependency Tree
```bash
mvn dependency:tree
```

### Skip Tests During Build
```bash
mvn package -DskipTests
```

### Clean All Generated Files
```bash
mvn clean
```

## Support & Documentation

- Full documentation: See `README_SETUP.md`
- Build instructions: See `BUILD.md`
- Original code: See `ATM.java` (legacy)
