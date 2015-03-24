package co.s4n.oo

import org.scalatest.FunSuite

class CashierTest extends FunSuite {

  test("Coffee shop process") {
    var client: Client = new Client("Yuji")
    var barista: Barista = new Barista("Ryan")
    var cashier: Cashier = new Cashier("Jean")

    var comanda: Comanda = cashier.createComanda("espresso", client)
    var beverage: CoffeeBeverage = barista.prepare(comanda)

    assert("Yuji" === beverage.clientName)
    assert("espresso" === beverage.name)
  }

  test("Coffee shop is now a profitable business!!!") {
    fail()
  }

}
