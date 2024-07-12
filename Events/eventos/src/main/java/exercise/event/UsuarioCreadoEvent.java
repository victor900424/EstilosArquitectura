package exercise.event;

import org.springframework.context.ApplicationEvent;

import exercise.model.Usuario;

public class UsuarioCreadoEvent extends ApplicationEvent {
    private Usuario usuario;

    public UsuarioCreadoEvent(Usuario usuario) {
        super(usuario);
        this.usuario = usuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }
}