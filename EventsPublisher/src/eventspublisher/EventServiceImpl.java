package eventspublisher;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EventServiceImpl implements EventService {
	
	public List<Event> events = new ArrayList<Event>();

	@Override
	public String addEvent(String id, String name, String des, String date) {
		Event event = new Event(id, name, des, date);
		events.add(event);
		return "New event " + event.getName() + " added successfully.";
	}

	@Override
	public List<Event> getAllEvents() {
		return events;
	}

	@Override
	public Event getEvent(String id) {
		Event event = null;
	    for (Event tempEvent : events) { 		      
	    	if(tempEvent.getId().equalsIgnoreCase(id)) {
	    		event = tempEvent;
	    	}
	    }
	    
	    if(event == null) {
	    	System.out.println("Sorry there is no such event");
	    	return null;
	    }
	    
	    return event;
	}
	
	

}
