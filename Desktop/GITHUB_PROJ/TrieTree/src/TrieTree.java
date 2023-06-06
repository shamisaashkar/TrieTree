import java.util.ArrayList;

public class TrieTree {
    private TrieNode root = new TrieNode();

    public void insert(String word) {
        TrieNode current = root;
        int length = word.length();
        int level;
        int index = 0;

        for (level = 0; level < length; level++) {
            index = word.charAt(level) - ' ';
            if (current.children[index] == null)
                current.children[index] = new TrieNode();

            current = current.children[index];
        }


        current.isEnd = true;
    }

    public void deleteWord(String word) {
        TrieNode trieNode = findNode(word);
        trieNode.isEnd = false;
    }

    public boolean searchWord(String word) {
        TrieNode trieNode = findNode(word);
        if(trieNode == null)
            return false;
        return trieNode.isEnd;
    }

    private TrieNode findNode(String word){
        TrieNode current = root;
        int level;
        int length = word.length();
        int index;

        for (level = 0; level < length; level++) {
            index = word.charAt(level) - ' ';

            if (current.children[index] == null)
                return null;

            current = current.children[index];
        }

        return current;
    }

    public ArrayList<String> suggestedWord(String word) {
        TrieNode current = findNode(word);
        if(current == null){
            return new ArrayList<>();
        }

        ArrayList<String> list = new ArrayList<>();
        findWordsFromNode(word, current, list);
        return list;
    }

    private void findWordsFromNode(String word, TrieNode current, ArrayList<String> list) {
        if (current.isEnd) {
            list.add(word);
        }
        for (int i = 0; i < current.children.length; i++) {
            if (current.children[i] != null) {
                findWordsFromNode(word + (char) (' ' + i), current.children[i], list);
            }
        }
    }
}
