
/*
*   Author: April Bollinger
*   Date: 3/8/2021
*   Program: Binary Tree
*   Purpose: To explore and learn how to implement Binary Trees
*/

// Main class.
public class BinaryTree {

    // Method that will insert the nodes or leaves into the tree.
    public void insertNode(TreeNode node, int randArray) {

        if(randArray < node.Letter){
            if(node.left != null) {
                // If the value is not null it will recursively call until it is null so it can create a new node.
                insertNode(node.left, randArray);
            }

            else{
                // Prints out this statement when a new node is created.
                System.out.println(" added a leaf with the value of " + randArray + " to the left");
                // Adding to the left.
                node.left = new TreeNode();
            }
        }
        if(randArray > node.Letter) {
            if (node.right != null) {
                // Recursive call.
                insertNode(node.right, randArray);
            } else {
                // Statement that tells you when it has added a new node.
                System.out.println(" added a leaf with the value of " + randArray + " to the right");
                // Adding to the right.
                node.right = new TreeNode();
            }
        }
    }


    // Main Method.
    public static void main(String[] args) {
        // Creating the binary tree within this file.
        BinaryTree tree = new BinaryTree();
        // Creating the root of the tree.
        TreeNode root = new TreeNode();
        // A bunch of testing values.
        // They are all greater than the node.Letter value.
        // When you switch the operators, the side the chars will be on will change.
        tree.insertNode(root, 'o');
        tree.insertNode(root, 't');
        tree.insertNode(root, 'i');
        tree.insertNode(root, 'y');
        tree.insertNode(root, 'a');
        tree.insertNode(root, '&');
        tree.insertNode(root, 'G');
        tree.insertNode(root, '6');
        tree.insertNode(root, '/');
        // A print statement to tell me when the operations are finished.
        System.out.println("Those are all of the leaves on the tree.");
    }

}