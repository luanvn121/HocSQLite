package com.example.rom.hocsqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Rom on 6/22/2016.
 */
public class StudentModify {

    private DBHelper dbHelper;
    public StudentModify(Context context) {
        dbHelper=new DBHelper(context);
    }
    //them
    public void insert (Student student){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values= new ContentValues();

        values.put(DBHelper.KEY_NAME,student.getName());
        values.put(DBHelper.KEY_EMAIL,student.getEmail());
        values.put(DBHelper.KEY_AGE,student.getAge());
        values.put(DBHelper.KEY_SDT,student.getSdt());

        db.insert(DBHelper.TABLE_NAME,null,values);
        db.close();

    }
    //sua
    public void update(Student student){
        SQLiteDatabase db=dbHelper.getWritableDatabase();
       ContentValues values=new ContentValues();

        values.put(DBHelper.KEY_NAME,student.getName());
        values.put(DBHelper.KEY_EMAIL,student.getEmail());
        values.put(DBHelper.KEY_AGE,student.getAge());
        values.put(DBHelper.KEY_SDT,student.getSdt());

        db.update(DBHelper.TABLE_NAME,values, DBHelper.KEY_ID+ "=?",new String[]{
                String.valueOf(student.getStudent_id())});
        db.close();

        }
    //xoa
    public void delete(int student_id){
        SQLiteDatabase db=dbHelper.getWritableDatabase();
        ContentValues values=new ContentValues();
        db.delete(DBHelper.TABLE_NAME,DBHelper.KEY_ID+"=?",new String[]{String.valueOf(student_id)});
        db.close();
    }

    //lấy tất cả dữ liệu trong bảng
    public Cursor getStudentList() {
        SQLiteDatabase db=dbHelper.getReadableDatabase();
        Cursor cursor= db.query(DBHelper.TABLE_NAME,new String[]{DBHelper.KEY_ID,DBHelper.KEY_NAME,DBHelper.KEY_EMAIL,DBHelper.KEY_AGE,DBHelper.KEY_SDT},null,null,null,null,null,null);
        if(cursor!=null){
            cursor.moveToFirst();

        }
        return cursor;
    }
    //lấy 1 dữ liệu trong bảng
    public Student fetchStudentByID(int student_id){
        SQLiteDatabase db=dbHelper.getReadableDatabase();
        Cursor cursor = db.query(DBHelper.KEY_NAME,new String[]{
                DBHelper.KEY_ID,DBHelper.KEY_NAME,DBHelper.KEY_EMAIL,DBHelper.KEY_AGE,DBHelper.KEY_SDT},DBHelper.KEY_ID+"=?",new String[]{String.valueOf(student_id)},null,null,null);
        if (cursor!=null){

    cursor.moveToFirst();
}
return new Student(cursor.getInt(0),cursor.getString(1),cursor.getString(2),cursor.getInt(3),cursor.getInt(4));
        }

}
