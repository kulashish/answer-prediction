package in.ac.iitb.cse.ml.data;

import in.ac.iitb.cse.ml.prediction.AttributesBuilder;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import weka.core.Attribute;
import weka.core.Instances;

public class TestSet extends StudentsSet {

	public TestSet(String path) throws IOException, ParseException {
		instances = new Instances("student",
				(ArrayList<Attribute>) new AttributesBuilder().build(), 100);

		File testFolder = new File(path);
		for (File file : testFolder.listFiles())
			populate(file);
	}

	private void populate(File testFile) throws IOException, ParseException {
		System.out.println("Populating from " + testFile.getName());
		StudentsData data = new StudentsData(testFile, true);
		StudentObject stud = null;
		StudentAttributes[] studentInstances = null;
		AttributesBuilder builder = new AttributesBuilder();
		/*
		 * Iterate over student data present in the file. For each student data
		 * object, create the student instances (attributes) and then create
		 * weka instance out of that
		 */
		while (null != (stud = data.readNext())) {
			studentInstances = builder.createInstances(stud);
			for (StudentAttributes studentInstance : studentInstances)
				instances.add(studentInstance.createWekaInstance());
		}
		data.close();
		System.out.println("Populated " + instances.size() + " instances");
	}

	public static void main(String args[]) {
		String path = args[0];
		String arffFile = args[1];
		TestSet test = null;
		try {
			System.out.println("Creating test set...");
			test = new TestSet(path);
			test.serializeARFF(arffFile);
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}
		System.out.println("Test set created!");
	}

}
