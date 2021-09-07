/*
 * Author: April Bollinger
 * Date: 3/8/2021 
 * Program: Binary Tree
 * This file is to be used with the BinaryTree.java file
 */


// The Testing is in the BinaryTree.java file.
public class TreeNode {

    // Setting up the data and the child nodes
    char Letter;
    TreeNode left;
    TreeNode right;

    // Giving the variables their starting values
    TreeNode() {
        // Had to switch to primitive char type so that the operators <,>, and = would work.
        int Letter = '\0';
        left = null;
        right = null;

    }

    // Constructors.
    public void construct(TreeNode Left, TreeNode right, char Letter) {
        this.right = right;
        this.left = left;
        this.Letter = Letter;
    }

}