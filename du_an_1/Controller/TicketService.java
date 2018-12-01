package com.example.admin.du_an_1.Controller;

import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import com.example.admin.du_an_1.DAO.daoProducts;
import com.example.admin.du_an_1.Repository.Product;
import com.example.admin.du_an_1.Repository.Ticket;

public class TicketService {
    Context context;
    daoProducts DaoProducts;
    public TicketService(Context context) {
        this.context = context;
        DaoProducts= daoProducts.getInstance(context);
    }

    public String getTitle(Bundle args) {
        return args.getCharSequence("title", "NO TITLE FOUND").toString();
    }

    public Boolean setType(String typeString) {
        if (typeString.equals("Export")) {
            return true ;
        } else
            return false;
    }

    public void addTicket(Ticket ticket, Product product,String ticketType){
        if(setType(ticketType)){
            addExport(ticket,product);
        }
        else{
            addImport(ticket,product);
        }
    }

    private void addImport(Ticket ticket, Product product){
        DaoProducts.insertProduct(product);
        Toast.makeText(context, "Add Import", Toast.LENGTH_SHORT).show();
        // Add Ticket to TABLE with type import
    }

    private void addExport(Ticket ticket, Product product){
        Toast.makeText(context, "Add Export", Toast.LENGTH_SHORT).show();
        // Add Ticket to TABLE with type export
    }
}
