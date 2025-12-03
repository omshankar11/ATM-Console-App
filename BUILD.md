# Build Instructions

## Using Maven

### Prerequisites
- Java Development Kit (JDK) 11 or higher
- Maven 3.6.0 or higher

### Build Steps

1. **Clean and Build**
   ```bash
   mvn clean build
   ```

2. **Compile Only**
   ```bash
   mvn compile
   ```

3. **Run Tests**
   ```bash
   mvn test
   ```

4. **Package Application**
   ```bash
   mvn package
   ```

5. **Install to Local Repository**
   ```bash
   mvn install
   ```

## Running the Application

### Option 1: Using Maven
```bash
mvn exec:java -Dexec.mainClass="com.atm.ui.ATMInterface"
```

### Option 2: Using Java Command
```bash
java -cp target/classes:~/.m2/repository/mysql/mysql-connector-java/8.0.33/mysql-connector-java-8.0.33.jar com.atm.ui.ATMInterface
```

### Option 3: Using Compiled JAR
```bash
java -jar target/atm-console-app.jar
```

## Development

### Using an IDE (IntelliJ IDEA or Eclipse)

1. Import project as Maven project
2. IDE will automatically download dependencies
3. Right-click on `ATMInterface.java` and select "Run"

## Environment Variables

Set these if needed:
- `JAVA_HOME` - Path to JDK installation
- `MAVEN_HOME` - Path to Maven installation

## Troubleshooting Build Issues

### Dependency Issues
```bash
mvn dependency:resolve
```

### Rebuild from Scratch
```bash
mvn clean install -U
```

### Skip Tests (for quick build)
```bash
mvn clean package -DskipTests
```

### View Dependency Tree
```bash
mvn dependency:tree
```
