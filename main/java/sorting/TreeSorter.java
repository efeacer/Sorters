package sorting;

public class TreeSorter extends Sorter {

    private class BSTNode {
        int data;
        BSTNode left;
        BSTNode right;

        BSTNode(int data, BSTNode left, BSTNode right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    private int idx;

    public void sort(int[] arr) {
        BSTNode root = null;
        for (int item: arr)
            root = insertToBST(item, root);
        idx = 0;
        inOrderTraversal(arr, root);
    }

    private BSTNode insertToBST(int data, BSTNode sub) {
        if (sub == null)
            return new BSTNode(data, null, null);
        else if (data < sub.data)
            sub.left = insertToBST(data, sub.left);
        else
            sub.right = insertToBST(data, sub.right);
        return sub;
    }

    private void inOrderTraversal(int[] arr, BSTNode sub) {
        if (sub != null) {
            inOrderTraversal(arr, sub.left);
            arr[idx++] = sub.data;
            inOrderTraversal(arr, sub.right);
        }
    }
}