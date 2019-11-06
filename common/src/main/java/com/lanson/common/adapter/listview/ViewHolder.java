package com.lanson.common.adapter.listview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.util.Linkify;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;

public class ViewHolder {

    private final SparseArray<View> mViews;
    protected  int mPosition;
    private View mConvertView;
    protected int mLayoutId;
    private Context mContext;

    public ViewHolder(Context context, View itemView, ViewGroup parent, int position){
        this.mContext = context;
        this.mConvertView = itemView;
        this.mPosition = position;
        this.mViews = new SparseArray<View>();
        mConvertView.setTag(this);
    }

    /**
     * 拿到一个ViewHolder对象
     *
     * @param context
     * @param convertView
     * @param parent
     * @param layoutId
     * @param position
     * @return
     */
    public static ViewHolder get(Context context, View convertView, ViewGroup parent, int layoutId, int position){
        if (convertView == null){
            View itemView = LayoutInflater.from(context).inflate(layoutId, parent, false);
            ViewHolder holder = new ViewHolder(context, itemView, parent, position);
            holder.mLayoutId = layoutId;
            return holder;
        }else {
            ViewHolder holder = (ViewHolder)convertView.getTag();
            holder.mPosition = position;
            return holder;
        }
    }

    /**
     * 通过控件的Id获取对于的控件，如果没有则加入views
     *
     * @param viewId
     * @return
     */
    public <T extends View> T getView(int viewId){
        View view = mViews.get(viewId);
        if (view == null){
            view = mConvertView.findViewById(viewId);
            mViews.put(viewId, view);
        }
        return (T) view;
    }

    public View getConvertView(){
        return mConvertView;
    }

    public int getLayoutId(){
        return mLayoutId;
    }

    public void updatePosition(int position){
        this.mPosition = position;
    }

    public int getItemPosition(){
        return mPosition;
    }

    /***********以下均为辅助方法***********/

    /**
     * 设置TextView的值
     *
     * @param viewId
     * @param text
     * @return
     */
    public ViewHolder setText(int viewId, String text){
        TextView tv = getView(viewId);
        tv.setText(text);
        return this;
    }

    /**
     * 设置图片源
     * @param viewId
     * @param resId
     * @return
     */
    public ViewHolder setImageResource(int viewId, int resId){
        ImageView view = getView(viewId);
        view.setImageResource(resId);
        return this;
    }

    /**
     * 设置图片源
     * @param viewId
     * @param bitmap
     * @return
     */
    public ViewHolder setImageBitmap(int viewId, Bitmap bitmap){
        ImageView view = getView(viewId);
        view.setImageBitmap(bitmap);
        return this;
    }

    /**
     * 设置图片源
     * @param viewId
     * @param drawable
     * @return
     */
    public ViewHolder setImageDrawable(int viewId, Drawable drawable){
        ImageView view = getView(viewId);
        view.setImageDrawable(drawable);
        return this;
    }

    /**
     * 设置背景颜色
     * @param viewId
     * @param color
     * @return
     */
    public ViewHolder setBackgroundColor(int viewId, int color){
        View view = getView(viewId);
        view.setBackgroundColor(color);
        return this;
    }

    /**
     * 设置背景图片
     * @param viewId
     * @param backgroundRes
     * @return
     */
    public ViewHolder setBackgroundRes(int viewId, int backgroundRes){
        View view = getView(viewId);
        view.setBackgroundResource(backgroundRes);
        return this;
    }

    /**
     * 设置字体颜色
     * @param viewId
     * @param textColor
     * @return
     */
    public ViewHolder setTextColor(int viewId, int textColor){
        TextView view = getView(viewId);
        view.setTextColor(textColor);
        return this;
    }

    /**
     * 设置字体颜色
     * @param viewId
     * @param textColorRes
     * @return
     */
    public ViewHolder setTextColorRes(int viewId, int textColorRes){
        TextView view = getView(viewId);
        view.setTextColor(mContext.getResources().getColor(textColorRes));
        return this;
    }

