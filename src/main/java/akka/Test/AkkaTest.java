package akka.Test;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import com.typesafe.config.ConfigFactory;

/**
 * @author lyy
 */
public class AkkaTest {
    public static void main(String[] args) {
        ActorSystem system=ActorSystem.create("hello", ConfigFactory.load("sample.conf"));
        ActorRef actorRef=system.actorOf(Props.create(HelloWorld.class),"helloworld");
        System.out.println("HelloWorld actor path:"+actorRef.path());
    }
}
