package co.s4n.akka

import akka.actor.{Props, ActorSystem}
import org.scalatest.{BeforeAndAfter, FunSuite}

class ActorModelTest extends FunSuite with BeforeAndAfter {

  test( "Coffee shop is a concurrency success" ) {
    val system = ActorSystem( "ActorModelTest" )

    val barista = system.actorOf( Props[Barista], name = "Barista" )
    val cashier = system.actorOf( Props[Cashier], name = "Cashier" )
    val client = system.actorOf( Props[Client], name = "Client" )
    client ! Order( "espresso", ClientInfo( "Yuji" ) )
    Thread.sleep( 1000 )

    system.shutdown()
  }
}
