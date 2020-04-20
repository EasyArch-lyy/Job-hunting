package akka.Test;

import akka.actor.UntypedActor;

/**
 * @author lyy
 */
public class Greeter extends UntypedActor {
    enum Msg{GREET,DONE;}
    @Override
    public void onReceive(Object msg) throws Throwable, Throwable {
        if(msg==Msg.GREET){
            System.out.println("Hello world");
            //向消息发送方发送DONE消息
            getSender().tell(Msg.DONE,getSelf());
        }
    }
}
