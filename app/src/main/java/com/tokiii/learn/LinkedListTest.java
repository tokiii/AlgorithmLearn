package com.tokiii.learn;

import androidx.annotation.NonNull;

/**
 * 单链表
 */
public class LinkedListTest {
    public static void main(String[] args) {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        HeroNode heroNode = new HeroNode(1, "1", "哈哈哈");
        HeroNode heroNode1 = new HeroNode(1, "1", "哈哈哈");
        HeroNode heroNode2 = new HeroNode(2, "1", "哈哈哈");
        HeroNode heroNode3 = new HeroNode(3, "1", "哈哈哈");
        HeroNode heroNode4 = new HeroNode(4, "1", "哈哈哈");
        HeroNode heroNode5 = new HeroNode(5, "1", "哈哈哈");
        HeroNode heroNode6 = new HeroNode(6, "1", "哈哈哈");
        singleLinkedList.addByOrder(heroNode);
        singleLinkedList.addByOrder(heroNode3);
        singleLinkedList.addByOrder(heroNode4);
        singleLinkedList.addByOrder(heroNode2);
        singleLinkedList.addByOrder(heroNode1);
//        singleLinkedList.list();
//        singleLinkedList.remove(4);
//        singleLinkedList.list();
//        singleLinkedList.remove(3);
        singleLinkedList.list();
//        singleLinkedList.remove(30);

        System.out.printf("单链表有效数据个数为%d\n", getSize(singleLinkedList.getHead()));
        int k = 2;
        System.out.printf("获取倒数第%d个链表的值为%d\n", k, findLastIndexNode(singleLinkedList.getHead(), 2).no);
    }


    //获取单链表数据有效个数
    public static int getSize(HeroNode head) {
        if (head.next == null) {
            return 0;
        }
        int size = 0;
        HeroNode temp = head;
        while (temp.next != null) {
            size++;
            temp = temp.next;
        }

        return size;
    }

    //获取倒数第index个节点
    public static HeroNode findLastIndexNode(HeroNode head, int index) {
        int size = getSize(head);
        if (size == 0) {
            throw new RuntimeException("链表为空！");
        }
        if (index > size || index < 0) {
            throw new RuntimeException("输入的位置有问题！");
        }
        HeroNode temp = head;
        int length = 0;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (length == size - index) {
                break;
            }
            length++;
            temp = temp.next;
        }
        return temp;
    }
}

/**
 * 管理列表
 */
class SingleLinkedList {
    // 先初始化一个头节点 头节点不要动，不存放具体的数据
    private HeroNode head = new HeroNode(0, "", "");

    public HeroNode getHead() {
        return head;
    }

    //添加节点到单向链表
    // 当不考虑编号的顺序时，找到当前链表的最后一个节点 将最后节点的next指向新的节点
    public void add(HeroNode heroNode) {
        // head节点不能动 通过辅助节点temp
        HeroNode temp = head;
        // 当退出while循环时，指向的是链表的最后
        while (true) {
            if (temp.next == null) {
                break;
            } else {
                temp = temp.next;
            }
        }
        temp.next = heroNode;
    }


    //添加节点到单向链表
    //考虑编号的顺序时
    public void addByOrder(HeroNode heroNode) {
        // head节点不能动 通过辅助节点temp
        HeroNode temp = head;
        boolean flag = false;
        // 当退出while循环时，指向的是链表的最后
        while (true) {
            if (temp.next == null) {
                break;
            }
            // 说明temp的下一个节点比要插入的大，则temp这个位置的下一个节点就是要插入的这个节点
            else if (temp.next.no > heroNode.no) {
                break;
            }
            // 说明编号存在
            else if (temp.next.no == heroNode.no) {
                flag = true;
                break;
            } else {
                temp = temp.next;
            }
        }
        //判断flag的值
        if (flag) {
            System.out.printf("准备插入的节点 %d 已经存在\n", heroNode.no);
            return;
        }

        heroNode.next = temp.next;// 新节点的下一个指针指向temp的下一个节点
        temp.next = heroNode;// temp的下一指针指向新节点
    }


    public void list() {
        //判断链表是否为空
        if (head.next == null) {
            return;
        }
        // 头节点不用打印
        HeroNode temp = head.next;
        while (true) {
            if (temp == null) {
                break;
            }
            System.out.println(temp.toString());
            // 将 temp后移
            temp = temp.next;
        }
    }

    //修改节点信息  不能修改no
    public void update(HeroNode newHeroNode) {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head;
        boolean flag = false; //是否找到该节点
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.no == newHeroNode.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if (flag) {
            temp.name = newHeroNode.name;
            temp.nickname = newHeroNode.nickname;
        } else {
            System.out.printf("没找到编号%d的节点", newHeroNode.no);
        }
    }

    //删除节点
    public void remove(int no) {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head;
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            } else if (temp.next.no == no) { //如果temp的下一个节点的no 和  要删除的节点相同 temp的下一个节点就是要删除的节点
                flag = true;
                break;
            }
            temp = temp.next;
        }

        //如果找到要删
        if (flag) {
            temp.next = temp.next.next;
            System.out.printf("删除节点%d成功\n", no);
        } else {
            System.out.println("没找到要删除的节点");
        }

    }

    //查找单链表中倒数第k个节点
    public void search(int k) {
        int searchPosition = -1;
        if (head.next == null) {
            return;
        }
        while (true) {

        }

    }
}


class HeroNode {
    int no;
    String name;
    String nickname;
    //指向下一个节点
    HeroNode next;

    public HeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickname = nickName;
    }

    @NonNull
    @Override
    public String toString() {
        return "heroNo " + no + "  name " + name;
    }
}



