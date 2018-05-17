package services;

public class TimeSlots {
	int slot_ID;
	int timeStart;
	int timeEnd;
	String timeName;
	public TimeSlots(int slot_ID, int timeStart, int timeEnd, String timeName) {
		super();
		this.slot_ID = slot_ID;
		this.timeStart = timeStart;
		this.timeEnd = timeEnd;
		this.timeName = timeName;
	}
	
	public int getSlot_ID() {
		return slot_ID;
	}
	public void setSlot_ID(int slot_ID) {
		this.slot_ID = slot_ID;
	}
	public int getTimeStart() {
		return timeStart;
	}
	public void setTimeStart(int timeStart) {
		this.timeStart = timeStart;
	}
	public int getTimeEnd() {
		return timeEnd;
	}
	public void setTimeEnd(int timeEnd) {
		this.timeEnd = timeEnd;
	}
	public String getTimeName() {
		return timeName;
	}
	public void setTimeName(String timeName) {
		this.timeName = timeName;
	}
	
	
	
}
