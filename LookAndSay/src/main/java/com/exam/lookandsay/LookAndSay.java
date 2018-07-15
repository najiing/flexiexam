package com.exam.lookandsay;

import javax.management.RuntimeErrorException;

/* Define a function LookAndSay as follows 
 *  Read off the digits of the input counting the number of digits in groups of the same digit.
 *  Ex. 
 *  LookAndSay(1) = 11  		Because 1 is read off as one 1 or "11"
 *  LookAndSay(11) = 21 		Because 11 is read off as two 1's or "21"
 *  LookAndSay(21) = 1211 		Because 21 is read off as one 2's then one 1's or "1211"
 *  LookAndSay(1211) = 111221 	Because 1211 is read off as one 1's then 2 one's then two 2's or "111221"
 *  LookAndSay(111221) = 312211	Because 111221 is read off as 3 one's then two 2's then one 1's or "312211"
 *  
 *  We define a "Look and Say" sequence as repeatedly call the "LookAndSay" function on its output.
 *  Given the number "start" and the number of iteration "n", calculate the "nth" number in a "Look and Say"
 *  starting from "start".
 *  
 *  Based from the previous Example.
 *   If the start is "11" and n = 2 LookAndSay("11",2") = 1211 because LookAndSay(LookAndSay(11)) = 1211;
 *   
 *   We will use String representation to avoid Number overflow.
 *   Create the LookAndSay Method defined below and pass all the Unit tests and try to manage possible exceptions.
 */
public class LookAndSay {

	public String LookAndSay(String input, int n) {
		// arguments validation
		if (input == null) {
			throw new NullPointerException("null input not allowed");
		}

		StringBuilder result = new StringBuilder();

		input = input + " "; // for empty/single input
		char temp = input.charAt(0);
		int ctr = 0;

		for (char digit : input.toCharArray()) {
			if (digit != temp) {
				result.append(ctr).append(temp);
				ctr = 1;
				temp = digit;
			} else {
				ctr++;
			}
		}

		if (n == 0) {
			return input.trim();
		} else if (n < 0) {
			throw new IllegalArgumentException("negative n not allowed");
		} else if (n > 1) {
			return LookAndSay(result.toString(), n - 1);
		} else {
			return result.toString().trim();
		}
	}

	public String LookAndSay1(String input, int n) {
		// arguments validation
		if (input == null) {
			throw new NullPointerException("null input not allowed");
		}
		if (n < 0) {
			throw new IllegalArgumentException("negative n not allowed");
		}

		for (int x = 1; x <= n; x++) {
			StringBuilder result = new StringBuilder();
			for (int i = 0; i < input.length(); i++) {
				int ctr = 1;
				for (int j = i + 1; j < input.length(); j++) {
					if (input.charAt(i) == input.charAt(j)) {
						ctr += 1;
						i = j;
					} else {
						i = --j;
						break;
					}
				}
				result.append(ctr + "" + input.charAt(i));
			}
			input = result.toString();
		}

		return input;
	}

}
