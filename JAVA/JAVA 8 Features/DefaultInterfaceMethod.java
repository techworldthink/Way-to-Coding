
public class DefaultInterfaceMethod implements my_packages.C {

	public void m1() {
		System.out.println("m1 inside main file");
	}
	
	public static void main(String[] args) {
		
		DefaultInterfaceMethod obj = new DefaultInterfaceMethod();
		obj.m1();
	}

}
