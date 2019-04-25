package com.example.contacts;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * @author: dangnh
 * Adapter for listview
 */
public class MyArrayAdapter extends ArrayAdapter<ContactsInfo> {
    public MyArrayAdapter(Context context, ArrayList<ContactsInfo> items) {
        super(context, R.layout.listview_element, items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.listview_element, parent, false);
        }
        TextView txtName = (TextView) convertView.findViewById(R.id.txtName);
        TextView txtEmail = (TextView) convertView.findViewById(R.id.txtEmail);
        TextView txtAddress = (TextView) convertView.findViewById(R.id.txtAddress);
        txtName.setText(getItem(position).getName());
        txtEmail.setText(getItem(position).getEmail());
        txtAddress.setText(getItem(position).getAddress());
        return convertView;
    }
}
