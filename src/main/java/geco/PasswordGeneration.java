package geco;

public class PasswordGeneration {

	private String password;

	public PasswordGeneration() {
	}

	public String getRandomPassword() {
		String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		String pass = "";

		for (int i = 0; i < 8; i++) {
			int x = (int)Math.floor(Math.random() * 62);
			pass += chars.charAt(x);
		}

		return pass;
	}

}
