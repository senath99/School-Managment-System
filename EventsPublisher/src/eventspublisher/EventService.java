package eventspublisher;

import java.util.Date;
import java.util.List;

public interface EventService {
	
	public String addEvent(String id, String name, String des, String date);
	
	public List<Event> getAllEvents();
	
	public Event getEvent(String id);

}
