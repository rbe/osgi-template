package eu.artofcoding.myservice.client;

import eu.artofcoding.myservice.api.MyData;
import eu.artofcoding.myservice.api.MyService;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;

import java.util.logging.Logger;

public class MyBundleActivator implements BundleActivator {

    private static final Logger logger = Logger.getLogger(MyBundleActivator.class.getName());

    @Override
    public void start(BundleContext context) throws Exception {
        final String symbolicName = context.getBundle().getSymbolicName();
        logger.info(String.format("Starting bundle %s", symbolicName));
        final ServiceReference<MyService> serviceReference = context.getServiceReference(MyService.class);
        if (null != serviceReference) {
            MyService myService = context.getService(serviceReference);
            if (null != myService) {
                MyData myData = new MyData();
                myData.setFirstname("Justus");
                myData.setLastname("Jonas");
                System.out.println(myService.sayHello(myData));
            }
            logger.info(String.format("Bundle %s started", symbolicName));
        } else {
            logger.info(String.format("Service reference for bundle %s not found.", MyService.class));
        }
    }

    @Override
    public void stop(BundleContext context) throws Exception {
        final String symbolicName = context.getBundle().getSymbolicName();
        //logger.info(String.format("Stopping bundle %s", symbolicName));
        logger.info(String.format("Bundle %s stopped", symbolicName));
    }

}
