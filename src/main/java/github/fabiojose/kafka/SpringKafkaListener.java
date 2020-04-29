package github.fabiojose.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

/**
 * @author fabiojose
 */
@Component
public class SpringKafkaListener {

    @KafkaListener(topics = "topico")
    public void consume(@Payload String valor, Acknowledgment ack) {

        System.out.println("Valor do registro: " + valor);

        // TODO Processar valor do registro
        // ...

        // Commmit manual, que também será síncrono
        ack.acknowledge();

    }
}