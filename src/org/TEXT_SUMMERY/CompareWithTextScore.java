package org.TEXT_SUMMERY;

import java.util.Comparator;

import org.rankingModel.TextRankingModel;

public class CompareWithTextScore implements Comparator<TextRankingModel> {

	public int compare(TextRankingModel textScore, TextRankingModel nextTextScore) {
		return nextTextScore.getTextScore()-textScore.getTextScore();
	}

}
