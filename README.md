# 🎬 Movies API - Spring Boot Backend

This is a **RESTful backend API** built with **Java Spring Boot** for managing a movie database. It includes features like **JWT-based authentication**, **file/image uploading**, **pagination & sorting**, and **password reset functionality**.

---

## 🚀 Features

- 🔐 **User Authentication** using **JWT**
- 📝 **CRUD Operations** for Movies
- 🖼️ **Image Uploading** (Poster/Image for Movies)
- 📂 **File Handling** with storage on disk
- 📄 **Pagination and Sorting** for movie listings
- 🔑 **Forgot Password Flow** using email token reset

---

## 🛠️ Technologies Used

- Java 17+
- Spring Boot
- Spring Security + JWT
- Spring Data JPA (Hibernate)
- MySQL/PostgreSQL (configurable)
- Lombok
- Swagger (API Documentation)
- Apache Commons IO
- Java Mail Sender (for forgot password)
- Multipart File Handling

---

## 🧰 Setup Instructions

### 1. Clone the repository

```bash
git clone https://github.com/your-username/movies-api-springboot.git
cd movies-api-springboot
```

### 2. Configure the `application.properties`

```properties
# Database Configuration
spring.datasource.url=jdbc:mysql://localhost:3306/moviesdb
spring.datasource.username=root
spring.datasource.password=yourpassword

# JWT Configuration
jwt.secret=your_jwt_secret
jwt.expiration=86400000

# File Storage Path
file.upload-dir=uploads/

# Mail Configuration
spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username=youremail@example.com
spring.mail.password=your_email_password
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true
```

> 🔐 **Secure your secrets** using environment variables or a secure config manager in production!

### 3. Run the application

```bash
./mvnw spring-boot:run
```

### 4. Access API Documentation

Open Swagger UI:

```
http://localhost:8080/swagger-ui/index.html
```

---

## 📚 API Endpoints Overview

### 🔐 Authentication

- `POST /api/auth/register` – User registration
- `POST /api/auth/login` – Login and receive JWT token
- `POST /api/auth/forgot-password` – Request reset email
- `POST /api/auth/reset-password` – Reset password using token

### 🎥 Movies

- `GET /api/movies?page=0&size=10&sort=title,asc` – Paginated and sorted list
- `POST /api/movies` – Create a movie (with image upload)
- `PUT /api/movies/{id}` – Update a movie
- `DELETE /api/movies/{id}` – Delete a movie
- `GET /api/movies/{id}` – Get movie details

### 📂 File Upload

- Upload handled using `MultipartFile`
- Stored in the path configured in `file.upload-dir`

---

## ✅ Sample JSON – Create Movie

```json
{
  "title": "Inception",
  "description": "A mind-bending thriller",
  "releaseDate": "2010-07-16",
  "genre": "Sci-Fi"
}
```

Use multipart/form-data with the above JSON and an image file.

---

## 🔒 Security

- **JWT** is used for securing all protected endpoints.
- Only registered and authenticated users can create, update, or delete movies.
- Admin roles can be introduced for further authorization.

---

## 🔄 Forgot Password Flow

1. `POST /api/auth/forgot-password` with email
2. User receives email with reset link/token
3. `POST /api/auth/reset-password` with token and new password

---

## 📸 Image Uploading

- Accepts only `.jpg`, `.jpeg`, `.png`
- Validated and stored under `/uploads/` directory
- Can be retrieved or served statically

---

## 🧪 Testing

- Unit and integration tests can be written using JUnit and Mockito.
- Swagger helps for quick manual testing.

---

## 📌 Future Improvements

- Role-based access control (admin, user)
- Image optimization (thumbnailing)
- OAuth2 / Google login
- Docker containerization
- Logging with ELK stack

---

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

---

Would you like a sample Swagger/OpenAPI documentation or Postman collection for this API as well?
