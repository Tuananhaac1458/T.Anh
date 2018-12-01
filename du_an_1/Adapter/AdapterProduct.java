package com.example.admin.du_an_1.Adapter;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.admin.du_an_1.DAO.daoProducts;
import com.example.admin.du_an_1.R;
import com.example.admin.du_an_1.Repository.Product;

import java.util.List;

public class AdapterProduct extends BaseAdapter {
   List<Product> arrProducts;
   public Fragment context;
    private int resource;
   public LayoutInflater inflater;
   daoProducts daoProducts;

   public AdapterProduct (Fragment context, List<Product> arrProducts){
       super();
       this.context = context;
       this.arrProducts = arrProducts;
   }

    @Override
    public int getCount() {
        return arrProducts.size();
    }

    @Override
    public Object getItem(int position) {
        return arrProducts.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public static class ViewHolder{
       TextView txtname;
       TextView txtcode;
       TextView txtcategory;
    }
    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
      ViewHolder holder;
      if (view == null){
          holder = new ViewHolder();
          view = inflater.inflate(R.layout
          .adapter_product,null);
          holder.txtname = (TextView) view.findViewById(R.id.txtname);
          holder.txtcode = (TextView) view.findViewById(R.id.txtcode);
          holder.txtcategory = (TextView) view.findViewById(R.id.txtcategory);
      }
      else holder = (ViewHolder) view.getTag();
      Product product = (Product) arrProducts.get(i);
       holder.txtcategory.setText(product.getCategory());
       holder.txtname.setText(product.getName());
       holder.txtcode.setText(product.getCode());
        return view;
    }
}
