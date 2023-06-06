class TrieNode {
    TrieNode[] children = new TrieNode[90];
    boolean isEnd;

    TrieNode() {
        isEnd = false;
        for (int i = 0; i < 90; i++) {
            children[i] = null;
        }
    }
}