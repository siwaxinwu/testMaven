/*
package container;

import java.util.Collection;

*/
/**
 * description：
 * author：dingyawu
 * date：created in 19:34 2020/7/27
 * history:
 *//*

public class MyLinkedlist<E> {
    transient int size = 0;
    transient Node<E> first;
    transient Node<E> last;

    public MyLinkedlist() {

    }
    public MyLinkedlist(Collection<? extends E> c) {
        this();
        addAll(c);
    }
    public boolean addAll(int index, Collection<? extends E> c) {
        checkPositionIndex(index);
        Object[] a = c.toArray();
        int numNew = a.length;
        if (numNew == 0) return false;
        Node<E> pred, succ;
        if (index == size) {
            succ = null;
            pred = last;
        } else {
            succ = node(index);
            pred = succ.prev;
        }
        for (Object o : a) {
            @SuppressWarnings("unchecked")
            E e = (E) o;
            Node<E> newNode = new Node<>(pred, e, null);
            if (pred == null)
                first = newNode;
            else
                pred.next = newNode;
            pred = newNode;
        }
        if (succ == null) {
            last = pred;
        } else {
            pred.next = succ;
            succ.prev = pred;
        }
        size += numNew;
        modCount++;
        return true;
    }

    Node<E> node(int index) {
        if (index < (size >> 1)) {
            Node<E> x = first;
            for (int i = 0; i < index; i++)
                x = x.next;
            return x;
        } else {
            Node<E> x = last;
            for (int i = size - 1; i > index; i--)
                x = x.prev;
            return x;
        }
    }

    private void checkPositionIndex(int index) {
        if (!isPositionIndex(index))
        throw new IndexOutOfBoundsException(String.valueOf(index));
    }

    private boolean isPositionIndex(int index) {
        return index >= 0 && index <= size;
    }


    public boolean addAll(Collection<? extends E> c) {
        return addAll(size, c);
    }
    public void addFirst(E e) {
        linkFirst(e);
    }

    private void linkFirst(E e) {

        final Node<E> f = first;
        final Node<E> newNode = new Node<>(null, e, f);
        first = newNode;
        if (f == null)
            last = newNode;
        else
            f.prev = newNode;
        size++;
        modCount++;
    }

    public void addLast(E e) {
        linkLast(e);
    }

    void linkLast(E e) {
        final Node<E> l = last;
        final Node<E> newNode = new Node<>(l, e, null);
        last = newNode;
        if (l == null)
            first = newNode;
        else
            l.next = newNode;
        size++;
        modCount++;
    }

    public boolean add(E e) {
        linkLast(e);
        return true;
    }

    void linkLast(E e) {
        final Node<E> l = last;
        // 前驱为前last，值为e，后继为null
        final Node<E> newNode = new Node<>(l, e, null);
        last = newNode;
        //最后一个节点为空，说明列表中无元素
        if (l == null)
            //first同样指向此节点
            first = newNode;
        else
            //否则，前last的后继指向当前节点
            l.next = newNode;
        size++;
        modCount++;
    }

    public void add(int index, E element) {
        checkPositionIndex(index);

        if (index == size)
            linkLast(element);
        else
            linkBefore(element, node(index));
    }
    */
