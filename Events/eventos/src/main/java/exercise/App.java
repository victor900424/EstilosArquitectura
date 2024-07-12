package exercise;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import exercise.event.UsuarioCreadoEvent;
import exercise.model.Usuario;
import exercise.publisher.EventPublisher;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(App.class, args);
        EventPublisher publisher = context.getBean(EventPublisher.class);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            // Obtener datos del usuario
            System.out.print("Ingrese su nombre: ");
            String nombre = reader.readLine();

            System.out.print("Ingrese su email: ");
            String email = reader.readLine();

            // Crear un nuevo usuario y publicar el evento
            Usuario nuevoUsuario = new Usuario(1L, nombre, email);
            publisher.publishEvent(new UsuarioCreadoEvent(nuevoUsuario));

        } catch (IOException e) {
            e.printStackTrace();
        }

        finally {
            // Cierra el contexto de la aplicación para liberar el puerto
            context.close();
        }

    }
}