package leetcode;

import java.util.HashMap;

class Trie {
    boolean contain;
    HashMap<Character,Trie> subTree;

    /** Initialize your data structure here. */
    public Trie() {
        contain = false;
        subTree = new HashMap<>();
    }


    /** Inserts a word into the trie. */
    public void insert(String word) {
        if(word.length() == 0) return;
        else if(word.length() == 1){
            Trie trie = subTree.getOrDefault(word.charAt(0),new Trie());
            trie.contain = true;
            this.subTree.put(word.charAt(0),trie);
        }else {
            Trie trie = subTree.getOrDefault(word.charAt(0),new Trie());
            trie.insert(word.substring(1));
            this.subTree.put(word.charAt(0),trie);
        }
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        if(word.length() == 0) return contain;
        Trie t = subTree.get(word.charAt(0));
        if(t != null) return t.search(word.substring(1));
        else return false;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        if(prefix.length() == 0) return true;
        Trie t = subTree.get(prefix.charAt(0));
        if(t != null) return t.startsWith(prefix.substring(1));
        else return false;
    }
}
public class le208 {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");

        System.out.println(trie.search("apple"));   // 返回 true
        System.out.println(trie.search("app")); // 返回 false
        System.out.println(trie.startsWith("app"));// 返回 true
        trie.insert("app");
        System.out.println(trie.search("app"));// 返回 true
        System.out.println(trie.search("apple"));// true
        System.out.println();
    }

}
