import java.util.Scanner;

/*
*   Author: April Bollinger
*   Date: 3/28/2021
*   Program: Red and Black Binary Tree
*   Purpose: To explore and learn how to implement Red and Black Binary Trees
*   Resources: https://stackoverflow.com/questions/6646467/how-to-find-time-taken-to-run-a-java-program
*              https://github.com/Bibeknam/algorithmtutorprograms/blob/master/data-structures/red-black-trees/RedBlackTree.java
*              https://www.sanfoundry.com/java-program-implement-red-black-tree/
*              https://www.programiz.com/dsa/red-black-tree
*
*   Rules of A Red and Black Binary Tree:
*   1. Every Node is Either Red or Black.
*   2. The Root Node must be Black.
*   3. A Red Node's Children cannot be Red.
*   4. A null Child is Considered to be a Black Leaf Node.
*   5. All Paths from any Node to any Null Leaf descendent must have the same number or Black Nodes.
*
*/

// initializing and declaring everything inside this file.
// It did not want to work right when it was coming from the other file.
class RedBlackTreeNode{
    int number;
    RedBlackTreeNode parent;
    RedBlackTreeNode left;
    RedBlackTreeNode right;
    int color;
}


// Main class.
public class RedAndBlackTree {

    // Creating Variables 
    private RedBlackTreeNode Root;
    private RedBlackTreeNode TNULL;
    

    // Helpers
    private void OrderBeforeHelp(RedBlackTreeNode redBlackTreeNode){
        if(redBlackTreeNode != TNULL){
            System.out.println(redBlackTreeNode.number + " ");
            OrderBeforeHelp(redBlackTreeNode.left);
            OrderBeforeHelp(redBlackTreeNode.right);
        }
    }
    
    private void DuringOrderHelp(RedBlackTreeNode redBlackTreeNode){
        if(redBlackTreeNode != TNULL){
            DuringOrderHelp(redBlackTreeNode.left);
            System.out.println(redBlackTreeNode.number + " ");
            DuringOrderHelp(redBlackTreeNode.right);
        }
    }

    private void OrderAfterHelp(RedBlackTreeNode redBlackTreeNode){
        if(redBlackTreeNode != TNULL){
            OrderAfterHelp(redBlackTreeNode.left);
            OrderAfterHelp(redBlackTreeNode.right);
            System.out.println(redBlackTreeNode.number + " ");
        }
    }


    // Searching the Binary Tree.
    private RedBlackTreeNode SearchTree(RedBlackTreeNode redBlackTreeNode, int UserNumber, long start) {
        int i = 0;
        i++;
        long Start = System.nanoTime();
        if (redBlackTreeNode == TNULL || UserNumber == redBlackTreeNode.number) { // ERROR
            System.out.println("The number you entered was found in the Binary tree.");
            long End = System.nanoTime();
            long total = Start - End;
            System.out.println("It took " + total + " nanoseconds to find it or " + i + " interation(s).");
            return redBlackTreeNode;
        }
        if (UserNumber < redBlackTreeNode.number) {
            return SearchTree(redBlackTreeNode.left, UserNumber, Start);
        } else {
            return SearchTree(redBlackTreeNode.right, UserNumber, Start); // ERROR
        }
    }

    // Fixing the Tree so that it meets the requirements for a Red and Black Binary Tree.
    private void InsertionFix(RedBlackTreeNode redBlackTreeNode) {
        RedBlackTreeNode n;
        while (redBlackTreeNode.parent.color == 1) {
            if (redBlackTreeNode.parent == redBlackTreeNode.parent.parent.right) {
                n = redBlackTreeNode.parent.parent.left;
                if (n.color == 1) {
                    n.color = 0;
                    redBlackTreeNode.parent.color = 0;
                    redBlackTreeNode.parent.parent.color = 1;
                    redBlackTreeNode = redBlackTreeNode.parent.parent;
                } else {
                    if (redBlackTreeNode == redBlackTreeNode.parent.left) {
                        redBlackTreeNode = redBlackTreeNode.parent;
                        rotateRight(redBlackTreeNode);
                    }
                    redBlackTreeNode.parent.color = 0;
                    redBlackTreeNode.parent.parent.color = 1;
                    rotateLeft(redBlackTreeNode.parent.parent);
                }
            } else {
                n = redBlackTreeNode.parent.parent.right;
                if (n.color == 1) { 
                    n.color = 0;
                    redBlackTreeNode.parent.color = 0;
                    redBlackTreeNode.parent.parent.color = 1;
                    redBlackTreeNode = redBlackTreeNode.parent.parent;

                } else {
                    if (redBlackTreeNode == redBlackTreeNode.parent.right) {
                        redBlackTreeNode = redBlackTreeNode.parent;
                        rotateLeft(redBlackTreeNode);
                    }
                    redBlackTreeNode.parent.color = 0;
                    redBlackTreeNode.parent.parent.color = 1;
                    rotateRight(redBlackTreeNode.parent.parent);
                }
            }
            if (redBlackTreeNode == Root) {
                break;
            }
        }
        Root.color = 0;
    }

   
    // Setting more Variables.
    public RedAndBlackTree() {
        TNULL = new RedBlackTreeNode();
        TNULL.color = 0;
        TNULL.left = null;
        TNULL.right = null;
        Root = TNULL;
    }


