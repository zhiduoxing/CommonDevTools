package com.lanson.common.adapter.listview.base;

import com.lanson.common.adapter.listview.ViewHolder;

public interface ItemViewDelegate<T> {

    abstract int getItemViewLayoutId();

    abstract boolean isForViewType(T item, int position);

    abstract void convert(ViewHolder holder, T t, int position);

}
