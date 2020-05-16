package classes;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class EncodePassword {
    public static String getSecurePassword(String password, byte[] salt) throws NoSuchAlgorithmException{
        MessageDigest digest = MessageDigest.getInstance("SHA-512");
        digest.reset();
        digest.update(salt);
        byte[] hash=digest.digest(password.getBytes());
        return bytesToStringHex(hash);
    }

    private final static char[] hexArray= "0123456789ABCDEF".toCharArray();

    public static String bytesToStringHex(byte[] bytes){
        char[] hexChars = new char[bytes.length*2];
        for(int j=0; j<bytes.length; j++){
            int v=bytes[j] & 0xFF;
            hexChars[j*2]=hexArray[v >>> 4];
            hexChars[j*2+1]=hexChars[v & 0x0F];
        }
        return new String(hexChars);
    }

    public static byte[] createSalt() {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        return salt;
    }
}
