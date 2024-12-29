package ec.com.sofka.mapper;

import ec.com.sofka.Log;
import ec.com.sofka.document.LogDocument;

public class LogMapper {

    public static Log toDomain(LogDocument entity) {
        if (entity == null) {
            return null;
        }
        Log account = new Log();
        account.setId(entity.getId());
        account.setMessage(entity.getMessage());
        account.setRegistrationDate(entity.getRegistrationDate());
        return account;
    }

    public static LogDocument toEntity(Log domain) {
        if (domain == null) {
            return null;
        }

        LogDocument entity = new LogDocument();
        entity.setId(domain.getId());
        entity.setMessage(domain.getMessage());
        entity.setRegistrationDate(domain.getRegistrationDate());
        return entity;
    }
}
