package blog.yrol.kafka.consumer.wikimedia;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "blog.yrol")
public class KafkaWikimediaConsumerApplication implements CommandLineRunner {

    public static final Logger LOG = LoggerFactory.getLogger(KafkaWikimediaConsumerApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(KafkaWikimediaConsumerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        LOG.info("Consumer app started");
    }
}