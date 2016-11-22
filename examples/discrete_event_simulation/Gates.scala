
class Wire {
  private var sigVal = false
  private var actions: List[Action] = List()
  def getSingal: Boolean = sigVal
  def setSignal(s: Boolean): Unit = 
    if (s != sigVal) {
      sigVal = s
      actions foreach (_())
    }
  def addAction(a: Action): Unit = {
    actions = a :: actions
    a()
  }
}

def inverter(input: Wire, output: Wire): Unit = {
  def invertAction(): Unit = {
    val inputSig = input.getSignal
    afterDelay(InverterDelay) { output setSignel !inputSig }
  }
  input addAction invertAction
}
