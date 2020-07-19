package container;

/**
 * description：
 * author：dingyawu
 * date：created in 15:32 2020/7/19
 * history:
 */
public class MyArrayList {
    transient Object[] elementData;
    private static final int DEFAULT_CAPACITY = 10;
    private static final Object[] EMPTY_ELEMENTDATA = {};
    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};
    private int size;

    public MyArrayList( int initCapacity){
        if (initCapacity < 0){
            throw new IllegalArgumentException("初始化，参数非法" + initCapacity);
        }
        if (initCapacity == 0){
            elementData = EMPTY_ELEMENTDATA;
        }
        elementData = new Object[initCapacity];
    }

    public Object getIndex(int index){
        checkIndex(index);
        return elementData[index];
    }

    public void addObject(Object object){
        changeElement(size + 1);
        elementData[size ++] = object;

    }

    public Object removeIndex(int index){
        checkIndex(index);
        int pos = size - index -1 ;
        Object result = elementData[pos];
        if (pos > 0){
            System.arraycopy(elementData, index + 1, elementData, index, pos);
            elementData[size --] = null;
            return result;
        }
        return null;
    }
    public Object removeObject(Object object){
        for (int i = 0; i < size; i++) {
            if (elementData[i].equals(object)){
                removeIndex(i);
            }
        }
        return null;
    }


    private void changeElement(int miniCapacity) {
        if (size == elementData.length){
            int oldCapacity = elementData.length;
            int newCapacity = oldCapacity + oldCapacity << 1;
            if (newCapacity < miniCapacity){
                newCapacity = miniCapacity;
            }
            Object[] objects = new Object[newCapacity];
            System.arraycopy(elementData, 0, objects, 0, elementData.length);
            elementData = objects;
        }
    }

    private void checkIndex(int index) {
        if (index > elementData.length -1) {
            throw new IllegalArgumentException("数组下标越界");
        }
    }


}
