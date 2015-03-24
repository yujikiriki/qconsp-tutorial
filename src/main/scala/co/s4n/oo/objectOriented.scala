package co.s4n.oo

class Barista(name: String) {

  import EsspresoMachine._

  def prepare(comanda: Comanda): CoffeeBeverage =
    extract(comanda)

}

object EsspresoMachine {
  def extract(c: Comanda): CoffeeBeverage =
    new CoffeeBeverage(c.preparation, c.client.name)
}

class CoffeeBeverage(var name: String, var clientName: String)

class Cashier(name: String) {

  def createComanda(menuItem: String, client: Client): Comanda =
    Comanda(menuItem, client)

}

class Client(var name: String)

class Comanda(var number: String, var preparation: String, var client: Client)

object Comanda {
  import scala.util.Random

  def apply(menuItem: String, client: Client): Comanda =
    new Comanda(
      number = Random.nextInt().toString,
      preparation = menuItem,
      client = client)

}
