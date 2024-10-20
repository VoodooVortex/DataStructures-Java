public class BinaryTree {
    static class node{
        Object data;
        node left;
        node right;
        int height;

        node(Object data){
            this.data = data;
            this.left = null;
            this.right = null;
            height = 0;
        }

        boolean isLeaf(){
            return left == null && right == null;
        }
    }

    node root;
    BinaryTree(){
        root = null;
    }



    //pre-order
    int findHeight(node curr){
        if (curr == null) return 0;
        return curr.height;
    }

    int getBalanceHeight(node curr){
        if (curr == null) return 0;
        return 1 + Math.max(getBalanceHeight(curr.left), getBalanceHeight(curr.right));
    }

    //post-order
    boolean isFullBinaryTree(node leaf){
        if (leaf == null) return true;

        if (leaf.isLeaf()) return true;

        if (leaf.left != null && leaf.right != null){
            return isFullBinaryTree(leaf.left) && isFullBinaryTree(leaf.right);
        }

        return false;
    }

    //
    boolean isBalancedBinaryTree(node leaf){
        if (leaf == null) return true;

        int df = Math.abs(getBalanceHeight(leaf.left) - getBalanceHeight(leaf.right));

        return df <= 1 && isBalancedBinaryTree(leaf.left) && isBalancedBinaryTree(leaf.right);
    }

    node left_Rotate(node root){
        if (root == null || root.right == null) return root;
        node branch = root.right;
        root.right = branch.left;
        branch.left = root;
        root.height = 1 + Math.max(findHeight(root.left), findHeight(root.right));
        branch.height = 1 + Math.max(findHeight(branch.left), findHeight(branch.right));
        return branch;
    }

    node right_Rotate(node root){
        if (root == null || root.left == null) return root;
        node branch = root.left;
        root.left = branch.right;
        branch.right = root;
        root.height = 1 + Math.max(findHeight(root.left), findHeight(root.right));
        branch.height = 1 + Math.max(findHeight(branch.left), findHeight(branch.right));
        return branch;
    }

    node left_right_Rotate(node root){
        root.left = left_Rotate(root.left);
        return right_Rotate(root);
    }

    node right_left_Rotate(node root){
        root.right = right_Rotate(root.right);
        return left_Rotate(root);
    }

    void insert(Object value){
        root = addTree(root, value);
    }

    int getBalanceFactor(node leaf){
        if(leaf == null) return 0;
        return findHeight(leaf.left) - findHeight(leaf.right);
    }

    node addTree(node leaf, Object v){
        if (leaf == null) return new node(v);
        if (Integer.parseInt((String) leaf.data) > Integer.parseInt((String) v)) {
            leaf.left = addTree(leaf.left, v);
        }else if (Integer.parseInt((String) leaf.data) < Integer.parseInt((String) v)) {
            leaf.right = addTree(leaf.right, v);
        }else {
            return root;
        }

        leaf.height = 1 + Math.max(findHeight(leaf.left), findHeight(leaf.right));

        int balance = getBalanceFactor(leaf);

        if (balance > 1 && Integer.parseInt((String) leaf.left.data) > Integer.parseInt((String) v)){
            return right_Rotate(leaf);
        }
        if (balance < -1 && Integer.parseInt((String) leaf.right.data) < Integer.parseInt((String) v)){
            return left_Rotate(leaf);
        }
        if (balance > 1 && Integer.parseInt((String) leaf.left.data) < Integer.parseInt((String) v)){
            return left_right_Rotate(leaf);
        }
        if (balance < -1 && Integer.parseInt((String) leaf.right.data) > Integer.parseInt((String) v)){
            return right_left_Rotate(leaf);
        }

        return leaf;
    }

    node minValue (node r){
        node curr = r;
        while (curr.left != null) {
            curr = curr.left;
        }
        return curr;
    }

    void delete(Object value){
        root = deleteNode(root, value);
    }

    node deleteNode(node r, Object v){
        if (r == null) return r;

        if (Integer.parseInt((String) r.data) > Integer.parseInt((String) v)){
            r.left = deleteNode(r.left, v);
        }else if (Integer.parseInt((String) r.data) < Integer.parseInt((String) v)){
            r.right = deleteNode(r.right, v);
        }else {
            if (r.left == null || r.right == null){
                node temp = r.left != null ? r.left : r.right;
                if (temp == null){
                    r = null;
                }else {
                    r = temp;
                }
            }else {
                node temp = minValue(r.right);
                r.data = temp.data;
                r.right = deleteNode(r.right, temp.data);
            }
        }

        if (r == null) return r;

        r.height = 1 + Math.max(findHeight(r.left), findHeight(r.right));

        int balance = getBalanceFactor(r);

        if (balance > 1 && getBalanceFactor(r.left) >= 0){
            return right_Rotate(r);
        }
        if (balance < -1 && getBalanceFactor(r.right) <= 0){
            return left_Rotate(r);
        }
        if (balance > 1 && getBalanceFactor(r.left) < 0){
            return left_right_Rotate(r);
        }
        if (balance < -1 && getBalanceFactor(r.right) > 0){
            return right_left_Rotate(r);
        }

        return r;
    }


    void printPreOrder(node leaf){
        if(leaf == null) return;
        System.out.print(leaf.data + " ");
        printPreOrder(leaf.left);
        printPreOrder(leaf.right);
    }

    void printInOrder(node leaf){
        if(leaf == null) return;
        printInOrder(leaf.left);
        System.out.print(leaf.data + " ");
        printInOrder(leaf.right);
    }

    void printPostOrder(node leaf){
        if(leaf == null) return;
        printPostOrder(leaf.left);
        printPostOrder(leaf.right);
        System.out.print(leaf.data + " ");
    }

    boolean search(Object value){
        return searchD(root,value);
    }

    boolean searchD(node root, Object v){
        if (root == null) return false;
        if (root.equals(v)){
            return true;
        }
        return searchD(root.right, v) || searchD(root.left, v);
    }

    void destroyTree(node leaf){
        if (leaf == null) return;
        // find left
        if (leaf.left != null) {
            destroyTree(leaf.left);
            // process
            leaf.left = null;
        }
        // find right
        if (leaf.right != null) {
            destroyTree(leaf.right);
            // process
            leaf.right = null;
        }
        // set root is null
        if(root.isLeaf()){
            root = null;
        }
    }
}