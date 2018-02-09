package org.rankingModel;

public class TextRankingModel {
	private int textScore;
	private String sentence;
	private int lineNo;

	public TextRankingModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TextRankingModel(String sentence,int lineNo, int textScore) {
		super();
		this.textScore = textScore;
		this.sentence = sentence;
		this.lineNo = lineNo;
	}

	public int getLineNo() {
		return lineNo;
	}

	public void setLineNo(int lineNo) {
		this.lineNo = lineNo;
	}

	public int getTextScore() {
		return textScore;
	}

	public void setTextScore(int textScore) {
		this.textScore = textScore;
	}

	public String getSentence() {
		return sentence;
	}

	public void setSentence(String sentence) {
		this.sentence = sentence;
	}

	@Override
	public String toString() {
		return "TextRankingModel [textScore=" + textScore + ", sentence=" + sentence + ", lineNo=" + lineNo + "]";
	}



}
