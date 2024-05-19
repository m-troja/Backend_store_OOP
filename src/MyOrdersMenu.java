import java.util.Arrays;

public class MyOrdersMenu implements Menu {

	private ApplicationContext context;
	private OrderManagementService orderManagementService;
	Menu menuToNavigate;

	{
		context = ApplicationContext.getInstance();
		orderManagementService = DefaultOrderManagementService.getInstance();
	}

	@Override
	public void start() {
		checkIfNoOrders();
		printMenuHeader();
		printOrders();


	}

	private void checkIfNoOrders() {
		int userID = context.getLoggedInUser().getId();
		Order[] ordersArray = orderManagementService.getOrdersByUserId(userID);
		if (ordersArray[0] == null) {
			System.out.println("Unfortunately, you don’t have any orders yet. Navigate back to\n" +
					"main menu to place a new order");
			menuToNavigate = new MainMenu();
			menuToNavigate.start();
		}
	}

	private void printOrders() {
		int userID = context.getLoggedInUser().getId();
		Order[] ordersArray = orderManagementService.getOrdersByUserId(userID);
		for (Order o : ordersArray) {

			if (o != null) {
				System.out.println(o);
			}
		}

	}

	@Override
	public void printMenuHeader() {
		System.out.println("*** LIST OF ORDERS ***");
	}

}
