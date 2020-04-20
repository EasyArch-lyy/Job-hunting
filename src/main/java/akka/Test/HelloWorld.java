package akka.Test;

import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.UntypedActor;

/**
 * @author lyy
 */
public class HelloWorld extends UntypedActor {

    ActorRef greeter;

    /**
     * AKKA回调方法,在Actor启动前调用,完成初始化工作
     */
    @Override
    public void preStart(){
        //创建Greeter实例
        greeter=getContext().actorOf(Props.create(Greeter.class),"greeter");
        System.out.println("Greeter Actor path:"+greeter.path());
        //向Greeter发送消息GREET
        greeter.tell(Greeter.Msg.GREET,getSelf());
    }
    /**
     * 消息处理方法
     */
    @Override
    public void onReceive(Object msg) throws Throwable, Throwable {
        if(msg==Greeter.Msg.DONE){
            //在收到DONE消息后,再向Greeter发送GREET
            greeter.tell(Greeter.Msg.GREET,getSelf());
            //停止自身
            getContext().stop(getSelf());
        }else {
            unhandled(msg);
        }
    }
}
