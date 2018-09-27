package pratham.com.playstore;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class PlayStore2Adapter extends RecyclerView.Adapter<PlayStore2Adapter.MyViewHolder> {
    Play2G_S list;
    Context context;

    public PlayStore2Adapter(Play2G_S list, Context context) {
        this.list = list;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_row2, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {


        holder.textView.setText(list.getImageTitles()[position]);  /// shows error set null
        Picasso.get()
                .load(list.getImages()[position])
                .into(holder.imgs);
        holder.size.setText(list.getSize()[position]);

        holder.menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                PopupMenu popupMenu = new PopupMenu(context,v);
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        String s = "null";
                        switch (item.getItemId()){
                            case R.id.install:
                                s=list.getImageTitles()[position];
                                Toast.makeText(context, s +" is Installed", Toast.LENGTH_SHORT).show();
                                break;

                            case R.id.add:
                                s=list.getImageTitles()[position];
                                Toast.makeText(context, s+" is added to WishList", Toast.LENGTH_SHORT).show();
                                break;

                            case R.id.interest:
                                s=list.getImageTitles()[position];
                                Toast.makeText(context, s+" removed from your list", Toast.LENGTH_SHORT).show();
                                break;

                        }
                        return false;
                    }
                });

                popupMenu.inflate(R.menu.pop_up_menu);
                popupMenu.show();
            }
        });

    }


    @Override
    public int getItemCount() {

        return list.getImageTitles().length;  //returns 4
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textView,size;
        ImageView imgs,menu;

        public MyViewHolder(View v) {
            super(v);

            textView = v.findViewById(R.id.txtView);
            size = v.findViewById(R.id.size);
            imgs = v.findViewById(R.id.imgs);
            menu = v.findViewById(R.id.menu);
        }
    }
}
