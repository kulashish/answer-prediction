package in.ac.iitb.cse.ml.data;

import in.ac.iitb.cse.ml.prediction.AttributesBuilder;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import weka.core.Attribute;
import weka.core.Instances;
import weka.core.converters.ArffSaver;

public class TrainingSet {
	private Instances trainingInstances;

	public Instances getTrainingInstances() {
		return trainingInstances;
	}

	public void setTrainingInstances(Instances trainingInstances) {
		this.trainingInstances = trainingInstances;
	}

	/*
	 * Creates TrainingSet instance from the CSV files present in a folder whose
	 * path is provided to the constructor
	 */
	public TrainingSet(String path) throws IOException, ParseException {
		trainingInstances = new Instances("student",
				(ArrayList<Attribute>) new AttributesBuilder().build(), 100);

		File trainFolder = new File(path);
		for (File file : trainFolder.listFiles())
			populate(file);
	}

	/*
	 * Populates training instances from the instances present in the CSV file
	 */
	private void populate(File trainFile) throws IOException, ParseException {
		System.out.println("Populating from " + trainFile.getName());
		StudentsData data = new StudentsData(trainFile);
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
				trainingInstances.add(studentInstance.createWekaInstance());
		}
		data.close();
		System.out.println("Populated " + trainingInstances.size()
				+ " instances");
	}

	/*
	 * Expects two arguments - folder containing the CSV files and path to
	 * output ARFF file
	 */
	public static void main(String args[]) {
		String path = args[0];
		String arffFile = args[1];
		TrainingSet train = null;
		try {
			System.out.println("Creating training set...");
			train = new TrainingSet(path);
			train.serializeARFF(arffFile);
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}
		System.out.println("Training set created!");
	}

	private void serializeARFF(String arffFile) throws IOException {
		ArffSaver saver = new ArffSaver();
		saver.setInstances(trainingInstances);
		saver.setFile(new File(arffFile));
		saver.writeBatch();
	}
}
