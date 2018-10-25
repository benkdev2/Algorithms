import com.sun.source.tree.Tree;
import org.hamcrest.core.IsSame;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IsSameTreeTest {

    IsSameTree sameTree;
    TreeNode leftTree;
    TreeNode rightTree;

    @BeforeEach
    void setUp() {
        sameTree = new IsSameTree();
        leftTree = new TreeNode(1);
        rightTree = new TreeNode(1);
    }

    @Test
    void allLeftNodesTest() {
        leftTree.left = new TreeNode(2);
        leftTree.left.left = new TreeNode(-1);
        leftTree.left.left.left = new TreeNode(5);
        rightTree.left = new TreeNode(2);
        rightTree.left.left = new TreeNode(-1);
        rightTree.left.left.left = new TreeNode(5);
        boolean expected = true;
        boolean actual = sameTree.isSameTree(leftTree, rightTree);
        assertEquals(expected, actual, "Expected " + expected + " but was " + actual);
    }

    @Test
    void unequalChildNodesTest() {
        leftTree.left = new TreeNode(2);
        leftTree.right = new TreeNode(3);
        leftTree.left.left = new TreeNode(-1);
        leftTree.left.left.left = new TreeNode(5);
        rightTree.left = new TreeNode(2);
        rightTree.right = new TreeNode(3);
        rightTree.left.left = new TreeNode(9);
        rightTree.left.left.left = new TreeNode(5);
        boolean expected = false;
        boolean actual = sameTree.isSameTree(leftTree, rightTree);
        assertEquals(expected, actual, "Expected " + expected + " but was " + actual);
    }

    @Test
    void unequalRootNodesTest() {
        leftTree.val = 2;
        leftTree.left = new TreeNode(2);
        leftTree.right = new TreeNode(3);
        leftTree.left.left = new TreeNode(-1);
        leftTree.left.left.left = new TreeNode(5);
        rightTree.left = new TreeNode(2);
        rightTree.right = new TreeNode(3);
        rightTree.left.left = new TreeNode(-1);
        rightTree.left.left.left = new TreeNode(5);
        boolean expected = false;
        boolean actual = sameTree.isSameTree(leftTree, rightTree);
        assertEquals(expected, actual, "Expected " + expected + " but was " + actual);
    }

    @Test
    void unequalFurthestChildNodes() {
        leftTree.left = new TreeNode(2);
        leftTree.right = new TreeNode(3);
        leftTree.left.left = new TreeNode(-1);
        leftTree.right.right = new TreeNode(5);
        leftTree.left.left.left = new TreeNode(7);
        rightTree.left = new TreeNode(2);
        rightTree.right = new TreeNode(3);
        rightTree.left.left = new TreeNode(-1);
        rightTree.right.right = new TreeNode(5);
        rightTree.left.left.left = new TreeNode(4);
        boolean expected = false;
        boolean actual = sameTree.isSameTree(leftTree, rightTree);
        assertEquals(expected, actual, "Expected " + expected + " but was " + actual);
    }

    @Test
    void nullRootNodesTest() {
        leftTree = null;
        rightTree = null;
        boolean expected = true;
        boolean actual = sameTree.isSameTree(leftTree, rightTree);
        assertEquals(expected, actual, "Expected " + expected + " but was " + actual);
    }

    @Test
    void oneNullRootNodeTest() {
        leftTree = null;
        boolean expected = false;
        boolean actual = sameTree.isSameTree(leftTree, rightTree);
        assertEquals(expected, actual, "Expected " + expected + " but was " + actual);
    }

    @Test
    void nullInTreeTest() {
        leftTree.left = new TreeNode(2);
        leftTree.right = new TreeNode(3);
        leftTree.left.left = null;
        rightTree.left = new TreeNode(2);
        rightTree.right = new TreeNode(3);
        rightTree.left.left = null;
        boolean expected = true;
        boolean actual = sameTree.isSameTree(leftTree, rightTree);
        assertEquals(expected, actual, "Expected " + expected + " but was " + actual);
    }
}