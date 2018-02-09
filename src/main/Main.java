package main;

import java.util.Dictionary;
import java.util.List;

import javax.swing.border.EtchedBorder;
import javax.swing.plaf.BorderUIResource.EtchedBorderUIResource;

import org.TEXT_RANKING.TextRanking;
import org.TEXT_SUMMERY.TextSortProcessor;
import org.TEXT_SUMMERY.TextSummeryFactory;
import org.keyWords.KeyWordProcessor;
import org.rankingModel.TextRankingModel;
import org.text_extraction.ExtractionProcessor;

public class Main {

	public static void main(String[] args) {

		// System.out.println(ExtractionProcessor.getPassage());
		// List<TextRankingModel>list =TextRanking.getRankedText();
		/*
		 * for(int i=0;i<list.size();i++){ System.out.println(list.get(i)); }
		 */
		/*
		 * List<TextRankingModel> list = TextSortProcessor.getSortedTextList();
		 * for (int i = 0; i < list.size(); i++) {
		 * System.out.println(list.get(i)); }
		 */

		System.out.println("================== text summary===========");
		System.out.println(TextSummeryFactory.getSummary());

	}

}
