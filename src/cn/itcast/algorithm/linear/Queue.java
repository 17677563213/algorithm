package cn.itcast.algorithm.linear;

import org.junit.Test;

import java.awt.font.NumericShaper;
import java.time.temporal.ValueRange;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Queue<T> implements Iterable<T>{
    //记录首结点
    private Node head;
    //记录最后一个结点
    private Node last;
    //记录队列中元素的个数
    private int N;


    private class Node{
        public T item;
        public Node next;

        public Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
    }
    public Queue() {
        this.head = new Node(null,null);
        this.last=null;
        this.N=0;
    }

    //判断队列是否为空
    public boolean isEmpty(){
        return N==0;
    }

    //返回队列中元素的个数
    public int size(){
        return N;
    }

    //向队列中插入元素t
    public void enqueue(T t){

        if (last==null){
            //当前尾结点last为null
            last= new Node(t,null);
            head.next=last;
        }else {
            //当前尾结点last不为null
            Node oldLast = last;
            last = new Node(t, null);
            oldLast.next=last;
        }

        //元素个数+1
        N++;
    }

    //从队列中拿出一个元素
    public T dequeue(){
        if (isEmpty()){
            return null;
        }

        Node oldFirst= head.next;
        head.next=oldFirst.next;
        N--;


        if (isEmpty()){
            last=null;
        }
        return oldFirst.item;
    }


    @Override
    public Iterator<T> iterator() {
        return new QIterator();
    }

    private class QIterator implements Iterator{
        private Node n;

        public QIterator(){
            this.n=head;
        }
        @Override
        public boolean hasNext() {
            return n.next!=null;
        }

        @Override
        public Object next() {
            n = n.next;
            return n.item;
        }


        /**
         * sc config i8042prt start= disabled
         *
         * sc config i8042prt start= auto
         *
         *
         */
    }


    /**
     *
     *
     * 知识点:
     *  对于数组对象,如果需要里面的元素全部相等,需要一个一个的进行遍历复制,不可以直接将对象指针指向处理
     *
     * @param nums
     * @param val
     * @return
     */

    public int removeElement(int[] nums, int val) {
        int j=0;
        for (int i = 0; i <nums.length ; i++) {
            if(nums[i]!=val){
                nums[j]=nums[i];
                j++;
            }
        }
        return j;
    }
    @Test
    public void method06(){
        int [] numbers={3,2,2,3};
        int val=3;
        removeElement(numbers, val);
    }
    @Test
    public void method07(){
        int [] numbers={1,3,5};
        int [] numbers2={4,3,6};
        numbers=numbers2;
        for (int number : numbers) {
            System.out.println(number);
        }
        /**
         * 疑问:
         *  1.为什么Java中能够进行这样操作,可是到力扣题库中就不能够进行这种
         */


    }



    public List<List<Integer>> threeSum(int[] nums) {

        /**
         * 思路:
         *  1.固定一个
         *  2.左右进行移动
         *  3.处理元素重复问题
         */

//        数组排序
        Arrays.sort(nums);

//        创建集合容器
        List<List<Integer>> res = new ArrayList();
//        从第一个开始遍历
        for (int i = 0; i < nums.length; i++) {
//            获取目标元素
            int target = 0 - nums[i];
//            定位左边元素
            int l = i + 1;
//            定位右边元素
            int r = nums.length - 1;
//            减少循环
            if (nums[i] > 0)
                break;
//            外层循环,移动
            if (i == 0 || nums[i] != nums[i - 1]) {
//                寻找元素
                while (l < r) {
                    if (nums[l] + nums[r] == target) {
                        res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                        while (l < r && nums[l] == nums[l + 1]) l++; //元素去重操作
                        while (l < r && nums[r] == nums[r - 1]) r--;//元素去重操作
                        l++;
                        r--;
                    } else if (nums[l] + nums[r] < target)
                        l++;
                    else
                        r--;
                }
            }
        }
        return res;
    }


    public List<List <Integer>> getElment(int[] nums){
        ArrayList<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i <nums.length ; i++) {
            int target=0-nums[i];
            int l=i+1;
            int r=nums.length-1;
            if(nums[i]>0){
                break;
            }
//            去重
            if(nums[i]!=nums[i-1]||i==0){
                while(l<r){
                    if(nums[r]+nums[l]==target){
                        ArrayList<Integer> element = new ArrayList<>();
                            element.add(nums[i]);
                            element.add(nums[r]);
                            element.add(nums[l]);
                            list.add(element);
                            l++;
                            r--;
                    }else if(nums[r]+nums[l]>target){
                        r--;
                    } else{
                        l++;
                    }

                }
            }
        }

        return list;

    }










}












