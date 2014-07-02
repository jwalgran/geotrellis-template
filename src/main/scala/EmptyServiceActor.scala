package empty

import akka.actor.Actor
import spray.routing.HttpService

class EmptyServiceActor() extends Actor with EmptyService {
  def actorRefFactory = context
  def receive = runRoute(serviceRoute)
}

trait EmptyService extends HttpService {
  implicit def executionContext = actorRefFactory.dispatcher

  val serviceRoute = {
    get {
      complete {
        "raster is faster but vector is corrector"
      }
    }
  }
}
