package eventssubscriber;

import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import eventspublisher.EventService;

public class Activator implements BundleActivator {

	private static BundleContext context;
	ServiceReference reference;
	Scanner sc = new Scanner(System.in);

	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
		System.out.println("Hello there!!! Events subscriber started.");
		reference = bundleContext.getServiceReference(EventService.class.getName());
		EventService eventService = (EventService) bundleContext.getService(reference);
		
		SubscriberService subscriberService = new SubscriberServiceImpl();
		subscriberService.clientService(eventService);
		
	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Events subscriber stopped. See you later!!!");
		bundleContext.ungetService(reference);
		Activator.context = null;
	}

}
