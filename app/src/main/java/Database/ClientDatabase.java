package Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import Utils.Utils;

public class ClientDatabase extends SQLiteOpenHelper {
    public ClientDatabase( Context context) {
        super(context, Utils.DATABASE_NAME2, null, Utils.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CLIENT_TABLE="CREATE TABLE "+Utils.TABLE_NAME_CLIENT+"("
                +Utils.COL_ID+" INTEGER PRIMARY KEY,"
                +Utils.COL_NAME+" TEXT,"
                +Utils.COL_AGE+" TEXT"
                +")";
        db.execSQL(CREATE_CLIENT_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+Utils.TABLE_NAME_CLIENT);
        onCreate(db);
    }




    public void addClient(String ID,String name,String Age){
        SQLiteDatabase database=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();

        contentValues.put(Utils.COL_ID,ID);
        contentValues.put(Utils.COL_NAME,name);
        contentValues.put(Utils.COL_AGE,Age);

        database.insert(Utils.TABLE_NAME_CLIENT,null,contentValues);
        database.close();
    }


    public void deleteClient(String ID){
        SQLiteDatabase database=this.getWritableDatabase();
        database.delete(Utils.TABLE_NAME_CLIENT,Utils.COL_ID+"=?",new String[]{String.valueOf(ID)});
    }


    public int updateClient(String ID,String Name,String Age){
        SQLiteDatabase database=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();

        contentValues.put(Utils.COL_NAME,Name);
        contentValues.put(Utils.COL_AGE,Age);

        return database.update(Utils.TABLE_NAME_CLIENT,contentValues,Utils.COL_ID+"=?",new String[]{String.valueOf(ID)});
    }


    public Cursor searchForClientById(String ID){
        SQLiteDatabase database=this.getReadableDatabase();
        Cursor cursor=database.query(Utils.TABLE_NAME_CLIENT
                ,new String[]{Utils.COL_ID,Utils.COL_NAME,Utils.COL_AGE}
                ,Utils.COL_ID+"=?"
                ,new String[]{String.valueOf(ID)},null,null,null,null);
        if (cursor!=null){
            cursor.moveToFirst();
        }
        return cursor;
    }
}
