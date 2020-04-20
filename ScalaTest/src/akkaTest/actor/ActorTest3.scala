package akkaTest.actor

import akka.actor.{Actor, ActorSystem, Props}
import akka.event.Logging

class StringActor3(name:String)extends Actor{
  val log=Logging(context.system,this)
  override def receive: Receive = {
    case s:String=>log.info("名字:"+name+"接受到消息:"+s)
    case _=>log.info("错误")
  }
}
class ContextActor extends Actor{
  val log=Logging(context.system,this)
  val stringActor=context.actorOf(Props(new StringActor3("xxx")),name="stringactor")
  override def receive: Receive ={
    case s:String=>{
      log.info("contextActor 接受到消息: "+s)
      stringActor!"bbbbb"
    }
    case _=>log.info("错误")
  }
}
object ActorTest3 {
  def main(args: Array[String]): Unit = {
    val system=ActorSystem("systemactor")
    val contextActor=system.actorOf(Props[ContextActor],name="contextactor")
    contextActor!"aaaaa"
    system.shutdown()
  }
}
