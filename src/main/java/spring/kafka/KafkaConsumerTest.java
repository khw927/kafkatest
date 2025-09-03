package spring.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.stereotype.Component;

/**
 * kafka 메세지 수신
 *
 * @author hyewon
 * @version 1.0
 */
@Component
public class KafkaConsumerTest {

    /**
     * 서버에 해당되는 이름의 토픽이 없으면 새로 생성
     *
     * @return New Topic 생성된 토픽
     */
    @Bean
    public NewTopic hwTopic1() {
        return TopicBuilder.name("hwTopic1")
                .partitions(10) // 10개의 파티션으로 분할
                .replicas(1) // 1개의 레플리카로 복제
                .build();
    }

    /**
     * 서버에 해당 그룹의 해당 토픽 명이 들어오면 메세지 수신
     *
     * @param message 수신할 메세지
     * @throws Exception 메세지가 빈 경우 예외 발생
     */
    @KafkaListener(topics = "hwTopic1", groupId = "hw_kafka_group")
    public void listener1(String message) throws Exception {
        System.out.println("data1 = " + message);

        if (message.isBlank()){
            throw new Exception("message is blank");
        }
    }

    @Bean
    public NewTopic hwTopic2() {
        return TopicBuilder.name("hwTopic2")
                .partitions(10) // 10개의 파티션으로 분할
                .replicas(1) // 1개의 레플리카로 복제
                .build();
    }

    @KafkaListener(topics = "hwTopic2", groupId = "hw_kafka_group")
    public void listener2(String message) throws Exception {
        System.out.println("data2 = "+message);
    }
}