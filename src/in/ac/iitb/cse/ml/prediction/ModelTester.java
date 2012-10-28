package in.ac.iitb.cse.ml.prediction;

import in.ac.iitb.cse.ml.util.WekaUtil;

import java.io.BufferedWriter;
import java.io.FileWriter;

import weka.classifiers.Classifier;
import weka.core.Instances;
import weka.core.SerializationHelper;

public class ModelTester {
	private String modelFile;
	private String testFile;
	private String outFile;

	public ModelTester(String model, String test, String out) {
		modelFile = model;
		testFile = test;
		outFile = out;
	}

	public void test() throws Exception {
		System.out.println("Loading test instances");
		Instances testInstances = new WekaUtil().getInstances(testFile);
		System.out.println("Number of test instances : "
				+ testInstances.numInstances());

		Classifier classifier = (Classifier) SerializationHelper
				.read(modelFile);
		System.out.println("Loaded model");
		System.out.println("Classifying instances");
		int val = 0;
		int userId = -1;
		int lastUser = -1;
		double count = 0.0d;
		int total = 0;
		double cls = 0.0d;
		BufferedWriter writer = new BufferedWriter(new FileWriter(outFile));
		writer.append("user_id,outcome");
		writer.newLine();
		for (int i = 0; i < testInstances.numInstances(); i++) {
			userId = (int) testInstances.instance(i).value(0);
			val = (int) classifier.classifyInstance(testInstances.instance(i));
			if (lastUser != -1 && userId != lastUser) {
				writer.append(lastUser + ",");
				writer.append(String.valueOf(cls >= 0.5d ? 1 : 0));
				writer.append("," + cls);
				writer.newLine();
				count = 0.0d;
				total = 0;
			}
			lastUser = userId;
			cls = val == 1 ? (++count / ++total) : (count / ++total);
		}
		writer.append(lastUser + ",");
		writer.append(String.valueOf(cls >= 0.5d ? 1 : 0));
		writer.append("," + cls);
		writer.newLine();
		writer.close();
		System.out.println("Serialized output!");
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ModelTester tester = new ModelTester(args[0], args[1], args[2]);
		try {
			tester.test();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
