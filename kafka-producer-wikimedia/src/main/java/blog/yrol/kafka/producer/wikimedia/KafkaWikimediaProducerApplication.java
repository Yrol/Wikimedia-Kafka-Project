package blog.yrol.kafka.producer.wikimedia;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = "blog.yrol")
public class KafkaWikimediaProducerApplication implements CommandLineRunner {

    public static final Logger LOG = LoggerFactory.getLogger(KafkaWikimediaProducerApplication.class);

    @Autowired
    private WikimediaChangesProducer wikimediaChangesProducer;

    public static void main(String[] args) {
        SpringApplication.run(KafkaWikimediaProducerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        LOG.info("Producer app started");
        wikimediaChangesProducer.sendMessage();
    }
}
