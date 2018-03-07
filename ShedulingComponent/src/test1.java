import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

import exceptions.InvalidSheduleExcepiton;
import import_export_impl.SheduleImportExportJsonImplementation;
import model.Event;
import model.EventFactory;
import model.Schedule;

public class test1 {
	
	public static void main(String[] args) {

		
		SheduleImportExportJsonImplementation sheduleImportExportJsonImplementation = new SheduleImportExportJsonImplementation();

		try {
			Schedule schedule=sheduleImportExportJsonImplementation.importShedule(new File("Proba.json"));
			System.out.println(schedule);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
