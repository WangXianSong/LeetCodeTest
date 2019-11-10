package leetcode;


/**
 * 学习Array数据结构
 */
public class ArrayCode {

    private int[] data;
    private int size;

    // 构造函数，传入数组的容量capacity构造Array
    public ArrayCode(int capacity) {
        data = new int[capacity];
        size = 0;
    }

    // 无参构造函数，默认数组容量capacity为10
    public ArrayCode() {
        this(10);
    }

    // 获取数组中的元素个数
    public int getSize() {
        return size;
    }

    // 获取数组中的容量
    public int getCapacity() {
        return data.length;
    }

    // 返回数组是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    // 在所有元素后面添加一个新元素
    public void addLast(int e) {
        if (size == data.length) {
            throw new IllegalArgumentException("AddList faild. Array is full");
        }
        data[size] = e;
        size++;
    }

    // 在指定位置添加一个新元素
    public void add(int index, int e) {
        if (size == data.length) {
            throw new IllegalArgumentException("AddList faild. Array is full");
        }
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add faild. Require index >=0 and inde <=size");
        }
        // 从最后一个元素开始往后挪一个位置
        for (int i = size - 1; i >= index; i--) {
            // 然后一个索引位置赋值前一个索引位置的值
            data[i + 1] = data[i];
        }
        // 在index位置赋值，并将e值添加进去
        data[index] = e;
        size++;
    }

    // 在数组中第一个位置添加新元素
    public void addFirst(int e) {
        add(0, e);
    }

    // 获取index索引位置的元素
    public int getIndex(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Get faild. index is illegal");
        }
        return data[index];
    }

    // 查找是否存在某个e
    public boolean contains(int e) {
        for (int i = 0; i < size; i++) {
            if (data[i] == e) {
                return true;
            }
        }
        return false;
    }

    // 查找元素e并返回index
    public int find(int e) {
        for (int i = 0; i < size; i++) {
            if (data[i] == e) {
                return i;
            }
        }
        return -1;
    }

    // 从数组中删除指定索引
    public int remove(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Delete faild. Require index >=0 and inde <=size");
        }
        int res = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        return res;
    }

    // 从数组中删除第一个元素
    public int removeFirst() {
        return remove(0);
    }

    // 从数组中删除最后一个元素
    public int removeLast() {
        return remove(size - 1);
    }

    // 从数组中删除元素e,可以更多操作：返回布尔型（是否成功）、检查是否还存在e元素（重复）removeAll和findAll;
    public void removeElement(int e) {
        int index = find(e);
        if (index != -1) {
            remove(index);
        }
    }

    @Override
    public String toString() {

        StringBuilder res = new StringBuilder();
        res.append(String.format("Array:Size = %d, capacity = %d \n", size, data.length));
        res.append('[');
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size - 1) {
                res.append(",");
            }
        }
        res.append(']');
        return res.toString();
    }
}

