# 🏧 ATM Console Application - Complete Setup Guide

## 📋 Table of Contents
1. [Overview](#overview)
2. [Prerequisites](#prerequisites)
3. [Installation & Setup](#installation--setup)
4. [Running the Application](#running-the-application)
5. [Project Structure](#project-structure)
6. [Architecture](#architecture)
7. [Features](#features)
8. [Testing](#testing)
9. [Troubleshooting](#troubleshooting)

---

## Overview

Your ATM Console Application has been completely restructured with:
- ✅ Professional Maven project structure
- ✅ Modular, scalable code organization
- ✅ Comprehensive unit tests (6/6 passing)
- ✅ Production-ready executable JAR
- ✅ Full documentation

### What Changed?
- **Before**: Single 143-line Java file (ATM.java)
- **After**: 4 well-organized classes with MVC architecture + comprehensive tests

---

## Prerequisites

### Required
- **Java**: JDK 11 or higher
  ```bash
  java -version
  # Should show version 11 or higher
  ```
- **Maven**: 3.6.0 or higher
  ```bash
  mvn -version
  # Should show Maven 3.6.0+
  ```
- **MySQL**: 5.7 or higher
  ```bash
  mysql --version
  # Should show MySQL version
  ```

### Installation Links (if needed)
- Java: https://www.oracle.com/java/technologies/downloads/
- Maven: https://maven.apache.org/download.cgi
- MySQL: https://dev.mysql.com/downloads/mysql/

---

## Installation & Setup

### Step 1: Setup MySQL Database

**Option A: Using Command Line**
```bash
mysql -u root -p < "C:\Users\hp\Documents\Projects\ATM-Console-App\SQL\database_setup.sql"
```

**Option B: Using MySQL Workbench or GUI Tool**
1. Open MySQL Workbench
2. Create new connection (if needed)
3. Connect as root user
4. File → Open SQL Script → Select `database_setup.sql`
5. Execute (Ctrl+Enter)

**What This Creates:**
- Database: `atm_db`
- Table: `accounts` (with 2 test accounts)
- Table: `transactions` (for logging)

**Verify Database Created:**
```bash
mysql -u root -p
> USE atm_db;
> SELECT * FROM accounts;
```

You should see 2 test accounts:
| account_number | pin  | balance   |
|---|---|---|
| 123456 | 1111 | 5000.00 |
| 789012 | 2222 | 1500.50 |

### Step 2: Download Dependencies (Automatic)
No manual action needed! Maven will automatically download:
- MySQL JDBC Driver
- JUnit testing framework
- SLF4J logging framework
- Logback logging implementation

---

## Running the Application

### Method 1: Using Maven (Recommended) ⭐

```bash
cd "C:\Users\hp\Documents\Projects\ATM-Console-App"
mvn exec:java -Dexec.mainClass="com.atm.ui.ATMInterface"
```

**Pros**: 
- Automatic classpath setup
- Automatic dependency resolution
- Works without manual compilation

### Method 2: Using Pre-built JAR

```bash
cd "C:\Users\hp\Documents\Projects\ATM-Console-App"
java -jar target/atm-console-app.jar
```

**Pros**:
- Fastest execution
- All dependencies included
- Ready for distribution

### Method 3: Using IDE (IntelliJ/Eclipse)

1. Open project as Maven project
2. Right-click `src/main/java/com/atm/ui/ATMInterface.java`
3. Select "Run 'ATMInterface.main()'"

---

## Using the Application

### Login Screen
```
Enter account number: 123456
Enter PIN: 1111
✓ Login successful!
```

### Main Menu
```
========================================
          ATM Menu
========================================
1. Check Balance
2. Deposit
3. Withdraw
4. View Recent Transactions
5. Exit
Choose an option (1-5): 1
```

### Example Operations

**Check Balance**
```
Choose an option (1-5): 1
Current Balance: $5000.00
```

**Deposit**
```
Choose an option (1-5): 2
Enter amount to deposit: $500
✓ Deposit successful!
New balance: $5500.00
```

**Withdraw**
```
Choose an option (1-5): 3
Enter amount to withdraw: $200
✓ Withdrawal successful!
New balance: $5300.00
```

---

## Project Structure

### Directory Layout
```
ATM-Console-App/
├── src/
│   ├── main/java/com/atm/
│   │   ├── model/Account.java                 # Data model
│   │   ├── service/AccountService.java        # Business logic
│   │   ├── util/DatabaseConnection.java       # DB utilities
│   │   └── ui/ATMInterface.java               # Main app (ENTRY POINT)
│   ├── main/resources/
│   │   ├── application.properties             # App config
│   │   ├── logback.xml                        # Logging setup
│   │   └── log4j.xml                          # Alternative logging
│   └── test/java/com/atm/test/
│       └── AccountTest.java                   # Unit tests
│
├── target/                                     # Build output
│   └── atm-console-app.jar                    # Executable JAR
│
├── SQL/
│   └── database_setup.sql                     # Database schema
│
├── pom.xml                                    # Maven configuration
├── BUILD.md                                   # Build instructions
├── QUICK_START.md                             # Quick start guide
├── README_SETUP.md                            # Setup guide
├── PROJECT_SUMMARY.md                         # Completion report
└── ATM.java                                   # Original code (legacy)
```

### Class Responsibilities

**Account.java** (Model)
- Represents a bank account
- Manages balance state
- Provides deposit/withdraw methods

**AccountService.java** (Service)
- Authenticates users
- Manages database operations
- Logs transactions

**DatabaseConnection.java** (Utility)
- Creates database connections
- Handles connection errors
- Manages JDBC driver loading

**ATMInterface.java** (UI)
- Main entry point
- Displays menus
- Handles user input
- Orchestrates operations

---

## Architecture

### Design Patterns Used

1. **MVC (Model-View-Controller)**
   - Model: Account class
   - View: ATMInterface class
   - Controller: ATMInterface (orchestrates)

2. **Service Layer Pattern**
   - AccountService encapsulates business logic
   - Separates concerns from UI

3. **Utility Pattern**
   - DatabaseConnection centralizes DB setup
   - Reusable across application

4. **DAO (Data Access Object)**
   - AccountService acts as DAO
   - All database access goes through this layer

### Data Flow

```
User Input (ATMInterface)
        ↓
User Interface Logic (ATMInterface)
        ↓
Business Logic (AccountService)
        ↓
Database Layer (DatabaseConnection)
        ↓
MySQL Database
```

---

## Features

### Core Features ✅
- [x] Account authentication (Account # + PIN)
- [x] Check balance
- [x] Deposit money
- [x] Withdraw money
- [x] Transaction logging
- [x] Input validation
- [x] Error handling
- [x] Formatted output

### Technical Features ✅
- [x] Unit tests (6 test cases)
- [x] Maven build automation
- [x] Dependency management
- [x] SQL integration
- [x] Logging framework
- [x] Configuration management

### Future Features 🔮
- [ ] Transaction history view
- [ ] PIN change functionality
- [ ] Account transfers
- [ ] Multi-user support
- [ ] GUI interface (Swing/JavaFX)
- [ ] Cloud deployment
- [ ] Encryption/Security enhancements

---

## Testing

### Run All Tests
```bash
cd "C:\Users\hp\Documents\Projects\ATM-Console-App"
mvn test
```

### Expected Output
```
-------------------------------------------------------
 T E S T S
-------------------------------------------------------
Running com.atm.test.AccountTest
Tests run: 6, Failures: 0, Errors: 0, Skipped: 0

Results:
Tests run: 6, Failures: 0, Errors: 0, Skipped: 0
BUILD SUCCESS
```

### Test Cases Included

| Test | Purpose |
|---|---|
| testAccountCreation | Verify account initialization |
| testDeposit | Test deposit functionality |
| testWithdraw | Test successful withdrawal |
| testWithdrawInsufficientFunds | Test insufficient funds error |
| testNegativeDeposit | Test invalid deposit amount |
| testNegativeWithdraw | Test invalid withdrawal amount |

---

## Troubleshooting

### Issue 1: "MySQL JDBC Driver not found"
```
ERROR: com.mysql.jdbc.Driver not found
```

**Solution:**
```bash
# Clean and rebuild to download dependencies
mvn clean compile

# Verify MySQL connector was downloaded
dir %USERPROFILE%\.m2\repository\mysql\
```

### Issue 2: "Connection refused"
```
ERROR: Cannot connect to database at localhost:3306
```

**Solution:**
1. Verify MySQL is running
   ```bash
   # Windows: Check MySQL service
   services.msc  # Look for MySQL service
   
   # Or check via command line
   netstat -an | findstr 3306
   ```

2. Check database credentials in `DatabaseConnection.java`
3. Verify database exists: `mysql -u root -p -e "SHOW DATABASES;"`

### Issue 3: "Invalid account number or PIN"
```
Login failed
```

**Solution:**
1. Verify database setup was executed
   ```bash
   mysql -u root -p < SQL/database_setup.sql
   ```
2. Check test accounts exist
   ```bash
   mysql -u root -p atm_db -e "SELECT * FROM accounts;"
   ```
3. Use correct credentials: Account 123456, PIN 1111

### Issue 4: "No tests were run"
```
Tests run: 0
```

**Solution:**
```bash
# Check test files exist
dir src\test\java\com\atm\test

# Run tests with verbose output
mvn test -X
```

### Issue 5: Maven command not found
```
'mvn' is not recognized as an internal or external command
```

**Solution:**
1. Install Maven from https://maven.apache.org/
2. Add Maven to PATH environment variable
3. Verify installation: `mvn -version`

### Issue 6: Java version mismatch
```
ERROR: Java 8 or older detected (requires 11+)
```

**Solution:**
1. Install Java 11 or higher
2. Verify: `java -version`
3. Set JAVA_HOME environment variable
4. Restart terminal/IDE

---

## Build & Deployment

### Clean Build
```bash
mvn clean install
```

### Skip Tests (Quick Build)
```bash
mvn clean package -DskipTests
```

### View Dependencies
```bash
mvn dependency:tree
```

### Generate Documentation
```bash
mvn javadoc:javadoc
```

---

## Configuration

### Database Credentials
**File**: `src/main/java/com/atm/util/DatabaseConnection.java`

```java
private static final String DB_URL = "jdbc:mysql://localhost:3306/atm_db";
private static final String USER = "root";
private static final String PASS = "";  // Update here
```

### Application Properties
**File**: `src/main/resources/application.properties`

```properties
db.url=jdbc:mysql://localhost:3306/atm_db
db.user=root
db.password=
app.version=1.0.0
```

### Logging Configuration
**File**: `src/main/resources/logback.xml`

Edit to change:
- Log level (INFO, DEBUG, ERROR)
- Log file location
- Log format

---

## Support & Help

### Documentation Files
- `QUICK_START.md` - 5-minute quick start
- `BUILD.md` - Build instructions
- `README_SETUP.md` - Complete setup guide
- `PROJECT_SUMMARY.md` - What was done

### Command Reference

| Command | Purpose |
|---|---|
| `mvn clean compile` | Compile source code |
| `mvn test` | Run unit tests |
| `mvn package` | Create JAR file |
| `mvn clean` | Delete build artifacts |
| `mvn dependency:tree` | Show dependencies |
| `java -jar target/atm-console-app.jar` | Run application |

### Getting Help
1. Check the documentation files
2. Review error messages carefully
3. Check MySQL is running and database exists
4. Verify Java and Maven versions
5. Try `mvn clean install`

---

## Next Steps

1. ✅ Run the application following the steps above
2. ✅ Test with the provided credentials
3. ✅ Review code in `src/main/java`
4. ✅ Run unit tests with `mvn test`
5. ✅ Explore extending with new features
6. ✅ Deploy to production using the JAR

---

## Quick Reference - Step by Step

```bash
# 1. Navigate to project
cd C:\Users\hp\Documents\Projects\ATM-Console-App

# 2. Setup database (run once)
mysql -u root -p < SQL/database_setup.sql

# 3. Build project
mvn clean compile

# 4. Run tests
mvn test

# 5. Create JAR
mvn package

# 6. Run application
java -jar target/atm-console-app.jar

# 7. Or run using Maven
mvn exec:java -Dexec.mainClass="com.atm.ui.ATMInterface"
```

---

**Your ATM Console App is now ready to use!** 🎉

For quick start, see `QUICK_START.md`
For more details, see `PROJECT_SUMMARY.md`
For build info, see `BUILD.md`
