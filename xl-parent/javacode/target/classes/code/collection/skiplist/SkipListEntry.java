package code.collection.skiplist;

import lombok.Data;

/**
 * 跳表的实现:节点模型
 *
 */
@Data
public class SkipListEntry<T> {

    // data
    public Integer key;
    public T value;

    // links
    public SkipListEntry up;
    public SkipListEntry down;
    public SkipListEntry left;
    public SkipListEntry right;


    // constructor
    public SkipListEntry(Integer key, T value) {
        this.key = key;
        this.value = value;
    }




}
