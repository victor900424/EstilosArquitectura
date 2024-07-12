package exercise.publisher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import exercise.event.UsuarioCreadoEvent;

@Component
public class EventPublisher {
    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    public void publishEvent(UsuarioCreadoEvent event) {
        applicationEventPublisher.publishEvent(event);
    }
}