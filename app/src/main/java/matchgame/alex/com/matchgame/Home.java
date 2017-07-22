package matchgame.alex.com.matchgame;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.Arrays.asList;

public class Home extends AppCompatActivity {

    Button bt1, bt2, bt3, bt4, bt5, bt6, bt7, bt8, bt9, bt10, bt11, bt12, bt13, bt14, bt15, bt16,btReiniciar;
    TextView txtAcerto, txtErro;
    int Acerto=0, Erro=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);


        txtAcerto = (TextView) findViewById(R.id.txtAcerto);
        txtErro = (TextView) findViewById(R.id.txtErros);
        btReiniciar=(Button)findViewById(R.id.btnReiniciar);
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

        final Button[] Botoes = new Button[]{bt1, bt2, bt3, bt4, bt5, bt6, bt7, bt8, bt9, bt10, bt11, bt12, bt13, bt14, bt15, bt16};
        final ArrayList BotoesValores = new ArrayList(asList(1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8));
        Collections.shuffle(BotoesValores);
        final List ListaValoresBotaoClicado = new ArrayList();

        for (int i = 0; i < BotoesValores.size(); i++) {
            for (int j = 0; j < Botoes.length; j++) {
                Botoes[j].setText(String.valueOf((BotoesValores.get(i))));
                BotoesValores.remove(i);
            }
        }

        for (int i = 0; i < Botoes.length; i++) {
            final int finalI = i;
            Botoes[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Botoes[finalI].setTextColor(Color.parseColor("#000000"));
                    Botoes[finalI].setTag("0");
                    ListaValoresBotaoClicado.add(Botoes[finalI].getText());

                    if (ListaValoresBotaoClicado.size() == 2) {
                        for (int i = 0; i < Botoes.length; i++) {
                            if (Botoes[i].getTag() == "0" && (ListaValoresBotaoClicado.contains(Botoes[i].getText()))) {
                                if (String.valueOf(ListaValoresBotaoClicado.get(0).toString()).equals(String.valueOf(ListaValoresBotaoClicado.get(1).toString()))) {
                                    Botoes[i].setTextColor(Color.GRAY);
                                    Botoes[i].setClickable(false);
                                    Botoes[i].setTag("");
                                    Acerto++;
                                }
                            } else {
                                for (int k = 0; k < Botoes.length; k++) {
                                    if (Botoes[k].getTag()=="0"){
                                        Botoes[k].setTextColor(Color.TRANSPARENT);
                                    }
                                }
                                Erro++;
                            }
                        }
                        for (int j = 0; j < Botoes.length; j++) {
                            Botoes[j].setTag("");
                        }
                        ListaValoresBotaoClicado.clear();
                    }
                    if (Acerto==16){
                        Toast.makeText(getApplicationContext(),"Parabéns! Você Conseguiu.",Toast.LENGTH_SHORT).show();
                        btReiniciar.setVisibility(View.VISIBLE);
                    }
                    txtAcerto.setText(String.valueOf(" Acertos: "+Acerto));
                    txtErro.setText(String.valueOf(" Erros: "+ Erro));
                }
            });
        }

        btReiniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btReiniciar.setVisibility(View.INVISIBLE);
                final ArrayList BotoesValores = new ArrayList(asList(1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8));
                Collections.shuffle(BotoesValores);
                for (int i = 0; i < BotoesValores.size(); i++) {
                    for (int j = 0; j < Botoes.length; j++) {
                        Botoes[j].setText(String.valueOf((BotoesValores.get(i))));
                        Botoes[j].setTextColor(Color.TRANSPARENT);
                        BotoesValores.remove(i);
                        if (Botoes[i].getTag() == "0" && (ListaValoresBotaoClicado.contains(Botoes[i].getText()))) {
                            Botoes[i].setClickable(true);
                            Botoes[i].setTag("");
                        }
                    }
                }
                Acerto=0;
                Erro=0;
                txtAcerto.setText(String.valueOf(" Acertos: "+Acerto));
                txtErro.setText(String.valueOf(" Erros: "+ Erro));
                ListaValoresBotaoClicado.clear();
            }
        });
    }
}
