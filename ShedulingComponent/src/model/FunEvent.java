package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 
 * Represents fun activity(for example going to party or football game)
 * 
 * @author comex
 *
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@Background
public class FunEvent extends Event {

	private Rating rating = Rating.OK;
	/**
	 * Represents the impresion of the event
	 */
	private String impressions;

	/**
	 * Represents the cost of event
	 */
	private int cost;

}
