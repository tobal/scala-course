package exercises


object Exercise24 {
  def uncurry[A, B, C](f: A => B => C): (A, B) => C = (a, b) => f(a)(b)
}
