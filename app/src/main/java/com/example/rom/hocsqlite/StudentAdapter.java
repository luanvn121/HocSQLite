package com.example.rom.hocsqlite;

import android.content.Context;
import android.database.Cursor;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

/**
 * Created by Rom on 6/22/2016.
 */
public class StudentAdapter extends CursorAdapter {
    public StudentAdapter(Context context, Cursor c, boolean autoRequery) {
        super(context, c, autoRequery);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        View view= LayoutInflater.from(context).inflate(R.layout.item_line,parent,false);
        return view;
    }
    
    //fafasfsdfsdf

    //nhanh2
    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView tvName, tvAge,tvSdt;
        tvName=(TextView)view.findViewById(R.id.tvName);
        tvAge=(TextView)view.findViewById(R.id.tvAge);
        tvSdt=(TextView)view.findViewById(R.id.tvSdt);


        tvName.setText(cursor.getString(1));
        tvAge.setText(String.valueOf(cursor.getInt(3)));
        tvAge.setText(String.valueOf(cursor.getInt(4)));

    }

    public Parcelable getItem() {
        return null;
    }
}
