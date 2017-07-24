package matchgame.alex.com.matchgame;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

public class Sobre extends AppCompatActivity {
    private static Button next;
    private static TextSwitcher textswitcher;

    // String array to be shown on textSwitcher
    String textToShow[] = { "Olá, sou o\n Alex Ferreira.", "Um Desenvolvedor Android Júnior",
            "Ainda estou estudando e aprendendo","E-mail: \n\nalexferreiracp@gmail.com","Fone/Whats: \n\n+55-19-98803-0727","Viver é aprender todo dia!","Obrigado por instalar meu app." };

    // Total length of the string array
    int messageCount = textToShow.length;
    // to keep current Index of text
    int currentIndex = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sobre);

        // Call all the methods
        init();
        loadAnimations();
        setFactory();
        setListener();
    }

    void init() {
        next = (Button) findViewById(R.id.buttonNext);
        textswitcher = (TextSwitcher) findViewById(R.id.textSwitcher);

    }

    void loadAnimations() {

        // Declare the in and out animations and initialize them
        Animation in = AnimationUtils.loadAnimation(this,
                android.R.anim.slide_in_left);
        Animation out = AnimationUtils.loadAnimation(this,
                android.R.anim.slide_out_right);

        // set the animation type of textSwitcher
        textswitcher.setInAnimation(in);
        textswitcher.setOutAnimation(out);
    }

    // Click listener method for button
    void setListener() {

        // ClickListener for NEXT button
        // When clicked on Button TextSwitcher will switch between texts
        // The current Text will go OUT and next text will come in with
        // specified animation
        next.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                currentIndex++;
                // If index reaches maximum reset it
                if (currentIndex == messageCount)
                    currentIndex = 0;

                // Set the textSwitcher text according to current index from
                // string array
                textswitcher.setText(textToShow[currentIndex]);
            }
        });
    }

    // Set Factory for the textSwitcher *Compulsory part
    void setFactory() {
        textswitcher.setFactory(new ViewSwitcher.ViewFactory() {

            public View makeView() {

                // Create run time textView with some attributes like gravity,
                // color, etc.
                TextView myText = new TextView(Sobre.this);
                myText.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL);
                myText.setTextSize(20);
                myText.setTextColor(Color.WHITE);
                return myText;
            }
        });

    }
}
