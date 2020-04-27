package github.fabiojose.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

/**
 * @author fabiojose
 */
@Component
public class SpringKafkaListenter {

    @KafkaListener(topics = "topico")
    public void consume(@Payload String valor, Acknowledgment ack) {

        try {

            System.out.println("Valor do registro: " + valor);

            // Processar valor do registro

        }finally {

            // Commmit manual, que também será síncrono
            ack.acknowledge(); 
        }
    }
}