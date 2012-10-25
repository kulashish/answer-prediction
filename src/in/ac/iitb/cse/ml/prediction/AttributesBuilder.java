package in.ac.iitb.cse.ml.prediction;

import in.ac.iitb.cse.ml.data.StudentAttributes;
import in.ac.iitb.cse.ml.data.StudentObject;
import in.ac.iitb.cse.ml.util.ModelConstants;

import java.util.ArrayList;
import java.util.List;

import weka.core.Attribute;

public class AttributesBuilder {

	public List<Attribute> build() {
		List<Attribute> attribsList = new ArrayList<Attribute>();
		for (String attribName : ModelConstants.ATTRIBUTES)
			attribsList.add(new Attribute(attribName));
		return attribsList;
	}

	public StudentAttributes[] createInstances(StudentObject stud) {
		StudentAttributes[] instances = new StudentAttributes[stud.getTags().length];
		for (int i = 0; i < instances.length; i++) {
			instances[i] = new StudentAttributes(stud);
			instances[i].setTag(stud.getTags()[i]);
		}
		return instances;
	}
}
