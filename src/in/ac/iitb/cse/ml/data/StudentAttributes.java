package in.ac.iitb.cse.ml.data;

import in.ac.iitb.cse.ml.util.ModelConstants;
import weka.core.DenseInstance;
import weka.core.Instance;

public class StudentAttributes {
	private long id;
	private long quesId;
	private int quesType;
	private int group;
	private int track;
	private int subtrack;
	private int tag;
	private long timeToAnswer;
	private int gameType;
	private int numPlayers;
	private int quesSet;
	private int correct;

	public StudentAttributes(StudentObject stud) {
		id = stud.getUserID();
		quesId = stud.getQuesID();
		quesType = stud.getQuesType();
		group = stud.getGroupName();
		track = stud.getTrackName();
		subtrack = stud.getSubtrackName();
		gameType = stud.getGameType();
		numPlayers = stud.getNumPlayers();
		quesSet = stud.getQuesSetId();
		correct = stud.isCorrect() ? 1 : 0;
		if (stud.getAnsweredAt() != null && stud.getStartedAt() != null)
			timeToAnswer = stud.getAnsweredAt().getTime()
					- stud.getStartedAt().getTime();
	}

	public Instance createWekaInstance() {
		Instance instance = new DenseInstance(ModelConstants.NUM_ATTRIBUTES);
		instance.setValue(0, id);
		instance.setValue(1, quesId);
		instance.setValue(2, quesType);
		instance.setValue(3, group);
		instance.setValue(4, track);
		instance.setValue(5, subtrack);
		instance.setValue(6, tag);
		instance.setValue(7, timeToAnswer);
		instance.setValue(8, gameType);
		instance.setValue(9, numPlayers);
		instance.setValue(10, quesSet);
		instance.setValue(11, correct);
		return instance;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getQuesId() {
		return quesId;
	}

	public void setQuesId(long quesId) {
		this.quesId = quesId;
	}

	public int getQuesType() {
		return quesType;
	}

	public void setQuesType(int quesType) {
		this.quesType = quesType;
	}

	public int getGroup() {
		return group;
	}

	public void setGroup(int group) {
		this.group = group;
	}

	public int getTrack() {
		return track;
	}

	public void setTrack(int track) {
		this.track = track;
	}

	public int getSubtrack() {
		return subtrack;
	}

	public void setSubtrack(int subtrack) {
		this.subtrack = subtrack;
	}

	public int getTag() {
		return tag;
	}

	public void setTag(int tag) {
		this.tag = tag;
	}

	public long getTimeToAnswer() {
		return timeToAnswer;
	}

	public void setTimeToAnswer(long timeToAnswer) {
		this.timeToAnswer = timeToAnswer;
	}

	public int getGameType() {
		return gameType;
	}

	public void setGameType(int gameType) {
		this.gameType = gameType;
	}

	public int getNumPlayers() {
		return numPlayers;
	}

	public void setNumPlayers(int numPlayers) {
		this.numPlayers = numPlayers;
	}

	public int getQuesSet() {
		return quesSet;
	}

	public void setQuesSet(int quesSet) {
		this.quesSet = quesSet;
	}

}
