package ai181.kozyrevych;

import java.util.*;

public class Tree<T extends Comparable<T>> {
    private Tree<T> leftNode = null;
    private Tree<T> rightNode = null;
    private T val;
    List<T> printValues = new ArrayList<>();

    public Tree(T val) {
        this.val = val;
    }

    public void add(T... val) {
        for (T t : val) {
            _add(t);
        }
    }

    private void _add(T val) {
        if (val.compareTo(this.val) < 0) {
            if (this.leftNode == null) {
                this.leftNode = new Tree<>(val);
            } else {
                this.leftNode.add(val);
            }
        } else if (val.compareTo(this.val) > 0) {
            if (this.rightNode == null) {
                this.rightNode = new Tree<>(val);
            } else {
                this.rightNode.add(val);
            }
        }
    }

    public boolean search(T val) {
        return _search(this, val);
    }

    private boolean _search(Tree<T> node, T val) {
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
        _traversal(this);
        return printValues;
    }

    private void _traversal(Tree<T> node) {
        Queue<Tree<T>> queue = new ArrayDeque<>();
        queue.offer(node);

        while (!queue.isEmpty()) {
            Tree<T> queueNode = queue.poll();
            printValues.add(queueNode.val);

            if (queueNode.leftNode != null) {
                queue.offer(queueNode.leftNode);
            }

            if (queueNode.rightNode != null) {
                queue.offer(queueNode.rightNode);
            }
        }
    }

    public StringBuilder toString(StringBuilder prefix, boolean isTail, StringBuilder sb) {
        //prefix - времененное хранилище для одной строки дерева
        //sb постоянное хранилище для всех строк (то есть sb это совокупность префиксов)
        //если tail = true, то добавляем горизонтальную линию, в ином случае добавляем пробелы к prefix
        if (rightNode != null) {
            rightNode.toString(new StringBuilder().append(prefix).append(isTail ? "│   " : "    "), false, sb);
        }
        sb.append(prefix).append(isTail ? "└── " : "┌── ").append(val.toString()).append("\n");
        if (leftNode != null) {
            leftNode.toString(new StringBuilder().append(prefix).append(isTail ? "    " : "│   "), true, sb);
        }
        return sb;
    }

    @Override
    public String toString() {
        return this.toString(new StringBuilder(), true, new StringBuilder()).toString();
    }

}






