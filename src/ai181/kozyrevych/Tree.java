package ai181.kozyrevych;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

class Tree<T extends Comparable<T>> {
    private Node<T> root = null;

    private List<T> printValues = new ArrayList<>();

    public void add(T... val) {
        for (T t : val) {
            _add(root, t);
        }
    }

    private void _add(Node<T> node, T val) {
        if (root == null) {
            root = new Node<>(val);
        } else if (val.compareTo(node.val) < 0) {
            if (node.leftNode == null) {
                node.leftNode = new Node<>(val);
            } else {
                _add(node.leftNode, val);
            }
        } else if (val.compareTo(node.val) > 0) {
            if (node.rightNode == null) {
                node.rightNode = new Node<>(val);
            } else {
                _add(node.rightNode, val);
            }
        }
    }

    public boolean search(T val) {
        return _search(root, val);
    }

    private boolean _search(Node<T> node, T val) {
        if (node == null) {
            return false;
        }

        switch (val.compareTo(node.val)) {
            case -1:
                return _search(node.leftNode, val);
            case 1:
                return _search(node.rightNode, val);
            case 0:
                return true;
        }
        return false;
    }

    public List<T> traversal() {
        printValues.clear();
        if (root != null) {
            _traversal(root);
        }
        return printValues;
    }

    private void _traversal(Node<T> node) {
        Queue<Node<T>> queue = new ArrayDeque<>();
        queue.offer(node);

        while (!queue.isEmpty()) {
            Node<T> queueNode = queue.poll();
            printValues.add(queueNode.val);

            if (queueNode.leftNode != null) {
                queue.offer(queueNode.leftNode);
            }

            if (queueNode.rightNode != null) {
                queue.offer(queueNode.rightNode);
            }
        }
    }

    public void remove(T val) {
        _remove(root, val);
    }

    public Node<T> _remove(Node<T> node, T val) {
        if (node == null) {
            return null;
        }

        if (val.compareTo(node.val) > 0) {
            node.rightNode = _remove(node.rightNode, val);
        } else if (val.compareTo(node.val) < 0) {
            node.leftNode = _remove(node.leftNode, val);
        } else {
            if (node.rightNode == null && node.leftNode == null) {
                node = null;
            } else if (node.rightNode == null) {
                node.val = getRightNode(node);
                node.leftNode = _remove(node.leftNode, node.val);
            } else {
                node.val = getLeftNodeOfRightNode(node);
                node.rightNode = _remove(node.rightNode, node.val);
            }
        }
        return node;
    }

    private T getLeftNodeOfRightNode(Node<T> node) {
        node = node.rightNode;

        while (node.leftNode != null) {
            node = node.leftNode;
        }
        return node.val;
    }

    private T getRightNode(Node<T> node) {
        node = node.leftNode;

        while (node.rightNode != null) {
            node = node.rightNode;
        }
        return node.val;
    }

    public StringBuilder toString(StringBuilder prefix, boolean isTail, StringBuilder sb, Node<T> root) {
        //prefix - времененное хранилище для одной строки дерева
        //sb постоянное хранилище для всех строк (то есть sb это совокупность префиксов)
        //если tail = true, то добавляем горизонтальную линию, в ином случае добавляем пробелы к prefix
        if (root.rightNode != null) {
            toString(new StringBuilder().append(prefix).append(isTail ? "│   " : "    "), false, sb, root.rightNode);
        }
        sb.append(prefix).append(isTail ? "└── " : "┌── ").append(root.val.toString()).append("\n");
        if (root.leftNode != null) {
            toString(new StringBuilder().append(prefix).append(isTail ? "    " : "│   "), true, sb, root.leftNode);
        }
        return sb;
    }

    @Override
    public String toString() {
        if (root == null) {
            return "";
        }
        return this.toString(new StringBuilder(), true, new StringBuilder(), root).toString();
    }


    private class Node<T> {
        private Node<T> leftNode = null;
        private Node<T> rightNode = null;
        private T val;

        public Node(T val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    '}';
        }
    }

}






