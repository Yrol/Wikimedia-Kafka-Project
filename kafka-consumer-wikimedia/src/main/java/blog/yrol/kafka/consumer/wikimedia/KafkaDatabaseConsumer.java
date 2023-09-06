package blog.yrol.kafka.consumer.wikimedia;

import blog.yrol.kafka.consumer.wikimedia.entity.WikimediaData;
import blog.yrol.kafka.consumer.wikimedia.repository.WikimediaDataRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaDatabaseConsumer {

    public static final Logger LOG = LoggerFactory.getLogger(KafkaDatabaseConsumer.class);

    private WikimediaDataRepo wikimediaDataRepo;

    public KafkaDatabaseConsumer(WikimediaDataRepo wikimediaDataRepo) {
        this.wikimediaDataRepo = wikimediaDataRepo;
    }

    @KafkaListener(topics = "wikimedia_recentchange",  groupId = "my-group-id")
    public void consume(String eventMassage) {
        LOG.info(String.format("Event message received -> %s", eventMassage));

        WikimediaData wikimediaData =  new WikimediaData();
        wikimediaData.setWikiEventData(eventMassage);

        wikimediaDataRepo.save(wikimediaData);
    }
}
