interface Visitor {

	void visitA(A a);

	void visitB(B b);

	void visitC(C c);
	
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

class C implements Visitable {
	public void do_different() {
		System.out.println("do differently");
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visitC(this);
	}
}

public class Farm {

	public static void main(String[] args) {
		A a = new A();
		B b = new B();
		C c = new C();

		Visitable truc = c;
		
		truc.accept(new Visitor() {
			
			@Override
			public void visitB(B b) {
				b.do_that();
			}
			
			@Override
			public void visitA(A a) {
				a.do_this();
			}

			@Override
			public void visitC(C c) {
				c.do_different();
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

			@Override
			public void visitC(C c) {
				throw new UnsupportedOperationException("not in C");
			}
		});
	}

}
