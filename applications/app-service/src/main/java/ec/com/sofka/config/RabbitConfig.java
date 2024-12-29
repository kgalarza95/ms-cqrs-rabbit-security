package ec.com.sofka.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//2. Create class to configure RabbitMQ here in app layer: To generate beans
@Configuration
public class RabbitConfig {
    //3. Configurations: Environment variables - Names must follow a pattern like this
    // Each queue must have its own name - Broker admin must create this and provide us as info to connect later
    public static final String EXCHANGE_NAME = "simpleExchange";
    public static final String QUEUE_NAME = "simpleQueue";
    public static final String ROUTING_KEY = "routingKey";

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
