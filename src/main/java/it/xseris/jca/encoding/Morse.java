package it.xseris.jca.encoding;

import java.util.HashMap;
import java.util.Map;

public class Morse {

	private static Map<Character, String> encode = new HashMap<Character, String>() {
		private static final long serialVersionUID = 1L;
		{
			put('a', "._");
			put('b', "_...");
			put('c', "_._.");
			put('d', "_..");
			put('e', ".");
			put('f', ".._.");
			put('g', "__.");
			put('h', "....");
			put('i', "..");
			put('j', ".___");
			put('k', "_._");
			put('l', "._..");
			put('m', "__");
			put('n', "_.");
			put('o', "___");
			put('p', ".__.");
			put('q', "__._");
			put('r', "._.");
			put('s', "...");
			put('t', "_");
			put('u', ".._");
			put('v', "..._");
			put('w', ".__");
			put('x', "_.._");
			put('y', "_.__");
			put('z', "__..");

			put('0', "_____");
			put('1', ".____");
			put('2', "..___");
			put('3', "...__");
			put('4', "...._");
			put('5', ".....");
			put('6', "_....");
			put('7', "__...");
			put('8', "___..");
			put('9', "____.");

			put('.', "._._._");
			put(',', "__..__");
			put(':', "___...");
			put('?', "..__..");
			put('=', "_..._");
			put('-', "_...._");
			put('(', "_.__.");
			put(')', "_.__._");
			put('@', ".__._.");
			put('!', "_._.__");

		}
	};

	private static Map<String, Character> decode = new HashMap<String, Character>() {
		private static final long serialVersionUID = 1L;
		{
			put("._", 'a');
			put("_...", 'b');
			put("_._.", 'c');
			put("_..", 'd');
			put(".", 'e');
			put(".._.", 'f');
			put("__.", 'g');
			put("....", 'h');
			put("..", 'i');
			put(".___", 'j');
			put("_._", 'k');
			put("._..", 'l');
			put("__", 'm');
			put("_.", 'n');
			put("___", 'o');
			put(".__.", 'p');
			put("__._", 'q');
			put("._.", 'r');
			put("...", 's');
			put("_", 't');
			put(".._", 'u');
			put("..._", 'v');
			put(".__", 'w');
			put("_.._", 'x');
			put("_.__", 'y');
			put("__..", 'z');

			put("_____", '0');
			put(".____", '1');
			put("..___", '2');
			put("...__", '3');
			put("...._", '4');
			put(".....", '5');
			put("_....", '6');
			put("__...", '7');
			put("___..", '8');
			put("____.", '9');

			put("._._._", '.');
			put("__..__", ',');
			put("___...", ':');
			put("..__..", '?');
			put("_..._", '=');
			put("_...._", '-');
			put("_.__.", '(');
			put("_.__._", ')');
			put(".__._.", '@');
			put("_._.__", '!');

		}
	};

	/**
	 * Encode the text using Morse Code.
	 * 
	 * @param Text
	 *            The input text
	 * @return The output
	 */
	public static String encode(String text) {
		StringBuilder ret = new StringBuilder();
		text = text.toLowerCase();
		for (char c : text.toCharArray()) {
			if (encode.containsKey(c)) {
				ret.append(encode.get(c) + " ");
			} else {
				ret.append(" ");
			}
		}
		return ret.toString().trim();
	}

	/**
	 * Encode the text using Morse Code.
	 * 
	 * @param text
	 *            The input text
	 * @param dot
	 *            The char representing the dot
	 * @param line
	 *            The char representing the line
	 * @return The output
	 */
	public static String encode(String text, String dot, String line) {
		return encode(text).replace(".", dot).replace("_", line);
	}

	/**
	 * Decode the text using Morse Code.
	 * 
	 * @param Text
	 *            The input text
	 * @return The output
	 */
	public static String decode(String text) {
		StringBuilder ret = new StringBuilder();
		String[] textArr = text.split(" ");
		for (String elem : textArr) {
			if (decode.containsKey(elem)) {
				ret.append(decode.get(elem));
			} else {
				ret.append(" ");
			}
		}
		return ret.toString();
	}

	/**
	 * Decode the text using Morse Code.
	 * 
	 * @param text
	 *            The input text
	 * @param dot
	 *            The char representing the dot
	 * @param line
	 *            The char representing the line
	 * @return The output
	 */
	public static String decode(String text, String dot, String line) {
		text = text.replace(dot, ".").replace(line, "_");
		return decode(text);
	}

}
