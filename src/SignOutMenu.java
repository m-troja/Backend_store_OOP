public class SignOutMenu implements Menu {

	private ApplicationContext context;
	
	{
		context = ApplicationContext.getInstance();
	}
	
	@Override
	public void start() {
		printMenuHeader();
		context.setLoggedInUser(null);
		returnToMainMenu();
	}

	@Override
	public void printMenuHeader() {
		System.out.println("Signed out!");
	}
	public void returnToMainMenu(){
		Menu mainMenu = new MainMenu();
		mainMenu.start();
	}
}
