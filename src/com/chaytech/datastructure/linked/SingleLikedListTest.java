package com.chaytech.datastructure.linked;

/**
 * 单向链表测试
 *
 * @author Chency
 * @email chaytech@163.com
 * @Date: 2019/06/23 16:26
 */
public class SingleLikedListTest {
    public static void main(String[] args) {

        SingleLinkedList singleLikedList = new SingleLinkedList<String>();
        singleLikedList.add("a");
        singleLikedList.add("b");
        singleLikedList.add("c");
        singleLikedList.add("d");
        singleLikedList.add("e");
        System.out.println("删除前：");
        singleLikedList.showLinkedList();

        singleLikedList.remove("b");
        System.out.println("删除d后：");
        singleLikedList.showLinkedList();

        singleLikedList.update("e","f");
        System.out.println("将e修改为f后：");
        singleLikedList.showLinkedList();

        System.out.println("链表节点个数：" + singleLikedList.size());

        System.out.println("查找链表种倒数第1个节点："+ singleLikedList.findLastIndexNode(1));

        System.out.println("非递归反转链表：");
//        singleLikedList.showLinkedList(singleLikedList.reverseLinkList());

        System.out.println("递归反转链表：");
        singleLikedList.showLinkedList(singleLikedList.recursionReverseLinkList());
    }
}
