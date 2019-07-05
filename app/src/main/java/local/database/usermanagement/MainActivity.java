package local.database.usermanagement;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

import local.database.usermanagement.adapter.BookAdapter;
import local.database.usermanagement.data.BookDatabase;
import local.database.usermanagement.data.entity.Book;

public class MainActivity extends AppCompatActivity {
    private RecyclerView bookWrap;
    private List<Book> bookList = new ArrayList<>();
    private BookAdapter bookAdapter;
    BookDatabase bookDatabase;
   // private FilmAdapter filmAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bookDatabase= BookDatabase.getInstance(this);

        intiUI();
        getResult();

    }

    private void intiUI(){
        bookWrap = findViewById(R.id.bookWrap);
        bookWrap.setLayoutManager(new LinearLayoutManager(this));
        bookAdapter = new BookAdapter(bookList,this);
        bookWrap.setAdapter(bookAdapter);

    }

    private void getResult(){
        List<Book> books = bookDatabase.bookDao().getBook();
        for(int i =0;i<5;i++){
            //bookList.add();
        }
        bookAdapter.notifyDataSetChanged();
    }
}
