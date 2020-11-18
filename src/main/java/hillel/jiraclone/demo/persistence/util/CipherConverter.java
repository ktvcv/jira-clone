package hillel.jiraclone.demo.persistence.util;

import org.springframework.stereotype.Component;

import javax.persistence.AttributeConverter;
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
