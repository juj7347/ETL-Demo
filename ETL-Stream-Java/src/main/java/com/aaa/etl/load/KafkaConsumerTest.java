package com.aaa.etl.load;

import java.time.Duration;
import java.util.Collections;
import java.util.Iterator;
import java.util.Properties;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

public class KafkaConsumerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Properties kafkaConsProperties = new Properties();
		//환경변수 설정
		kafkaConsProperties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		kafkaConsProperties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		kafkaConsProperties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		kafkaConsProperties.put(ConsumerConfig.GROUP_ID_CONFIG, "test-group");
		kafkaConsProperties.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
		
		Consumer<String, String> consumer = new KafkaConsumer<String, String>(kafkaConsProperties);
		
		//topic 값 중 하나 선택
		consumer.subscribe(Collections.singletonList("topic_unempl_ann"));
		
		String message = null;
		try {
			while (true) {
				ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(100));
				
				for (ConsumerRecord<String, String> record : records) {
					message = record.value();
					System.out.println(message);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			consumer.close();
		}
	}

}
