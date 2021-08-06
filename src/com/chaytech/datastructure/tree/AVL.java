package com.chaytech.datastructure.tree;

import java.util.Comparator;

/**
 * 平衡二叉搜索树
 *
 * @author Chency
 * @email chaytech@163.com
 * @Date 2021/06/10 9:13
 */
public class AVL<E> extends BST<E> {

    public AVL() {
    }

    public AVL(Comparator<E> comparator) {
        super(comparator);
    }

    @Override
    protected void afterAdd(Node<E> node) {
        while ((node = node.parent) != null) {
            // 是平衡的
            if (isBalance(node)) {
                // 更新树的高度
                updateHeight(node);
            } else {
                // 恢复平衡
                reBalance(node);
                break;
            }
        }
    }

    @Override
    protected Node<E> createNode(E element) {
        return new AVLNode<E>(element);
    }

    /**
     * 更新高度
     *
     * @param node
     */
    private void updateHeight(Node<E> node) {
        ((AVLNode<E>) node).updateHeight();
    }

    /**
     * 判断节点是否平衡
     *
     * @return
     */
    private boolean isBalance(Node<E> node) {
        return Math.abs(((AVLNode<E>) node).balanceFactor()) <= 1;
    }

    /**
     * 恢复平衡
     *
     * @param node 高度最高不平衡的节点
     */
    private void reBalance(Node<E> node) {

    }
    private class AVLNode<E> extends Node<E> {
        private int height = 1; // 树的高度

        public AVLNode(E element) {
            super(element);
        }

        /**
         * 计算平衡因子
         *
         * @return
         */
        public int balanceFactor() {
            int leftHeight = left == null ? 0 : ((AVLNode<E>) left).height;
            int rightHeight = right == null ? 0 : ((AVLNode<E>) right).height;
            return leftHeight - rightHeight;
        }

        /**
         * 更新节点高度
         *
         */
        public void updateHeight() {
            int leftHeight = left == null ? 0 : ((AVLNode<E>) left).height;
            int rightHeight = right == null ? 0 : ((AVLNode<E>) right).height;
            height = Math.max(leftHeight, rightHeight);
        }
    }
}
