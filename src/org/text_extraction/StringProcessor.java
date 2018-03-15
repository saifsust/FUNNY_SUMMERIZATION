package org.text_extraction;

import java.util.Dictionary;
import java.util.StringTokenizer;

public class StringProcessor {
	private static final int KEY_WORD_SCORE = 30;
	private static final int QUOTATION_SCORE = 60;

	public static int getSentenceKeyWordWeight(String sentence, Dictionary<String, Boolean> dictionary) {
		StringTokenizer token = new StringTokenizer(sentence);
		int keyWordWeight = 0;
		while (token.hasMoreTokens()) {
			String next = token.nextToken();
			if (dictionary.get(next) != null) {
				keyWordWeight += KEY_WORD_SCORE;

			}
		}
		return keyWordWeight;
	}

	public static int getSentenceQuotationWeight(String sentence) {

		int quotation = 0;
		for (int i = 0; i < sentence.length(); i++) {
			if (sentence.charAt(i) == '\"' || sentence.charAt(i) == '‘' || sentence.charAt(i) == '’') {
				quotation += QUOTATION_SCORE;
			}
		}
		return quotation;
	}

}
