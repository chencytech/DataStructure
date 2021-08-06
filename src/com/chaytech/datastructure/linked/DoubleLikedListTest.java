package com.chaytech.datastructure.linked;

/**
 * 双向链表测试
 *
 * @author Chency
 * @email chaytech@163.com
 * @Date: 2019/06/23 16:26
 */
public class DoubleLikedListTest {
    public static void main(String[] args) {

        DoubleLikedList doubleLikedList = new DoubleLikedList<String>();
        doubleLikedList.add("a");
        doubleLikedList.add("b");
        doubleLikedList.add("c");
        doubleLikedList.add("d");
        doubleLikedList.add("e");
        System.out.println("删除前：");
        doubleLikedList.showLinkedList();

        doubleLikedList.remove("b");
        System.out.println("删除d后：");
        doubleLikedList.showLinkedList();

        doubleLikedList.update("e","f");
        System.out.println("将e修改为f后：");
        doubleLikedList.showLinkedList();

        System.out.println("链表节点个数：" + doubleLikedList.size());

        System.out.println("查找链表种倒数第1个节点："+ doubleLikedList.findLastIndexNode(1));

        System.out.println("非递归反转链表：");
//        singleLikedList.showLinkedList(singleLikedList.reverseLinkList());

        System.out.println("递归反转链表：");
        doubleLikedList.showLinkedList(doubleLikedList.recursionReverseLinkList());

    }
}
