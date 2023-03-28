package com.xl.springbootxl.configs.kafka;

import lombok.extern.java.Log;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Log
public class KafkaConsumer {

    //不指定group，默认取yml里配置的
    @KafkaListener(topics = {"kafka01"})
    public void onMessage1(ConsumerRecord<?, ?> consumerRecord) {
        Optional<?> optional = Optional.ofNullable(consumerRecord.value());
        if (optional.isPresent()) {
            Object msg = optional.get();
            log.info("message:{}"+msg);
        }
    }
}
