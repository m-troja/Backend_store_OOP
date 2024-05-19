public class DefaultOrderManagementService implements OrderManagementService {

	private static final int DEFAULT_ORDER_CAPACITY = 10;

	private static DefaultOrderManagementService instance;

	private Order[] arrayOfOrders  = new Order[DEFAULT_ORDER_CAPACITY];;
	private Order[] ordersArrayToReturn;
	
	public static OrderManagementService getInstance() {
		if (instance == null) {
			instance = new DefaultOrderManagementService();
		}
		return instance;
	}

	@Override
	public void addOrder(Order order) {

		int i = 0;
		for( i = 0 ; arrayOfOrders.length > i; i++) {
			if (arrayOfOrders[i] == null) {
				arrayOfOrders[i] = order;
				System.out.println("DefaultOrderMgmtService arrayOfOrders[" + i + "]: " +arrayOfOrders[i]);
				break;
			}
		}

	}

	@Override
	public Order[] getOrdersByUserId(int userId) {
		int i = 0;
		 ordersArrayToReturn = new Order[DEFAULT_ORDER_CAPACITY];
		for (i = 0; i < arrayOfOrders.length; i++) {
			if (arrayOfOrders[i] != null && arrayOfOrders[i].getCustomerId() == userId) {
				ordersArrayToReturn[i] = arrayOfOrders[i];
			}
		}

		return ordersArrayToReturn;
	}

	@Override
	public Order[] getOrders() {
		// <write your code here>
		return null;
	}
	
	void clearServiceState() {
		// <write your code here>
	}

}
