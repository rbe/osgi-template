package eu.artofcoding.myservice.impl;

import eu.artofcoding.myservice.api.MyService;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.cm.ConfigurationException;
import org.osgi.service.cm.ManagedService;

import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.logging.Logger;

public class MyBundleActivator implements BundleActivator, ManagedService {

    private static final Logger logger = Logger.getLogger(MyBundleActivator.class.getName());

    private ServiceRegistration serviceRegistration;

    @Override
    public void start(BundleContext context) throws Exception {
        final String symbolicName = context.getBundle().getSymbolicName();
        logger.info(String.format("Starting bundle %s through %s", symbolicName, this.getClass().getName()));
        Dictionary<String, Object> properties = new Hashtable<>(1);
        // PID for ConfigurationAdmin
        properties.put(Constants.SERVICE_PID, MyService.class.getName());
        // Register service (singleton)
        //serviceRegistration = context.registerService(MyService.class.getName(), new MyService(), properties);
        // Register service factory (multiple instances, cached instances)
        serviceRegistration = context.registerService(MyService.class.getName(), new MyServiceFactory(), properties);
        logger.info(String.format("Bundle %s started", symbolicName));
    }

    @Override
    public void stop(BundleContext context) throws Exception {
        final String symbolicName = context.getBundle().getSymbolicName();
        logger.info(String.format("Stopping bundle %s", symbolicName));
        serviceRegistration.unregister();
        logger.info(String.format("Bundle %s stopped", symbolicName));
    }

    @Override
    public void updated(Dictionary properties) throws ConfigurationException {
        if (null != properties) {
            Enumeration e = properties.elements();
            while (e.hasMoreElements()) {
                System.out.printf("%s#updated(Dictionary): e=%s%n", this, e.nextElement());
            }
        }
    }

}
