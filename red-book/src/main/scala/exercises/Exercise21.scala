package exercises


object Exercise21 {
  def fib(n: Int): Int = {
    @annotation.tailrec
    def rec(counter: Int, previous: Int, current: Int): Int = {
      if (counter <= 0) {
        previous
      } else {
        rec(counter - 1, current, previous + current)
      }
    }
    rec(n, 0, 1)
  }
}
