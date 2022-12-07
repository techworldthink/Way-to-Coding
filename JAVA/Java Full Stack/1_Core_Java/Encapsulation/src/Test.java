public class Test {

	public static void main(String[] args) {

		Customer c = new Customer();
		c.setFirstName(null);
		c.setLastName("Thippireddy");
		c.setCreditCard("12345");

		System.out.println("First Name:" + c.getFirstName());
		System.out.println("Last Name:" + c.getLastName());
		System.out.println("Credit Card:" + c.getCreditCard());
	}

}
