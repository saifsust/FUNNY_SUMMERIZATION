package org.text_extraction;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.List;
import java.util.Scanner;

public class ExtractionProcessor {
	/**** score value ******/

	private static String temp;

	public static List<String> getAllSentences() {

		String passage = getPassage();
		List<String> sentencesList = new ArrayList<String>();
		sentencesList.clear();
		temp = "";
		for (int i = 0; i < passage.length(); i++) {
			// System.out.println(passage.charAt(i));
			if (passage.charAt(i) == '।') {
				sentencesList.add(temp);

				temp = "";
			}
			temp += passage.charAt(i);
		}
		return sentencesList;
	}

	public static String getPassage() {

		Scanner scanner = PassageReadFactory.readKeyWord();
		temp = "";
		while (scanner.hasNext()) {
			temp += scanner.nextLine();
		}
		scanner.close();

		return temp;
	}

}
