package model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * Represents one event in user schedule.It can be work activity(for example
 * finish project for university) or fun activity(for example go to party)
 * 
 * @author comex
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = { "title" })
public abstract class Event {

	/**
	 * The title of event
	 */
	private String title;
	/**
	 * description of the event
	 */
	private String description;
	/**
	 * event start time
	 */
	private LocalDateTime startActivity;
	/**
	 * event end time
	 */
	private LocalDateTime endActivity;
	/**
	 * is event finished successfully
	 */
	private boolean done;

	/**
	 * list of other person on this event
	 */
	private List<Person> persons = new ArrayList<>();

	/**
	 * @param other other event
	 * @return true if events are overlapping or false if not
	 */
	public boolean isOverlapWithOther(Event other) {
		return (this.startActivity.compareTo(other.startActivity) >= 0
				&& this.startActivity.compareTo(other.endActivity) <= 0)
				|| (this.endActivity.compareTo(other.startActivity) >= 0
						&& this.endActivity.compareTo(other.endActivity) <= 0)
				|| (other.startActivity.compareTo(this.startActivity) >= 0
						&& other.startActivity.compareTo(this.endActivity) <= 0)
				|| (other.endActivity.compareTo(this.startActivity) >= 0
						&& other.endActivity.compareTo(this.endActivity) <= 0);

	}

}
