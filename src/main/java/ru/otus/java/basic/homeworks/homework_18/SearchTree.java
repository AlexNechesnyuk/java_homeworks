package ru.otus.java.basic.homeworks.homework_18;

import java.util.ArrayList;
import java.util.List;

public class SearchTree<T extends Comparable<T>> {
    private final Node<T> root;

    private static class Node<T> {
        T current;
        Node<T> less;
        Node<T> more;
    }

    private Node<T> buildTree(List<T> elements, int start, int end) {
        if (start == end)
            return null;
        Node<T> node = new Node<>();
        int middle = (start + end) / 2;
        node.current = elements.get(middle);
        node.less = buildTree(elements, start, middle);
        node.more = buildTree(elements, middle + 1, end);
        return node;
    }

    public SearchTree(List<T> elements) {
        root = buildTree(elements, 0, elements.size());
    }

    public T find(T element) {
        return find(element, root);
    }

    private T find(T element, Node<T> node) {
        int compare = element.compareTo(node.current);
        if (compare == 0) {
            return element;
        }
        if (compare > 0) {
            return node.more == null ? null : find(element, node.more);
        }
        return node.less == null ? null : find(element, node.less);
    }

    private void fillArrayRecursive(Node<T> node, List<T> list) {
        if (node == null)
            return;
        if (node.less != null)
            fillArrayRecursive(node.less, list);
        list.add(node.current);
        if (node.more != null)
            fillArrayRecursive(node.more, list);
    }

    public List<T> getSortedList() {
        List<T> out = new ArrayList<>();
        fillArrayRecursive(root, out);
        return out;
    }


}
