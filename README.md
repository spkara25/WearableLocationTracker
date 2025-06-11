
```markdown
# 🚨 Wearable GPS Tracker (Simulation)

A Java-based simulation of a wearable GPS tracker designed for disaster management scenarios (e.g., tracking fishermen at sea). This project simulates real-time location tracking using wearable devices like watches, pins, or shirts.

---

## 🌟 Features

✅ Real-time GPS logging (simulated)  
✅ Wearable device simulation  
✅ Clean, modular Java code  
✅ Easily extendable with additional features (e.g., alerts, analytics, visualization)

---

## 📦 Project Structure

```
wearable-tracker/
│
├── src/
│   ├── main/
│   │   └── Main.java
│   │
│   ├── device/
│   │   └── WearableDevice.java
│   │
│   └── service/
│       └── TrackerService.java
│
├── README.md
│
└── .gitignore

````

---

## 🛠️ Prerequisites

- **Java 11+** (or higher)
- Basic understanding of Java (classes, packages, etc.)

---

## 🔌 How to Run

### 1. Compile

Using terminal:
```bash
cd wearable-tracker
javac src/main/Main.java src/device/WearableDevice.java src/service/TrackerService.java
````

*(On Windows, use `\` instead of `/` for paths.)*

### 2. Run

```bash
java -cp src main.Main
```

### 3. Output

You should see:

```
Device Device001 is being tracked...
Latitude: 13.7563, Longitude: 100.5018
```

---

## 🚀 Next Steps

Here are some ideas to extend this project:

✅ Integrate with a database for logs
✅ Add a map visualization (e.g., use a web dashboard or external API)
✅ Implement SOS alerts
✅ Create a mobile or web interface
✅ Integrate real GPS modules and sensors

---

## 📌 Notes

* The GPS coordinates in this simulation are hardcoded or randomly generated for demonstration.
* For a real-world deployment, integrate with an actual GPS module or mobile device API.

