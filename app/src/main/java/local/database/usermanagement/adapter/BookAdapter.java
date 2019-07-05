package local.database.usermanagement.adapter;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

import local.database.usermanagement.R;
import local.database.usermanagement.data.entity.Book;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.ViewHolder> {
    private List<Book> bookList;
    private AppCompatActivity context;

    public BookAdapter(List<Book> bookList, AppCompatActivity context) {
        this.bookList = bookList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.book_list_layout,viewGroup,false);
        return new BookAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        final Book book = bookList.get(position);
        viewHolder.title.setText(book.title);
        viewHolder.price.setText((int) book.price);
        viewHolder.des.setText(book.desc);
        viewHolder.date.setText(book.date);
        viewHolder.author.setText(book.author);
    }

    @Override
    public int getItemCount() {
        return bookList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView title,price,date,author,des;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.txtTitle);
            price = itemView.findViewById(R.id.txtPrice);
            date = itemView.findViewById(R.id.txtDate);
            author = itemView.findViewById(R.id.txtAuthor);
            des = itemView.findViewById(R.id.txtDes);
        }
    }
}
