/*
 * Author: April Bollinger
 * Date: 3/8/2021 
 * Program: Binary Tree
 * This file is to be used with the BinaryTree.java file
 */

// The Testing is in the BinaryTree.java file.
public class RedBlackTreeNode {

    // Setting up the data and the child nodes
    int number;
    int color;
    RedBlackTreeNode left;
    RedBlackTreeNode right;
    RedBlackTreeNode parent;
	RedBlackTreeNode root;

    // Giving the variables their starting values
    RedBlackTreeNode() {
        // Had to switch to primitive char type so that the operators <,>, and = would
        // work.
        int number = 0;
        int color = 1;
        left = null;
        right = null;
        parent = null;

    }

    // Constructors.
    public void construct(RedBlackTreeNode Left, RedBlackTreeNode right, int number) {
        this.right = right;
        this.left = left;
        this.parent = parent;
        this.number = number;
        this.color = color;
    }

}