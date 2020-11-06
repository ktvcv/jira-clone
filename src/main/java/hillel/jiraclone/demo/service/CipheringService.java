package hillel.jiraclone.demo.service;

import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.encrypt.TextEncryptor;
import org.springframework.stereotype.Service;

@Service
public class CipheringService {

    final private String salt = System.getenv("salt");
    final private String password = System.getenv("password");

    public String encrypt(final String textToEncrypt){
        TextEncryptor encryptor = Encryptors.text(password, salt);
        return encryptor.encrypt(textToEncrypt);
    }

    public String decrypt(final String textToDecrypt){
        TextEncryptor decryptor = Encryptors.text(password, salt);
        return decryptor.decrypt(textToDecrypt);
    }

}
