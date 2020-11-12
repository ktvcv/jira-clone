package hillel.jiraclone.demo.persistence.util;

import hillel.jiraclone.demo.service.CipheringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Optional;

@Component
@Converter(autoApply = true)
public class CipherConverter implements AttributeConverter<String, String> {

    @Autowired
    CipheringService cipheringService;

    @Override
    public String convertToDatabaseColumn(String s) {
        Assert.notNull(s, "You want to convert nullable string");
        return cipheringService.encrypt(s);
    }

    @Override
    public String convertToEntityAttribute(String s) {
        Assert.notNull(s, "You want to convert nullable string");
        return cipheringService.decrypt(s);
    }
}
