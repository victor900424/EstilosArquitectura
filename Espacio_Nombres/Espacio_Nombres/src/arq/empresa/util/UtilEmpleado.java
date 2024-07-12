package arq.empresa.util;

import arq.empresa.modelo.Empleado;

public class UtilEmpleado {
    public String procesarEmpleado(Empleado empleado) {
        return "Empleado: " + empleado.getNombre() + ", Departamento: " + empleado.getDepartamento();
    }
}
