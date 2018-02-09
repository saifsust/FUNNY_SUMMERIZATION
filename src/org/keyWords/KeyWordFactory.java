package org.keyWords;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class KeyWordFactory {
	private final String KEY_WORD_FILE = "DATA_SET/KEY_WORD.txt";

	private KeyWordFactory() {
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

	private static KeyWordFactory instance = new KeyWordFactory();
	private Scanner scanner;
	private BufferedReader buffered;
	private FileReader reader;
}
