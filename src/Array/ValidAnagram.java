package Array;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {
    public static boolean isAnagram(String s, String t){
        if (s.length() != t.length()){
            return false;
        }
        int[] count = new int[26];
        for(int i=0; i<s.length(); i++){
            count[s.charAt(i) - 'A']++;
            count[t.charAt(i) - 'A']--;
        }
        for(int i=0;i<26;i++){
            if(count[i] !=0){
                return false;
            }
        }
        return true;
    }
    //Question 1: Write a function to determine if two strings are anagrams of each other,
    // but this time consider the strings to be case-insensitive (i.e., 'A' and 'a' should be treated as the same character).
    public static boolean isAnagramCaseSensitive(String s, String t){
        if (s.length() != t.length()){
            return false;
        }
        s = s.toLowerCase();
        t = t.toLowerCase();
        int[] count = new int[26];
        for(int i = 0; i < s.length(); i++){
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }
        for(int i = 0; i < 26; i++){
            if(count[i] != 0){
                return false;
            }
        }
        return true;
    }
    //Question 2: Modify the anagram-checking function to handle strings that may contain spaces and punctuation.
    // For example, "A gentleman" and "Elegant man" should be considered anagrams.
    public static boolean isAnagramWithPunctuation(String s, String t){
        s = s.replaceAll("[^a-zA-Z]", "").toLowerCase();
        t = t.replaceAll("[^a-zA-Z]", "").toLowerCase();
        if (s.length() != t.length()){
            return false;
        }
        int[] count = new int[26];
        for(int i = 0; i < s.length(); i++){
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }
        for(int i = 0; i < 26; i++){
            if(count[i] != 0){
                return false;
            }
        }
        return true;
    }
    //Question 3: Extend the anagram-checking function to work with Unicode characters. For instance,
    public static boolean isAnagramWithUnicode(String s, String t){
        if (s.length() != t.length()){
            return false;
        }
        Map<Character, Integer> count = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            count.put(s.charAt(i), count.getOrDefault(s.charAt(i), 0) + 1);
            count.put(t.charAt(i), count.getOrDefault(t.charAt(i), 0) - 1);
        }
        for(int value : count.values()){
            if(value != 0){
                return false;
            }
        }
        return true;
    }
    public static void countFrequency(String s){
        int[] count = new int[26];
        s=s.toLowerCase();
        for(int i=0;i<s.length();i++){
            if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') { // Ensure only letters are counted
            count[s.charAt(i) - 'a']++;
            }
        }
        for(int i=0;i<26;i++){
            System.out.println((char) (i + 'a') + ": " + count[i]);
        }
    }
    public static void main(String[] args){
        String s="ABS";
        String t="SBA";
        System.out.println(isAnagram(s,t));
        System.out.println(isAnagramCaseSensitive("abc","ABC"));
        System.out.println(isAnagramWithPunctuation("A man degree","an MA degree"));
        System.out.println(isAnagramWithUnicode("ab@gamil.com","b@agmail.com"));
        String st="A brown fox jump right over the lazy dog";
        countFrequency(st);
    }
}
