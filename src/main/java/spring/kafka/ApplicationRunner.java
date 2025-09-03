package spring.kafka;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author hyewon
 * @version 1.0
 */
@Component
public class ApplicationRunner implements CommandLineRunner {

    // 메시지 전송 담당 서비스
    private final KafkaProducerTest producerService;

    // 생성자
    public ApplicationRunner(KafkaProducerTest producerService) {
        this.producerService = producerService;
    }

    /**
     * 애플리케이션 시작 시 실행
     * 설정값 확인 및 테스트 메시지 전송
     * @param args 커맨드 라인 인자
     * @throws Exception
     */
    @Override
    public void run(String... args) throws Exception {

        // 테스트 메시지 전송
        producerService.sendMessage("hwTopic1", "kafka hi");
        producerService.sendMessage("hwTopic2", "kafka bye");
    }
}

