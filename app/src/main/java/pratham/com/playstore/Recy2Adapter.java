package pratham.com.playstore;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

class Recy2Adapter extends RecyclerView.Adapter<Recy2Adapter.ViewHolder> {
    List<Ref_g_s> list;
    public Recy2Adapter(List<Ref_g_s> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
/*
        View v = LayoutInflater.from(parent.getContext()).inflate()*/
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull Recy2Adapter.ViewHolder holder, int position) {

    }


    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
