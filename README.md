
### SQL Injection Demo

This project is a demonstration of **SQL Injection vulnerabilities** using a simple login system built with PHP and MySQL. It is designed for **educational purposes** to help understand how SQL injection attacks work and how to prevent them.

> ⚠️ This project contains intentionally vulnerable code. DO NOT use it in production environments.

---

## 📚 What is SQL Injection?

**SQL Injection (SQLi)** is a code injection technique that exploits security vulnerabilities in an application's software by manipulating SQL queries through user input. It allows attackers to access, modify, or delete data in a database.

---

## 🧪 Features

- Simple PHP-based login form
- Vulnerable SQL query for demonstration
- Login bypass using classic SQLi payloads
- Clear codebase for learning purposes

---

## 🛠️ Setup Instructions

### Requirements
- Local server (e.g. [XAMPP](https://www.apachefriends.org/))
- PHP & MySQL
- Web browser

### Installation

1. **Clone this repository:**

```bash
git clone https://github.com/ZiadMahmoud2003/sql-injection.git
```

2. **Move the folder** to your web server directory (e.g., `htdocs` in XAMPP).

3. **Start Apache and MySQL** via XAMPP.

4. **Create the database**:

Go to [phpMyAdmin](http://localhost/phpmyadmin), and run:

```sql
CREATE DATABASE test;
USE test;

CREATE TABLE users (
    id INT(11) AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    password VARCHAR(50) NOT NULL
);

INSERT INTO users (username, password) VALUES ('admin', 'admin123');
```

5. **Visit the app** in your browser:

```
http://localhost/sql-injection/
```

Try logging in using:

- Username: `admin`
- Password: `admin123`

---

## 💥 Try an SQL Injection

Example payload to bypass login:

```
Username: ' OR '1'='1
Password: anything
```

This tricks the SQL query into always returning true.

---

## ✅ How to Prevent SQL Injection

> This project is intentionally insecure. Here's how you should secure real applications:

- Use **prepared statements** with **PDO** or **MySQLi**
- Sanitize and validate user input
- Use least privilege for DB users

---

## 📜 License

This project is licensed under the MIT License.

---

## ⚠️ Disclaimer

This project is for **educational and ethical testing purposes only**. Unauthorized use of these techniques on systems you do not own is illegal.

---

Made with ❤️ by [Ziad Mahmoud](https://github.com/ZiadMahmoud2003)
```
