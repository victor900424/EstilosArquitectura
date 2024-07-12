package soa;

import java.util.HashMap;
import java.util.Map;

public class ServiceRegistry {
    private Map<String, Service> services = new HashMap<>();

    public void registerService(String serviceName, Service service) {
        services.put(serviceName, service);
    }

    public Service getService(String serviceName) {
        return services.get(serviceName);
    }
}