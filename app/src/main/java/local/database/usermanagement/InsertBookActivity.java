package local.database.usermanagement;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import local.database.usermanagement.data.BookDatabase;
import local.database.usermanagement.data.entity.Book;

public class InsertBookActivity extends AppCompatActivity {
    EditText title,price,date,author,des;
    Button btnInsert;
    BookDatabase bookDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_book);

        title = findViewById(R.id.iptTitle);
        author = findViewById(R.id.iptAuthor);
        des = findViewById(R.id.iptDes);
        date = findViewById(R.id.iptDate);
        price = findViewById(R.id.iptPrice);
        btnInsert = findViewById(R.id.btnInsert);

        bookDatabase= BookDatabase.getInstance(this);
        btnInsert.setOnClickListener(v->{
           try {
               Book book = new Book();
               book.title = title.getText().toString();
               book.author = author.getText().toString();
               book.desc = des.getText().toString();
               book.date = date.getText().toString();
               book.id =0;
               book.price = Double.parseDouble(price.getText().toString());
               insertBook(book);
               Toast.makeText(this, "Inserted", Toast.LENGTH_SHORT).show();
           }catch (Exception e){
                Log.e("11111",""+e.toString());
           }
        });

    }

    private long insertBook(Book book){
        if (book !=null){
            return bookDatabase.bookDao().save(book);
        }
        return 0l;
    }

    private void getBookList(){
        List<Book> books =bookDatabase.bookDao().getBook();
        Log.e("00000","Book List"+books.toString());
    }
}
