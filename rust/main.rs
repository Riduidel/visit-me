trait Visitor {
     fn visitA(&self, a:&A);
     fn visitB(&self, b:&B);
}
trait Visitable {
     fn accept(&self, visitor:&Visitor);
}

struct A {}
impl A {
     fn do_this(&self) {
        println!("do this in A");
    }
}

impl Visitable for A {
     fn accept(&self, visitor:&Visitor) {
        visitor.visitA(self);
    }
}

struct B {}
impl B {
     fn do_that(&self) {
        println!("do that in B");
    }
}

impl Visitable for B {
     fn accept(&self, visitor:&Visitor) {
        visitor.visitB(self);
    }
}

struct DoWhatYouCan {}
impl Visitor for DoWhatYouCan {
     fn visitA(&self, a:&A) {
        a.do_this();
    }
     fn visitB(&self, b:&B) {
        b.do_that();
    }

}

fn main() {
    let a = A{};
    let b = B{};

    a.accept(&DoWhatYouCan{});
}