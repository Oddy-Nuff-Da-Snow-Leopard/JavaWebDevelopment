package by.epam.appetizer.service.encryption;

import by.epam.appetizer.service.encryption.exception.EncryptionException;
import org.apache.log4j.Logger;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;

import static java.nio.charset.StandardCharsets.UTF_8;

public final class PasswordEncryptor {

    private static final Logger LOGGER = Logger.getLogger(PasswordEncryptor.class);
    private static final String KEY_PATTERN = "PBKDF2WithHmacSHA1";
    private static final int ITERATION_COUNT = 65536;
    private static final int KEY_LENGTH = 128;
    private static final PasswordEncryptor INSTANCE = new PasswordEncryptor();

    private PasswordEncryptor() {
    }

    public static PasswordEncryptor getInstance() {
        return INSTANCE;
    }

    public String generateHash(String email, String password) throws EncryptionException {
        KeySpec keySpec = new PBEKeySpec(password.toCharArray(), email.getBytes(),
                ITERATION_COUNT, KEY_LENGTH);
        try {
            SecretKeyFactory factory = SecretKeyFactory.getInstance(KEY_PATTERN);
            byte[] encoded = factory.generateSecret(keySpec).getEncoded();
            System.out.println(new String(encoded, UTF_8));
            return new String(encoded, UTF_8);
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            LOGGER.fatal(e);
            throw new EncryptionException(e);
        }
    }
}
