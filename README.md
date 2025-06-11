
```markdown
# 🚨 Wearable GPS Tracker with Database Integration

A Java-based wearable GPS tracker designed for disaster management scenarios (e.g., tracking fishermen at sea). This project allows real-time location logging and stores device logs in a MySQL database.

---

## 🌟 Features

✅ Real-time GPS logging  
✅ Logs stored in MySQL  
✅ Wearable device simulation  
✅ Simple, modular Java code  
✅ Easily extendable with additional features (e.g., analytics, alerts, GUI)

---

## 📦 Project Structure

```

src/
device/
WearableDevice.java       # Represents a wearable device
service/
TrackerService.java       # Handles logging data to MySQL
main/
Main.java                 # Entry point
mysql-connector-java-x.x.x.jar # MySQL JDBC driver (external)

````

---

## 🛠️ Prerequisites

- **Java 11+**
- **MySQL Server** installed and running
- **MySQL JDBC Driver** (`mysql-connector-java-x.x.x.jar`)

---

## 🐬 Database Setup

1️⃣ Log into MySQL:
```bash
mysql -u root -p
````

2️⃣ Create the database:

```sql
CREATE DATABASE tracker_db;
```

3️⃣ Create a user:

```sql
CREATE USER 'tracker_user'@'localhost' IDENTIFIED BY 'yourpassword';
GRANT ALL PRIVILEGES ON tracker_db.* TO 'tracker_user'@'localhost';
FLUSH PRIVILEGES;
```

4️⃣ Create the logs table:

```sql
USE tracker_db;
CREATE TABLE logs (
    id INT AUTO_INCREMENT PRIMARY KEY,
    deviceId VARCHAR(50) NOT NULL,
    latitude DOUBLE,
    longitude DOUBLE,
    timestamp DATETIME DEFAULT CURRENT_TIMESTAMP,
    distressSignal BOOLEAN
);
```

---

## 🔌 How to Run

### 1. Compile

**If using Terminal**:

```bash
javac -cp .:mysql-connector-java-8.4.0.jar src/main/Main.java src/device/WearableDevice.java src/service/TrackerService.java
```

*(Use `;` instead of `:` on Windows.)*

### 2. Run

```bash
java -cp .:mysql-connector-java-8.4.0.jar src/main/Main
```

### 3. Output

You should see:

```
Logged data for device: Device001
```

And your MySQL database will contain the latest device logs.

---

## 🚀 Next Steps

Here are some ideas to extend this project:

✅ Add a GUI with JavaFX (or Swing)
✅ Integrate real GPS modules
✅ Implement data analytics or reporting
✅ Add an SOS alert system
✅ Build a web dashboard for monitoring

---

## 📌 Notes

* If using an IDE like IntelliJ IDEA, add the `mysql-connector-java-x.x.x.jar` to your project’s **Libraries/Dependencies**.
* If using Maven, add:

```xml
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>8.4.0</version>
</dependency>
```
