package dangnh.homework.e.currencyconverter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * @author: dangnh
 * Adapter for Currency types spinner
 */
public class MyArrayAdapter extends ArrayAdapter<Item> {
    public MyArrayAdapter(Context context, ArrayList<Item> items) {
        super(context, R.layout.my_spinner, items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.my_spinner, parent, false);
        }
        TextView txtView = (TextView) convertView.findViewById(R.id.txtView);
        ImageView imgView = (ImageView) convertView.findViewById(R.id.imgView);
        //Display only abbreation of the currency after selected
        txtView.setText(getItem(position).getTxt().substring(0, 3));
        imgView.setImageResource(getItem(position).getImg());
        return convertView;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.my_spinner, parent, false);
        }
        TextView txtView = (TextView) convertView.findViewById(R.id.txtView);
        ImageView imgView = (ImageView) convertView.findViewById(R.id.imgView);
        txtView.setText(getItem(position).getTxt());
        imgView.setImageResource(getItem(position).getImg());
        return convertView;

    }
}
