package edu.train.chapter1;

public class WordSpliter {
	
	public static int splitWord(String word) {
		String[] splitWords = word.split(" ");
		return splitWords.length;
	}
	
	public static void main(String[] args) {
		String word = "Hello I love Java";
		int length = splitWord(word);
		System.out.println(word + "的单词个数是：" + length);
	}
}
