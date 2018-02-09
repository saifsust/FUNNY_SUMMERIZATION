package org.text_extraction;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class PassageReadFactory {
	private final String KEY_WORD_FILE = "DATA_SET/PASSAGE.txt";

	private PassageReadFactory() {
		try {

			reader = new FileReader(KEY_WORD_FILE);
			buffered = new BufferedReader(reader);
			scanner = new Scanner(buffered);

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	public static Scanner readKeyWord() {
		return instance.scanner;

	}

	private static PassageReadFactory instance = new PassageReadFactory();
	private Scanner scanner;
	private BufferedReader buffered;
	private FileReader reader;


}
