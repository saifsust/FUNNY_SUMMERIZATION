package org.TEXT_RANKING;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.List;

import org.keyWords.KeyWordProcessor;
import org.rankingModel.TextRankingModel;
import org.text_extraction.ExtractionProcessor;
import org.text_extraction.StringProcessor;

public class TextRanking {
	private static int textScore;
	private static final int FIRST_LINE_SCORE = 1000;
	private static final int LAST_LINE_SCORE = 70;
	private static final int QUOTATION_SCORE = 40;

	public static List<TextRankingModel> getRankedText() {

		Dictionary<String, Boolean> dictionary = KeyWordProcessor.KeyWordDictionary();
		List<String> textList = ExtractionProcessor.getAllSentences();
		List<TextRankingModel> rankedText = new ArrayList<TextRankingModel>();
		rankedText.clear();

		boolean found = false;
		for (int i = 0; i < textList.size(); i++) {
			textScore = 0;
			if (i == 0) {
				textScore = FIRST_LINE_SCORE;
			} else if (i == textList.size() - 1) {
				textScore = LAST_LINE_SCORE;
			} else {
				textScore += StringProcessor.getSentenceQuotationWeight(textList.get(i));
				if (found)
					textScore += 2 * QUOTATION_SCORE;
				if (textScore == 40) {
					textScore *= 2;
					if (found == false)
						found = true;
					else
						found = false;
				}
				textScore += StringProcessor.getSentenceKeyWordWeight(textList.get(i), dictionary);

			}

			// System.out.println(textScore);
			rankedText.add(new TextRankingModel(textList.get(i), i, textScore));
		}
		textList.clear();

		return rankedText;
	}

}
