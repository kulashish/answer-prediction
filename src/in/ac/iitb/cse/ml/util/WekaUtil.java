package in.ac.iitb.cse.ml.util;

import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

public class WekaUtil {
	public Instances getInstances(String file) throws Exception {
		DataSource datasource = new DataSource(file);
		Instances data = datasource.getDataSet();
		if (data.classIndex() == -1)
			data.setClassIndex(data.numAttributes() - 1);
		return data;
	}
}
