package in.ac.iitb.cse.ml.prediction;

import java.util.ArrayList;
import java.util.Collections;

import weka.classifiers.bayes.NaiveBayesUpdateable;
import weka.core.Attribute;
import weka.core.Instances;
import weka.core.SerializationHelper;
import weka.core.converters.ConverterUtils.DataSource;

public class ModelLearner {
	/*
	 * Location of the ARFF file
	 */
	private String trainFile;
	private String modelFile;

	public ModelLearner(String file, String mFile) {
		trainFile = file;
		modelFile = mFile;
	}

	public void learn() throws Exception {
		DataSource datasource = new DataSource(trainFile);
		Instances data = datasource.getDataSet();
		if (data.classIndex() == -1)
			data.setClassIndex(data.numAttributes() - 1);

		Instances smalldata = new Instances("small",
				(ArrayList<Attribute>) new AttributesBuilder().build(), 100);
		for (int i = 0; i < 100; i++)
			smalldata.add(data.get(i));
		smalldata.setClassIndex(smalldata.numAttributes() - 1);
		NaiveBayesUpdateable model = new NaiveBayesUpdateable();
		System.out.println("Training Naive Bayes classifier...");
		model.buildClassifier(smalldata);
		for (int i = 100; i < data.numInstances(); i++)
			model.updateClassifier(data.get(i));
		// model.buildClassifier(data);
		System.out.println("Serializing model...");
		SerializationHelper.write(modelFile, model);
		System.out.println("Done!");
	}

	public static void main(String args[]) {
		ModelLearner learner = new ModelLearner(args[0], args[1]);
		try {
			learner.learn();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
