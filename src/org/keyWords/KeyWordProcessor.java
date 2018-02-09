package org.keyWords;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Scanner;

public class KeyWordProcessor {



	public static Dictionary<String, Boolean> KeyWordDictionary() {
		scanner = KeyWordFactory.readKeyWord();
		Dictionary<String, Boolean> keyWords = new Hashtable<String, Boolean>();
		while (scanner.hasNext()) {
			String word = scanner.next();
			keyWords.put(word, true);
		}
		scanner.close();
		return keyWords;

	}

	private static Scanner scanner;
}
