public class MACBookPro extends MACBook {

	@Override
	public void start() {
		System.out.println("Inside MacBookPros start Method");
	}

	@Override
	public void shutdown() {
		System.out.println("Inside MacBookPros shutdown Method");
	}
	
	
	public void prosmethod(){
		System.out.println("Inside MacBookPros prosmethod Method");
	}
}
