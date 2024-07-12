package arq.empresa.servicio;

import arq.empresa.modelo.Empleado;
import arq.empresa.util.UtilEmpleado;

import java.util.Scanner;

public class ServicioEmpleado {
    public void ejecutarServicio() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Ingrese el nombre del empleado: ");
        String nombre = scanner.nextLine();
        
        System.out.print("Ingrese el departamento del empleado: ");
        String departamento = scanner.nextLine();
        
        Empleado empleado = new Empleado();
        empleado.setNombre(nombre);
        empleado.setDepartamento(departamento);
        
        UtilEmpleado util = new UtilEmpleado();
        String resultado = util.procesarEmpleado(empleado);
        
        System.out.println("Resultado del servicio: " + resultado);
    }
}
