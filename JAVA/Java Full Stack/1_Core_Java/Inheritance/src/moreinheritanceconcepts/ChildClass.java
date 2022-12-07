package moreinheritanceconcepts;

public class ChildClass extends SuperClass {
	
	ChildClass(){
		this(10);
		System.out.println("No Arg ChildClass Constructor");
	}
	
	ChildClass(int x){
		super(x);
		System.out.println("Arg ChildClass Constructor");
		
	}
	
	public static void main(String[] args) {
		ChildClass c = new ChildClass();
	}

}
