package com.example.springboot;


import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.MessageEvent;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;

/**
 * Class to handle incoming events from the Wikimedia event stream
 */
@AllArgsConstructor
@Slf4j
public class WikimediaChangesHandler implements EventHandler {
    private KafkaTemplate<String,String> kafkaTemplate;
    @Value("${spring.kafka.topic.wikimedia-recent-change.name}")
    private String wikimediaRecentChangeTopicName;
    @Override
    public void onOpen() throws Exception {

    }

    @Override
    public void onClosed() throws Exception {

    }

    @Override
    public void onMessage(String s, MessageEvent messageEvent) throws Exception {
        log.info("event data: " + messageEvent.getData());

        kafkaTemplate.send(wikimediaRecentChangeTopicName, messageEvent.getData());
    }

    @Override
    public void onComment(String s) throws Exception {

    }

    @Override
    public void onError(Throwable throwable) {

    }
}
