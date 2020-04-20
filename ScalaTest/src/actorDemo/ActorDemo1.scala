package actorDemo

import akka.actor.Actor
/**
 * 功能点：
 * 1继承Actor类 2重写act方法
 * 发送字符串
 */
class ActorDemo extends Actor{
  override def act =
  {
    while (true) {
      receive {
        case name: String => println("hello, " + name)
        case money: Int => println("how much " + money)

      }
    }
  }

  override def receive: Receive = ???
}
object ActorDemo1 {
  def main(args: Array[String]): Unit = {
    //创建继承actor的对象
    val helloActor=new ActorDemo
    //启动akka
    helloActor.start()
    helloActor ! "tom"
  }
}
