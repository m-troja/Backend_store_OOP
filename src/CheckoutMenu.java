
import java.util.Scanner;


public class CheckoutMenu implements Menu {

	private ApplicationContext context;
	private OrderManagementService orderManagementService;

	Menu menuToNavigate;
	{
		context = ApplicationContext.getInstance();
		orderManagementService = DefaultOrderManagementService.getInstance();
	}
	
	@Override
	public void start() {
		while (true) {
			printMenuHeader();
			Scanner sc = new Scanner(System.in);
			String userInput = sc.next();


			if (!createOrder(userInput)) {
				continue;
			}
			context.getSessionCart().clear();
			break;
		}
		
		System.out.println("Thanks a lot for your purchase. Details about order delivery are sent to your email.");
		menuToNavigate = new MainMenu();
		menuToNavigate.start();
	}
	
	private boolean createOrder(String creditCardNumber) {
		Order order = new DefaultOrder();

		//verify card no is  16 digits longs
		if (!order.isCreditCardNumberValid(creditCardNumber)) {
			while (!order.isCreditCardNumberValid(creditCardNumber)) {
				System.out.println("You entered invalid credit card number. Valid credit card should contain 16 digits. Please, try one more time.");
				Scanner sc = new Scanner(System.in);
				String userInput = sc.next();
				if (order.isCreditCardNumberValid(userInput)) {
					break;
				}
			}
		}

		//add card no to the order
		order.setCreditCardNumber(creditCardNumber);

		order.setProducts(context.getSessionCart().getProducts());
		System.out.println("Checkout menu: " + order.toString());
		order.setCustomerId(context.getLoggedInUser().getId());
		orderManagementService.addOrder(order);
		return true;
	}

	@Override
	public void printMenuHeader() {
		System.out.println("***** CHECKOUT *****");
		System.out.print(
				"Enter your credit card number without spaces and press enter if you confirm purchase: ");
	}

}
