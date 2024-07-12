package soa;

public class Client {
    private Server server;

    public Client(Server server) {
        this.server = server;
    }

    public void requestService(String serviceName) {
        server.handleRequest(serviceName);
    }
}