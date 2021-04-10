package eventssubscriber;

import java.util.List;
import java.util.Scanner;

import eventspublisher.Event;
import eventspublisher.EventService;

public class SubscriberServiceImpl implements SubscriberService {
	
	Scanner sc = new Scanner(System.in);

	@Override
	public void clientService(EventService eventService) {
		
		System.out.println();
		System.out.println("========== Welcome to Event Management Portal. ==========");
		System.out.println();
		System.out.println("Please select the service you want.");
		
		while(true) {
			String id;
			String name;
			String desc;
			String date;
			String input;
			
			System.out.println("> To add new event enter: add");
			System.out.println("> To view all events: all");
			System.out.println("> To view event details enter: event");
			System.out.println("> To exit enter: exit");
			System.out.print("> ");
			input = sc.nextLine();
			System.out.println();
			
			if(input.equalsIgnoreCase("exit")) {
				return;
			}
			else if(input.equalsIgnoreCase("add")) {
				System.out.print("Event ID: ");
				id = sc.nextLine();
				System.out.print("Event name: ");
				name = sc.nextLine();
				System.out.print("Event description: ");
				desc = sc.nextLine();
				System.out.print("Event date: ");
				date = sc.nextLine();
				System.out.println();
				
				String tem = eventService.addEvent(id, name, desc, date);
				System.out.println(tem);
				System.out.println();
			}
			else if(input.equalsIgnoreCase("all")) {
				List<Event> events = eventService.getAllEvents();
				
			    System.out.println("Event List: "); 		
			    for (Event event : events) {
			    	System.out.println();
			    	System.out.println(event.getId());
			        System.out.println(event.getName());
			        System.out.println(event.getDescription());
			        System.out.println(event.getDate());
			        System.out.println();
			    }
			}
			else if(input.equalsIgnoreCase("event")) {
				String tempId;
				System.out.print("Enter event ID: ");
				tempId = sc.nextLine();
				Event event = eventService.getEvent(tempId);
				System.out.println();
				System.out.println(event.getId());
				System.out.println(event.getName());
				System.out.println(event.getDescription());
				System.out.println(event.getDate());
				System.out.println();
			}
			else {
				System.out.println("Invalid command. Try again.");
			}
			
			System.out.print("Do you want to continue?(yes/no): ");
			String end = sc.nextLine();
			if(end.equalsIgnoreCase("no")) {
				return;
			}
			
			
		}
		
	}

}
