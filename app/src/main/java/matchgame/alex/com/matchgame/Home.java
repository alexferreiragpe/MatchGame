package matchgame.alex.com.matchgame;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.Arrays.asList;

public class Home extends AppCompatActivity {

    final List ListaValoresBotaoClicado = new ArrayList();
    final String iconeescondeimagem = (String.valueOf(R.drawable.interrogacao));
    Button bt1, bt2, bt3, bt4, bt5, bt6, bt7, bt8, bt9, bt10, bt11, bt12, bt13, bt14, bt15, bt16, bt17, bt18, bt19, bt20, bt21, bt22, bt23, bt24, bt25, bt26, bt27, bt28, bt29, bt30, btReiniciar;
    int Acerto = 0, Erro = 0, total = 0;
    ImageButton btnSobre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        btReiniciar = (Button) findViewById(R.id.btnReiniciar);
        btnSobre = (ImageButton) findViewById(R.id.btSobre);
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
        bt17 = (Button) findViewById(R.id.btn17);
        bt18 = (Button) findViewById(R.id.btn18);
        bt19 = (Button) findViewById(R.id.btn19);
        bt20 = (Button) findViewById(R.id.btn20);
        bt21 = (Button) findViewById(R.id.btn21);
        bt22 = (Button) findViewById(R.id.btn22);
        bt23 = (Button) findViewById(R.id.btn23);
        bt24 = (Button) findViewById(R.id.btn24);
        bt25 = (Button) findViewById(R.id.btn25);
        bt26 = (Button) findViewById(R.id.btn26);
        bt27 = (Button) findViewById(R.id.btn27);
        bt28 = (Button) findViewById(R.id.btn28);
        bt29 = (Button) findViewById(R.id.btn29);
        bt30 = (Button) findViewById(R.id.btn30);

        final Button[] Botoes = new Button[]{bt1, bt2, bt3, bt4, bt5, bt6, bt7, bt8, bt9, bt10,
                bt11, bt12, bt13, bt14, bt15, bt16, bt17, bt18, bt19, bt20,
                bt21, bt22, bt23, bt24, bt25, bt26, bt27, bt28, bt29, bt30};
        final ArrayList BotoesValores = new ArrayList(asList(1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8,
                9, 9, 10, 10, 11, 11, 12, 12, 13, 13, 14, 14, 15, 15));

        Collections.shuffle(BotoesValores);


        for (int i = 0; i < BotoesValores.size(); i++) {
            for (int j = 0; j < Botoes.length; j++) {
                Botoes[j].setText(String.valueOf((BotoesValores.get(i))));
                BotoesValores.remove(i);
                final int finalJ = j;
                Botoes[finalJ].postDelayed(new Runnable() {
                    public void run() {
                        Botoes[finalJ].setTextColor(Color.TRANSPARENT);
                        Botoes[finalJ].setTag("");
                        Botoes[finalJ].setClickable(true);
                        Botoes[finalJ].setBackgroundResource(Integer.parseInt(iconeescondeimagem));
                    }
                }, 3000);
            }
        }

        for (int i = 0; i < Botoes.length; i++) {
            final int finalI = i;
            Botoes[i].setOnClickListener(new View.OnClickListener() {
                @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
                @Override
                public void onClick(View v) {
                    if (ListaValoresBotaoClicado.size()>2){
                        ListaValoresBotaoClicado.clear();
                    }
                    Botoes[finalI].setClickable(false);
                    Botoes[finalI].setTextColor(Color.parseColor("#000000"));
                    Botoes[finalI].setBackground(null);
                    Botoes[finalI].setBackgroundColor(Color.CYAN);
                    Botoes[finalI].setTag("0");

                    ListaValoresBotaoClicado.add(Botoes[finalI].getText());
                    if (ListaValoresBotaoClicado.size() == 2) {
                        for (int i = 0; i < Botoes.length; i++) {
                            if (Botoes[i].getTag() == "0" && (ListaValoresBotaoClicado.contains(Botoes[i].getText()))) {
                                if (String.valueOf(ListaValoresBotaoClicado.get(0).toString()).equals(String.valueOf(ListaValoresBotaoClicado.get(1).toString()))) {
                                    Botoes[i].setTextColor(Color.BLACK);
                                    Botoes[i].setBackgroundColor(Color.GREEN);
                                    Botoes[i].setClickable(false);
                                    Botoes[i].setTag("");
                                    Acerto = Acerto + 1;
                                } else {
                                    final int finalI1 = i;
                                    Botoes[i].postDelayed(new Runnable() {
                                        public void run() {


                                            for (int i = 0; i < Botoes.length; i++) {
                                                if (Botoes[i].getTag().equals("0")) {
                                                    Botoes[i].setBackgroundResource(Integer.parseInt(iconeescondeimagem));
                                                    Botoes[i].setTag("");
                                                    Botoes[i].setClickable(true);
                                                    Botoes[i].setTextColor(Color.TRANSPARENT);
                                                }
                                            }

                                        }
                                    }, 200);

                                    Erro = Erro + 1;

                                }
                            }
                        }

                        ListaValoresBotaoClicado.clear();
                    }


                    if (Acerto == 30) {
                        total = ((Acerto * 100) / (Acerto + Erro));
                        AlertDialog.Builder alertDialog = new AlertDialog.Builder(Home.this);
                        alertDialog.setTitle("Match Game...");
                        alertDialog.setMessage("Parabéns! \n\nVocê Conseguiu" + "\n\n\nSeu Aproveitamento foi de: " + total + "%");
                        alertDialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();

                            }
                        });
                        alertDialog.setIcon(R.drawable.icone);
                        alertDialog.show();
                        btReiniciar.setVisibility(View.VISIBLE);
                    }
                }
            });
        }

        btReiniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btReiniciar.setVisibility(View.INVISIBLE);
                final ArrayList BotoesValores = new ArrayList(asList(1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9, 10, 10, 11, 11, 12, 12, 13, 13, 14, 14, 15, 15));
                Collections.shuffle(BotoesValores);
                for (int i = 0; i < BotoesValores.size(); i++) {
                    for (int j = 0; j < Botoes.length; j++) {
                        Botoes[j].setText(String.valueOf((BotoesValores.get(i))));
                        Botoes[j].setTextColor(Color.BLACK);
                        Botoes[j].setClickable(true);
                        BotoesValores.remove(i);
                        Botoes[j].setTag("");
                        Botoes[j].setBackgroundColor(Color.CYAN);

                        final int finalJ = j;
                        Botoes[j].postDelayed(new Runnable() {
                            public void run() {

                                Botoes[finalJ].setTextColor(Color.TRANSPARENT);
                                Botoes[finalJ].setTag("");
                                Botoes[finalJ].setClickable(true);
                                Botoes[finalJ].setBackgroundResource(Integer.parseInt(iconeescondeimagem));
                            }
                        }, 3000);

                    }
                }
                Acerto = 0;
                Erro = 0;
                total = 0;
                ListaValoresBotaoClicado.clear();

            }
        });

        btnSobre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home.this, Sobre.class));
            }
        });
    }
}
