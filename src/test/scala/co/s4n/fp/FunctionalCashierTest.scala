package co.s4n.fp

import org.scalatest.FunSuite

class FunctionalCashierTest extends FunSuite {

  test("Coffee preparation process") {
    val client: Client = Client("Yuji")
    val barista: Barista = Barista("Ryan")

    val comanda: Option[Comanda] = Cashier.createComanda("espresso", client)

    val beverage: Option[CoffeeBeverage] = comanda.map {
      c => barista.prepare(c)
    }

    beverage match {
      case Some(b) =>
        assert("Yuji" === b.clientName)
        assert("espresso" === b.name)
      case None => fail()
    }

  }

  test("Coffee shop is now a profitable business!!!") {
    fail()
  }

}
