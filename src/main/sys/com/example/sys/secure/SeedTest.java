package com.example.sys.secure;

import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

public class SeedTest {

	private static final String SEEDKEY = "QFRTVFlzQm1Lc0pjTmdDag==";
	private static final String CBCKEY = "KPAYWtest1WpTest";

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Encoder encoder = Base64.getEncoder();
		Decoder decoder = Base64.getDecoder();

		byte[] pbszUserKey = decoder.decode(SEEDKEY);
		byte[] pbszIV = CBCKEY.getBytes();

		String str = "userid123";
		byte[] cipherText = KISA_SEED_CBC.SEED_CBC_Encrypt(pbszUserKey, pbszIV, str.getBytes(), 0,
				str.getBytes().length);
		for (int i = 0; i < cipherText.length; i++) {
			System.out.print(Integer.toHexString(0xff & cipherText[i]) + " ");
		}
		System.out.println("\n" + encoder.encodeToString(cipherText));

		byte[] plainText = KISA_SEED_CBC.SEED_CBC_Decrypt(pbszUserKey, pbszIV, cipherText, 0, cipherText.length);
		System.out.println("\n" + new String(plainText));
	}

}
