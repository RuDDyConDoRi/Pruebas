/**
 *
 * @author rudy.condori
 */

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PruebasEncriptacionSHA1 {
    public static void main (String[] args) throws NoSuchAlgorithmException{
        
        String mensaje = "test string to sha1";
        
        String encriptado = sha1(mensaje);
        System.out.println("El mensaje es: "+mensaje);
        System.out.println("El Resultado del algoritmo es: "+encriptado);
        System.out.println("El resultado Verificacion: "+sha1Vericacion(mensaje, encriptado.toString()));
    }
    
    static String sha1(String input) throws NoSuchAlgorithmException {
        MessageDigest mDigest = MessageDigest.getInstance("SHA1");
        byte[] result = mDigest.digest(input.getBytes());
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < result.length; i++) {
            sb.append(Integer.toString((result[i] & 0xff) + 0x100, 16).substring(1));
        }
        return sb.toString();
    }
    
    public static boolean sha1Vericacion(String mensaje, String encriptado)throws NoSuchAlgorithmException{
        MessageDigest mDigest = MessageDigest.getInstance("SHA1");
        byte[] result = mDigest.digest(mensaje.getBytes());
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < result.length; i++) {
            sb.append(Integer.toString((result[i] & 0xff) + 0x100, 16).substring(1));
        }
        return sb.toString().equals(encriptado);
    }
}
