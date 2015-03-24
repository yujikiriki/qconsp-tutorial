package co.s4n.fp

case class Client(name: String)

case class CoffeeBeverage(var name: String, var clientName: String)

case class Barista(name: String) {
  import EsspresoMachine._

  def prepare(comanda: Comanda): CoffeeBeverage = extract(comanda)

}
case class Comanda(number: String, preparation: String, client: Client)

object Comanda {
  import scala.util.Random

  /* Factory method implementation FTW */
  def apply(menuItem: String, client: Client): Comanda =
    new Comanda(
      number = Random.nextInt().toString,
      preparation = menuItem,
      client = client)

}

object EsspresoMachine {
  def extract(c: Comanda): CoffeeBeverage = new CoffeeBeverage(c.preparation, c.client.name)
}

trait Cashier {
  def createComanda(menuItem: String, client: Client): Option[Comanda] = {
    // client.name = "Magical dwarf in Production"
    Some(Comanda(menuItem, client)) // None
  }
}

object Cashier extends Cashier
