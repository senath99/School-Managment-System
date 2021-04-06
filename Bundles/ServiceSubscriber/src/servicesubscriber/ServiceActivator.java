package servicesubscriber;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import servicepublisher.ServicePublisher;

/**
 * The activator class controls the plug-in life cycle
 */
public class ServiceActivator extends AbstractUIPlugin {


	ServiceReference servicReference;
	
	@Override
	public void start(BundleContext context) throws Exception {
		System.out.println("Start Subscriber Service");
		servicReference = context.getServiceReference(ServicePublisher.class.getName());
		ServicePublisher servicePublisher = (ServicePublisher) context.getService(servicReference);
		System.out.println(servicePublisher.publishService());
	
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		System.out.println("Good Bye!!");
		context.ungetService(servicReference);
	}

	
}
