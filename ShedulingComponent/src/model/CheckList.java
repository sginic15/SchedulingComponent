package model;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * Represents the list of tasks for {@code WorkEvent}
 * 
 * @author comex
 *
 */


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CheckList {
	
	private String title;
	private String description;
	private List<CheckItem> items=new ArrayList<CheckItem>();
	
}
