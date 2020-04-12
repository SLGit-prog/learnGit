package source.code.everyday;

import java.util.HashMap;

public class HashMapLearn {

    /*
      Map集合的特点：
         将键映射到值得对象，一个映射不能包含重复的键，每个键最多只能映射到一个值
      Map和Collection集合的区别：
         * Map集合存储元素事成对出现的，Map的键事唯一的，值是可以重复的
         * Collection集合存储元素是单独出现的，其子类Set是唯一的，List是可重复的
      要点：
         * Map集合的数据结构针对键有效，和值无关
         * Collection集合的数据结构针对元素有效
         * 允许使用null值和null键
         * 不保证映射的顺序，特别是不保证改顺序更久不变
         * HashMap是非线程安全的，在多线程的环境下可能能会出现问题。


         * jdk1.7及之前：HashMap数据结构是：线性表 + 链表
         * jdk1.8及以后，初始化仍然是：线性表 + 链表，指示当链表的长度超过一定数量之后，
                         会把链表转换成红黑树来增加代码运行时候的性能。
                         在源码中
                         static final int TREEIFY_THRESHOLD = 8;
                         用来指定这个数量，初始值为8
     */

    /*
     顶级接口：Entry<K,V>
     JDK1.8种，哈希冲突 -- 链表变成平衡二叉树(红黑树)。
     * 值得注意的是TreeSet和TreeMap底层就是用红黑树来实现的。
     装填因子为0.75。如果超过了0.75的比例，那么会创建2倍大的哈希表。
     */
    HashMap hs = new HashMap();
    /*
        详细笔记：
            * static final int DEFAULT_INITIAL_CAPACITY = 1 << 4;
              初始容量，最开始线性表的大小为16

            * static final float DEFAULT_LOAD_FACTOR = 0.75f;
              加载因子。当 线性表中的元素 > 初始容量 * 加载因子时，线性表长度会扩容为原来的2倍
              即：扩容后的长度 = 扩容前 * 2

            * static final int hash(Object key) {
                int h;
                return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
            }

              这里不能使用key的hash值
                  n = table.length;
                  index = （n-1） & hash;
              table的长度都是2的幂，因此index只与hash值的低n为有关
              因此会大概率放生冲突的现象
              通过高16位和低16位进行异或来降低冲突

            * static final int MAXIMUM_CAPACITY = 1 << 30;
              static final int tableSizeFor(int cap) {
                  int n = cap - 1;
                  n |= n >>> 1;
                  n |= n >>> 2;
                  n |= n >>> 4;
                  n |= n >>> 8;
                  n |= n >>> 16;
                  return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
              }

              在实例化HashMap时，如果给定了initialCapacity，由于HashMap的capacity都是2的幂
              这个方法相当于找到大于等于initialCapacity的最小的2的幂
              （如果initialCapacity就是2的幂，那么返回的还是这个数值）
              int n = cap - 1  //如果cap已经是2的幂，如果不进行减1的操作，则返回的时cap的2倍

    */
}
