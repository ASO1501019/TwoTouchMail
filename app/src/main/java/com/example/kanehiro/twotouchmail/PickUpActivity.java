package com.example.kanehiro.twotouchmail;

import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import java.util.Random;

public class PickUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pik_up);

        Button btnSend = (Button) this.findViewById(R.id.button);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioGroup rgPlace = (RadioGroup) findViewById(R.id.rg_place);
                int checkedId = rgPlace.getCheckedRadioButtonId();
                String strPlace = ((RadioButton) findViewById(checkedId)).getText().toString();
                EditText edit01 = (EditText) findViewById(R.id.editText);
                String title = edit01.getText().toString();

                Resources res = getResources();

                        //Randomクラスのインスタンス化
                        Random rnd = new Random();
                        int ran = rnd.nextInt(3);
                        Uri uri = null;

                switch(ran) {
                    case 1:
                         uri = Uri.parse("mailto:" + res.getString(R.string.mail1).toString());
                        break;
                    case 2:
                         uri = Uri.parse("mailto:" + res.getString(R.string.mail2).toString());
                        break;
                    case 3:
                        uri = Uri.parse("mailto:" + res.getString(R.string.mail3).toString());
                        break;
                }

                Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
                intent.putExtra(Intent.EXTRA_SUBJECT, title);
                intent.putExtra(Intent.EXTRA_TEXT, strPlace + "に迎えにきて");

                startActivity(intent);

            }
        });
    }
}