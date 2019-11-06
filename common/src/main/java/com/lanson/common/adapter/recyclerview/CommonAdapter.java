package com.lanson.common.adapter.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;

import com.lanson.common.adapter.recyclerview.base.ItemViewDelegate;

import java.util.List;

public abstract class CommonAdapter<T> extends MultiItemTypeAdapter<T>
{
    private Context mContext;
    private int mLayoutId;
    private List<T> mDatas;
    private LayoutInflater mInflater;

    public CommonAdapter(final Context context, final int layoutId, List<T> datas){
        super(context, datas);
        mContext = context;
        mInflater = LayoutInflater.from(context);
        mLayoutId = layoutId;
        mDatas = datas;

        addItemViewDelegate(new ItemViewDelegate<T>(){
            @Override
            public int getItemViewLayoutId(){
                return layoutId;
            }

            @Override
            public boolean isForViewType( T item, int position){
                return true;
            }

            @Override
            public void convert(ViewHolder holder, T t, int position){
                CommonAdapter.this.convert(holder, t, position);
            }
        });
    }

    protected abstract void convert(ViewHolder holder, T t, int position);


}
