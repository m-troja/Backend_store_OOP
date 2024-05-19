import java.util.Scanner;

public class SettingsMenu implements Menu {

	private static final String SETTINGS = "1. Change Password" + System.lineSeparator()
			+ "2. Change Email";

	private ApplicationContext context;

	{

		context = ApplicationContext.getInstance();
	}

	@Override
	public void start() {

		mainLoop: while(true) {
		printMenuHeader();

		//listen for user input
		Scanner sc = new Scanner(System.in);
		int userInputInt = sc.nextInt();
		switch (userInputInt) {
			case 1:
				changePassword();
				break mainLoop;
			case 2:
				changeEmail();
				break mainLoop;

			default:
				System.out.println("Only 1, 2 is allowed. Try one more time");
		}

		}
	}
	private void changePassword() {
		System.out.println("Enter new password: ");
		Scanner sc = new Scanner(System.in);
		String newPass = sc.next();
		context.getLoggedInUser().setPassword(newPass);
		System.out.println("Your password has been successfully changed");

	}
	private void changeEmail() {
		System.out.println("Enter new email: ");
		Scanner sc = new Scanner(System.in);
		String newEmail = sc.next();
		context.getLoggedInUser().setEmail(newEmail);
		System.out.println("Your email has been successfully changed");
	}



	@Override
	public void printMenuHeader() {
		System.out.println(SETTINGS);
	}

}
