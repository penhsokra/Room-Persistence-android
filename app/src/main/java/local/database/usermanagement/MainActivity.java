package local.database.usermanagement;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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
    FloatingActionButton floatingActionButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        floatingActionButton = findViewById(R.id.addMore);


        floatingActionButton.setOnClickListener(v->{
            Intent intent = new Intent(this,InsertBookActivity.class);
            startActivity(intent);
            finish();
        });

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
        bookAdapter.addMoreItem(books);
        Log.e("0000",""+books);
    }
}
