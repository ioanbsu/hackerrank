package com.artigile.day22;

import java.util.Scanner;

/**
 * Created by ibahdanau on 5/19/17.
 */
public class Solution {

    public static int getHeight(Node root) {
        //Write your code here
        int maxHeigthLeft = 0;
        int maxHeigthRight = 0;
        if (root.left != null) {
            maxHeigthLeft = getHeight(root.left) + 1;
        }
        if (root.right != null) {
            maxHeigthRight = getHeight(root.right) + 1;
        }
        return Math.max(maxHeigthLeft, maxHeigthRight);
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

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        Node root = null;
        while (T-- > 0) {
            int data = sc.nextInt();
            root = insert(root, data);
        }
        int height = getHeight(root);
        System.out.println(height);
    }
}
