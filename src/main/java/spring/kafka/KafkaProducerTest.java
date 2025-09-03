package spring.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

/**
 * kafka 메세지 송신
 *
 * @author hyewon
 * @version 1.0
 */
@Component
public class KafkaProducerTest {

    /** kafka template 객체 선언 */
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    /**
     * 토픽 메세지 전송
     *
     * @param topic 토픽 명
     * @param message 전달할 메세지
     */
    public void sendMessage(String topic, String message) {
        System.out.println("토픽 이름 : " + topic + ", 메시지 : " + message);
        kafkaTemplate.send(topic, message);
    }
}