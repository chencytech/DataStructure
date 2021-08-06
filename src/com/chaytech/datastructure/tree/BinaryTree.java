package com.chaytech.datastructure.tree;

import com.chaytech.datastructure.tree.printer.BinaryTreeInfo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树
 *
 * @author Chency
 * @email chaytech@163.com
 * @Date 2021/06/09 21:32
 */
public class BinaryTree<E> implements BinaryTreeInfo {

    protected int size;
    protected Node<E> root;

    public int size() {
        return size;
    }

    public int isEmpty() {
        return size = 0;
    }

    public void clear() {
        root = null;
    }

    /**
     * 前序遍历
     *
     * 先访问根节点，在遍历左子树，在遍历右子树
     *
     * @return
     */
    public List<E> preOrderTraversal(){
        List<E> result = new ArrayList<>();
        preOrderTraversal(result,root);
        return result;
    }
    private List<E> preOrderTraversal(List<E> result, Node<E> node) {
        if (node != null) {
            result.add(node.element);
            preOrderTraversal(result,node.left);
            preOrderTraversal(result,node.right);
        }
        return result;
    }

    /**
     * 中序遍历
     *
     * 先遍历左子树，再遍历跟节点，然后遍历右子树，
     * 得到的结果是升序的，从小到大排列
     *
     * @return
     */
    public List<E> inOrderTraversal(){
        List<E> result = new ArrayList<>();
        inOrderTraversal(result, root);
        return result;
    }
    private List<E> inOrderTraversal(List<E> result, Node<E> node){
        if (node != null) {
            inOrderTraversal(result, node.left);
            result.add(node.element);
            inOrderTraversal(result, node.right);
        }
        return result;
    }

    /**
     * 后序遍历
     *
     * 先遍历左子树，再遍历跟节点，然后遍历右子树，
     *
     * @return
     */
    public List<E> postOrderTraversal(){
        List<E> result = new ArrayList<>();
        postOrderTraversal(result, root);
        return result;
    }
    private List<E> postOrderTraversal(List<E> result, Node<E> node){
        if (node != null) {
            postOrderTraversal(result, node.left);
            postOrderTraversal(result, node.right);
            result.add(node.element);
        }
        return result;
    }

    /**
     * 后序遍历
     *
     * 从上往下，从左往右依次遍历每个节点
     *
     * @return
     */
    public List<E> levelOrderTraversal(){
        List<E> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<Node<E>> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node<E> node = queue.poll();
            result.add(node.element);
            if (node.left != null) {
                queue.offer(node.left);
            }

            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return result;
    }

    /**
     * 获取指定节点的前驱节点
     *
     * 中序遍历时的前一个节点
     *
     * @return
     */
    protected Node<E> getPredecessor(Node<E> node){
        if (node == null) {
            return null;
        }
        // 前驱节点在左子树当中（left.right.right.....）
        Node<E> p = node.left;
        if (p != null) {
            while (p.right != null) {
                p = p.right;
            }
            return p;
        } else {
            // 如果没找到则从父节点中找前驱节点
            while (node.parent != null && node == node.parent.left) {
                node = node.parent;
            }
        }

        /**
         * 存在两种情况：
         *  1.node.parent == null 则代表没有前驱节点直接返回null
         *  2.node == node.parent.right 如果当前节点是父节点的右子树则父节点是前驱节点
         */
        return node.parent;
    }

    /**
     * 获取指定节点的后继节点
     *
     * 中序遍历时的后一个节点
     *
     * @param node
     * @return
     */
    protected Node<E> getSuccessor(Node<E> node){
        if (node == null) {
            return null;
        }
        // 前驱节点在左子树当中（right.left.left.....）
        Node<E> p = node.right;
        if (p != null) {
            while (p.left != null) {
                p = p.left;
            }
            return p;
        } else {
            // 如果没找到则从父节点中找前驱节点
            while (node.parent != null && node == node.parent.right) {
                node = node.parent;
            }
        }

        /**
         * 存在两种情况：
         *  1.node.parent == null 则代表没有前驱节点直接返回null
         *  2.node == node.parent.left 如果当前节点是父节点的左子树则父节点是前驱节点
         */
        return node.parent;
    }

    /**
     * 树的节点
     * @param <E>
     */
    protected class Node<E> {
        E element;
        Node<E> left;
        Node<E> right;
        Node<E> parent;

        public Node(E element) {
            this.element = element;
        }

        /**
         * 是否叶子节点
         *
         * @return
         */
        public boolean isLeaf(){
            return left == null && right == null;
        }

        /**
         * 是否度为2
         *
         * @return
         */
        public boolean hasTwoChildren() {
            return left != null && right != null;
        }

        /**
         * 是否是左子节点
         *
         * @return
         */
        public boolean isLeftChild() {
            return parent != null && this == parent.left;
        }

        /**
         * 是否是右子节点
         *
         * @return
         */
        public boolean isRightChild() {
            return parent != null && this == parent.right;
        }
    }

    /**
     * 创建节点
     *
     * @param element
     * @return
     */
    protected Node<E> createNode(E element) {
        return new Node<E>(element);
    }

    @Override
    public Object root() {
        return root;
    }

    @Override
    public Object left(Object node) {
        return ((Node<E>) node).left;
    }

    @Override
    public Object right(Object node) {
        return ((Node<E>) node).right;
    }

    @Override
    public Object string(Object node) {
        return ((Node<E>) node).element;
    }
}
