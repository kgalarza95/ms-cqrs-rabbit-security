package ec.com.sofka.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//2. Create class to configure RabbitMQ here in app layer: To generate beans
@Configuration
public class RabbitConfig {

    //3. Configurations: Environment variables - Names must follow a pattern like this
    // Each queue must have its own name - Broker admin must create this and provide us as info to connect later
    @Value("${amqp.exchange.default}")
    public String EXCHANGE_NAME;
    @Value("${amqp.queue.default}")
    public  String QUEUE_NAME ;
    @Value("${amqp.routing.key.default}")
    public  String ROUTING_KEY;

    //4. Exchange configuration
    @Bean
    public DirectExchange exchange(){
        return new DirectExchange(EXCHANGE_NAME);
    }

    //5. Queue configuration: As many queues you have - ofc you can have more than one and each one must have its proper name
    //2nd param here: durable - Queue will survive a broker restart
    @Bean
    public Queue queue() {
        return new Queue(QUEUE_NAME, true);
    }

    //6. Binding configuration: Connects queue with exchange - As many bindings as queues I have

    @Bean
    public Binding binding(Queue queue, DirectExchange exchange){
        return  BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY);
    }

}
