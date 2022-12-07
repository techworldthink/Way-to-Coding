package my_packages;

public interface C {
	default void m1() {
		System.out.println("m1 inside C");
	}
}
