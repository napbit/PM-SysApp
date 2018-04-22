package com.binus.pmsys.utils;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import java.util.Random;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class HashHelper {
	
	private static final Random RANDOM = new SecureRandom();
	
	public HashHelper() { }
	
	public static byte[] getSalt() {
		byte[] salt = new byte[16];
		RANDOM.nextBytes(salt);
		return salt;
	}
	
	public static byte[] getHash(final char[] password, final byte[] salt, final int iterate, final int keyLen) {
		byte[] res = null;
		
		try {
			SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
			PBEKeySpec spec = new PBEKeySpec(password, salt, iterate, keyLen);
			SecretKey key = skf.generateSecret(spec);
			res = key.getEncoded();
		} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
			e.printStackTrace();
		} finally {
			Arrays.fill(password, (Character) '0');
		}
		
		return res;
	}

	
}
