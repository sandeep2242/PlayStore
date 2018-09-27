package pratham.com.playstore;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.text.method.DigitsKeyListener;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity  {
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        String intentName[] = getResources().getStringArray(R.array.impIntentName);
        String intentId[] = getResources().getStringArray(R.array.impIntentId);
        List<PlayStore1G_S> playStore1G_s = new ArrayList<>();

        for (int i = 0; i < intentName.length; i++) {
            PlayStore1G_S g_s = new PlayStore1G_S();
            g_s.setSubTitle(intentId[i]);
            g_s.setTitle(intentName[i]);
            playStore1G_s.add(g_s);
        }

         editText = findViewById(R.id.editText);
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
                        editText.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_FLAG_MULTI_LINE);

                    }
                    editText.setSelection(s.length());
                }catch (NumberFormatException e){
                    editText.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_FLAG_MULTI_LINE);

                    Log.i("sand",e.toString());
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        Button button = findViewById(R.id.btn);
        RecyclerView view = findViewById(R.id.recy23View);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        view.setLayoutManager(manager);
        ImpliAdapter adapter = new ImpliAdapter(playStore1G_s,editText);
        view.setAdapter(adapter);

    }


}
