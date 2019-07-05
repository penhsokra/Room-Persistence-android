package local.database.usermanagement.data.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.graphics.Bitmap;

@Entity(tableName = "book")
public class Book {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public String title;
    public String author;
    public String date;
    public String desc;
    public double price;
    //public int thumb;
    @ColumnInfo(name = "user_id")
    public int userID;
    @Ignore
    public Bitmap bitmap;

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", date='" + date + '\'' +
                ", desc='" + desc + '\'' +
                ", price=" + price +
                ", userID=" + userID +
                ", bitmap=" + bitmap +
                '}';
    }
}
