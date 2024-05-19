import java.util.Scanner;

public class ProductCatalogMenu implements Menu {

	private static final String CHECKOUT_COMMAND = "checkout";
	private ApplicationContext context;
	Product[] products;
	private Menu menuToNavigate = null;
	private ProductManagementService productManagementService;


	{
		context = ApplicationContext.getInstance();
		productManagementService = DefaultProductManagementService.getInstance();
	}

	@Override
	public void start() {
		printProducts();
		printMenuHeader();
		selectProduct();
	}
	int counterCartItems = 0;
	private void selectProduct() {
		Cart cart = new DefaultCart();
		Product product = null;
		Scanner sc = new Scanner(System.in);

		//select items and create a cart
		while (true) {

			System.out.print("User input: ");
			String userInput = sc.next();

			 if (userInput.equals(CHECKOUT_COMMAND) && (counterCartItems == 0)) {
				System.out.println("‘Your cart is empty. Please, add product to cart first and then proceed with checkout");
				start();
			 }
			 else if (userInput.equals("menu")) {
				menuToNavigate = new MainMenu();
				menuToNavigate.start();
			}
			else if (userInput.equals(CHECKOUT_COMMAND) && (counterCartItems > 0) && (context.getLoggedInUser() != null)) {
				menuToNavigate = new CheckoutMenu();
				menuToNavigate.start();
			}
			int userInputInt = Integer.valueOf(userInput);
			if (userInputInt >= 1 && userInputInt <= 10) {
				if (context.getLoggedInUser() == null) {
					System.out.println("You are not logged in. Please, sign in or create new account");
					menuToNavigate = new MainMenu();
					menuToNavigate.start();
				}
				product = productManagementService.getProductById(userInputInt);
				cart.addProduct(product);
				context.setSessionCart(cart);
				System.out.println("Product " + product.getProductName() + " has been added to your cart. If you want to add a new product - enter the product id. If you want to proceed with checkout - enter word ‘checkout’ to console");
				counterCartItems++;
			}
			else {
				System.out.println("Please, enter product ID if you want to add product to cart. Or enter ‘checkout’ if you want to proceed with checkout. Or enter ‘menu’ if you want to navigate back to the main menu.");
				printProducts();
			}
		}
	}

	@Override
	public void printMenuHeader() {
		System.out.println("Enter product id to add it to the cart or ‘menu’ if you want to navigate back to the main menu");
	}

	public void printProducts() {
		Product[] products = productManagementService.getProducts();
		for ( Product product : products) {
			System.out.println(product);
		}
	}
}
