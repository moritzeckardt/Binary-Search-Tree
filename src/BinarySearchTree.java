// Namen: Paul Rodemers 22573550, Moritz Eckardt 22878595

import java.util.List;
import java.util.NoSuchElementException;

public class BinarySearchTree implements BSTInterface {
    // Inner class tree node
    private static class TreeNode {
        // Properties
        int value;
        TreeNode left;
        TreeNode right;
        TreeNode parent;

        // Constructor
        public TreeNode(int value) {
            this.value = value;
        }
    }

    // Properties
    TreeNode root;

    // Methods
    @Override
    public void clear() {

    }

    @Override
    public boolean exists(int value) {
        return existsRecursive(value, root);
    }

    private boolean existsRecursive(int value, TreeNode toCheck) {
        // We are at the end of the tree
        if (toCheck == null) {
            return false;
        }

        // We have found a node with the right value
        if (value == toCheck.value) {
            return true;
        }

        // Compare tree nodes and get next node
        TreeNode newToCheck = (value < toCheck.value) ? toCheck.left : toCheck.right;

        // Call recursive
        return existsRecursive(value, newToCheck);
    }

    @Override
    public void insert(int value) throws ElementExistsException {
        // Call function
        insertRecursive(value, root, null);
    }

    private void insertRecursive(int value, TreeNode toCheck, TreeNode parent) throws ElementExistsException {
        // Check if null
        if (toCheck == null) {
            toCheck = new TreeNode(value);
            toCheck.parent = parent;
            return;
        }

        // Check if value already exists
        if (value == toCheck.value) {
            throw new ElementExistsException("Element does already exist");
        }

        // Compare tree nodes and find spot
        TreeNode newToCheck = (value < toCheck.value) ? toCheck.left : toCheck.right;

        // Call recursive
        insertRecursive(value, newToCheck, toCheck);
    }

    @Override
    public void remove(int value) throws NoSuchElementException {

    }

    @Override
    public List<Integer> inOrderList() {
        return null;
    }

    @Override
    public List<Integer> preOrderList() {
        return null;
    }

    @Override
    public List<Integer> postOrderList() {
        return null;
    }

    // Main
    public static void main(String[] args) {

    }
}
