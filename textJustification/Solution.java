package textJustification;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	public List<String> fullJustify(String[] words, int maxWidth) {
		List<String> output = new ArrayList<String>();
		int formatStart;
		int formatEnd = 0;
		int length;
		length = 0;
		formatStart = 0;
		for (int i = 0; i < words.length; i++) {
			boolean isStartWord = false;
			if (length == 0)
				isStartWord = true;
			length += words[i].length();
			if (!isStartWord)
				length++; // at least a space between two words
			if (length > maxWidth) {
				formatEnd = i - 1;
				format(formatStart, formatEnd, maxWidth, words, output);
				formatStart = i;
				length = 0;
				i--;
			}

		}
		format(formatStart, words.length - 1, maxWidth, words, output);
		return output;
	}

	private void format(int formatStart, int formatEnd, int maxWidth,
			String[] words, List<String> output) {
		StringBuilder outputBuilder = new StringBuilder();
		
		if (formatStart == formatEnd || formatEnd == words.length - 1) {
			for (int i = formatStart; i <= formatEnd; i++) {
				if (!(i == formatStart)) outputBuilder.append(" ");
				outputBuilder.append(words[i]);
			}
			int spaceNum = maxWidth - outputBuilder.length();
			for (int i = 0; i < spaceNum; i++) {
				outputBuilder.append(" ");
			}
		} else {
			int wordNum = formatEnd - formatStart + 1;
			int wordsLength = 0;
			for (int i = formatStart; i <= formatEnd; i++) {
				wordsLength += words[i].length();
			}
			int spaceNum = (maxWidth - wordsLength) / (wordNum - 1);
			int spaceNumModule = (maxWidth - wordsLength) % (wordNum - 1);
			boolean isStartWord = true;
			for (int i = formatStart; i <= formatEnd; i++) {
				if (i == formatStart)
					isStartWord = true;
				else
					isStartWord = false;
				if (!isStartWord) {
					for (int j = 0; j < spaceNum; j++) {
						outputBuilder.append(" ");
					}
					if (spaceNumModule > 0) {
						outputBuilder.append(" ");
						spaceNumModule--;
					}
				}
				outputBuilder.append(words[i]);
			}
		}
		output.add(outputBuilder.toString());
	}

}