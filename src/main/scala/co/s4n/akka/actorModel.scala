package co.s4n.akka

import akka.actor.{Actor, ActorSelection}
import akka.pattern._

import scala.concurrent.{ExecutionContext, Future}

class Client extends Actor {

  override def receive: Actor.Receive = {
    case order: Order =>
      val cashier: ActorSelection = context.actorSelection( "akka://ActorModelTest/user/Cashier" )
      cashier ! order
    case cb: CoffeeBeverage =>
      println( s"I'm a happy customer!!! I received a ${cb}" )
    case CashierHadProblems =>
      println( s"I'm a under caffeinated..." )
  }
}

class Barista extends Actor {
  import EsspresoMachine._

  override def receive: Receive = {
    case comanda: Comanda =>
      val beverage: CoffeeBeverage = extract(comanda)
      sender() ! beverage
  }
}

class Cashier extends Actor {
  import scala.concurrent.duration._
  import Cashier._

  private implicit val _: ExecutionContext = context.dispatcher

  override def receive: Actor.Receive = {
    case order: Order =>
      val originalSender = sender()

      val comanda: Option[Comanda] = createComanda( menuItem = order.menuItem, client = order.client )

      comanda match {
        case Some( c ) =>
          val baristaRef: ActorSelection = context.actorSelection( "akka://ActorModelTest/user/Barista" )
          // Ask pattern
          val futureBeverage: Future[Any] = ( baristaRef ? c )( 5.seconds ).mapTo[CoffeeBeverage]
          // Pipe future pattern
          pipe( futureBeverage ) to originalSender
          ()
        case None =>
          originalSender ! CashierHadProblems
      }

  }
}

object Cashier {
  def createComanda(menuItem: String, client: ClientInfo): Option[Comanda] = {
    Some(Comanda(menuItem, client))
  }
}

object EsspresoMachine {
  def extract(c: Comanda): CoffeeBeverage = new CoffeeBeverage(c.preparation, c.client.name)
}
