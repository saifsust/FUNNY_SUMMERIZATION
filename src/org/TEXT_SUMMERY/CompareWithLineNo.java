package org.TEXT_SUMMERY;

import java.util.Comparator;

import org.rankingModel.TextRankingModel;

public class CompareWithLineNo implements Comparator<TextRankingModel> {

	public int compare(TextRankingModel line, TextRankingModel nextLine) {
		return line.getLineNo()-nextLine.getLineNo();
	}


}
