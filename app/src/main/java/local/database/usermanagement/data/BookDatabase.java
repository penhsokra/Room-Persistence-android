package local.database.usermanagement.data;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import local.database.usermanagement.data.dao.BookDao;
import local.database.usermanagement.data.entity.Book;

@Database(version = 1,entities = {Book.class})
public abstract class BookDatabase extends RoomDatabase {

    static final String DB_NAME = "book_db";
    public abstract BookDao bookDao();

    public static BookDatabase getInstance(Context context){
        return Room.databaseBuilder(context,BookDatabase.class,DB_NAME).allowMainThreadQueries().build();
    }

}
