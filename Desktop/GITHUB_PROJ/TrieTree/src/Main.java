import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final String red = "\u001B[31m";
        final String blue = "\u001B[34m";
        final String purple = "\u001B[35m";
        final String yellow = "\u001B[33m";

        System.out.println(yellow+"Commands:\nadd [word]\ndelete [word]\nsearch [word]\ncontains [word]");
        Scanner sc = new Scanner(System.in);
        TrieTree tree = new TrieTree();
        while (true){
            String input = sc.nextLine();
            if(input.startsWith("add ")){
                tree.insert(input.replaceFirst("add ",""));
                System.out.println(blue+"Done!");
            }
            else if(input.startsWith("delete ")){
                tree.deleteWord(input.replaceFirst("delete ",""));
                System.out.println(blue+"Done!");
            }
            else if(input.startsWith("contains ")){
                System.out.println(purple+tree.searchWord(input.replaceFirst("contains ","")));
            }
            else if(input.startsWith("search")){
                ArrayList<String> words = tree.suggestedWord(input.replaceFirst("search ",""));
                for(String word : words){
                    System.out.println(word);
                }
            }
            else{
                System.out.println(red+"Wrong input");
            }
        }
    }
}
