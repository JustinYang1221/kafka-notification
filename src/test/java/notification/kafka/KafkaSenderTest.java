package notification.kafka;

import com.NotificationApplication;
import com.notification.kafka.impl.KafkaSender;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * @author: justin
 * @date: 2022/9/5
 */

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = NotificationApplication.class)
public class KafkaSenderTest {

    @Autowired
    KafkaSender kafkaSender;

    @Test
    public void sendTest() throws InterruptedException {
        for(int i=0;i< 10; i++){

            kafkaSender.send("send test "+ i);
            System.out.println("Send out message "+ i);
            Thread.sleep(1000);
        }

        Thread.sleep(3000);
    }
}
