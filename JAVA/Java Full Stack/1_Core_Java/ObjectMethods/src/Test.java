public class Test {

	public static void main(String[] args) {

		Passenger passenger = new Passenger();
		passenger.setFirstName("Bharath");
		passenger.setLastName("Thippireddy");
		passenger.setId(123);
		
		Passenger passenger2 = new Passenger();
		passenger2.setFirstName("Bharath");
		passenger2.setLastName("Thippireddy");
		passenger2.setId(123);
		
		System.out.println(passenger.equals(passenger2));
		
		

	}

}
