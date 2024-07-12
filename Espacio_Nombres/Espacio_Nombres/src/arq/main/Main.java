package arq.main;

import arq.empresa.servicio.ServicioEmpleado;

public class Main {
    public static void main(String[] args) {
        ServicioEmpleado servicio = new ServicioEmpleado();
        servicio.ejecutarServicio();
    }
}
