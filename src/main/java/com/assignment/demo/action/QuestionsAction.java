package com.assignment.demo.action;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.assignment.demo.entity.Questions;

public abstract class QuestionsAction {

	public static List<String> createArrayListFromString(String str) {
		List<String> strList = new ArrayList<>();
		if (str != null) {
			String[] strSplit = str.split(",");
			strList = Arrays.asList(strSplit);
		}
		return strList;
	}

	public static String createStringFromList(List<String> strList) {
		String answer = null;
		if (strList != null && !strList.isEmpty()) {
			for (String str : strList) {
				if (answer == null) {
					answer = "";
				}
				answer += str;
				if (strList.get(strList.size() - 1) != str) {
					answer += ',';
				}
			}
		}
		return answer;
	}

	public static Integer getRangeHappiness(Questions response, Integer happiness) {
		if (response.getAns() != null && !response.getAns().isEmpty()) {
			List<String> strList = createArrayListFromString(response.getAns());
			if (Integer.parseInt(strList.get(0)) >= 5 && Integer.parseInt(strList.get(0)) <= 9) {
				happiness += 2;
			} else if (Integer.parseInt(strList.get(0)) > 9 && Integer.parseInt(strList.get(0)) <= 14) {
				happiness += 3;
			} else if (Integer.parseInt(strList.get(0)) > 14 && Integer.parseInt(strList.get(0)) <= 19) {
				happiness += 4;
			} else if (Integer.parseInt(strList.get(0)) > 19) {
				happiness += 5;
			}
		}
		return happiness;
	}

	public static Integer getRadioHappiness(Questions response, Integer happiness) {
		if (response.getAns() != null && !response.getAns().isEmpty()) {
			List<String> strList = createArrayListFromString(response.getAns());
			if (strList.get(0).equals("Extremely Dissatisfied")) {
				happiness -= 5;
			} else if (strList.get(0).equals("Very Dissatisfied")) {
				happiness -= 3;
			} else if (strList.get(0).equals("Somewhat Dissatisfied")) {
				happiness -= 2;
			} else if (strList.get(0).equals("Somewhat Satisfied")) {
				happiness += 1;
			} else if (strList.get(0).equals("Extremely Satisfied")) {
				happiness += 2;
			}
		}
		return happiness;
	}

	public static Integer getCheckboxHappiness(Questions response, Integer happiness) {
		if (response.getAns() != null && !response.getAns().isEmpty()) {
			List<String> strList = createArrayListFromString(response.getAns());
			if (strList.size() <= 1) {
				happiness += 2;
			} else if (strList.size() > 1 && strList.size() <= 3) {
				happiness += 1;
			} else if (strList.size() > 3 && strList.size() <= 5) {
				happiness -= 1;
			} else if (strList.size() > 5 && strList.size() <= 7) {
				happiness -= 2;
			} else if (strList.size() > 7 && strList.size() <= 8) {
				happiness -= 3;
			} else if (strList.size() >= 9) {
				happiness -= 4;
			}
		}
		return happiness;
	}

	public static Integer getSelectHappiness(Questions response, Integer happiness) {
		if (response.getAns() != null && !response.getAns().isEmpty()) {
			List<String> strList = createArrayListFromString(response.getAns());
			if (strList.get(0).equals("YES")) {
				happiness += 3;
			} else if (strList.get(0).equals("NO")) {
				happiness -= 3;
			}
		}
		return happiness;
	}
}
