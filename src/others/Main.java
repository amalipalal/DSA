package others;

public class Main {
    public static void main(String[] args) {
        System.out.println(findFirstNonRepeatingLetter(String.join("", args)));
    }

    public static String reverseString(String input) {
        StringBuilder reversedString = new StringBuilder();
        for (int index = input.length() - 1; index >= 0 ; index--) {
            reversedString.append(input.charAt(index));
        }
        return reversedString.toString();
    }

    public static String reverseSentence(String sentence) {
        String[] sentenceArray = sentence.split(" ");
        StringBuilder reversedSentence = new StringBuilder();

        for (int index = sentenceArray.length - 1; index >= 0; index--) {
            reversedSentence.append(sentenceArray[index]).append(" ");
        }

        return reversedSentence.toString().trim();
    }

    public static boolean isPalindrome(String word) {
        String lowerCaseWord = word.toLowerCase();
        int wordLength = word.length();
        int lastIndex = wordLength - 1;

        for (int index = 0; index <= wordLength / 2 ; index++) {
            if (word.charAt(index) != word.charAt(lastIndex - index)) {
                return false;
            }
        }
        return true;
    }

    public static String removeWhiteSpaces(String word) {
        StringBuilder builder = new StringBuilder();
        for (char character: word.toCharArray()) {
            if (character == ' ') { continue; }
            builder.append(character);
        }
        return builder.toString();
    }

    public static String removeAllWhiteSpaces(String word) {
        return word.replaceAll("\\s+", "");
    }

    public static char findFirstNonRepeatingLetter(String word) {
        word = word.toLowerCase();
        int[] alphabets = new int[26];
        char[] wordCharacters = word.toCharArray();

        for (char character : wordCharacters) {
            alphabets[character - 'a']++;
        }

        for (char character : wordCharacters) {
            if (alphabets[character - 'a'] == 1) {
                return character;
            }
        }

        return '\0';
    }

    public static String findMaximumOccuringLetter(String word) {
        word = word.toLowerCase();
        int[] letterCount = new int[26];
        char[] wordCharacters = word.toCharArray();

        for (char character : wordCharacters) {
            letterCount[character - 'a']++;
        }

        return "";
    }
}

class MiniMain {

    private final String className;

    public MiniMain(String className) {
        this.className = className;
    }

    public String getClassName() {return this.className;}
}
