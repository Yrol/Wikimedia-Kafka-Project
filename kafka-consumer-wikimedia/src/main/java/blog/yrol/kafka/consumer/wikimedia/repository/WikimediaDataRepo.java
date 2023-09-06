package blog.yrol.kafka.consumer.wikimedia.repository;

import blog.yrol.kafka.consumer.wikimedia.entity.WikimediaData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WikimediaDataRepo extends JpaRepository<WikimediaData, Long> {
}
