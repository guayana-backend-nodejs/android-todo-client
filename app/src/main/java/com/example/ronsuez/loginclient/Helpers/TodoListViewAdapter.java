package com.example.ronsuez.loginclient.Helpers;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.ronsuez.loginclient.Model.Todo;
import com.example.ronsuez.loginclient.R;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by ronsuez on 2/5/15.
 */
public class TodoListViewAdapter extends BaseAdapter {

    private ArrayList<Todo> mTodos;
    private Context mCtx;
    OnClick mListener;
    private LayoutInflater mInflater;


    public TodoListViewAdapter(ArrayList<Todo> todos , Context ctx, OnClick listener ){
           mTodos = todos;
           mCtx = ctx;
           mListener = listener;
           mInflater = LayoutInflater.from(mCtx);
    }

    @Override
    public int getCount() {
        return mTodos.size();
    }

    @Override
    public Object getItem(int position) {
        return mTodos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return mTodos.get(position).getId();
    }

    public void addItems(List<Todo> items) {
        mTodos = new ArrayList<Todo>(items);
        notifyDataSetChanged();
    }

    public void addItems(Todo item) {
        mTodos.add(item);
        notifyDataSetChanged();
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        final ViewHolder holder;

        if (convertView == null)  {

            convertView = mInflater.inflate(R.layout.the_item, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }else {

            holder = (ViewHolder)convertView.getTag();
        }

        holder.mFrame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view2) {
                mListener.onClick(position);

            }
        });

        //aqui defino lo que voy a escribir
        holder.mTodoTextView.setText(mTodos.get(position).getName());

        return convertView;
    }




    static class ViewHolder {
        @InjectView(R.id.todo_layout)
        LinearLayout mFrame;

        @InjectView(R.id.todo_textview)
        TextView mTodoTextView;

        public ViewHolder(View view) {
            ButterKnife.inject(this, view);
        }
    }

    public interface OnClick{
        void onClick(int position);
    }
}
