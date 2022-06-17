//Time Complexity O(K+Q)Average length of word or query string
//Space Complexity O(N*k) N words K average length 
//Leetcode tested

public class StreamChecker {
    class TrieNode{
        TrieNode[] children;
        boolean isEnd;
        public TrieNode(){
            children = new TrieNode[26];
        }
    }
    TrieNode root;
    StringBuilder sb;
    public void insert(String word){
        TrieNode cur = root;
        for (int i = word.length()-1; i >=0 ; i--) {
            char c = word.charAt(i);
            if(cur.children[c - 'a'] == null){
                cur.children[c - 'a'] = new TrieNode();
            }
            cur = cur.children[c - 'a'];
        }
        cur.isEnd = true;
    }
    public StreamChecker(String[] words) {
        root = new TrieNode();
        sb = new StringBuilder();
        for (String word :words)  insert(word);
    }

    public boolean query(char letter) {
        sb.append(letter);
        TrieNode curr = root;
        for (int i = sb.length()-1; i >=0 ; i--) {
            char c = sb.charAt(i);
            if(curr.children[c - 'a'] == null) return false;
            if(curr.children[c - 'a'].isEnd) return true;
            curr = curr.children[c - 'a'];
        }
        return false;
    }
}
