import java.util.Arrays;

public class DefaultCart implements Cart {
	private Product[] cart;

	public DefaultCart() {
		this.cart =  new Product[10];

	}

	
	@Override
	public boolean isEmpty() {
		return this.cart[0] == null;

	}

	@Override
	public void addProduct(Product product) {
		//find not-null place and put product there
		int i;
		for (i = 0; i< cart.length;  i++){
			if (cart[i] == null) {
				cart[i] = product;
				System.out.println("Default Cart product added: " + cart[i].toString());
				System.out.println("Default Cart full cart: " + Arrays.toString(cart));
				break;
			}
		}
	}

	@Override
	public Product[] getProducts() {
		System.out.println("Default Cart show cart: " + Arrays.toString(cart));
		Product[] products = new Product[10];
		this.cart = cart;
		int i;

		for (i = 0; i< cart.length && i<products.length;  i++) {
			if (cart[i] != null) {
				products[i] = cart[i];
				System.out.println("Default Cart product getted: " + cart[i].toString());

			} else break;

		}
		System.out.println("Default Cart full getted: " + Arrays.toString(cart));
		return products;
	}

	@Override
	public void clear() {
		for (Product p : cart) {
			p = null;
		}
	}

	@Override
	public String toString() {
		this.cart = cart;
		return "DefaultCart{" +
				"cart=" + Arrays.toString(cart) +
				'}';
	}
}
