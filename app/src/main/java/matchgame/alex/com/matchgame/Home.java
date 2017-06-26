package matchgame.alex.com.matchgame;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Collections;
import static java.util.Arrays.asList;
public class Home extends AppCompatActivity {

    Button bt1, bt2, bt3, bt4, bt5, bt6, bt7, bt8, bt9, bt10, bt11, bt12, bt13, bt14, bt15, bt16;

    TextView txtacerto, txterro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        txtacerto = (TextView) findViewById(R.id.txtAcerto);
        txterro = (TextView) findViewById(R.id.txtErros);
        bt1 = (Button) findViewById(R.id.btn1);
        bt2 = (Button) findViewById(R.id.btn2);
        bt3 = (Button) findViewById(R.id.btn3);
        bt4 = (Button) findViewById(R.id.btn4);
        bt5 = (Button) findViewById(R.id.btn5);
        bt6 = (Button) findViewById(R.id.btn6);
        bt7 = (Button) findViewById(R.id.btn7);
        bt8 = (Button) findViewById(R.id.btn8);
        bt9 = (Button) findViewById(R.id.btn9);
        bt10 = (Button) findViewById(R.id.btn10);
        bt11 = (Button) findViewById(R.id.btn11);
        bt12 = (Button) findViewById(R.id.btn12);
        bt13 = (Button) findViewById(R.id.btn13);
        bt14 = (Button) findViewById(R.id.btn14);
        bt15 = (Button) findViewById(R.id.btn15);
        bt16 = (Button) findViewById(R.id.btn16);

        final Button[] BotoesArray = new Button[]{bt1, bt2, bt3, bt4, bt5, bt6, bt7, bt8, bt9, bt10, bt11, bt12, bt13, bt14, bt15, bt16};
        ArrayList ValoresArray = new ArrayList(asList(1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8));
        Collections.shuffle(ValoresArray);

        for (int i = 0; i < ValoresArray.size(); i++) {
            for (int j = 0; j < BotoesArray.length; j++) {
                BotoesArray[j].setText(String.valueOf((ValoresArray.get(i))));
                ValoresArray.remove(i);
            }
        }


        for (int i = 0; i < BotoesArray.length; i++) {
            final int finalI = i;
            BotoesArray[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    BotoesArray[finalI].setTextColor(Color.parseColor("#000000"));


                }
            });
        }


    }
}
