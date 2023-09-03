package blog.yrol.kafka.consumer.wikimedia;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaDatabaseConsumer {

    public static final Logger LOG = LoggerFactory.getLogger(KafkaDatabaseConsumer.class);

    @KafkaListener(topics = "wikimedia_recentchange",  groupId = "my-group-id")
    public void consume(String eventMassage) {
        LOG.info(String.format("Event message received -> %s", eventMassage));
    }
}
