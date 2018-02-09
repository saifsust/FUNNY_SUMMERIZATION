package org.TEXT_SUMMERY;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.TEXT_RANKING.TextRanking;
import org.rankingModel.TextRankingModel;

public class TextSortProcessor {
	private static final double TAKE_ACCORDINGLY_SCORE = 0.5;
	private static final int LEAST_HIGH_SCORE = 7;

	public static List<TextRankingModel> getSortedTextList() {
		List<TextRankingModel> textList = TextRanking.getRankedText();
		List<TextRankingModel> highScoredList = new ArrayList<TextRankingModel>();
		Collections.sort(textList, new CompareWithTextScore());
		for (int i = 0; i < textList.size(); i++) {
			if (textList.get(i).getTextScore() < LEAST_HIGH_SCORE)
				break;
			//System.out.println();
			highScoredList.add(textList.get(i));
		}
		textList.clear();
		textList = new ArrayList<TextRankingModel>();
		for (int i = 0; i < highScoredList.size() * TAKE_ACCORDINGLY_SCORE; i++) {
			textList.add(highScoredList.get(i));
		}
		highScoredList.clear();
		Collections.sort(textList, new CompareWithLineNo());
		return textList;
	}



}
