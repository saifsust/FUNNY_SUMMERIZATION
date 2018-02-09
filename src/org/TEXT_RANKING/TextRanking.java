package org.TEXT_RANKING;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.List;

import org.keyWords.KeyWordProcessor;
import org.rankingModel.TextRankingModel;
import org.text_extraction.ExtractionProcessor;

public class TextRanking {
	private static int textScore;
	private static final int FIRST_LINE_SCORE = 100;
	private static final int LAST_LINE_SCORE = 11;

	public static List<TextRankingModel> getRankedText() {

		Dictionary<String, Boolean> dictionary = KeyWordProcessor.KeyWordDictionary();
		List<String> textList = ExtractionProcessor.getAllSentences();
		List<TextRankingModel> rankedText = new ArrayList<TextRankingModel>();
		rankedText.clear();
		for (int i = 0; i < textList.size(); i++) {
			if (i == 0) {
				textScore = FIRST_LINE_SCORE;
			} else if (i == textList.size() - 1) {
				textScore = LAST_LINE_SCORE;
			} else
				textScore = ExtractionProcessor.getNumericValue(textList.get(i), dictionary);
			rankedText.add(new TextRankingModel(textList.get(i), i, textScore));
		}
		textList.clear();

		return rankedText;
	}

}
