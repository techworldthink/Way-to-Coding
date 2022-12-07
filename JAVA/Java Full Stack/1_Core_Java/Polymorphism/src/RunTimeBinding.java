public class RunTimeBinding {

	public static void main(String[] args) {

		AppleLaptop m1 = new MACBookPro();
		AppleLaptop m2 = new MACBookAir();

		m1.start();
		m1.shutdown();
		
		MACBookPro m3 =  (MACBookPro) m1;
		m3.prosmethod();

		m2.start();
		m2.shutdown();
		
		MACBookAir m4 = (MACBookAir) m2;

	}

}
