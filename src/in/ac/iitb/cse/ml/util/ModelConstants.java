package in.ac.iitb.cse.ml.util;

public interface ModelConstants {
	public static final int NUM_ATTRIBUTES = 12;
	public static final String[] ATTRIBUTES = { "id", "ques_id", "ques_type",
			"group", "track", "subtrack", "tag", "time", "game_type",
			"num_players", "ques_set" };
	public static final String CLASS_ATTRIBUTE = "correct";
	public static final String[] CLASS_VALUES = { "0", "1" };
}
