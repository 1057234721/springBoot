
package cn.enjoy.mq;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
@Component
//定义该类需要监听的队列
@RabbitListener(queues = "enjoy")
public class Receiver {
    @RabbitHandler  //指定对消息的处理
    public void process(String msg) {
        System.out.println("receive msg : " + msg);
    }
}
