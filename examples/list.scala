
trait List[T] {
    def isEmpty: Boolean
    def head: T
    def tail: List[T]
}

class Cons[T] (val head: T, val tail: List[T]) extends List[T] {
    def isEmpty = false
}

class Nil[T] extends List[T] {
    def isEmpty: Boolean = true
    def head: Nothing = throw new NoSuchElementException("Nil.head")
    def tail: Nothing = throw new NoSuchElementException("Nil.tail")
}

object List {
    // List(1, 2) = List.apply(1, 2)
    def apply[T](x1: T, x2: T): List[T] = new Cons(x1, new Cons(x2, new Nil))

    def nth[T](idx: Int, l: List[T]) {
        if (l.isEmpty) throw IndexOutOfBoundsException
        else if (idx == 0) l.head
        else nth(idx - 1, l.tail)
    }
}
