public class OverridingTest {
	public static void main(String[] args) {
		Car car = new Car();
		System.out.println(car.fuel());
		Bike bike = new Bike();
		System.out.println(bike.fuel());
	}
}
