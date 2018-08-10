package main

import (
	"fmt"
	"os"
)

type Visitor interface {
	visitA(a A) error
	visitB(b B) error
}

type Visitable interface {
	accept(v Visitor)
}

type A struct { // implements Visitable
}

func (a A) doThis() {
	fmt.Println("doThis")
}
func (a A) accept(v Visitor) {
	v.visitA(a)
}

type B struct { // implements Visitable
}

func (b B) doThat() {
	fmt.Println("doThat")
}
func (b B) doAnotherThing() {
	fmt.Println("doAnotherThing")
}
func (b B) accept(v Visitor) {
	v.visitB(b)
}

func main() {
	err := function()
	if err != nil {
		fmt.Fprintf(os.Stderr, "error: %v\n", err)
		os.Exit(-1)
	}
}

func function() error {
	var v Visitable = B{}

	// <== Galére sur l'étape 3, pas possible de faire une classe anonyme new Visitor{} pour implementer les méthodes du Visitor
	v.accept(Visitor1{})

	// o.doIt()
	// if implementation, ok := o.(B); ok { // <=== Petit galère sur l'étape 2, le instanceof est carrément pas intuitif
	// 	implementation.doAnotherThing()
	// } else {
	// 	return errors.New("Not Implemented")
	// }
	return nil
}

type Visitor1 struct {
}

func (v Visitor1) visitA(a A) error {
	a.doThis()
	return nil
}
func (v Visitor1) visitB(b B) error {
	b.doThat()
	return nil
}
