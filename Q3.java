import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MinimumMaximumTreeDistance2D {
    static class Tree {
        int x;
        int y;
        
        Tree(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public static int findMinMaxDistance(List<Tree> trees) {
        trees.sort(Comparator.comparingInt(tree -> tree.x)); // Sort by x-coordinate
        
        int n = trees.size();
        int minMaxDistance = Integer.MAX_VALUE;
        
        for (int i = 1; i < n; i++) {
            Tree leftTree = trees.get(i - 1);
            Tree rightTree = trees.get(i);
            
            int distance = (rightTree.x - leftTree.x) / 2;  // Cut the tree in the middle
            int newMaxDistance = Math.max(distance, Math.min(leftTree.y, rightTree.y));
            
            minMaxDistance = Math.min(minMaxDistance, newMaxDistance);
        }
        
        return minMaxDistance;
    }
    
    public static void main(String[] args) {
        List<Tree> trees = Arrays.asList(
            new Tree(1, 5),
            new Tree(2, 10),
            new Tree(5, 15),
            new Tree(8, 20),
            new Tree(12, 25)
        );
        
        int minMaxDistance = findMinMaxDistance(trees);
        System.out.println("Minimum Possible Maximum Distance: " + minMaxDistance);
    }
}
