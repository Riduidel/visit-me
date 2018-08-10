interface Visitor {
  visitA(instance: A);
  visitB(instance: B);
}
interface Visitable {
  accept(visitor: Visitor);
}

class A implements Visitable {
  do_this() {
    console.log("A do this");
  }
  accept(visitor: Visitor) {
    visitor.visitA(this);
  }
}

class B implements Visitable {
  do_that() {
    console.log("B do that");
  }
  accept(visitor: Visitor) {
    visitor.visitB(this);
  }
}

const a = new A();
const b = new B();
const bidule: Visitable = b;

bidule.accept({
  visitA(instance) {
    instance.do_this();
  },
  visitB(instance) {
    instance.do_that();
  }
});
