package import_export_spec;

import java.io.File;
import java.io.IOException;

import exceptions.InvalidSheduleExcepiton;
import model.Schedule;

/**
 * 
 * Represents abstract model of shedule importer.
 * 
 * @author comex
 *
 */

public interface ScheduleImportExport<T> {
	
	/**
	 * @param file JSON file which contains data for schedule
	 * @return Schedule object from JSON
	 * @throws IOException IO Exception
	 */
	public Schedule importSheduleFromJSONFile(T source) throws IOException;
	
	
	/**
	 * @param destination where export schedule
	 * @param schedule schedule we wont to export
	 * @throws InvalidSheduleExcepiton If activities overlaps
	 * @throws IOException IO Exception
	 */
	public void exportSheduleToJSONFile(T destination,Schedule schedule) throws InvalidSheduleExcepiton,IOException;

}
