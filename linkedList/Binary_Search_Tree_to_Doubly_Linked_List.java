/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/

class Solution {
    List<Node> sortedList = new ArrayList<Node>();

    public Node treeToDoublyList(Node root) {
        inorder(root);
        return makeList();

    }

    public Node makeList() {
        Node head = null;
        Node prev = null;
        Node ptr = null;
        if (this.sortedList.size() > 0) {
            for (int i = 0; i < this.sortedList.size(); i++) {
                ptr = new Node(this.sortedList.get(i).val);
                if (head == null) {
                    ptr.left = null;
                    ptr.right = null;
                    head = ptr;
                    prev = ptr;
                } else {
                    ptr.left = prev;
                    prev.right = ptr;
                    ptr.right = null;
                    prev = ptr;
                }

            }
            ptr.right = head;
            head.left = ptr;
            return head;
        }
        return null;

    }

    public void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            this.sortedList.add(root);
            inorder(root.right);
        }
    }
}