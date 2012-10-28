package in.ac.iitb.cse.ml.prediction;

import in.ac.iitb.cse.ml.util.WekaUtil;
import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.core.Instances;
import weka.core.SerializationHelper;

public class ModelValidator {
	private String modelFile;
	private String validationFile;
	private String trainFile;

	public ModelValidator(String model, String validation, String train) {
		modelFile = model;
		validationFile = validation;
		trainFile = train;
	}

	public void validate() throws Exception {
		Classifier classifier = (Classifier) SerializationHelper
				.read(modelFile);
		// Instances train = getInstances(trainFile);
		Instances validate = new WekaUtil().getInstances(validationFile);
		Evaluation eval = new Evaluation(validate);
		System.out.println("Evaluating model...");
		eval.evaluateModel(classifier, validate);
		System.out.println(eval.toSummaryString());
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			new ModelValidator(args[0], args[2], args[1]).validate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
