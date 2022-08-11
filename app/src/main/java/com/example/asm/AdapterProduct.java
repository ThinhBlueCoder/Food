package com.example.asm;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.RequiresApi;

import java.util.ArrayList;

public class AdapterProduct extends BaseAdapter {

    Context context;
    ArrayList<Product> listProducts;

    public AdapterProduct(Context context,ArrayList<Product> listProducts){
        this.context=context;
        this.listProducts=listProducts;
    }
    @Override
    public int getCount() {
        return listProducts.size();
    }

    @Override
    public Object getItem(int i) {
        return listProducts.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }
    public class ViewHolder{
        TextView tvId,tvName;
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater=LayoutInflater.from(context);
        ViewHolder viewHolder;
        if (view==null){
            viewHolder=new ViewHolder();
            view=inflater.inflate(R.layout.list_view,null);
            viewHolder.tvId=(TextView) view.findViewById(R.id.pid);
            viewHolder.tvName=(TextView) view.findViewById(R.id.name);
            view.setTag(viewHolder);
        }else {
            viewHolder=(ViewHolder) view.getTag();
        }
        Product product=listProducts.get(i);
        viewHolder.tvId.setText(product.getId()+"");
        viewHolder.tvName.setText(product.getName());
        return view;
    }
}

