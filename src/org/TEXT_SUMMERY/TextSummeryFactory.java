package org.TEXT_SUMMERY;

import java.util.List;

import org.rankingModel.TextRankingModel;

public class TextSummeryFactory {
	private static String summary = "";
	private static double take = 0.4;

	public static String getSummary() {

		List<TextRankingModel> sortedSentenced = TextSortProcessor.getSortedTextList();
		//System.out.println(sortedSentenced);
		summary = "";
		for (int i = 0; i < sortedSentenced.size(); i++) {
			//System.out.println("Summary");
			summary += sortedSentenced.get(i).getSentence();
		}
		return summary;
	}

}
