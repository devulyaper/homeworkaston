package org.example.myList;

public interface MyList<T> {

    /**
     * Добавляет новый элемент в список. При достижении размера внутреннего
     * массива происходит его увеличение в два раза.
     *
     * @param item элемент, который нужно добавить в список
     */
    void add(T item);

    /**
     * Добавляет новый элемент в список по индексу.
     *
     * @param item элемент, который нужно добавить в список
     * @param index индекс, по которому нужно добавить элемент
     */
    void add(T item, int index);

    /**
     * @param index индекс элемента, который нужно вернуть
     * @return элемент списка по указанному индексу
     */
    T get(int index);

    /**
     * Удаляет элемент списка по индексу. Все элементы справа от удаляемого
     * перемещаются на шаг влево. Если после удаления элемента количество
     * элементов стало в CUT_RATE раз меньше чем размер внутреннего массива,
     * то внутренний массив уменьшается в два раза, для экономии занимаемого
     * места.
     *
     * @param index индекс элемента, который нужно удалить
     */
    void remove(int index);

    /**
     * Удаляет первое вхождение элемента в список.
     *
     * @param item элемент, который нужно удалить из списка
     */
    void remove(T item);

    /**
     * Удаляет все элементы из списка.
     */
    void removeAll();

    /**
     * @return количество элементов в списке
     */
    int size();
}
