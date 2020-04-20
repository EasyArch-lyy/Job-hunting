package akkaTest.actor

import akka.actor.{Actor, ActorSystem, Props}
import akka.event.Logging


class StringActor1 extends Actor{
  val  log=Logging(context.system,this)
  override def receive: Receive = {
    case s:String=>log.info("接受到消息:"+s)
    case _=>log.info("错误")
  }
}

object ActorTest1 {
  def main(args: Array[String]): Unit = {
      val system=ActorSystem("systemactor")
      val stringActor=system.actorOf(Props[StringActor1],name="stringactor")
      stringActor!"aaa"
    system.shutdown()
  }
}
