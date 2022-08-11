package com.itlong.datastructure.hashmap

import org.junit.Test

class HashMapTest {
    @Test
    fun test01() {
        val userBean1 = UserBean("123")
        val userBean2 = UserBean("123")
        val result1 = userBean1.equals(null)
        val result2 = userBean1 == userBean2
        val appleBean = AppleBean(20)
        val result3 = userBean1.equals(appleBean)
        val result4 = userBean1 == userBean1
        println("result1->$result1 result2->$result2 result3->$result3 result4->$result4")
    }

    @Test
    fun test02() {
        // https://blog.csdn.net/qq_35958391/article/details/125015642
        // 结论：HashMap的线程不安全体现在会造成死循环、数据丢失、数据覆盖等问题。其中死循环和数据丢失是在JDK1.7中出现的问题，
        // 在JDK1.8中已经得到解决，但是1.8中仍会有数据覆盖这样的问题。HashMap是线程不安全的，线程安全场景应该使用ConcurrentHashMap。

        // https://blog.csdn.net/shi_xiansheng/article/details/117792691
        // 有个问题要特别声明下：
        //HashMap在jdk1.7中采用表头插入法，在扩容时会改变链表中元素原本的顺序，以至于在并发场景下导致链表成环的问题。
        //在jdk1.8中采用的是尾部插入法，在扩容时会保持链表元素原本的顺序，就不会出现链表成环的问题了。

        //java 1.7 和 java1.8 HashMap 的区别
        //jdk1.7中HashMap采用的是位桶+链表的方式，即我们常说的散列链表的方式，而
        //jdk1.8中采用的是位桶+链表/红黑树的方式，也是非线程安全的。当某个位桶的链表的长度达到某个阀值（8）的时候，这个链表就将转换成红黑树。
        //在jdk1.8中，如果链表长度大于8且节点数组长度大于64的时候，就把链表下所有的节点转为红黑树。
        //树形化还有一个要求就是数组长度必须大于等于64，否则继续采用扩容策略
        //总的来说，HashMap默认采用数组+单链表方式存储元素，当元素出现哈希冲突时，会存储到该位置的单链表中。
        // 但是单链表不会一直增加元素，当元素个数超过8个时，会尝试将单链表转化为红黑树存储。但是在转化前，会再判断一次当前数组的长度，
        // 只有数组长度大于64才处理。否则，进行扩容操作。

        // HashMap中有两个重要的参数：初始容量大小和加载因子，初始容量大小是创建时给数组分配的容量大小，默认值为16，
        // 加载因子默认0.75f，用数组容量大小乘以加载因子得到一个值，
        // 一旦数组中存储的元素个数超过该值就会调用rehash方法将数组容量增加到原来的两倍，专业术语叫做扩容.
        //在做扩容的时候会生成一个新的数组，原来的所有数据需要重新计算哈希码值重新分配到新的数组，所以扩容的操作非常消耗性能.

        // 1、map.put(k,v)实现原理（同3）
        //第一步首先将k,v封装到Node对象当中（节点）。
        // 第二步它的底层会调用K的hashCode()方法得出hash值。
        // 第三步通过哈希表函数/哈希算法，将hash值转换成数组的下标，下标位置上如果没有任何元素，就把Node添加到这个位置上。
        // 如果说下标对应的位置上有链表。此时，就会拿着k和链表上每个节点的k进行equal。如果所有的equals方法返回都是false， 那么这个新的节点将被添加到链表的末尾。如其中有一个equals返回了true，那么这个节点的value将会被覆盖。
        //
        // java1.8 中put 源码：put 中调用 putVal（）方法：
        //1.首先判断map中是否有数据，没有就执行resize方法
        //2.如果要插入的键值对要存放的这个位置刚好没有元素，那么把他封装成Node对象，放在这个位置上即可
        //3.如果这个元素的key与要插入的一样，那么就替换一下。
        //4.如果当前节点是TreeNode类型的数据，执行putTreeVal方法
        //5.遍历这条链子上的数据，完成了操作后多做了一件事情，判断，并且可能执行treeifyBin方法
        val hashMap = HashMap<UserBean, AppleBean>() // JDK7:插入链表的头部，头插法 JDK8:插入链表的尾部，尾插法
        val userBean1 = UserBean("abc")
        val userBean2 = UserBean("def")
        val userBean3 = UserBean("ABC") // 与userBean1的equals一样，v被覆盖了，变为appleBean3
        val appleBean1 = AppleBean(20)
        val appleBean2 = AppleBean(30)
        val  appleBean3 = AppleBean(40)
        hashMap.put(userBean1, appleBean1)
        hashMap.put(userBean2, appleBean2)
        hashMap.put(userBean3, appleBean3)


        // 2、map.get(k)实现原理
        //第一步：先调用k的hashCode()方法得出哈希值，并通过哈希算法转换成数组的下标。
        // 第二步：通过上一步哈希算法转换成数组的下标之后，在通过数组下标快速定位到某个位置上。
        // 重点理解如果这个位置上什么都没有，则返回null。如果这个位置上有单向链表，那么它就会拿着参数K和单向链表上的每一个节点的K进行equals，
        // 如果所有equals方法都返回false，则get方法返回null。如果其中一个节点的K和参数K进行equals返回true，那么此时该节点的value就是我们要找的value了，
        // get方法最终返回这个要找的value。
        hashMap.forEach {
            println("key->${it.key.name} value->${it.value.price}")
        }
        // key->abc value->40
        // key->def value->30
    }
}