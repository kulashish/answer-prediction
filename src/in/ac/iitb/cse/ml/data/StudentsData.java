package in.ac.iitb.cse.ml.data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;

public class StudentsData {
	private BufferedReader reader;
	private boolean blnTest;

	public StudentsData(String file, boolean test) throws IOException {
		blnTest = test;
		reader = new BufferedReader(new FileReader(file));
		reader.readLine();
	}

	public StudentsData(File file, boolean test) throws IOException {
		blnTest = test;
		reader = new BufferedReader(new FileReader(file));
		reader.readLine();
	}

	public StudentObject readNext() throws IOException, ParseException {
		StudentObject t = null;
		String line = reader.readLine();
		if (null != line)
			t = blnTest ? StudentObject.createTestStudent(line)
					: new StudentObject(line);
		return t;
	}

	public void close() throws IOException {
		if (null != reader)
			reader.close();
	}

}
