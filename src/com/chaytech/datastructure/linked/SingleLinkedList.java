package com.chaytech.datastructure.linked;

/**
 * 单向链表
 *
 * @author Chency
 * @email chaytech@163.com
 * @Date: 2019/06/23 16:17
 */
public class SingleLinkedList<T> {

    private Node<T> head = new Node<>(); // 头节点

    /**
     * 判断链表是否为空
     *
     * @return
     */
    public boolean isEmpty(){
        return head == null || head.next == null;
    }

    /**
     * 添加节点到单向链表
     *
     * @param item
     * @return
     */
    public boolean add(T item){
        Node<T> newNode = new Node<>(item);

        Node<T> tempNode = head; // 将头节点赋值给临时节点
        while(tempNode.next != null){ // 遍历找到最后一个节点
            tempNode = tempNode.next;
        }

        tempNode.next = newNode; // 将最后一个节点的next指向新的节点
        return true;
    }

    /**
     * 修改节点数据
     *
     * @param sourceItem 节点原数据
     * @param tragetItem 节点新数据
     * @return
     */
    public boolean update(T sourceItem, T tragetItem) {
        if (this.isEmpty()) {
            System.out.println("linkedList is empty");
            return false;
        }

        Node<T> tempNode = head; // 将第一个节点赋值给临时节点
        while (true) {
            if (tempNode == null) {
                System.out.println("node is empty");
                break;
            }
            if (sourceItem.equals(tempNode.item)) {
                tempNode.item = tragetItem;
                return true;
            }
            tempNode = tempNode.next;
        }

        return false;
    }

    /**
     * 删除节点
     *
     * @param item 节点数据
     * @return
     */
    public boolean remove(T item) {
        if (this.isEmpty()) {
            System.out.println("linkedList is empty");
            return false;
        }

        Node<T> tempNode = head; // 将头节点赋值给临时节点
        while (true) {
            if (tempNode.next == null) {
                System.out.println("node next is empty");
                break;
            }
            if (item.equals(tempNode.next.item)) {
                tempNode.next = tempNode.next.next;
                return true;
            }
            tempNode = tempNode.next;
        }
        System.out.println("not find node item");
        return false;
    }

    /**
     * 获取队列长度
     *
     * @return
     */
    public int size() {
        if (this.isEmpty()) {
            return 0;
        }

        int size = 0;
        Node<T> tempNode = head; // 将头节点赋值给临时节点
        while (tempNode.next != null) { // 遍历找到最后一个节点
            size++;
            tempNode = tempNode.next;
        }

        return size;
    }

    /**
     * 查找（查找单链表中的倒数第k个结点）
     *
     * @param index
     * @return
     */
    public Node<T> findLastIndexNode(int index){
        if(this.isEmpty()){
            return null;
        }

        int size = this.size(); // 获取链表长度
        if(index <= 0 || index > size){
            return null;
        }

        Node<T> tempNode = head.next; // 将第一个有效节点赋值给临时变量
        for (int i = 0; i < size - index; i++) {
            tempNode = tempNode.next;
        }

        return tempNode;
    }

    /**
     * 非递归反转链表：从头部开始处理，依次替换位置
     *
     * @return
     */
    public Node<T> reverseLinkList() {
        // 如果当前链表为空或者只有一个节点，则无需反转，直接返回
        if (this.isEmpty() || head.next.next == null) {
            return head;
        }

        Node<T> tempNode = head.next; // 将第一个有效节点赋值给临时变量
        Node<T> prev = null; // 临时变量前一个节点
        while (tempNode != null) {
            Node<T> next = tempNode.next; // 当前节点的下一个节点
            Node<T> currentNode = tempNode; // 当前遍历的节点
            // 将前一个节点赋值给当前节点的下一个节点(此处是进行节点反转)
            // 比如有a、b、c、d、e等5个几点，那第一个节点为a
            // 进行反转的话，a就成了最后一个节点，所以a的next = prev（当遍历第一个节点的时候，prev就等于null）
            // 遍历第二个节点b的时候，b的next就是prev，前一个节点为a，所以b就到了a的前面
            // 后面依次遍历
            currentNode.next = prev;
            // 将当前节点赋值给临时变量 -> 前一个节点
            prev = currentNode;
            tempNode = next; // 往后移动一个节点（a -> b）
        }
        return prev;
    }

    /**
     * 递归反转node节点：从尾部开始处理
     *
     * @return
     */
    public Node<T> recursionReverseLinkList() {
        // 如果当前链表为空或者只有一个节点，则无需反转，直接返回
        if (this.isEmpty() || head.next.next == null) {
            return head;
        }
        return recursionReverse(head);
    }

    /**
     * 递归反转
     *
     * @param node
     * @return
     */
    public Node<T> recursionReverse(Node<T> node){
        Node<T> prev = null;
        if (node == null || node.next == null) {
            return node;
        } else {
            // 递归找到最后一个节点
            prev = recursionReverse(node.next);
            // 设置当前节点的下一个下一个节点为前一个节点
            node.next.next = node;
            // 设置当前节点的下一个节点为null
            node.next = null;
        }
        return prev;
    }

    /**
     * 显示链表数据
     *
     */
    public void showLinkedList(){
        if (this.isEmpty()) {
            System.out.println("linkedList is empty");
            return;
        }

        Node<T> tempNode = head; // 将头节点赋值给临时节点
        while (true){
            System.out.println(tempNode); // 输出节点信息
            if(tempNode.next == null){ // 判断是不是最后一个节点
                break;
            }
            tempNode = tempNode.next; // 节点向后移动
        }
    }

    /**
     * 根据指定节点显示链表数据
     *
     * @param node
     */
    public void showLinkedList(Node<T> node){
        if (node == null || node.next == null) {
            System.out.println("linkedList is empty");
            return;
        }

        Node<T> tempNode = node; // 将头节点赋值给临时节点
        while (true){
            System.out.println(tempNode); // 输出节点信息
            if(tempNode.next == null){ // 判断是不是最后一个节点
                break;
            }
            tempNode = tempNode.next; // 节点向后移动
        }
    }

    /**
     * 链表节点类
     *
     * @param <T>
     */
    private class Node<T>{
        private T item; // 节点数据
        private Node<T> next; // 下一个节点

        public Node(){
        }

        public Node(T item){
            this.item = item;
        }

        public Node(T item,Node<T> next){
            this.item = item;
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" + "item=" + item + '}';
        }
    }
}