    // Methods that Call the Helpers and make it possible to call them without a bunch of parameters.
    public void OrderBefore(){
        OrderBeforeHelp(this.Root);
    }

    public void DuringOrder(){
        DuringOrderHelp(this.Root);
    }
    
    public void OrderAfter(){
        OrderAfterHelp(this.Root);
    }

    public RedBlackTreeNode Searcher(int k, long start) {
        return SearchTree(this.Root, k, start);
    }

    // Rotating the nodes to the left to meet the requirments.
    public void rotateLeft(RedBlackTreeNode x) {
        RedBlackTreeNode y = x.right;
        x.right = y.left;
        if (y.left != TNULL) {
            y.left.parent = x;

        }

        y.parent = x.parent;
        if (x.parent == null) {
            this.Root = y;
        } else if (x == x.parent.left) {
            x.parent.right = y;
        } else {
            x.parent.right = y;

        }
        y.left = x;
        x.parent = y;
    }

    // Rotating to the Right.
    public void rotateRight(RedBlackTreeNode x) {
        RedBlackTreeNode y = x.left;
        x.left = y.right;
        if (y.right != TNULL) {
            y.right.parent = x;

        }
        y.parent = x.parent;
        if (x.parent == null) {
            this.Root = y;

        } else if (x == x.parent.right) {
            x.parent.right = y;
        } else {
            x.parent.left = y;
        }
        y.right = x;
        x.parent = y;

    }

    // Inserting the nodes.
    public void InsertNode(int currentNum){
        RedBlackTreeNode redBlackTreeNode = new RedBlackTreeNode();

        redBlackTreeNode.parent = null;
        redBlackTreeNode.number = currentNum;
        redBlackTreeNode.left = TNULL;
        redBlackTreeNode.right = TNULL;
        redBlackTreeNode.color = 1;

        RedBlackTreeNode y = null;
        RedBlackTreeNode x = this.Root;

        while(x != TNULL){
            y = x;
            if(redBlackTreeNode.number < x.number){
                x = x.left;

            }else {
                x = x.right;

            }
        }

        redBlackTreeNode.parent = y;
        if(y == null){
            Root = redBlackTreeNode;

        }else if(redBlackTreeNode.number < y.number){
            y.left = redBlackTreeNode;
        }else{
            y.right = redBlackTreeNode;
        }

        if(redBlackTreeNode.parent == null){
            redBlackTreeNode.color = 0;
            return;
        }

        if(redBlackTreeNode.parent.parent == null){
            return;
        }

        // Calling the Fixer.
        InsertionFix(redBlackTreeNode);

    }

    // Another Helper/Constructor
    public RedBlackTreeNode getRoot(){
        return this.Root;
    }
   
    // Searching the Array
    public static void SearchArray(int[] RandArray, int UserNumber, int c) { // Doesn't want to work
        long Starttime = System.nanoTime();
        int i = 0;
        while(i < c){
            if(UserNumber == RandArray.length){
                long Endtime = System.nanoTime();
                long totaltime = Endtime - Starttime;
                System.out.println("The number you enter was found. ");
                System.out.print("It took " + totaltime + "nanoseconds or " + i + " interation(s). ");
            }
        }
        System.out.println("I'm Sorry, but the number you enterd was not in the array.");
    }
   
    // The Main Method.
    public static void main(String[] args) {
        RedAndBlackTree tree = new RedAndBlackTree();
        int UserNumber = 0;
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter a number you would like to search for. ");
        UserNumber = scan.nextInt();
        int currentNum = 0;
        // Variable for the length of the array so it is easier to use.
        int c = 100000;
        int temp = 0;
        int[] RandArray = new int[c];
        for(int i = 0; i < RandArray.length; i++){
            temp = (int)(Math.random() * 10586);
            // Comment this out so you don't end up with 100,000 sentences.
            System.out.println( temp + " was inserted");
            RandArray[i] = temp;
        }


        for (int a = 0; a < RandArray.length; a++) {
            currentNum = RandArray[a];
            tree.InsertNode(currentNum);
        }
        // Can't get it to call method.
        tree.Searcher(UserNumber, temp);
        SearchArray(RandArray, UserNumber, c);

    }

}