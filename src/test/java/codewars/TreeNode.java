package codewars;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;
public class TreeNode implements Cloneable{

    TreeNode left;
    TreeNode right;

    public static boolean isPerfect(TreeNode root) {
    	return isPerfectTree(root) && isBalancedLeftSize(root) == isBalancedRightSize(root);
    }

    public static boolean isPerfectTree(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) return true;
        else if (root.left == null || root.right == null) return false;
        return isPerfectTree(root.left) && isPerfectTree(root.right);
    }

    public static int isBalancedLeftSize(TreeNode root) {
    	if (root == null) return 0;
    	else if (root.left == null) return 1;
        return 1+isBalancedLeftSize(root.left);
    }

    public static int isBalancedRightSize(TreeNode root) {
    	if (root == null) return 0;
    	else if (root.right == null) return 1;
        return 1+isBalancedRightSize(root.right);
    }
    
    static TreeNode leaf() {
        return new TreeNode();
    }

    static TreeNode join(TreeNode left, TreeNode right) {
        return new TreeNode().withChildren(left, right);
    }

    TreeNode withLeft(TreeNode left) {
        this.left = left;
        return this;
    }

    TreeNode withRight(TreeNode right) {
        this.right = right;
        return this;
    }

    TreeNode withChildren(TreeNode left, TreeNode right) {
        this.left = left;
        this.right = right;
        return this;
    }

    TreeNode withLeftLeaf() {
        return withLeft(leaf());
    }

    TreeNode withRightLeaf() {
        return withRight(leaf());
    }

    TreeNode withLeaves() {
        return withChildren(leaf(), leaf());
    }
    

    /**
     * null
     */
    @Test
    public void testNullTree() {
        TreeNode root = null;
        assertThat("null tree should be perfect", TreeNode.isPerfect(root), is(true));
    }

    /**
     *   0
     *  / \
     * 0   0
     */
    @Test
    public void testFullOneLevelTree() {
        TreeNode root = TreeNode.leaf().withLeaves();
        assertThat("root with two leaves should be perfect", TreeNode.isPerfect(root), is(true));
    }


    /**
     *   0
     */
    @Test
    public void testOneLeaf() {
        TreeNode root = TreeNode.leaf();
        assertThat("root with single leaf should not be perfect", TreeNode.isPerfect(root), is(true));
    }
    
    /**
     *   0
     *  /
     * 0
     */
    @Test
    public void testOneChildTree() {
        TreeNode root = TreeNode.leaf().withLeftLeaf();
        assertThat("root with single leaf should not be perfect", TreeNode.isPerfect(root), is(false));
    }
    

    /**
     *      0
     *    /   \
     *   0     0
     *  / \   / \
     * 0   0 0   0
     */
    @Test
    public void testFullTwoLevelTree() {
        TreeNode root = TreeNode.leaf().withChildren(TreeNode.leaf().withLeaves(), TreeNode.leaf().withLeaves());
        assertThat("root with two leaves should be perfect", TreeNode.isPerfect(root), is(true));
    }
    
    /**
     *      0
     *    /   \
     *   0     0
     *  / \   
     * 0   0 
     */
    @Test
    public void testFullTwoLevelTreeUnbalanced() {
        TreeNode root = TreeNode.leaf().withChildren(TreeNode.leaf().withLeaves(), TreeNode.leaf());
        assertThat("root with two leaves should be perfect", TreeNode.isPerfect(root), is(false));
    }

    /**
     *      0
     *    /   \
     *   0     0
     *  / \   /
     * 0   0 0 
     */
    @Test
    public void testFullTwoLevelTreeFalse() {
        TreeNode root = TreeNode.leaf().withChildren(TreeNode.leaf().withLeaves(), TreeNode.leaf().withLeftLeaf());
        assertThat("root with two leaves should be perfect", TreeNode.isPerfect(root), is(false));
    }

}
