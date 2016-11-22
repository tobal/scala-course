
trait Simulation {
  def currentTime = ???
  def afterDelay(delay: Int)(block: => Unit): Unit = ???
  def run(): Unit = ???
}
