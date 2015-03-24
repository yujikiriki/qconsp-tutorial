package co.s4n.akka

case class Order( menuItem: String, client: ClientInfo )

case class ClientInfo(name: String)

case class CoffeeBeverage(var name: String, var clientName: String)

case class Comanda(number: String, preparation: String, client: ClientInfo)

object Comanda {
  import scala.util.Random

  /* Factory method implementation FTW */
  def apply(menuItem: String, client: ClientInfo): Comanda =
    new Comanda(
      number = Random.nextInt().toString,
      preparation = menuItem,
      client = client)

}

sealed trait CoffePreparationState
case object CashierHadProblems extends CoffePreparationState
case object BaristaHadProblems extends CoffePreparationState