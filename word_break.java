class Solution {
public boolean recursive(String s, List<String> wordDict, StringBuilder sb, int index) {

    if (sb.toString().equals(s)) return true;

    if (sb.length() > s.length()) return false;

    for (int i = index; i < wordDict.size(); i++) {

        int len = sb.length();          

        sb.append(wordDict.get(i));     

        if (recursive(s, wordDict, sb, i + 1)) {
            return true;
        }

        sb.delete(len, sb.length());    
    }

    return false;
}
    public boolean wordBreak(String s, List<String> wordDict) {
        // Your code goes here
        StringBuilder sb=new StringBuilder();
        return recursive(s,wordDict,sb,0);
    }
}
