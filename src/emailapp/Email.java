package emailapp;

/**
 * This class represents the Email of new hires.
 * 
 * @author Anderson Cossul
 */
public class Email {
	private String firstName;
	private String lastName;
	private String department;
	private String password;
	private int mailboxCapacity;
	private String email;
	private String alternateEmailAddress;
	private int minimumPasswordLength = 8;

	/**
	 * @param firstName
	 *            (String)
	 * @param lastName
	 *            (String)
	 * @param department
	 *            (String)
	 */
	public Email(String firstName, String lastName, String department) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.department = department;
		this.password = generateRandomPassword();
		this.email = generateEmail();

		System.out.println("EMAIL CREATED:");
		System.out.println("Email: " + email);
		System.out.println("Password: " + password);
	}

	/**
	 * @return email (firstname.lastname@department.company.com if the
	 *         department was set or firstname.lastname@company.com if it was
	 *         not set.
	 */
	private String generateEmail() {
		String email = firstName.toLowerCase() + '.' + lastName.toLowerCase() + "@";
		if (department != "") {
			email += department.toLowerCase() + ".";
		}
		email += "company.com";
		return email;
	}

	/**
	 * @return password (String)
	 */
	private String generateRandomPassword() {
		String passwordChars = "ABCDEFGHIJKLMNOPQRSTUWXYZ0123456789!@#$%";
		char[] pass = new char[minimumPasswordLength];
		for (int i = 0; i < minimumPasswordLength; i++) {
			int randomValueInPasswordCharsRange = (int) (Math.random() * passwordChars.length());
			pass[i] = passwordChars.charAt(randomValueInPasswordCharsRange);
		}
		return new String(pass);
	}

	/**
	 * @param password
	 *            (must have length equal or greater than the
	 *            minimumPasswordLength (default is 8))
	 */
	public void setPassword(String password) {
		if (password.length() >= minimumPasswordLength) {
			this.password = password;
		}
	}

	/**
	 * @param mailboxCapacity
	 *            (must not be negative)
	 */
	public void setMailboxCapacity(int mailboxCapacity) {
		if (mailboxCapacity >= 0) {
			this.mailboxCapacity = mailboxCapacity;
		}
	}

	/**
	 * @param alternateEmailAddress
	 *            (String)
	 */
	public void setAlternateEmailAddress(String alternateEmailAddress) {
		this.alternateEmailAddress = alternateEmailAddress;
	}

	/**
	 * @returns name (String)
	 */
	public String getName() {
		return this.firstName + " " + this.lastName;
	}

	/**
	 * @return email (String)
	 */
	public String getEmail() {
		return this.email;
	}

	/**
	 * @return mailboxCapacity (int)
	 */
	public int getMailboxCapacity() {
		return this.mailboxCapacity;
	}

	/**
	 * Prints some important info about the object.
	 */
	@Override
	public String toString() {
		return "Email: " + email
				+ "\nPassword: " + password
				+ "\nMailBox Capacity: " + mailboxCapacity
				+ "\nAlternate Email Address: " + alternateEmailAddress;
	}
}
