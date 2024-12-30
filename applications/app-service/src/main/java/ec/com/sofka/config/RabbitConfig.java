package ec.com.sofka.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    @Value("${amqp.exchange.default}")
    public String EXCHANGE_NAME;
    @Value("${amqp.queue.default}")
    public  String QUEUE_NAME ;
    @Value("${amqp.routing.key.default}")
    public  String ROUTING_KEY;

    @Bean
    public DirectExchange exchange(){
        return new DirectExchange(EXCHANGE_NAME);
    }

    @Bean
    public Queue queue() {
        return new Queue(QUEUE_NAME, true);
    }

    @Bean
    public Binding binding(Queue queue, DirectExchange exchange){
        return  BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY);
    }

}
