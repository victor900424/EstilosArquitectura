package soa;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        // Crear el registro de servicios
        ServiceRegistry serviceRegistry = new ServiceRegistry();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            // Obtener datos del usuario
            System.out.print("Ingrese cuenta: ");
            String account = reader.readLine();

            System.out.print("Ingrese monto: ");
            Double amount = Double.parseDouble(reader.readLine());

            // Crear e insertar el servicio de remesas
            RemittanceService remittanceService = new RemittanceService(account, amount);
            serviceRegistry.registerService("remittanceService", remittanceService);

            // Crear el servidor con el registro de servicios
            Server server = new Server(serviceRegistry);

            // Crear el cliente con el servidor
            Client client = new Client(server);

            // El cliente solicita el servicio de remesas
            client.requestService("remittanceService");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}