package com.example.admin.du_an_1.UI.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.du_an_1.Controller.TicketService;
import com.example.admin.du_an_1.DAO.daoProducts;
import com.example.admin.du_an_1.DAO.daoUsers;
import com.example.admin.du_an_1.R;
import com.example.admin.du_an_1.Repository.Product;
import com.example.admin.du_an_1.Repository.Ticket;

import java.util.ArrayList;
import java.util.List;

public class Fragment_AddTicket extends Fragment implements View.OnClickListener {
    TicketService ticketService;
    Context context;
    Boolean ticketType;
    EditText etTicketTittle, etQuantity, etproductname, getEtproductcode;
    Spinner spProductId, spcategory ;
    Button btnAddTicket, btnCancel,  btnAddCategory, btndate;
    TextView tvTittle;
    String tittle;

    Product myProduct = new Product();
    Ticket myTicket;

    public Fragment_AddTicket() {
    }

    public static Fragment_AddTicket newInstance(String title) {
        Fragment_AddTicket fragment = new Fragment_AddTicket();
        Bundle args = new Bundle();
        args.putCharSequence("title", title);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Create instance context for Service and furthur use, user context instead getActivity()
        context=getActivity();
        // Set Tittle for Ticket
        ticketService= new TicketService(context);
        //CREATE FAKE DATA FOR TESTING
        myTicket= new Ticket();


    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.add_ticket_fragment, container, false);
        // DECLEARATION
        tvTittle=(TextView) view.findViewById(R.id.tvTicket);
        btnAddTicket= (Button) view.findViewById(R.id.btnAddTicket);


//        List<String> category = new ArrayList<>();
//        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(),android.R.layout.simple_spinner_item,category);
//        adapter.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
//        category.add("Cat");
//        category.add("Da");
//        category.add("Xi mang");
//        category.add("Sat");
//        spcategory.setAdapter(adapter);
//        etproductname = (EditText) view.findViewById(R.id.etProductName);
//        getEtproductcode = (EditText) view.findViewById(R.id.etProductCode);
// setup product


        //SETUP FUNC for ELEMENT
         tvTittle.setText(getTitle());
        tittle =getTitle();
        btnAddTicket.setOnClickListener(this);


        return view;
    }
//public Product addproduct (){
//
//            myProduct = new Product();
//            myProduct.setName(etproductname.getText().toString());
//            myProduct.setCode(getEtproductcode.getText().toString());
//            myProduct.setId(null);
//            if (spcategory.getSelectedItemPosition() == 0){
//                myProduct.setCategory("0");
//            }
//            else if (spcategory.getSelectedItemPosition() == 1){
//                myProduct.setCategory("1");
//            }
//            else if (spcategory.getSelectedItemPosition() == 2){
//                myProduct.setCategory("2");
//            }
//            else if (spcategory.getSelectedItemPosition() == 3){
//                myProduct.setCategory("3");
//            }
//        return myProduct;
//}
    public void onAddClicked(Ticket ticket, Product product,String tittle){
        this.ticketService.addTicket(ticket,product,tittle);
    }

    public void onCancelClicked(){}

    public String getTitle() {
        Bundle args = getArguments();
        return this.ticketService.getTitle(args);
    }
    public Boolean validate(){
        if (etproductname.getText().toString() == null){
            Toast.makeText(context, "Ten san pham trong", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (getEtproductcode.getText().toString() == null){
            Toast.makeText(context, "Ma san pham trong", Toast.LENGTH_SHORT).show();
            return false;
            }
        return true;
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case (R.id.btnAddTicket):
                if (validate() == true){
                    onAddClicked(myTicket,myProduct,tittle);
                }
                break;
        }

    }
}
