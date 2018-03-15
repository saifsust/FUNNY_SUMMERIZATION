package org.TEXT_SUMMERY;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.TEXT_RANKING.TextRanking;
import org.rankingModel.TextRankingModel;

public class TextSortProcessor {
	private static final double TAKE_ACCORDINGLY_SCORE = 0.35;
	private static final int LEAST_HIGH_SCORE = 20;

	public static List<TextRankingModel> getSortedTextList() {
		List<TextRankingModel> textList = TextRanking.getRankedText();
		List<TextRankingModel> highScoredList = new ArrayList<TextRankingModel>();
		Collections.sort(textList, new CompareWithTextScore());
		//System.out.println("Sorted text List");
		for (int i = 0; i < textList.size(); i++) {
			if (textList.get(i).getTextScore() < LEAST_HIGH_SCORE)
				break;
			highScoredList.add(textList.get(i));
			//System.out.println(textList.get(i));
		}
		textList.clear();
		textList = new ArrayList<TextRankingModel>();
	//	System.out.println("Selected Text List");
		for (int i = 0; i < (int) highScoredList.size() * TAKE_ACCORDINGLY_SCORE; i++) {
			textList.add(highScoredList.get(i));
			//System.out.println(highScoredList.get(i));
		}
		highScoredList.clear();
		Collections.sort(textList, new CompareWithLineNo());
		return textList;
	}

}
