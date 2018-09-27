package pratham.com.playstore;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class RecyFragment extends Fragment  {

    List<PlayStore1G_S> list = new ArrayList<>();
    List<Play2G_S> list1 = new ArrayList<>();
    public RecyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_recy, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        final EditText editText = getView().findViewById(R.id.edText);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                try{

                    long a = Long.parseLong(String.valueOf(s));
                    if (a>99){
                        editText.setInputType(InputType.TYPE_CLASS_PHONE);
                    }else {
                        editText.setInputType(InputType.TYPE_CLASS_TEXT);
                    }
                    editText.setSelection(s.length());
                }catch (Exception e){
                    editText.setInputType(InputType.TYPE_CLASS_TEXT);
                    Log.i("sand",e.toString());
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        String title[] = this.getResources().getStringArray(R.array.titleArray);
        String subTitle[] = this.getResources().getStringArray(R.array.subTitleArray);
        String recy1[] = this.getResources().getStringArray(R.array.recy1);
        String recy2[] = this.getResources().getStringArray(R.array.recy2);
        String recy3[] = this.getResources().getStringArray(R.array.recy3);

        String ads[] = this.getResources().getStringArray(R.array.newRow);

        String recy1Titles[] = this.getResources().getStringArray(R.array.recy1Title);
        String recy2Titles[] = this.getResources().getStringArray(R.array.recy2Title);
        String recy3Titles[] = this.getResources().getStringArray(R.array.recy3Title);

        String recy1Price[] = this.getResources().getStringArray(R.array.recy1price);
        String recy2Size[] = this.getResources().getStringArray(R.array.recy2size);
        String recy3Size[] = this.getResources().getStringArray(R.array.recy3size);


        Play2G_S play2G_s = new Play2G_S(); //getter setter class
        play2G_s.setImages(recy1);
        play2G_s.setImageTitles(recy1Titles);
        play2G_s.setSize(recy1Price);
        list1.add(play2G_s);
        Log.i("sand2", list1+ "");



        Play2G_S play2G_s2 = new Play2G_S();//getter setter class
        play2G_s2.setImages(recy2);
        play2G_s2.setImageTitles(recy2Titles);
        play2G_s2.setSize(recy2Size);
        list1.add(play2G_s2);
        Log.i("sand2", list1+ "");

        Play2G_S play2G_s3 = new Play2G_S();//getter setter class
        play2G_s3.setImages(recy3);
        play2G_s3.setImageTitles(recy3Titles);
        play2G_s3.setSize(recy3Size);
        list1.add( play2G_s3);

        for (int i = 0; i < title.length; i++) {
            PlayStore1G_S g_s = new PlayStore1G_S();
            g_s.setSubTitle(subTitle[i]);
            g_s.setTitle(title[i]);
            g_s.setAds(Integer.parseInt(ads[i]));
            g_s.setgSList(list1.get(i));
            list.add(g_s);
        }

        RecyclerView recyclerView =getView(). findViewById(R.id.recyView);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(manager);
        PlayStore1Adapter adapter = new PlayStore1Adapter(list);
        recyclerView.setAdapter(adapter);
    }


}
