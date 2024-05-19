import java.util.Arrays;

public class DefaultUserManagementService implements UserManagementService {

	private static final String NOT_UNIQUE_EMAIL_ERROR_MESSAGE = "This email is already used by another user. Please, use another email";
	private static final String EMPTY_EMAIL_ERROR_MESSAGE = "You have to input email to register. Please, try one more time";
	private static final String NO_ERROR_MESSAGE = "";

	private static final int DEFAULT_USERS_CAPACITY = 10;
	private static DefaultUserManagementService instance;
	private  User[] usersArray = new User[DEFAULT_USERS_CAPACITY];
	ApplicationContext contextInstance = ApplicationContext.getInstance();
	Menu mainMenu = new MainMenu();
	private  int numberOfUsers;
	// <write your code here>

	private DefaultUserManagementService() {
	}

	@Override
	public String registerUser(User user) {
		String firstname = user.getFirstName();
		String lastName = user.getLastName();
		String password = user.getPassword();
		String email = user.getEmail();
		int id = user.getId();


		if ( checkEmail(user.getEmail()))
		{

			//add user to array
			int i;
			usersArray[user.getId()] =  user;

			//numberofusers gets higher
			numberOfUsers = user.getId();


			//confirm user added to usersArray
			System.out.println("New user is created");


			//set user as logged
			contextInstance.setLoggedInUser(user);

			return "0";
		}

			else mainMenu.start();
			return "1";
	}

public int getNumberOfUsers() {
	return numberOfUsers;
}

	public boolean checkEmail(String email) {
		boolean flag = false;
		for (User users : usersArray) {
			if (users != null) {
				if (users.getEmail().equals(email)) {
					System.out.println(NOT_UNIQUE_EMAIL_ERROR_MESSAGE);
					return flag = false;
				}
			}
			if (email == null) {
				System.out.println(EMPTY_EMAIL_ERROR_MESSAGE);
				return flag = false;
			}
			else {
				System.out.println(NO_ERROR_MESSAGE);
				return flag = true;
			}
		}
		return flag;
	}

	public static UserManagementService getInstance() {
		if (instance == null) {
			instance = new DefaultUserManagementService();
		}
		return instance;
	}
	
	
	@Override
	public User[] getUsers() {
		return usersArray;
	}

	@Override
	public User getUserByEmail(String userEmail) {
		User[] array = getUsers();
		for (User user : array) {
			if (user.getEmail().equals(userEmail)) {
				return user;
			}
		}
		return null;
	}
	
	void clearServiceState() {
		// <write your code here>
	}

	@Override
	public String toString() {
		return "DefaultUserManagementService{" +
				"usersArray=" + Arrays.toString(usersArray) +
				'}';
	}
}
