interface Interface {
	void do_it();
}
class A implements Interface{
	public void do_this() {
		System.out.println("A do this");
	}

	@Override
	public void do_it() {
		do_this();
	}
	
	
}
class B implements Interface{
	public void do_that() {
		System.out.println("B do that");
	}
	
	public void do_another_thing() {
		System.out.println("Wayyy harder");
	}
	
	@Override
	public void do_it() {
		do_that();
	}
}

public class Farm {

	public static void main(String[] args) {
		A a = new A();
		B b = new B();

		Interface truc = a;
		truc.do_it();
		if (truc instanceof B) {
			B newb = (B) truc;
			newb.do_another_thing();
		} else {
			throw new UnsupportedOperationException("Ca marche pas");
		}
	}

}
