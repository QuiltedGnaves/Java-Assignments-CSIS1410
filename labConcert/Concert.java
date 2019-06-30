package labConcert;
/**
 * Sets the name, start time, and end time of a concert
 * 
 * @param name  String for the name of the concert
 * @param startTime Time object that is the start time of the concert
 * @param endTime Time object that is the end time of the concert
 * 
 * @author Dax Allen
 *
 */
public class Concert {

	private String name;
	private Time startTime;
	private Time endTime;
	
	public Concert (String name, Time start, Time end) {
		
		this.name = name;
		this.startTime = start;
		this.endTime = end;
	}

	@Override
	public String toString() {
		return "Concert [name=" + name + ", startTime=" + startTime + ", endTime=" + endTime + "]";
	}
	
}
