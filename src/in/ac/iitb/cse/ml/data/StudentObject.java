package in.ac.iitb.cse.ml.data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StudentObject {
	private static final int NUM_ATTRIBUTES = 17;
	private static final String DATE_PATTERN = "yyyy-MM-dd hh:mm:ss";
	private static final String TEST_DATE_PATTERN = "yyyy-MM-dd";
	private boolean correct;
	private int outcome;
	private long userID;
	private long quesID;
	private int quesType;
	private int groupName;
	private int trackName;
	private int subtrackName;
	private int[] tags;
	private Date startedAt;
	private Date answeredAt;
	private Date deactivatedAt;
	private int ansId;
	private int gameType;
	private int numPlayers;
	private Date testDate;
	private int quesSetId;

	public StudentObject() {

	}

	public static StudentObject createTestStudent(String line)
			throws ParseException {
		StudentObject stud = new StudentObject();
		String[] attribs = line.split(",");
		int index = 0;
		// setCorrect(Integer.parseInt(attribs[0]) == 1);
		// setOutcome(Integer.parseInt(attribs[index]));
		stud.setUserID(Integer.parseInt(attribs[index++]));
		stud.setQuesID(Long.parseLong(attribs[index++]));
		stud.setQuesType(Integer.parseInt(attribs[index++]));
		stud.setGroupName(Integer.parseInt(attribs[index++]));
		stud.setTrackName(Integer.parseInt(attribs[index++]));
		stud.setSubtrackName(Integer.parseInt(attribs[index++]));
		stud.setTags(attribs[index++].split(" "));
		stud.setStartedAt(attribs[index] == null
				|| attribs[index].equalsIgnoreCase("NULL") ? null
				: new SimpleDateFormat(DATE_PATTERN).parse(attribs[index++]));
		stud.setAnsweredAt(attribs[index] == null
				|| attribs[index].equalsIgnoreCase("NULL") ? null
				: new SimpleDateFormat(DATE_PATTERN).parse(attribs[index++]));
		stud.setDeactivatedAt(attribs[index] == null
				|| attribs[index].equalsIgnoreCase("NULL") ? null
				: new SimpleDateFormat(DATE_PATTERN).parse(attribs[index++]));
		// setAnsId(Integer.parseInt(attribs[index++]));
		stud.setGameType(Integer.parseInt(attribs[index++]));
		stud.setNumPlayers(Integer.parseInt(attribs[index++]));
		stud.setTestDate(attribs[index] == null
				|| attribs[index].equalsIgnoreCase("NULL") ? null
				: new SimpleDateFormat(TEST_DATE_PATTERN)
						.parse(attribs[index++]));
		if (!attribs[index].equalsIgnoreCase("NULL"))
			stud.setQuesSetId(Integer.parseInt(attribs[index++]));
		return stud;
	}

	public StudentObject(String line) throws ParseException {
		String[] attribs = line.split(",");
		setCorrect(Integer.parseInt(attribs[0]) == 1);
		setOutcome(Integer.parseInt(attribs[1]));
		setUserID(Integer.parseInt(attribs[2]));
		setQuesID(Long.parseLong(attribs[3]));
		setQuesType(Integer.parseInt(attribs[4]));
		setGroupName(Integer.parseInt(attribs[5]));
		setTrackName(Integer.parseInt(attribs[6]));
		setSubtrackName(Integer.parseInt(attribs[7]));
		setTags(attribs[8].split(" "));
		setStartedAt(attribs[9] == null || attribs[9].equalsIgnoreCase("NULL") ? null
				: new SimpleDateFormat(DATE_PATTERN).parse(attribs[9]));
		setAnsweredAt(attribs[10] == null
				|| attribs[10].equalsIgnoreCase("NULL") ? null
				: new SimpleDateFormat(DATE_PATTERN).parse(attribs[10]));
		setDeactivatedAt(attribs[11] == null
				|| attribs[11].equalsIgnoreCase("NULL") ? null
				: new SimpleDateFormat(DATE_PATTERN).parse(attribs[11]));
		setAnsId(Integer.parseInt(attribs[12]));
		setGameType(Integer.parseInt(attribs[13]));
		setNumPlayers(Integer.parseInt(attribs[14]));
		setTestDate(attribs[15] == null || attribs[15].equalsIgnoreCase("NULL") ? null
				: new SimpleDateFormat(TEST_DATE_PATTERN).parse(attribs[15]));
		setQuesSetId(Integer.parseInt(attribs[16]));
	}

	private void setTags(String[] strTags) {
		tags = new int[strTags.length];
		for (int i = 0; i < strTags.length; i++)
			tags[i] = Integer.parseInt(strTags[i]);
	}

	public boolean isCorrect() {
		return correct;
	}

	public void setCorrect(boolean correct) {
		this.correct = correct;
	}

	public int getOutcome() {
		return outcome;
	}

	public void setOutcome(int outcome) {
		this.outcome = outcome;
	}

	public long getUserID() {
		return userID;
	}

	public void setUserID(long userID) {
		this.userID = userID;
	}

	public long getQuesID() {
		return quesID;
	}

	public void setQuesID(long quesID) {
		this.quesID = quesID;
	}

	public int getQuesType() {
		return quesType;
	}

	public void setQuesType(int quesType) {
		this.quesType = quesType;
	}

	public int getGroupName() {
		return groupName;
	}

	public void setGroupName(int groupName) {
		this.groupName = groupName;
	}

	public int getTrackName() {
		return trackName;
	}

	public void setTrackName(int trackName) {
		this.trackName = trackName;
	}

	public int getSubtrackName() {
		return subtrackName;
	}

	public void setSubtrackName(int subtrackName) {
		this.subtrackName = subtrackName;
	}

	public int[] getTags() {
		return tags;
	}

	public void setTags(int[] tags) {
		this.tags = tags;
	}

	public Date getStartedAt() {
		return startedAt;
	}

	public void setStartedAt(Date startedAt) {
		this.startedAt = startedAt;
	}

	public Date getAnsweredAt() {
		return answeredAt;
	}

	public void setAnsweredAt(Date answeredAt) {
		this.answeredAt = answeredAt;
	}

	public Date getDeactivatedAt() {
		return deactivatedAt;
	}

	public void setDeactivatedAt(Date deactivatedAt) {
		this.deactivatedAt = deactivatedAt;
	}

	public int getAnsId() {
		return ansId;
	}

	public void setAnsId(int ansId) {
		this.ansId = ansId;
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

	public Date getTestDate() {
		return testDate;
	}

	public void setTestDate(Date testDate) {
		this.testDate = testDate;
	}

	public int getQuesSetId() {
		return quesSetId;
	}

	public void setQuesSetId(int quesSetId) {
		this.quesSetId = quesSetId;
	}

}
