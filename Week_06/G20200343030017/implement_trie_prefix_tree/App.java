package week6.implement_trie_prefix_tree;

public class App {
    public static void main(String[] args) {
        String word = "apple";
        Trie obj = new Trie();
        obj.insert(word);
        boolean param_2 = obj.search(word);
        boolean param_3 = obj.search("app");
        System.out.println(param_2);
        System.out.println(param_3);
    }
}
