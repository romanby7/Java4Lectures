import java.util.ArrayList;
import java.util.Random;

public class Main6 {

    private static final int MAX_TREES = 20;
    private static final int MAX_KEY = 20;
    private static final int MAX_LEVEL_DEPTH = 20;
    private static final Random random = new Random();


    public static void main(String[] args) {
        Tree<Integer> tree = new TreeImpl<>(20);
        tree.add(60);
        tree.add(25);
        tree.add(66);
        tree.add(15);
        tree.add(5);
        tree.add(20);
        tree.add(45);
        tree.add(30);
        tree.add(32);
        tree.add(55);

        tree.display();

        System.out.println(tree.isBalanced());


        System.out.println("Find 60: " + tree.find(60));
        System.out.println("Find 45: " + tree.find(45));
        System.out.println("Find 32: " + tree.find(32));
        System.out.println("Find 666: " + tree.find(666));

        tree.remove(15);
        tree.display();

        ArrayList<Tree<Integer>> trees = getTrees(MAX_TREES, MAX_KEY, MAX_LEVEL_DEPTH);

        int balanced = 0;
        int notBalanced = 0;

        for (Tree<Integer> treeInt : trees) {
            if (treeInt.isBalanced()) {
                balanced++;
                System.out.println("Balanced -------------------------------------------------");
                treeInt.display();
            }
            else {
                notBalanced++;
                System.out.println("Not balanced -------------------------------------------------");
                treeInt.display();
            }
        }

        System.out.println("Balanced trees: " + balanced / (MAX_TREES  / 100.0));
        System.out.println("Not balanced trees: " + notBalanced / (MAX_TREES  / 100.0)) ;


    }


    private static ArrayList<Tree<Integer>> getTrees(int maxTrees, int maxKey, int maxLevelDepth) {
        ArrayList<Tree<Integer>> trees = new ArrayList<>();

        for (int i = 0; i < maxTrees; i++) {
            trees.add(new TreeImpl<>(maxLevelDepth));
            for (int j = 0; j < maxKey / 2; j++) {
                trees.get(i).add(random.nextInt(maxKey));
            }
        }

        return trees;

    }


}
