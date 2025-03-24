
package Crud;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Hashing {
    
    public Hashing(){
        
    }
    
    public String doHashing(String password){
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            
            messageDigest.update(password.getBytes());
            
            byte[] resultByteArray =  messageDigest.digest();
            
            StringBuilder sb = new StringBuilder();
            
            for(byte b : resultByteArray){
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Hashing.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }
    
}
