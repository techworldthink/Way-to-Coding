import my_packages.A;

@FunctionalInterface
public interface Functional_Interface extends A {

	void myMethod();
	//void getValue(); -- leads to error!

}
