package servicepublisher;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class ServiceActivator implements BundleActivator {

	ServiceRegistration publisherServiceRegistration;
	
	@Override
	public void start(BundleContext context) throws Exception {
	
		System.out.println("Publisher Start");
		ServicePublisher publisherServicePublisher = new ServicepublishImpl();
		publisherServiceRegistration = context.registerService(ServicePublisher.class.getName(),
				publisherServicePublisher, null);
		
	}

	@Override
	public void stop(BundleContext arg0) throws Exception {
	
		System.out.println("Publisher Stop");
		publisherServiceRegistration.unregister();
		
	}

	

}
