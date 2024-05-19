import java.util.Scanner;

public class SignInMenu implements Menu {

	private ApplicationContext context;
	private UserManagementService userManagementService;
	Menu mainMenu = new MainMenu();

	{
		context = ApplicationContext.getInstance();
		userManagementService = DefaultUserManagementService.getInstance();
	}

	@Override
	public void start() {
		String email, password;
		if (context.getLoggedInUser() == null) {
			printMenuHeader();

			Scanner sc = new Scanner(System.in);
			System.out.println("Please, enter your email:");
			email = sc.nextLine();
			System.out.println("Please, enter your password:");
			password = sc.nextLine();

			User user = userManagementService.getUserByEmail(email);

			if ( user.getEmail().equals(email)  && (user.getPassword().equals(password))) {
				System.out.println("Glad to see you back " + user.getFirstName() +" " + user.getLastName());
				context.setLoggedInUser(user);
			}
			else {
				System.out.println("Unfortunately, such login and password doesn't exist");
				mainMenu.start();
			}
		}
	}

	@Override
	public void printMenuHeader() {
		System.out.println("***** Sign In *****");
	}

}
