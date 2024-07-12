package soa;

public class Server {
    private ServiceRegistry serviceRegistry;

    public Server(ServiceRegistry serviceRegistry) {
        this.serviceRegistry = serviceRegistry;
    }

    public void handleRequest(String serviceName) {
        Service service = serviceRegistry.getService(serviceName);
        if (service != null) {
            service.execute();
        } else {
            System.out.println("Servicio no encontrado: " + serviceName);
        }
    }
}