package hillel.jiraclone.demo.service;

import hillel.jiraclone.demo.exceptions.EncodingException;
import hillel.jiraclone.demo.persistence.util.constants.Constants;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.encrypt.TextEncryptor;
import org.springframework.stereotype.Service;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
import java.util.Objects;

@Service
public class CipheringService {

    private static SecretKeySpec secretKey;
    private static byte[] key;

    public void setKey(String myKey)
    {
        MessageDigest sha = null;
        try {
            key = myKey.getBytes(StandardCharsets.UTF_8);
            sha = MessageDigest.getInstance("SHA-1");
            key = sha.digest(key);
            key = Arrays.copyOf(key, 16);
            secretKey = new SecretKeySpec(key, "AES");
        }
        catch (NoSuchAlgorithmException e) {
            throw new EncodingException("No such algorithm", e);
        }
    }

    public String encrypt(String strToEncrypt)
    {
        if(Objects.isNull(strToEncrypt)) return null;
        try
        {
            setKey(Constants.SECRET);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes(StandardCharsets.UTF_8)));
        }
        catch (Exception e) {
            return null;
        }

    }

    public String decrypt(String strToDecrypt)
    {
        if(Objects.isNull(strToDecrypt)) return null;
        try
        {
            setKey(Constants.SECRET);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
        }
        catch (Exception e)
        {
            return null;
        }
    }

}
