interface Visitor {

	void visitA(A a);

	void visitB(B b);
	
}
interface Visitable {
	void accept(Visitor visitor);
}
class A implements Visitable{
	public void do_this() {
		System.out.println("A do this");
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visitA(this);
	}
	
}
class B implements Visitable{
	public void do_that() {
		System.out.println("B do that");
	}
	
	public void do_another_thing() {
		System.out.println("Wayyy harder");
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visitB(this);
	}
}

public class Farm {

	public static void main(String[] args) {
		A a = new A();
		B b = new B();

		Visitable truc = b;
		
		truc.accept(new Visitor() {
			
			@Override
			public void visitB(B b) {
				b.do_that();
			}
			
			@Override
			public void visitA(A a) {
				a.do_this();
			}
		});
		
		truc.accept(new Visitor() {
			
			@Override
			public void visitB(B b) {
				b.do_another_thing();
			}
			
			@Override
			public void visitA(A a) {
				throw new UnsupportedOperationException("not in A");
			}
		});
	}

}
