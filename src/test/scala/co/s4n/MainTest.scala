package co.s4n

import org.scalatest.FunSuite

class MainTest extends FunSuite {

  test("Hello world!") {
    info("Testing the Hello world!")
    assert(Main.firstFunction() === "Hello world!")
  }
}
