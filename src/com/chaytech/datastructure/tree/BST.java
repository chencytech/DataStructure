package com.chaytech.datastructure.tree;

import java.util.Comparator;

/**
 * 二叉搜索树
 *
 * @author Chency
 * @email chaytech@163.com
 * @Date 2021/06/08 16:03
 */
public class BST<E> extends BinaryTree<E> {

    private Comparator<E> comparator;

    public BST() {
        comparator = null;
    }

    public BST(Comparator<E> comparator) {
        this.comparator = comparator;
    }


    public boolean contains(E element) {
        return node(element) != null;
    }

    /**
     * 比较元素
     *
     * @param e1
     * @param e2
     * @return 如果返回0代表相等;如果返回1代表e1大于e2;如果返回-1代表e1小于e2
     */
    private int compare(E e1, E e2) {
        if (comparator != null) {
            return comparator.compare(e1, e2);
        }

        return ((Comparable<E>) e1).compareTo(e2);
    }

    /**
     * 添加元素
     *
     * @param element
     */
    public void add(E element){
        checkElementNotNull(element);

        Node<E> newNode = createNode(element);
        if (root == null) { // 如果根节点为空
            root = newNode;

            // 添加节点之后的处理
            afterAdd(newNode);
            return;
        }

        Node<E> parent = null;
        Node<E> current = root;
        for(;;){
            parent = current;
            int compareResult = this.compare(element, current.element);
            if (compareResult == 0) {
                // 如果相等覆盖掉原有的值
                parent.element = element;
                break;
            }

            newNode.parent = parent;
            if (compareResult > 0) {
                current = current.right;
                if (current == null) {
                    parent.right = newNode;
                    break;
                }
            } else if (compareResult < 0){
                current = current.left;
                if (current == null) {
                    parent.left = newNode;
                    break;
                }
            }
        }

        size++;
        // 添加节点之后的处理
        afterAdd(newNode);
    }

    public void remove(E element) {
        remove(node(element));
    }

    private void remove(Node<E> node) {
        if (node == null) {
            return;
        }

        // 度为2的节点
        if (node.hasTwoChildren()) {
            // 找到后继节点
            Node<E> successor = getSuccessor(node);
            // 将后继节点的值覆盖到删除节点
            node.element = successor.element;
            // 删除后继节点
            node = successor;
        }

        // 删除node节点（node的度必然是1或0）
        Node<E> replaceNode = node.left != null ? node.left : node.right;

        if (replaceNode != null) { // 度为1的节点
            // 将删除节点的parent指向后继节点的parent
            replaceNode.parent = node.parent;
            if (replaceNode.parent == null) { // 度为1的节点并且是跟节点
                root = replaceNode;
            } else if (node == replaceNode.parent.left) {
                replaceNode.parent.left = replaceNode;
            } else {
                replaceNode.parent.right = replaceNode;
            }
        } else if (node.parent == null) { // node是叶子节点并且是根节点
            root = null;
        } else { // node是叶子节点，但不是根节点
            // 判断删除节点是父节点的左叶子节点还是右叶子节点
            if (node == node.parent.left) {
                node.parent.left = null;
            } else {
                node.parent.right = null;
            }

        }

        size--;
    }
    private Node<E> node(E element){
        if (element == null) {
            return null;
        }
        Node<E> node = root;
        while (node != null) {
            int compare = compare(element, node.element);
            if (compare == 0) {
                return node;
            }
            if (compare > 0) {
                node = node.right;
            }  else {
                node = node.left;
            }
        }
        return null;
    }

    protected void afterAdd(Node<E> node) {

    }

    private void checkElementNotNull(E element) {
        if (element == null) {
            throw new IllegalArgumentException("element must not be null");
        }
    }

}
