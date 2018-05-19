package emailapp;

public class Main {
	public static void main(String[] args) {
		Email email = new Email("Anderson", "Cossul", "development");
		email.setPassword("admin123");
		email.setMailboxCapacity(999);
		email.setAlternateEmailAddress("anderson_cossul@hotmail.com");
		System.out.println("\n" + email);
	}
}
