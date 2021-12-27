package Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import Utils.Utils;

public class Database extends SQLiteOpenHelper {

    public Database(@Nullable Context context) {
        super(context, Utils.DATABASE_NAME, null,Utils.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE="CREATE TABLE "+Utils.TABLE_NAME + "("
                +Utils.COL_ID +" INTEGER PRIMARY KEY,"
                +Utils.COL_NAME +" TEXT,"
                +Utils.COL_PASSWORD +" TEXT"
                +")";
        db.execSQL(CREATE_TABLE);

        String CREATE_USER_TABLE="CREATE TABLE "+Utils.TABLE_NAME_USER+ "("
                +Utils.COL_ID +" INTEGER PRIMARY KEY,"
                +Utils.COL_NAME +" TEXT,"
                +Utils.COL_PASSWORD +" TEXT,"
                +Utils.COL_AGE +" TEXT"
                +")";
        db.execSQL(CREATE_USER_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+Utils.TABLE_NAME);
        onCreate(db);

        SQLiteDatabase db1;
        db.execSQL("DROP TABLE IF EXISTS "+Utils.TABLE_NAME_USER);
        onCreate(db);
    }






    public boolean login(String ID,String Password){
        SQLiteDatabase database=this.getWritableDatabase();
        Cursor cursor=database.rawQuery("SELECT * FROM "+Utils.TABLE_NAME
                +" WHERE "+Utils.COL_ID+"=? AND "+Utils.COL_PASSWORD+"=?"
                ,new String[]{ID,Password});

        if (cursor!=null){
            if (cursor.getCount()>0){
                return true;
            }
        }
        return false;
    }

    public void adminInsert(String ID,String Name,String Password){
        SQLiteDatabase database=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();

        contentValues.put(Utils.COL_ID,ID);
        contentValues.put(Utils.COL_NAME,Name);
        contentValues.put(Utils.COL_PASSWORD,Password);

        database.insert(Utils.TABLE_NAME,null,contentValues);
        database.close();
    }

    public void deleteAdmin(String ID) {
        SQLiteDatabase database=this.getWritableDatabase();
        database.delete(Utils.TABLE_NAME,Utils.COL_ID+"=?",new String[]{String.valueOf(ID)});
    }

    public int updateAdmin(String idUpdateAdmin, String nameUpdateAdmin, String passwordUpdateAdmin) {
        SQLiteDatabase database=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(Utils.COL_NAME,nameUpdateAdmin);
        contentValues.put(Utils.COL_PASSWORD,passwordUpdateAdmin);

        return database.update(Utils.TABLE_NAME,contentValues,Utils.COL_ID+"=?",new String[]{String.valueOf(idUpdateAdmin)});

    }

    public Cursor searchForAdminById(String search) {
        SQLiteDatabase database=this.getReadableDatabase();
        Cursor cursor=database.query(Utils.TABLE_NAME
                ,new String[]{Utils.COL_ID,Utils.COL_NAME}
                ,Utils.COL_ID+"=?"
                ,new String[]{String.valueOf(search)},null,null,null);

        if (cursor !=null){
            cursor.moveToFirst();
        }
        return cursor;

    }

    public Cursor adminShowInfo(String ID,String Name,String Password){
        SQLiteDatabase database=this.getReadableDatabase();
        Cursor cursor=database.query(Utils.TABLE_NAME
                ,new String[]{Utils.COL_ID,Utils.COL_NAME,Utils.COL_PASSWORD},null,null,null,null,null);
        return cursor;
    }





    public boolean userLogin(String ID,String Password){
        SQLiteDatabase database=this.getWritableDatabase();
        Cursor cursor=database.rawQuery("SELECT * FROM "+Utils.TABLE_NAME_USER
                        +" WHERE "+Utils.COL_ID+"=? AND "+Utils.COL_PASSWORD+"=?"
                ,new String[]{ID,Password});

        if (cursor!=null){
            if (cursor.getCount()>0){
                return true;
            }
        }
        return false;
    }


    public void addUser(String ID,String Name,String Password,String Age){
        SQLiteDatabase database=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();

        contentValues.put(Utils.COL_ID,ID);
        contentValues.put(Utils.COL_NAME,Name);
        contentValues.put(Utils.COL_PASSWORD,Password);
        contentValues.put(Utils.COL_AGE,Age);

        database.insert(Utils.TABLE_NAME_USER,null,contentValues);
        database.close();
    }


    public Cursor searchForUserById(String ID){
        SQLiteDatabase database=this.getReadableDatabase();
        Cursor cursor=database.query(Utils.TABLE_NAME_USER
                ,new String[]{Utils.COL_ID,Utils.COL_NAME,Utils.COL_AGE}
                ,Utils.COL_ID+"=?"
                ,new String[]{String.valueOf(ID)},null,null,null);

        if (cursor !=null){
            cursor.moveToFirst();
        }
        return cursor;
    }


    public void deleteUser(String ID){
        SQLiteDatabase database=this.getWritableDatabase();
        database.delete(Utils.TABLE_NAME_USER,Utils.COL_ID+"=?",new String[]{String.valueOf(ID)});

    }


    public int updateUser(String ID,String name,String password, String age){
        SQLiteDatabase database=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(Utils.COL_NAME,name);
        contentValues.put(Utils.COL_PASSWORD,password);
        contentValues.put(Utils.COL_AGE,age);

        return database.update(Utils.TABLE_NAME_USER,contentValues,Utils.COL_ID+"=?",new String[]{String.valueOf(ID)});
    }










}
