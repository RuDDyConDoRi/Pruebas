import java.io.IOException;

public class PruebaBase64_Bueno {

	public static void main(String[] args) {

		try {
			java.io.File file = new java.io.File("C:\\trabajos\\Test.pdf");
			java.io.FileInputStream fis = new java.io.FileInputStream(file);
			byte[] buff = new byte[(int) file.length()];
			fis.read(buff);
			// codificar base64
			String codificado_base64 = new sun.misc.BASE64Encoder().encode(buff);
			System.out.println("codificado:\n" + codificado_base64);
			
			// decodificar base64
			byte[] decodificado_base64 = new sun.misc.BASE64Decoder().decodeBuffer(codificado_base64);
			// System.out.println("decodificado:\n"+new String(decodificado_base64));
		
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