/**
     * 在succ节点前增加元素e(succ不能为空)
     *//*

    void linkBefore(E e, Node<E> succ) {
        // assert succ != null;
        // 拿到succ的前驱
        final Node<E> pred = succ.prev;
        // 新new节点：前驱为pred，值为e，后继为succ
        final Node<E> newNode = new Node<>(pred, e, succ);
        // 将succ的前驱指向当前节点
        succ.prev = newNode;
        // pred为空，说明此时succ为首节点
        if (pred == null)
            // 指向当前节点
            first = newNode;
        else
            // 否则，将succ之前的前驱的后继指向当前节点
            pred.next = newNode;
        size++;
        modCount++;
    }

    public E get(int index) {
        checkElementIndex(index);
        return node(index).item;
    }

    // 检测index合法性
    private void checkElementIndex(int index) {
        if (!isElementIndex(index))
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }

    // 根据index 获取元素
    Node<E> node(int index) {
        // assert isElementIndex(index);

        if (index < (size >> 1)) {
            Node<E> x = first;
            for (int i = 0; i < index; i++)
                x = x.next;
            return x;
        } else {
            Node<E> x = last;
            for (int i = size - 1; i > index; i--)
                x = x.prev;
            return x;
        }
    }
    public E getFirst() {
        final Node<E> f = first;
        if (f == null)
            throw new NoSuchElementException();
        return f.item;
    }

    public E getLast() {
        final Node<E> l = last;
        if (l == null)
            throw new NoSuchElementException();
        return l.item;
    }


    public boolean remove(Object o) {
        // 如果o是空
        if (o == null) {
            // 遍历链表查找 item==null 并执行unlink(x)方法删除
            for (Node<E> x = first; x != null; x = x.next) {
                if (x.item == null) {
                    unlink(x);
                    return true;
                }
            }
        } else {
            for (Node<E> x = first; x != null; x = x.next) {
                if (o.equals(x.item)) {
                    unlink(x);
                    return true;
                }
            }
        }
        return false;
    }

    E unlink(Node<E> x) {
        // assert x != null;
        // 保存x的元素值
        final E element = x.item;
        //保存x的后继
        final Node<E> next = x.next;
        //保存x的前驱
        final Node<E> prev = x.prev;

        //如果前驱为null，说明x为首节点，first指向x的后继
        if (prev == null) {
            first = next;
        } else {
            //x的前驱的后继指向x的后继，即略过了x
            prev.next = next;
            // x.prev已无用处，置空引用
            x.prev = null;
        }

        // 后继为null，说明x为尾节点
        if (next == null) {
            // last指向x的前驱
            last = prev;
        } else {
            // x的后继的前驱指向x的前驱，即略过了x
            next.prev = prev;
            // x.next已无用处，置空引用
            x.next = null;
        }
        // 引用置空
        x.item = null;
        size--;
        modCount++;
        // 返回所删除的节点的元素值
        return element;
    }

    ublic E remove(int index) {
        checkElementIndex(index);
        //node(index)会返回index对应的元素
        return unlink(node(index));
    }

    E unlink(Node<E> x)  方法上文有详解。

    public E removeFirst() {
        final Node<E> f = first;
        if (f == null)
            throw new NoSuchElementException();
        return unlinkFirst(f);
    }

    private E unlinkFirst(Node<E> f) {
        // assert f == first && f != null;
        //取出首节点中的元素
        final E element = f.item;
        //取出首节点中的后继
        final Node<E> next = f.next;
        f.item = null;
        f.next = null; // help GC
        // first指向前first的后继，也就是列表中的2号位
        first = next;
        //如果此时2号位为空，那么列表中此时已无节点
        if (next == null)
            //last指向null
            last = null;
        else
            // 首节点无前驱
            next.prev = null;
        size--;
        modCount++;
        return element;
    }
    原理与添加头节点类似。

    public E removeLast() {
        final Node<E> l = last;
        if (l == null)
            throw new NoSuchElementException();
        return unlinkLast(l);
    }

    private E unlinkLast(Node<E> l) {
        // assert l == last && l != null;
        // 取出尾节点中的元素
        final E element = l.item;
        // 取出尾节点中的后继
        final Node<E> prev = l.prev;
        l.item = null;
        l.prev = null; // help GC
        // last指向前last的前驱，也就是列表中的倒数2号位
        last = prev;
        // 如果此时倒数2号位为空，那么列表中已无节点
        if (prev == null)
            // first指向null
            first = null;
        else
            // 尾节点无后继
            prev.next = null;
        size--;
        modCount++;
        // 返回尾节点保存的元素值
        return element;
    }

    public E set(int index, E element) {
        checkElementIndex(index);
        // 获取到需要修改元素的节点
        Node<E> x = node(index);
        // 保存之前的值
        E oldVal = x.item;
        // 执行修改
        x.item = element;
        // 返回旧值
        return oldVal;
    }

    private static class Node<E> {
        // 值
        E item;
        // 后继
        Node<E> next;
        // 前驱
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }
}
*/
