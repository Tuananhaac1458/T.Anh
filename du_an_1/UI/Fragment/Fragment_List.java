package com.example.admin.du_an_1.UI.Fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.example.admin.du_an_1.Adapter.AdapterProduct;
import com.example.admin.du_an_1.Controller.LoginService;
import com.example.admin.du_an_1.Controller.TicketService;
import com.example.admin.du_an_1.DAO.daoProducts;
import com.example.admin.du_an_1.R;
import com.example.admin.du_an_1.Repository.Product;
import com.example.admin.du_an_1.Repository.Ticket;
import com.example.admin.du_an_1.UI.AddTicketActivity;

import java.util.List;

public class Fragment_List extends Fragment implements View.OnClickListener {
    FloatingActionButton fab;
    ListView listView;
    Context context;

    daoProducts DaoProduct;
    List<Product> arrayProducts;
    AdapterProduct adapterProduct;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        DaoProduct = daoProducts.getInstance(context);

       // add listview
//        arrayProducts =  DaoProduct.getAllItem();
//        adapterProduct = new AdapterProduct(this,arrayProducts);
//        adapterProduct.notifyDataSetChanged();
//        listView.setAdapter(adapterProduct);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_list, container, false);
        fab= (FloatingActionButton) view.findViewById(R.id.btnFAB_Add);
        fab.setOnClickListener(this);
          // tvtrangthai = (TextView) view.findViewById(R.id.tvtrangthai);
//        listView = (ListView) view.findViewById(R.id.lvproduct);
//
//        //
//        DaoProduct = daoProducts.getInstance(context);
//        arrayProducts =  DaoProduct.getAllItem();
//        adapterProduct = new AdapterProduct(this,arrayProducts);
//        adapterProduct.notifyDataSetChanged();
//        listView.setAdapter(adapterProduct);
        return view;
    }


    @Override
    public void onClick(View view) {
        startActivity(new Intent(getActivity(), AddTicketActivity.class));
    }
}
