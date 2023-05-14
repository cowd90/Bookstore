package util;

import java.security.MessageDigest;

import org.apache.tomcat.util.codec.binary.Base64;

public class Encode {
	
	public static String ToSHA1(String pwd) {
		String salt = "sdjkzghzg@35&dfj256hbad";
		String result = null;
		pwd += salt;
		
		try {
			byte[] dataBytes = pwd.getBytes("UTF-8");
			MessageDigest md = MessageDigest.getInstance("SHA-1");
			result = Base64.encodeBase64String(md.digest(dataBytes));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
