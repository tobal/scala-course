package recfun

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
    def pascal(c: Int, r: Int): Int = {
        if( c > r || c < 0 )
            0
        else
            if( c == 0 || c == r )
                1
            else
                pascal(c - 1, r - 1) + pascal(c, r - 1)
    }

  /**
   * Exercise 2
   */
    def balance(chars: List[Char]): Boolean = {
        def func(chars: List[Char], deviance: Int): Boolean = {
            if(chars.isEmpty)
                if(deviance == 0)
                    return true
                else
                    return false
            if(chars.head == '(')
                func(chars.tail, deviance + 1)
            else
                if(chars.head == ')')
                {
                    if(deviance == 0)
                        return false
                    func(chars.tail, deviance - 1)
                }
                else
                    func(chars.tail, deviance)
        }
        func(chars, 0)
    }
  
  /**
   * Exercise 3
   */
    def countChange(money: Int, coins: List[Int]): Int = {
        if(money == 0)
            return 1
        else
            if(coins.isEmpty || money < 0)
                return 0
            else
                countChange(money - coins.head, coins) + countChange(money, coins.tail)
    }
  }
