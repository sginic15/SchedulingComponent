package import_export_impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;

import exceptions.InvalidSheduleExcepiton;
import import_export_spec.SheduleImportExportJSON;
import model.Event;
import model.Schedule;

public class SheduleImportExportJsonImplementation implements SheduleImportExportJSON {

	@Override
	public Schedule importSheduleFromJSONFile(File file) throws IOException {
		Gson gson = new GsonBuilder().setPrettyPrinting().registerTypeAdapter(Event.class,new InterfaceAdapter<Event>()).create();
		BufferedReader reader = new BufferedReader(new FileReader(file));
		Schedule schedule = gson.fromJson(reader, Schedule.class);
		reader.close();
		return schedule;
	}

	@Override
	public void exportSheduleToJSONFile(File file, Schedule schedule) throws InvalidSheduleExcepiton, IOException {
		schedule.checkSchedule();
		Gson gson = new GsonBuilder().setPrettyPrinting().registerTypeAdapter(Event.class,new InterfaceAdapter<Event>()).create();
		Writer writer = new FileWriter(file);
		gson.toJson(schedule, writer);
		writer.flush();
	}

}
