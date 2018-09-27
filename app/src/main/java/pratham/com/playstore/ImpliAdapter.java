package pratham.com.playstore;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

class ImpliAdapter extends RecyclerView.Adapter<ImpliAdapter.MyViewHold> {
    List<PlayStore1G_S> list;
    EditText editText ;
    Context context;
    public ImpliAdapter(List<PlayStore1G_S> playStore1G_s, EditText editText) {
        list = playStore1G_s;
        this.editText = editText;
    }

    @NonNull
    @Override
    public MyViewHold onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        this.context = parent.getContext();
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.impli_txt,parent,false);
        return new MyViewHold(v);


    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHold holder, final int position) {

        holder.textView.setText(list.get(position).getTitle());
        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (Integer.parseInt(list.get(position).getSubTitle())){
                    case 0:

                        try{
                            if (Long.parseLong(String.valueOf(editText.getText().toString().length()))<=10){
                                context.startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+editText.getText().toString())));
                                Toast.makeText(context,editText.getText().toString().length()+"",Toast.LENGTH_LONG).show();
                            }else {
                                Toast.makeText(context,"Invalid Number",Toast.LENGTH_LONG).show();

                            }
                        }catch (Exception e){
                           // Toast.makeText(context,e.getMessage(),Toast.LENGTH_LONG).show();
                        }

                        break;

                    case 1:
                        try{
                            if (editText.getText().toString().toLowerCase().endsWith("com")||
                                    editText.getText().toString().toLowerCase().endsWith("in")||
                                    editText.getText().toString().toLowerCase().endsWith("net")){

                                Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("http://"+editText.getText().toString()));
                                context.startActivity(intent);
                            }else {
                                Toast.makeText(context,"Enter a valid web address" +
                                        "",Toast.LENGTH_LONG).show();
                            }
                        }catch (Exception e){
                            Toast.makeText(context,"Enter a valid web address" +
                                    e.getMessage(),Toast.LENGTH_LONG).show();
                        }

                        break;

                    case 2:
                        try{
                            if (Integer.parseInt(editText.getText().toString())<=1000){

                                Intent i = new Intent(Intent.ACTION_EDIT,Uri.parse("content://contacts/people/2"));
                                context.startActivity(i);
                            }else {
                                Toast.makeText(context,"Enter a valid contact details" ,Toast.LENGTH_LONG).show();

                            }
                        }catch (NumberFormatException e){

                        }
                }
            }
        });
    }



    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHold extends RecyclerView.ViewHolder {
        TextView textView ;
        public MyViewHold(View v) {
            super(v);

            textView = v.findViewById(R.id.txt);
        }
    }
}
