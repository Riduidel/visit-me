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
	}

}
