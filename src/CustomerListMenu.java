public class CustomerListMenu implements Menu {

	private ApplicationContext context;
	private UserManagementService userManagementService;
	Menu main = new MainMenu();
	
	{
		userManagementService = DefaultUserManagementService.getInstance();
		context = ApplicationContext.getInstance();
	}
	
	@Override
	public void start() {
		printMenuHeader();
		User[]  users  = userManagementService.getUsers();
		for (User user : users){
			if (user != null) System.out.println(user);
		}

		main.start();
	}

	@Override
	public void printMenuHeader() {
		System.out.println("*****USERS*****");
	}

}
