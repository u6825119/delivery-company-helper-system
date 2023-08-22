class Node {
    Order data;
    Node parent;
    Node left;
    Node right;
    int color;
}

public class RBTree {
    private Node root;
    private Node Null;

    private Order searchTreeHelper(Node node, int id) {
        if (node == Null || id == node.data.getID()) {
            return node.data;
        }
        if (id < node.data.getID()) {
            return searchTreeHelper(node.left, id);
        }
        return searchTreeHelper(node.right, id);
    }

    // Balance the tree after deletion of a node
    private void fixDelete(Node x) {
        Node s;
        while (x != root && x.color == 0) {
            if (x == x.parent.left) {
                s = x.parent.right;
                if (s.color == 1) {
                    s.color = 0;
                    x.parent.color = 1;
                    leftRotation(x.parent);
                    s = x.parent.right;
                }

                if (s.left.color == 0 && s.right.color == 0) {
                    s.color = 1;
                    x = x.parent;
                } else {
                    if (s.right.color == 0) {
                        s.left.color = 0;
                        s.color = 1;
                        rightRotation(s);
                        s = x.parent.right;
                    }

                    s.color = x.parent.color;
                    x.parent.color = 0;
                    s.right.color = 0;
                    leftRotation(x.parent);
                    x = root;
                }
            } else {
                s = x.parent.left;
                if (s.color == 1) {
                    s.color = 0;
                    x.parent.color = 1;
                    rightRotation(x.parent);
                    s = x.parent.left;
                }

                if (s.right.color == 0 && s.right.color == 0) {
                    s.color = 1;
                    x = x.parent;
                } else {
                    if (s.left.color == 0) {
                        s.right.color = 0;
                        s.color = 1;
                        leftRotation(s);
                        s = x.parent.left;
                    }

                    s.color = x.parent.color;
                    x.parent.color = 0;
                    s.left.color = 0;
                    rightRotation(x.parent);
                    x = root;
                }
            }
        }
        x.color = 0;
    }

    private void swapNodes(Node x, Node y) {
        if (x.parent == null)
            root = y;
        else if (x == x.parent.left)
            x.parent.left = y;
        else { x.parent.right = y; }
        y.parent = x.parent;
    }

    private void helper_delete(Node node, int id) {
        Node current = Null;
        Node x, y;
        while (node != Null) {
            if (node.data.getID() == id) {
                current = node;
            }

            if (node.data.getID() <= id) {
                node = node.right;
            } else {
                node = node.left;
            }
        }

        if (current == Null) {
            System.out.println("Couldn't find key in the tree");
            return;
        }

        y = current;
        int Color_y = y.color;
        if (current.left == Null) {
            x = current.right;
            swapNodes(current, current.right);
        } else if (current.right == Null) {
            x = current.left;
            swapNodes(current, current.left);
        } else {
            y = min(current.right);
            Color_y = y.color;
            x = y.right;
            if (y.parent == current) {
                x.parent = y;
            } else {
                swapNodes(y, y.right);
                y.right = current.right;
                y.right.parent = y;
            }

            swapNodes(current, y);
            y.left = current.left;
            y.left.parent = y;
            y.color = current.color;
        }
        if (Color_y == 0) {
            fixDelete(x);
        }
    }


    private void fix_insert(Node k) {
        Node u;
        while (k.parent.color == 1) {
            if (k.parent == k.parent.parent.right) {
                u = k.parent.parent.left;
                if (u.color == 1) {
                    u.color = 0;
                    k.parent.color = 0;
                    k.parent.parent.color = 1;
                    k = k.parent.parent;
                } else {
                    if (k == k.parent.left) {
                        k = k.parent;
                        rightRotation(k);
                    }
                    k.parent.color = 0;
                    k.parent.parent.color = 1;
                    leftRotation(k.parent.parent);
                }
            } else {
                u = k.parent.parent.right;

                if (u.color == 1) {
                    u.color = 0;
                    k.parent.color = 0;
                    k.parent.parent.color = 1;
                    k = k.parent.parent;
                } else {
                    if (k == k.parent.right) {
                        k = k.parent;
                        leftRotation(k);
                    }
                    k.parent.color = 0;
                    k.parent.parent.color = 1;
                    rightRotation(k.parent.parent);
                }
            }
            if (k == root) {
                break;
            }
        }
        root.color = 0;
    }


    public RBTree() {
        Null = new Node();
        Null.color = 0;
        Null.left = null;
        Null.right = null;
        root = Null;
    }


    public Order findByID(int k) {
        return searchTreeHelper(this.root, k);
    }

    //Finds the minimum value in the tree
    public Node min(Node node) {
        while (node.left != Null) {
            node = node.left;
        }
        return node;
    }



    public void leftRotation(Node x) {
        Node y = x.right;
        x.right = y.left;
        if (y.left !=Null) {
            y.left.parent = x;
        }
        y.parent = x.parent;
        if (x.parent == null) {
            this.root = y;
        } else if (x == x.parent.left) {
            x.parent.left = y;
        } else {
            x.parent.right = y;
        }
        y.left = x;
        x.parent = y;
    }

    public void rightRotation(Node x) {
        Node y = x.left;
        x.left = y.right;
        if (y.right != Null) {
            y.right.parent = x;
        }
        y.parent = x.parent;
        if (x.parent == null) {
            this.root = y;
        } else if (x == x.parent.right) {
            x.parent.right = y;
        } else {
            x.parent.left = y;
        }
        y.right = x;
        x.parent = y;
    }

    public void insert(Order key) {
        Node node = new Node();
        node.parent = null;
        node.data = key;
        node.left = Null;
        node.right = Null;
        node.color = 1;

        Node y = null;
        Node x = this.root;

        while (x != Null) {
            y = x;
            if (node.data.getID() < x.data.getID()) {
                x = x.left;
            } else {
                x = x.right;
            }
        }

        node.parent = y;
        if (y == null) {
            root = node;
        } else if (node.data.getID() < y.data.getID()) {
            y.left = node;
        } else {
            y.right = node;
        }

        if (node.parent == null) {
            node.color = 0;
            return;
        }

        if (node.parent.parent == null) {
            return;
        }

        fix_insert(node);
    }


    public void delete(int id) {
        helper_delete(this.root, id);
    }


}







