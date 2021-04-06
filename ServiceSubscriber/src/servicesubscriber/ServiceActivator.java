package servicesubscriber;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import servicepublisher.ServicePublisher;

public class ServiceActivator implements BundleActivator {

	ServiceReference serviceReference;

	


	public void start(BundleContext bundleContext) throws Exception {
	
		System.out.println("Start subscriber service");
		serviceReference = bundleContext.getServiceReference(ServicePublisher.class.getName());
		ServicePublisher servicePublisher = (ServicePublisher)bundleContext.getService(serviceReference);
		System.out.println(servicePublisher.publishService());

	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Good bye !!!");
		bundleContext.ungetService(serviceReference);
	}

}
