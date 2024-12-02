package com.judomanager.chat.config.kafka;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerializer;

import com.judomanager.chat.adapter.port.in.request.ChatDto;

@EnableKafka
@Configuration
public class KafkaConfig {

	private static final String GROUP_ID = "chat-group";
	private static final String KAFKA_SERVER = "http://localhost:9092";

	@Bean
	public ProducerFactory<String, ChatDto> msgProducerFactory() {
		Map<String, Object> config = new HashMap<>();
		config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, KAFKA_SERVER);
		config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
		return new DefaultKafkaProducerFactory<>(config);
	}

	@Bean
	public KafkaTemplate<String, ChatDto> msgKafkaTemplate() {
		return new KafkaTemplate<String, ChatDto>(msgProducerFactory());
	}

	@Bean
	public ConsumerFactory<String, ChatDto> consumerFactory() {
		Map<String, Object> props = new HashMap<>();
		props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, KAFKA_SERVER);
		props.put(ConsumerConfig.GROUP_ID_CONFIG, GROUP_ID);
		return new DefaultKafkaConsumerFactory<>(props, new StringDeserializer(),
			new JsonDeserializer<>(ChatDto.class, false));
	}

	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, ChatDto> kafkaListenerContainerFactory() {
		ConcurrentKafkaListenerContainerFactory<String, ChatDto> factory = new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(consumerFactory());
		return factory;
	}

}
