package ec.com.sofka.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection="logs")
public class LogDocument {

    @Id
    private String id;
    private String message;
    private LocalDate registrationDate;

    public LogDocument() {
    }

    public LogDocument(String id, String message, LocalDate registrationDate) {
        this.id = id;
        this.message = message;
        this.registrationDate = registrationDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

}
