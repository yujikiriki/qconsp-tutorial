package co.s4n.oo

class Client(var name: String)

class Barista(name: String) {
  import EsspresoMachine._

  def prepare(comanda: Comanda): CoffeeBeverage =
    extract(comanda)

}

class CoffeeBeverage(var name: String, var clientName: String)

class Cashier(name: String) {

  def createComanda(menuItem: String, client: Client): Comanda = {
    client.name = "Magical dwarf in Production"
    Comanda(menuItem, client)
  }

}

object EsspresoMachine {
  def extract(c: Comanda): CoffeeBeverage =
    new CoffeeBeverage(c.preparation, c.client.name)
}

class Comanda(var number: String, var preparation: String, var client: Client)

object Comanda {
  import scala.util.Random

  /* Factory method implementation FTW */
  def apply(menuItem: String, client: Client): Comanda =
    new Comanda(
      number = Random.nextInt().toString,
      preparation = menuItem,
      client = client)

}
