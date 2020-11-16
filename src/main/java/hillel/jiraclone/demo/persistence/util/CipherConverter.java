package hillel.jiraclone.demo.persistence.util;

import hillel.jiraclone.demo.persistence.util.constants.Constants;
import hillel.jiraclone.demo.service.CipheringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Objects;

@Component
//@Converter(autoApply = true)
public class CipherConverter implements AttributeConverter<String, String> {

    @Override
    public String convertToDatabaseColumn(String s) {
        if (Objects.isNull(s)) return null;
        return CipheringService.encrypt(s);
    }

    @Override
    public String convertToEntityAttribute(String s) {
        if (Objects.isNull(s)) return null;
        return CipheringService.decrypt(s);
    }
}
