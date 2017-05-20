package com.artigile.day23;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by ibahdanau on 5/19/17.
 */
public class Solution {

    private static Queue<Node> traverseQueue = new ArrayDeque<>();

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        Node root = null;
        while (T-- > 0) {
            int data = sc.nextInt();
            root = insert(root, data);
        }
        levelOrder(root);
    }

    static void levelOrder(Node root) {
        //Write your code here

        System.out.print(root.data + " ");
        if (root.left != null) {
            traverseQueue.add(root.left);
        }
        if (root.right != null) {
            traverseQueue.add(root.right);
        }

        while (!traverseQueue.isEmpty()) {
            Node node = traverseQueue.poll();
            levelOrder(node);
        }
    }

    public static Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        } else {
            Node cur;
            if (data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }
}
