# 🏥 Hospital Management System

The **Hospital Management System** is a **Java Swing–based desktop application** designed to manage day-to-day hospital operations efficiently.  
This project is developed as part of an **MCA academic project** and uses a **MySQL database** for data storage.

---

## 📌 Features

### 🔐 Login System
- Secure login for hospital staff
- Username and password authentication

### 🏠 Reception Dashboard
- Central control panel for all hospital activities
- Easy navigation to all modules

### 👤 Patient Management
- Add new patient details
- View patient information
- Update patient records
- Discharge patients

### 🛏️ Room Management
- View room details
- Check room availability
- Search rooms by status (Available / Occupied)

### 🏥 Department Information
- Displays hospital departments
- Shows department contact numbers

### 👨‍⚕️ Employee Information
- View doctor and staff details
- Name, age, salary, contact, and email information

### 🚑 Ambulance Management
- View ambulance details
- Driver name, vehicle name, availability, and location

---

## 🛠️ Technologies Used

- **Programming Language:** Java  
- **GUI Framework:** Java Swing  
- **Database:** MySQL  
- **Database Connectivity:** JDBC  
- **IDE:** IntelliJ IDEA / Eclipse  
- **Version Control:** Git & GitHub  

---

## 📂 Project Structure
Hospital-management-System
│
├── src/
│ └── hospital/management/system/
│ ├── Login.java
│ ├── Reception.java
│ ├── NEW_PATIENT.java
│ ├── Patient_Info.java
│ ├── Update_Patient_info.java
│ ├── Patient_discharge.java
│ ├── Room.java
│ ├── Search_Room.java
│ ├── Department.java
│ ├── Employee_info.java
│ ├── Ambulance.java
│ └── conn.java
│
├── screenshots/
│ ├── login.png
│ ├── dashboard.png
│ ├── add-patient.png
│ ├── patient-info.png
│ ├── update-patient.png
│ ├── discharge.png
│ ├── room-details.png
│ ├── search-room.png
│ ├── department.png
│ ├── employee-info.png
│ └── ambulance.png
│
├── README.md
└── database.sql


---

## ▶️ How to Run the Project

1. **Clone the repository**
   ```bash
   git clone https://github.com/DipakMagadum/Hospital-management-System.git


Open the project

Open IntelliJ IDEA or Eclipse

Import the project

Database Configuration

Create a MySQL database

Import database.sql

Update database username and password in conn.java

Run the Application

Run Login.java
