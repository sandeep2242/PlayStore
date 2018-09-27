package pratham.com.playstore;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class TwoFragment extends Fragment {


    Context context;
    RecyclerView recyclerView;
    public TwoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        context = container.getContext();

        String[] titles = context.getResources().getStringArray(R.array.titleArr);
        String[] orderId = context.getResources().getStringArray(R.array.orderId);
        String[] frnz = context.getResources().getStringArray(R.array.frndName);
        List<Ref_g_s> list = new ArrayList<>();


        for (int i = 0; i < titles.length; i++) {
            Ref_g_s g_s = new Ref_g_s();    // making object of getter setter class
            g_s.setFrnz(frnz[i]); //setting inidiviual elemnts in setFrnz
            g_s.setOrderId(orderId[i]);
            g_s.setTitle(titles[i]);

            list.add(g_s); // adding datat to the array list

        }

      /*  recyclerView = getView().findViewById(R.id.recy2View);
        LinearLayoutManager manager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(manager);
        Recy2Adapter adapter = new Recy2Adapter(list);
        recyclerView.setAdapter(adapter);*/

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_two, container, false);
    }

}
