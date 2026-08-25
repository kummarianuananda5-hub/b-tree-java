class BTreeNode {

    int[] keys;
    int t;
    BTreeNode[] children;
    int n;
    boolean leaf;

    BTreeNode(int t, boolean leaf) {
        this.t = t;
        this.leaf = leaf;

        keys = new int[2 * t - 1];
        children = new BTreeNode[2 * t];

        n = 0;
    }

    // Traverse the B-Tree
    void traverse() {

        int i;

        for (i = 0; i < n; i++) {

            if (!leaf) {
                children[i].traverse();
            }

            System.out.print(keys[i] + " ");
        }

        if (!leaf) {
            children[i].traverse();
        }
    }

    // Search a key
    BTreeNode search(int key) {

        int i = 0;

        while (i < n && key > keys[i]) {
            i++;
        }

        if (i < n && keys[i] == key) {
            return this;
        }

        if (leaf) {
            return null;
        }

        return children[i].search(key);
    }

    // Insert key into a non-full node
    void insertNonFull(int key) {

        int i = n - 1;

        if (leaf) {

            while (i >= 0 && keys[i] > key) {
                keys[i + 1] = keys[i];
                i--;
            }

            keys[i + 1] = key;
            n++;
        }

        else {

            while (i >= 0 && keys[i] > key) {
                i--;
            }

            i++;

            // If child is full
            if (children[i].n == 2 * t - 1) {

                splitChild(i, children[i]);

                if (keys[i] < key) {
                    i++;
                }
            }

            children[i].insertNonFull(key);
        }
    }

    // Split a child
    void splitChild(int i, BTreeNode fullChild) {

        BTreeNode newChild =
                new BTreeNode(fullChild.t, fullChild.leaf);

        newChild.n = t - 1;

        // Copy keys
        for (int j = 0; j < t - 1; j++) {
            newChild.keys[j] = fullChild.keys[j + t];
        }

        // Copy children
        if (!fullChild.leaf) {

            for (int j = 0; j < t; j++) {
                newChild.children[j] =
                        fullChild.children[j + t];
            }
        }

        fullChild.n = t - 1;

        // Move children
        for (int j = n; j >= i + 1; j--) {
            children[j + 1] = children[j];
        }

        children[i + 1] = newChild;

        // Move keys
        for (int j = n - 1; j >= i; j--) {
            keys[j + 1] = keys[j];
        }

        keys[i] = fullChild.keys[t - 1];

        n++;
    }
}


class BTree {

    BTreeNode root;
    int t;

    BTree(int t) {
        this.t = t;
        root = null;
    }

    // Insert a key
    void insert(int key) {

        // If tree is empty
        if (root == null) {

            root = new BTreeNode(t, true);
            root.keys[0] = key;
            root.n = 1;

            return;
        }

        // If root is full
        if (root.n == 2 * t - 1) {

            BTreeNode newRoot =
                    new BTreeNode(t, false);

            newRoot.children[0] = root;

            newRoot.splitChild(0, root);

            int i = 0;

            if (newRoot.keys[0] < key) {
                i++;
            }

            newRoot.children[i].insertNonFull(key);

            root = newRoot;
        }

        else {
            root.insertNonFull(key);
        }
    }

    // Search
    boolean search(int key) {

        if (root == null) {
            return false;
        }

        return root.search(key) != null;
    }

    // Traversal
    void traverse() {

        if (root != null) {
            root.traverse();
        }
    }


    public static void main(String[] args) {

        // Minimum degree
        BTree tree = new BTree(2);

        // Insert values
        int[] values = {
            10, 20, 5, 6,
            12, 30, 7, 17
        };

        for (int value : values) {
            tree.insert(value);
        }

        // Display B-Tree
        System.out.println("B-Tree traversal:");

        tree.traverse();

        System.out.println();

        // Search
        int key = 12;

        if (tree.search(key)) {
            System.out.println("Key " + key + " found");
        }
        else {
            System.out.println("Key " + key + " not found");
        }
    }
}