    /**
     * 设置透明度
     * @param viewId
     * @param value
     * @return
     */
    @SuppressLint("NewApi")
    public ViewHolder setAlpha(int viewId, float value){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB){
            getView(viewId).setAlpha(value);
        } else{
            // Pre-honeycomb hack to set Alpha value
            AlphaAnimation alpha = new AlphaAnimation(value, value);
            alpha.setDuration(0);
            alpha.setFillAfter(true);
            getView(viewId).startAnimation(alpha);
        }
        return this;
    }

    /**
     * 设置是否可见
     * @param viewId
     * @param visible
     * @return
     */
    public ViewHolder setVisible(int viewId, boolean visible){
        View view = getView(viewId);
        view.setVisibility(visible ? View.VISIBLE : View.GONE);
        return this;
    }

    /**
     *设置超链接
     * @param viewId
     * @return
     */
    public ViewHolder linkify(int viewId){
        TextView view = getView(viewId);
        Linkify.addLinks(view, Linkify.ALL);
        return this;
    }

    /**
     *设置字体
     * @param typeface
     * @param viewIds
     * @return
     */
    public ViewHolder setTypeface(Typeface typeface, int... viewIds){
        for (int viewId : viewIds){
            TextView view = getView(viewId);
            view.setTypeface(typeface);
            view.setPaintFlags(view.getPaintFlags() | Paint.SUBPIXEL_TEXT_FLAG);
        }
        return this;
    }

    /**
     * 设置进度条
     * @param viewId
     * @param progress
     * @return
     */
    public ViewHolder setProgress(int viewId, int progress){
        ProgressBar view = getView(viewId);
        view.setProgress(progress);
        return this;
    }

    /**
     * 设置进度条
     * @param viewId
     * @param progress
     * @param max
     * @return
     */
    public ViewHolder setProgress(int viewId, int progress, int max){
        ProgressBar view = getView(viewId);
        view.setMax(max);
        view.setProgress(progress);
        return this;
    }

    /**
     * 设置进度条最大值
     * @param viewId
     * @param max
     * @return
     */
    public ViewHolder setMax(int viewId, int max){
        ProgressBar view = getView(viewId);
        view.setMax(max);
        return this;
    }

    /**
     *设置评分值
     * @param viewId
     * @param rating
     * @return
     */
    public ViewHolder setRating(int viewId, float rating){
        RatingBar view = getView(viewId);
        view.setRating(rating);
        return this;
    }

    /**
     * 设置评分最大值
     * @param viewId
     * @param rating
     * @param max
     * @return
     */
    public ViewHolder setRating(int viewId, float rating, int max){
        RatingBar view = getView(viewId);
        view.setMax(max);
        view.setRating(rating);
        return this;
    }

    /**
     * 设置Tag
     * @param viewId
     * @param tag
     * @return
     */
    public ViewHolder setTag(int viewId, Object tag){
        View view = getView(viewId);
        view.setTag(tag);
        return this;
    }

    /**
     * 设置带key的tag
     * @param viewId
     * @param key
     * @param tag
     * @return
     */
    public ViewHolder setTag(int viewId, int key, Object tag){
        View view = getView(viewId);
        view.setTag(key, tag);
        return this;
    }

    /**
     * 设置选中状态
     * @param viewId
     * @param checked
     * @return
     */
    public ViewHolder setChecked(int viewId, boolean checked){
        Checkable view = (Checkable) getView(viewId);
        view.setChecked(checked);
        return this;
    }

    /**
     * 添加点击事件
     * @param viewId
     * @param listener
     * @return
     */
    public ViewHolder setOnClickListener(int viewId, View.OnClickListener listener){
        View view = getView(viewId);
        view.setOnClickListener(listener);
        return this;
    }

    /**
     * 添加触摸事件
     * @param viewId
     * @param listener
     * @return
     */
    public ViewHolder setOnTouchListener(int viewId, View.OnTouchListener listener){
        View view = getView(viewId);
        view.setOnTouchListener(listener);
        return this;
    }

    /**
     * 添加长按事件
     * @param viewId
     * @param listener
     * @return
     */
    public ViewHolder setOnLongClickListener(int viewId, View.OnLongClickListener listener){
        View view = getView(viewId);
        view.setOnLongClickListener(listener);
        return this;
    }

}
