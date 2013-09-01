package eu.artofcoding.myservice.impl;

import org.osgi.framework.Bundle;
import org.osgi.framework.ServiceFactory;
import org.osgi.framework.ServiceRegistration;

import java.util.logging.Logger;

public class MyServiceFactory implements ServiceFactory {

    private static final Logger logger = Logger.getLogger(MyServiceFactory.class.getName());

    @Override
    public Object getService(Bundle bundle, ServiceRegistration registration) {
        final MyServiceImpl myService = new MyServiceImpl();
        logger.info(String.format("Created new service instance %s for bundle=%s", myService, bundle.getSymbolicName()));
        return myService;
    }

    @Override
    public void ungetService(Bundle bundle, ServiceRegistration registration, Object service) {
    }

}
