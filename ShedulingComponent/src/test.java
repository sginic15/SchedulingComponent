import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.channels.ShutdownChannelGroupException;
import java.time.LocalDateTime;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;

import exceptions.InvalidSheduleExcepiton;
import import_export_impl.SheduleImportExportJsonImplementation;
import model.Event;
import model.EventFactory;
import model.FunEvent;
import model.Priority;
import model.Schedule;
import model.WorkEvent;

public class test {

	public static void main(String[] args) {
		
		Schedule schedule=new Schedule();
		EventFactory eventFactory=new EventFactory();
		Event workEvent1=eventFactory.getEvent("FUN");
		workEvent1.setStartActivity(LocalDateTime.of(2018, 1,12,12,25));
		workEvent1.setEndActivity(LocalDateTime.of(2018, 1,20,12,25));
		workEvent1.setTitle("event1");
		schedule.add(workEvent1);
		
		Event workEvent2=eventFactory.getEvent("WORK");
		workEvent2.setStartActivity(LocalDateTime.of(2018, 1,13,12,25));
		workEvent2.setEndActivity(LocalDateTime.of(2018, 1,25,12,25));
		workEvent2.setTitle("event2");
		schedule.add(workEvent2);
		
		
		
		
		
		
		SheduleImportExportJsonImplementation sheduleImportExportJsonImplementation=new SheduleImportExportJsonImplementation();
		System.out.println(schedule);
		try {
			sheduleImportExportJsonImplementation.exportSheduleToJSONFile(new File("Proba.json"), schedule);
		} catch (InvalidSheduleExcepiton | IOException e) {   
			e.printStackTrace();
		}
	}

}
