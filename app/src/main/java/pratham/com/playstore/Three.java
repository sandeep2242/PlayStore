package pratham.com.playstore;


import android.app.Dialog;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.text.SpannableString;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class Three extends Fragment {


    TextView textView;
    String string, txt;
    Dialog dialog;
    long startTime;
    SpannableString spannableString;

    public Three() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        string = container.getResources().getString(R.string.activity);
        return inflater.inflate(R.layout.fragment_three, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        textView = getView().findViewById(R.id.tect);
        ImageView imageView = getView().findViewById(R.id.search);
        final TextInputEditText editText = getView().findViewById(R.id.edit);

        textView.setText(string);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                highlight(editText.getText().toString());
            }
        });


        super.onActivityCreated(savedInstanceState);
    }

    public void highlight(final String txt) {

        spannableString = new SpannableString(string);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setCancelable(false); // if you want user to wait for some process to finish,
        builder.setView(R.layout.loading_dialog);
        dialog = builder.create();
        this.txt = txt;


        startTime = System.currentTimeMillis();
        new AsyTask().execute();


    }


    private class AsyTask extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... voids) {
            int n = string.length();
            for (int i = 0; i < n; i++)
                for (int j = i + 1; j <= n; j++)

                        if (string.substring(i, j).toLowerCase().equals(txt.toLowerCase())) {

                            spannableString.setSpan(new BackgroundColorSpan(Color.YELLOW), i, j, 0);
                            spannableString.setSpan(new StyleSpan(Typeface.BOLD), i, j, 0);
                            spannableString.setSpan(new ForegroundColorSpan(Color.BLACK), i, j, 0);
                        }



            return null;
        }

        @Override
        protected void onPreExecute() {
            dialog.show();
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(Void aVoid) {

            int x = (int) ((System.currentTimeMillis()-startTime)/1000);
            Toast.makeText(getActivity().getApplicationContext(),String.valueOf(x),Toast.LENGTH_LONG).show();
            try {


                if (spannableString != null || spannableString.equals("")) {
                    textView.setText(spannableString);

                } else {
                    dialog.dismiss();
                    Log.i("error", "sand");
                    Toast.makeText(getActivity(), "Item not found", Toast.LENGTH_SHORT).show();
                }

            } catch (Exception e) {
                Log.i("error", e.getMessage());
                Toast.makeText(getActivity(), "Item not found", Toast.LENGTH_SHORT).show();
            }
            dialog.dismiss();
            super.onPostExecute(aVoid);
        }
    }
}

