package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * Represents the single element of {@code CheckList}
 * 
 * @author comex
 *
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CheckItem {

	private String name;
	private boolean value;
}
