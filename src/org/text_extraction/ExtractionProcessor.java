package org.text_extraction;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.List;
import java.util.Scanner;

public class ExtractionProcessor {
    /**** score value ******/

	private static final int NUMARIC_SCORE=10;
	private static final int QUOTATION_SCORE=20;
	private static final int KEY_WORD_SCORE=12;


	private static String temp;

	public static int getNumericValue(String sentence, Dictionary<String, Boolean> dictionary) {

		temp = "";
		for (int i = 0; i < sentence.length(); i++) {
			if(sentence.charAt(i)==',')continue;
			if (Character.isDigit(sentence.charAt(i)))
				return NUMARIC_SCORE;
			if (sentence.charAt(i) == '\'' || sentence.charAt(i) == '"')
				return QUOTATION_SCORE;
			if (sentence.charAt(i) == ' ' || i==sentence.length()-1) {
				//System.out.println(temp);
				if (dictionary.get(temp)!=null ) {
					//System.out.println(temp);
					return KEY_WORD_SCORE;
				}

				temp = "";
				continue;
			}
			temp += sentence.charAt(i);


		}
		return 1;
	}

	public static List<String> getAllSentences() {

        String passage=getPassage();
		List<String> sentencesList = new ArrayList<String>();
		sentencesList.clear();
		temp = "";
		for (int i = 0; i < passage.length(); i++) {
			  //System.out.println(passage.charAt(i));
			if (passage.charAt(i) == '।') {
				sentencesList.add(temp);

				temp = "";
			}
			temp += passage.charAt(i);
		}
		return sentencesList;
	}


	public static String getPassage(){

	    Scanner scanner =PassageReadFactory.readKeyWord();
	    temp="";
	     while(scanner.hasNext()){
           temp+=scanner.nextLine();
	     }
	     scanner.close();

		return temp;
	}

}
