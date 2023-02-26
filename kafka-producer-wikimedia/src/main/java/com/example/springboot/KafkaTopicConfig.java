package com.example.springboot;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

/**
 * Class to store all Kafka Topic beans
 */
@Configuration
public class KafkaTopicConfig {
    @Value("${spring.kafka.topic.wikimedia-recent-change.name}")
    private String wikimediaRecentChangeTopicName;

    @Bean
    public NewTopic wikimediaRecentChangeTopic() {
        return TopicBuilder
                .name(wikimediaRecentChangeTopicName)
                .build();
    }
}
