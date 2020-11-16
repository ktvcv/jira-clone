package hillel.jiraclone.demo.exceptions;

public class EncodingException extends RuntimeException{
    public EncodingException(String message, Throwable cause) {
        super(message, cause);
    }
}
