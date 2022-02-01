package Manager;

import org.springframework.security.crypto.bcrypt.BCrypt;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String password = "Espellianus";
		String securePassword = BCrypt.hashpw(password, BCrypt.gensalt(10));
		System.out.println(securePassword);
		
		boolean matched = BCrypt.checkpw(password, securePassword);
		System.out.println(matched);
	}

}
