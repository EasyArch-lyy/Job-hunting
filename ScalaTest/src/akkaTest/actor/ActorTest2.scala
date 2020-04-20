package akkaTest.actor

import akka.actor.{Actor, ActorSystem, Props}
import akka.event.Logging

class StringActor2(name: String)extends Actor{
  val log=Logging(context.system,this)
  override def receive: Receive = {
    case s:String=>log.info("名字:"+name+"接受到消息："+s)
    case _=>log.info("错误")
  }
}

object ActorTest2 {
  def main(args: Array[String]): Unit = {
    val system=ActorSystem("systemactor")
    val stringActor=system.actorOf(Props(new StringActor2("xxx  ")),name = "stringactor")
    stringActor!"aaaaa"
    system.shutdown()
  }
}
