package exercises


object Exercise23 {
  def curry[A, B, C](f: (A, B) => C): A => (B => C) = a => b => f(a, b)
}

