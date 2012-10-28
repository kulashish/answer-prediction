package in.ac.iitb.cse.ml.data;

import java.io.File;
import java.io.IOException;

import weka.core.Instances;
import weka.core.converters.ArffSaver;

public class StudentsSet {
	protected Instances instances;

	public Instances getInstances() {
		return instances;
	}

	public void setInstances(Instances instances) {
		this.instances = instances;
	}

	protected void serializeARFF(String arffFile) throws IOException {
		ArffSaver saver = new ArffSaver();
		saver.setInstances(instances);
		saver.setFile(new File(arffFile));
		saver.writeBatch();
	}

}
