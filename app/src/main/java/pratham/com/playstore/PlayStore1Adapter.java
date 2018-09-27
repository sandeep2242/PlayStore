package pratham.com.playstore;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class PlayStore1Adapter extends RecyclerView.Adapter<PlayStore1Adapter.MyViewHolder> {
    Context context;
    View v1,v2;
    List<PlayStore1G_S> list;
    public PlayStore1Adapter(List<PlayStore1G_S> list) {
        this.list = list;
    }

    @Override
    public int getItemViewType(int position) {
        try {
            PlayStore1G_S gs = list.get(position);

            if (gs.getAds()==0){
                return 0;
            }else {
                return 1;
            }
        }catch (Exception e){
            return 1;
        }


    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        this.context= parent.getContext();
        switch (viewType){
            case 0:
                v1 = LayoutInflater.from(context).inflate(R.layout.single3,parent,false);
                return new MyViewHolder(v1);
            case 1:
                v2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_row1,parent,false);
                return new MyViewHolder(v2);
        }return null;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {


        if (holder.mView==v2){
            try{
                holder.title.setText(list.get(position).getTitle());
                holder.subTitle.setText(list.get(position).getSubTitle());/*
        Log.i("sand", Arrays.toString(list.get(position).getList().getImages()));
        Log.i("sand", Arrays.toString(list1.get(0).getImageTitles()));*/

                RecyclerView.LayoutManager manager = new LinearLayoutManager(this.context,LinearLayoutManager.HORIZONTAL,false);
                holder.recyclerView.setLayoutManager(manager);
                PlayStore2Adapter adapter = new PlayStore2Adapter(list.get(position).getgSList(),context );
                holder.recyclerView.setAdapter(adapter);
            }catch (Exception e){
                Log.e("ez",e.getMessage());
            }

        }




    }


    @Override
    public int getItemCount() {
        return list.size()+2;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView title,subTitle;
        RecyclerView recyclerView;
        View mView;
        public MyViewHolder(View v) {
            super(v);
            mView= v;

            title = v.findViewById(R.id.title1);
            subTitle = v.findViewById(R.id.subTitle1);
            recyclerView = v.findViewById(R.id.newRecyView);
        }
    }
}
