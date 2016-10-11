import java.security.*;
import javax.crypto.*;

public class SingleKey {

	public static void main(String[] args) {
		try {
			String algorithm = "DES"; //��������㷨,���� DES,DESede,Blowfish
			String message = "Hello World. ���Ǵ����ܵ���Ϣ";

			// ���ɸ�DES��Կ
			KeyGenerator keyGenerator = KeyGenerator.getInstance(algorithm);
			keyGenerator.init(56); //ѡ��DES�㷨,��Կ���ȱ���Ϊ56λ
			Key key = keyGenerator.generateKey(); //������Կ

			// ����Cipher����
			Cipher cipher = Cipher.getInstance("DES");

			//����Կ��������(message),��������(cipherText)
			cipher.init(Cipher.ENCRYPT_MODE, key);  //����ģʽΪ����(Cipher.ENCRYPT_MODE),keyΪ��Կ
			byte[] cipherText = cipher.doFinal(message.getBytes());  //�õ����ܺ���ֽ�����
			System.out.println("���ܺ����Ϣ: " + new String(cipherText));

			//����Կ��������(plainText),��������(cipherByte)
			cipher.init(Cipher.DECRYPT_MODE, key);  //����ģʽΪ����,keyΪ��Կ
			byte[] sourceText = cipher.doFinal(cipherText); //��ý��ܺ��ֽ�����
			System.out.println("���ܺ����Ϣ: " + new String(sourceText));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
