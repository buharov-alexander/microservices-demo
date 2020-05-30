package ru.buharov.microservices.producer.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import ru.buharov.microservices.common.dto.JokeDTO;

@Slf4j
@Component
public class MessageProducer {

    @Value("${kafka.topic.name}")
    private String kafkaTopicName;
    private KafkaTemplate<String, JokeDTO> kafkaTemplate;

    public MessageProducer(KafkaTemplate<String, JokeDTO> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(JokeDTO joke) {
        ListenableFuture<SendResult<String, JokeDTO>> future = kafkaTemplate.send(kafkaTopicName, joke);

        future.addCallback(new ListenableFutureCallback<SendResult<String, JokeDTO>>() {
            @Override
            public void onFailure(Throwable throwable) {
                log.error("Unable to send message = {} dut to: {}", joke, throwable.getMessage());
            }

            @Override
            public void onSuccess(SendResult<String, JokeDTO> stringDataSendResult) {
                log.info("Sent Message = {} with offset = {}", joke, stringDataSendResult.getRecordMetadata().offset());
            }
        });
    }
}
