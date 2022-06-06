import generics.MyGenericClass;

public class GenericClassDemo {

	public static void main(String[] args) {
		MyGenericClass<String> s = new MyGenericClass<String>("abc");
		s.displayObjectiveDetails();
		System.out.println(s.getObject());
		
		MyGenericClass<Integer> i = new MyGenericClass<Integer>(123);
		i.displayObjectiveDetails();
		System.out.println(i.getObject());

	}

}
