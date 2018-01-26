package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import exceptions.InvalidSheduleExcepiton;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Delegate;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = { "title" })
public class Schedule {

	private String title;
	private String description;
	@lombok.experimental.Delegate
	private List<Event> events = new ArrayList<>();

	public void sortSchedule() {
		events.sort((Event event1, Event event2) -> event1.getStartActivity().compareTo(event2.getStartActivity()));
	}

	public void checkSchedule() throws InvalidSheduleExcepiton {
		for (int i = 0; i < events.size(); i++) {
			for (int j = i + 1; j < events.size(); j++) {
				if (!events.get(i).getClass().isAnnotationPresent(Background.class) && !events.get(i).getTitle().equals(events.get(j).getTitle())
						&& events.get(i).isOverlapWithOther(events.get(j))) {
					throw new InvalidSheduleExcepiton(events.get(i), events.get(j));
				}
			}
		}
	}

}
