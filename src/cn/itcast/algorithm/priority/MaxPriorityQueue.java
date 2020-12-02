package cn.itcast.algorithm.priority;

public class MaxPriorityQueue<T extends Comparable<T>> {
    //存储堆中的元素
    private T[] items;
    //记录堆中元素的个数
    private int N;

    /**
     * 最大优先队列:
     * 类,实现的方式跟堆实现的方式也是一样,采用的是数组的形式
     * 成员变量: 一个数组,一个记录元素个数
     *
     * @param capacity
     */
    /**
     * 具备的方法:
     * 1.构造方法
     * 2.该队列的大小
     * 3.判断是否为空,主要判断该个数是否为空
     * 4比较大小
     * 5.替换位置
     * @param capacity
     */

    public MaxPriorityQueue(int capacity) {
        this.items = (T[]) new Comparable[capacity+1];
        this.N= 0;
    }

    //获取队列中元素的个数
    public int size() {
        return N;
    }

    //判断队列是否为空
    public boolean isEmpty() {
        return N==0;
    }

    //判断堆中索引i处的元素是否小于索引j处的元素
    private boolean less(int i, int j) {
        return items[i].compareTo(items[j])<0;
    }

    //交换堆中i索引和j索引处的值
    private void exch(int i, int j) {
        T tmp = items[i];
        items[i] = items[j];
        items[j] = tmp;
    }

    //往堆中插入一个元素
    public void insert(T t) {
        items[++N] = t;
        swim(N);
    }

    /**
     * 添加元素
     * 添加元素是在数组的最后面进行添加,添加完毕之后,需要进行调整元素的位置,元素需要上浮
     * @return
     */

    //删除堆中最大的元素,并返回这个最大元素

    /**
     * 删除思路:
     * 1.获取第一个元素,第一个元素就是最大的元素
     * 2.交换他们之间的位置
     * 3.
     * @return
     */
    public T delMax() {
        T max = items[1];
        exch(1,N);
        N--;
        sink(1);
        return max;
    }

    //使用上浮算法，使索引k处的元素能在堆中处于一个正确的位置
    private void swim(int k) {
        while(k>1){
            if (less(k/2,k)){
                exch(k/2,k);
            }
            k = k/2;
        }
    }
    //使用下沉算法，使索引k处的元素能在堆中处于一个正确的位置
    private void sink(int k) {
        while(2*k<=N){
            int max;
            if (2*k+1<=N){
                if (less(2*k,2*k+1)){
                    max=2*k+1;
                }else{
                    max = 2*k;
                }
            }else {
                max = 2*k;
            }
            if (!less(k,max)){
                break;
            }
            /**
             * 阿里巴巴科技有限公司
             * 字节跳动科技有限公司:
             * 这两个公司是我比较喜欢的,自己的目标就是这两个公司
             *
             *数据结构与算法
             * 计算机网络
             * 操作系统
             * 计算机组成原理
             * Java基础知识
             * guc
             * jvm
             * 数据库
             * spring
             * mybatis
             * 缓存
             * 消息中间件
             */
            exch(k,max);
            k = max;
        }
    }
}
