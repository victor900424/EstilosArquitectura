package exercise.listener;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import exercise.event.UsuarioCreadoEvent;

@Component
public class UsuarioCreadoListener {

    @EventListener
    public void handleUsuarioCreadoEvent(UsuarioCreadoEvent event) {
        System.out.println("Usuario creado: " + event.getUsuario());
    }
}