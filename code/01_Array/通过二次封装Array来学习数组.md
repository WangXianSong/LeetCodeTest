## 学习数组Array

从最简单开始，基于Java的数组类进行二次封装学，功能有：
- 获取数组长度、有效个数；
- 添加和删除元素；
- 查询和修改；
- 包含、搜索和删除；



## 进阶的数组Array
- 进阶1：泛型，可以放置任意数据类型，不是基本数据类型，是类对象；
- 进阶2：动态长度数组



## 简单时间复杂度分析
**添加操作时间复杂度：综合最坏O(n)**

- addLast(e): O(1)
- addFirst(e):O(n)
- add(index,e):O(n/2)=O(n)

**删除操作时间复杂度：综合最坏O(n)**

- removeLast(e):O(1)
- removeFirst(e):O(n)
- remove(index,e):O(n/2)=O(n)

**修改操作时间复杂度**

- set(index,e):O(1)

**查询操作时间复杂度**

-  get(index): O(1)
- contains(e): O(n)
- find(e): O(n)



## 可优化的地方
动态数组可优化的地方：**复杂度震荡**
- 原因：当数组元素达到扩容的数量时会马上进行扩容，但此时如果又删除了一个元素，
- 数组size又等于长度的二分，进行缩容，来回来回，导致资源消耗过高。
- 例子：10个元素增加1个，长度扩容到20，大小为11，删除1个，大小为10，为长度的一半，进行缩容。
- 解决办法：将着急模式(Eager)改成懒惰模式(Lazy)；ß
- 具体操作：当size==capacity/4时，才将capacity减半；



## 完整代码


```java
public class Array<E> {

    // 成员数组
    private E[] data;
    // 计算数组中有效的数字
    private int size;

    // 构造函数，传入数组的容量capacity构造Array
    public Array(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    // 无参数构造函数，默认传入10个元素
    public Array() {
        this(10);
    }

    // 获取数组的容量大小
    public int getCapacity() {
        return data.length;
    }

    // 获取数组的有效长度
    public int getSize() {
        return size;
    }

    // 判断数组是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    // 添加e元素在指定位置index
    public void add(int index, E e) {
        if (size == data.length) {
            // throw new IllegalArgumentException("add failded. Array is full");
            resize((int) (1.5 * data.length));//扩容1.5倍
        }
        // 插入其中，所以必须在size范围内
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("add failded. require index >=0 and index <=size");
        }
        // 将指定元素后的元素往后挪一位
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        // 覆盖这个位置
        data[index] = e;
        size++;
    }

    // 添加元素在末尾
    public void addLast(E e) {
        add(size, e);
    }

    // 添加元素在最前
    public void addFitst(E e) {
        add(0, e);
    }

    // 查询元素
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failded. index is Illegal");
        }
        return data[index];
    }

    // 修改元素
    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failded. index is Illegal");
        }
        data[index] = e;
    }

    // 包含
    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    // 寻找
    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    // 删除元素
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Remove failded. index is Illegal");
        }
        E ret = data[index];
        for (int i = index; i < size - 1; i++) {
            data[index] = data[index + 1];
        }
        size--;
        data[size] = null; // loitering objects 去除闲逛对象，否则暂时不能被回收
        // 动态减少,优化后为Lazy模式
        if (size == data.length / 4 && data.length / 2 != 0) {
            resize(data.length / 2);
        }
        return ret;
    }
    // 删除第一个
    public E removeFirst(int index) {
        return remove(0);
    }
    // 删除最后一个
    public E removeLast(int index) {
        return remove(size - 1);
    }
    // 删除某个元素
    public void removeElement(E e) {
        int index = find(e);
        if (index != -1) {
            remove(index);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Array size : %d, capacity : %d", size, data.length));
        sb.append('\n');
        sb.append('[');
        for (int i = 0; ; i++) {
            sb.append(data[i]);
            if (i == size - 1) {
                sb.append(']');
                return sb.toString();
            }
            sb.append(',');
        }
    }

    // 动态数组功能
    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }
}
```

