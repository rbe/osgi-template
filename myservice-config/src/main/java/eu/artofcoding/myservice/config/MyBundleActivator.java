package eu.artofcoding.myservice.config;

import eu.artofcoding.myservice.api.MyService;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.service.cm.Configuration;
import org.osgi.service.cm.ConfigurationAdmin;

import java.util.Dictionary;

public class MyBundleActivator implements BundleActivator {

    @Override
    public void start(BundleContext context) throws Exception {
        // ConfigurationAdmin
        final ServiceReference serviceReference = context.getServiceReference(ConfigurationAdmin.class.getName());
        ConfigurationAdmin configurationAdmin = (ConfigurationAdmin) context.getService(serviceReference);
        // Configuration of service
        Configuration configuration = configurationAdmin.getConfiguration(MyService.class.getName());
        Dictionary properties = configuration.getProperties();
        //properties.put();
        configuration.update(properties);
    }

    @Override
    public void stop(BundleContext context) throws Exception {
    }

}
