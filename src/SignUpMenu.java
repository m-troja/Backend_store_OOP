import java.util.Scanner;

public class SignUpMenu implements Menu {

	private UserManagementService userManagementService;
	private ApplicationContext context;
	public static int counter ;

	{
		userManagementService = DefaultUserManagementService.getInstance();
		context = ApplicationContext.getInstance();
	}

	@Override
	public void start() {
		printMenuHeader();
	}
	

	@Override
	public void printMenuHeader() {
		System.out.println("****SignUp Menu*****");
		getData();	
	}
	
	public void getData() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("first name:");
		String firstname = sc.nextLine();
		
		System.out.println("last name:");
		String lastname = sc.nextLine();

		System.out.println("password:");
		String password = sc.nextLine();

		System.out.println("email:");
		String email = sc.nextLine();
		
		
		if (firstname == null || firstname == "" || lastname == null || lastname == "" || password == null  || email == null || email == "") {
			System.out.println("Null found. Try again."); 
			getData();
		}
		
		User tempUser = new DefaultUser(firstname, lastname, password, email, counter);

		userManagementService.registerUser(tempUser);


//		String errorMessage = userManagementService.registerUser(user);
//		if (errorMessage == null || errorMessage.isEmpty()) {
//			context.setLoggedInUser(user);
//			System.out.println("New user is created");
//		} else {
//			System.out.println(errorMessage);
//		}

		counter++;
		returnToMainMenu();

	}
		
	 public void returnToMainMenu(){
			Menu mainMenu = new MainMenu();
			mainMenu.start();			
			}

}
	



