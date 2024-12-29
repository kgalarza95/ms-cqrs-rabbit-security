package ec.com.sofka;

import java.time.LocalDate;

public class Log {

    private String id;
    private String message;
    private LocalDate registrationDate;

    public Log() {
    }

    public Log(String message, LocalDate registrationDate) {
        this.message = message;
        this.registrationDate = registrationDate;
    }

    public Log(String id, String message, LocalDate registrationDate) {
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
