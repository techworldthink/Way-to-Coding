package generics;

public class MyGenericClass<T> {
	T obj;

	public MyGenericClass(T obj) {
		this.obj = obj;
	}

	public void displayObjectiveDetails() {
		System.out.println("The type of object: " + obj.getClass().getName());
	}

	public T getObject() {
		return obj;
	}

}
