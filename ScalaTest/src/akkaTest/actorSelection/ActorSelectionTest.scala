package akkaTest.actorSelection

import akka.actor.{Actor, ActorLogging, ActorRef, ActorSystem, Props}

class FirstActor extends Actor with ActorLogging{
  //通过context.actorOf创建Actor
  var child:ActorRef=_
  override def preStart():Unit = {
    log.info("FirstActor preStart")
    //通过context上下文创建Actor
    child=context.actorOf(Props[MyActor],name = "myActor")
  }
  def receive={
    //向MyActor发送消息
    case x=>{
      child ! x
      log.info("FirstActor received "+x)
    }
  }
}
class MyActor extends Actor with ActorLogging{
  var parentActorRef:ActorRef=_

  override def preStart(): Unit = {
    //通过context.parent获取父Actor的ActorRef
    parentActorRef=context.parent
  }
  def receive: PartialFunction[Any,Unit] ={
    case "test"=>{
      log.info("MyActor received test")
      parentActorRef!"aaaaa"
    }
    case  _  =>log.info("错误")
  }
}
object ActorSelectionTest {
  def main(args: Array[String]): Unit = {
    val system = ActorSystem("ActorSelectionTest")
    val systemLog=system.log
    //创建FirstActor对象
    val myActor = system.actorOf(Props[FirstActor],name ="firstActor" )
    //获取ActorPath
    val myActorPath=system.child("firstActor")
    //通过system.actorSelection方法获取ActorRef
    val myActor1=system.actorSelection("akka://ActorSelectionTest/user/firstActor")
    //向myActor1发送消息
    myActor1!"test"
    Thread.sleep(5000)
    system.shutdown()
  }
}
