package thomrosales.SimpleTicTacToe;

import android.app.Activity;
import android.graphics.Color;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.HashMap;
import java.util.Random;

public class SimpleTicTacToeActivity extends Activity implements OnClickListener {
    static int MiddleLeft;
    static int downLeft;
    static int downMiddle;
    static int downRight;
    static int middle;
    static int num;
    static int rightMiddle;
    static int rightTop;
    static int rndInt;
    static int score1;
    static int score2;
    static int topMiddle;
    static int topleft;
    TextView circle;
    Button clear;
    ImageView img0;
    ImageView img1;
    ImageView img2;
    ImageView img3;
    ImageView img4;
    ImageView img5;
    ImageView img6;
    ImageView img7;
    ImageView img8;
    TextView score;
    private SoundPool soundPool;
    private HashMap<Integer, Integer> soundsMap;
    TextView text;
    TextView turn;
    TextView win;
    TextView f3x;

    static {
        num = 99;
        rndInt = 98;
        score1 = 0;
        score2 = 0;
        middle = 9;
        topleft = 9;
        downMiddle = 9;
        downRight = 9;
        rightMiddle = 9;
        MiddleLeft = 9;
        downLeft = 9;
        topMiddle = 9;
        rightTop = 9;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(C0000R.layout.main);
        this.soundPool = new SoundPool(4, 3, 100);
        this.soundsMap = new HashMap();
        this.soundsMap.put(Integer.valueOf(1), Integer.valueOf(this.soundPool.load(this, C0000R.raw.click, 1)));
        this.img0 = (ImageView) findViewById(C0000R.id.imageView1);
        this.img1 = (ImageView) findViewById(C0000R.id.imageView2);
        this.img2 = (ImageView) findViewById(C0000R.id.imageView3);
        this.img3 = (ImageView) findViewById(C0000R.id.imageView4);
        this.img4 = (ImageView) findViewById(C0000R.id.imageView5);
        this.img5 = (ImageView) findViewById(C0000R.id.imageView6);
        this.img6 = (ImageView) findViewById(C0000R.id.imageView7);
        this.img7 = (ImageView) findViewById(C0000R.id.imageView8);
        this.img8 = (ImageView) findViewById(C0000R.id.imageView9);
        this.text = (TextView) findViewById(C0000R.id.text);
        this.win = (TextView) findViewById(C0000R.id.win);
        this.turn = (TextView) findViewById(C0000R.id.turn);
        this.clear = (Button) findViewById(C0000R.id.button);
        this.circle = (TextView) findViewById(C0000R.id.circle);
        this.f3x = (TextView) findViewById(C0000R.id.x);
        this.score = (TextView) findViewById(C0000R.id.score);
        this.img0.setOnClickListener(this);
        this.img1.setOnClickListener(this);
        this.img2.setOnClickListener(this);
        this.img3.setOnClickListener(this);
        this.img4.setOnClickListener(this);
        this.img5.setOnClickListener(this);
        this.img6.setOnClickListener(this);
        this.img7.setOnClickListener(this);
        this.img8.setOnClickListener(this);
        this.clear.setOnClickListener(this);
        rndInt = new Random().nextInt(1);
        this.text.setTypeface(null, 2);
        this.text.setText("Thomas Rosales 2012");
        this.score.setText("Score");
        this.circle.setTypeface(null, 1);
        this.circle.setTextColor(Color.parseColor("#2828FF"));
        this.circle.setText(String.valueOf(score1));
        this.f3x.setTypeface(null, 1);
        this.f3x.setTextColor(-65536);
        this.f3x.setText(String.valueOf(score2));
        if (rndInt == 0) {
            this.turn.setTypeface(null, 3);
            this.turn.setTextColor(Color.parseColor("#2828FF"));
            this.turn.setText("Circle turn");
        }
        if (rndInt == 1) {
            this.turn.setTypeface(null, 3);
            this.turn.setTextColor(-65536);
            this.turn.setText("X turn");
        }
    }

    public void playSound(int sound, float fSpeed) {
        AudioManager mgr = (AudioManager) getSystemService("audio");
        float volume = ((float) mgr.getStreamVolume(3)) / ((float) mgr.getStreamMaxVolume(3));
        this.soundPool.play(((Integer) this.soundsMap.get(Integer.valueOf(sound))).intValue(), volume, volume, 1, 0, fSpeed);
    }

    public void onClick(View view) {
        int imgid = 99;
        int id = view.getId();
        if (num == 0) {
            rndInt = 1;
        } else if (num == 1) {
            rndInt = 0;
        }
        if (rndInt == 0) {
            imgid = C0000R.drawable.o;
            this.turn.setTextColor(-65536);
            this.turn.setText("X turn");
            num = 0;
        } else if (rndInt == 1) {
            imgid = C0000R.drawable.x;
            this.turn.setTextColor(Color.parseColor("#2828FF"));
            this.turn.setText("Circle turn");
            num = 1;
        }
        switch (id) {
            case C0000R.id.imageView1:
                this.img0.setImageResource(imgid);
                this.img0.setOnClickListener(null);
                middle = num;
                playSound(1, 1.0f);
                break;
            case C0000R.id.imageView8:
                this.img7.setImageResource(imgid);
                this.img7.setOnClickListener(null);
                topMiddle = num;
                playSound(1, 1.0f);
                break;
            case C0000R.id.imageView3:
                this.img2.setImageResource(imgid);
                this.img2.setOnClickListener(null);
                downMiddle = num;
                playSound(1, 1.0f);
                break;
            case C0000R.id.imageView4:
                this.img3.setImageResource(imgid);
                this.img3.setOnClickListener(null);
                downRight = num;
                playSound(1, 1.0f);
                break;
            case C0000R.id.imageView5:
                this.img4.setImageResource(imgid);
                this.img4.setOnClickListener(null);
                rightMiddle = num;
                playSound(1, 1.0f);
                break;
            case C0000R.id.imageView9:
                this.img8.setImageResource(imgid);
                this.img8.setOnClickListener(null);
                topleft = num;
                playSound(1, 1.0f);
                break;
            case C0000R.id.imageView6:
                this.img5.setImageResource(imgid);
                this.img5.setOnClickListener(null);
                MiddleLeft = num;
                playSound(1, 1.0f);
                break;
            case C0000R.id.imageView7:
                this.img6.setImageResource(imgid);
                this.img6.setOnClickListener(null);
                downLeft = num;
                playSound(1, 1.0f);
                break;
            case C0000R.id.imageView2:
                this.img1.setImageResource(imgid);
                this.img1.setOnClickListener(null);
                rightTop = num;
                playSound(1, 1.0f);
                break;
        }
        if (id == C0000R.id.button) {
            clear();
        }
        int w = 0;
        int w2 = 0;
        if (topleft == 0 && topMiddle == 0 && rightTop == 0) {
            this.win.setTextColor(Color.parseColor("#2828FF"));
            w = 1;
            this.win.setTypeface(null, 1);
            this.win.setText("Circle wins!!!");
        }
        if (downRight == 0 && downMiddle == 0 && downLeft == 0) {
            this.win.setTextColor(Color.parseColor("#2828FF"));
            w = 1;
            this.win.setTypeface(null, 1);
            this.win.setText("Circle wins!!!");
        }
        if (downLeft == 0 && MiddleLeft == 0 && topleft == 0) {
            this.win.setTextColor(Color.parseColor("#2828FF"));
            w = 1;
            this.win.setTypeface(null, 1);
            this.win.setText("Circle wins!!!");
        }
        if (rightTop == 0 && rightMiddle == 0 && downRight == 0) {
            this.win.setTextColor(Color.parseColor("#2828FF"));
            w = 1;
            this.win.setTypeface(null, 1);
            this.win.setText("Circle wins!!!");
        }
        if (middle == 0 && topMiddle == 0 && downMiddle == 0) {
            this.win.setTextColor(Color.parseColor("#2828FF"));
            w = 1;
            this.win.setTypeface(null, 1);
            this.win.setText("Circle wins!!!");
        }
        if (middle == 0 && MiddleLeft == 0 && rightMiddle == 0) {
            this.win.setTextColor(Color.parseColor("#2828FF"));
            w = 1;
            this.win.setTypeface(null, 1);
            this.win.setText("Circle wins!!!");
        }
        if (topleft == 0 && downRight == 0 && middle == 0) {
            this.win.setTextColor(Color.parseColor("#2828FF"));
            w = 1;
            this.win.setTypeface(null, 1);
            this.win.setText("Circle wins!!!");
        }
        if (rightTop == 0 && downLeft == 0 && middle == 0) {
            this.win.setTextColor(Color.parseColor("#2828FF"));
            w = 1;
            this.win.setTypeface(null, 1);
            this.win.setText("Circle wins!!!");
        }
        if (w == 0) {
            if (topleft == 1 && topMiddle == 1 && rightTop == 1) {
                this.win.setTextColor(-65536);
                w2 = 1;
                this.win.setTypeface(null, 1);
                this.win.setText("X wins!!!");
            }
            if (downRight == 1 && downMiddle == 1 && downLeft == 1) {
                this.win.setTextColor(-65536);
                w2 = 1;
                this.win.setTypeface(null, 1);
                this.win.setText("X wins!!!");
            }
            if (downLeft == 1 && MiddleLeft == 1 && topleft == 1) {
                this.win.setTextColor(-65536);
                w2 = 1;
                this.win.setTypeface(null, 1);
                this.win.setText("X wins!!!");
            }
            if (rightTop == 1 && rightMiddle == 1 && downRight == 1) {
                this.win.setTextColor(-65536);
                w2 = 1;
                this.win.setTypeface(null, 1);
                this.win.setText("X wins!!!");
            }
            if (middle == 1 && topMiddle == 1 && downMiddle == 1) {
                this.win.setTextColor(-65536);
                w2 = 1;
                this.win.setTypeface(null, 1);
                this.win.setText("X wins!!!");
            }
            if (middle == 1 && MiddleLeft == 1 && rightMiddle == 1) {
                this.win.setTextColor(-65536);
                w2 = 1;
                this.win.setTypeface(null, 1);
                this.win.setText("X wins!!!");
            }
            if (topleft == 1 && downRight == 1 && middle == 1) {
                this.win.setTextColor(-65536);
                w2 = 1;
                this.win.setTypeface(null, 1);
                this.win.setText("X wins!!!");
            }
            if (rightTop == 1 && downLeft == 1 && middle == 1) {
                this.win.setTextColor(-65536);
                w2 = 1;
                this.win.setTypeface(null, 1);
                this.win.setText("X wins!!!");
            }
        } else {
            middle = 9;
            topleft = 9;
            downMiddle = 9;
            downRight = 9;
            rightMiddle = 9;
            MiddleLeft = 9;
            downLeft = 9;
            topMiddle = 9;
            rightTop = 9;
            score1++;
        }
        if (w2 == 1) {
            middle = 9;
            topleft = 9;
            downMiddle = 9;
            downRight = 9;
            rightMiddle = 9;
            MiddleLeft = 9;
            downLeft = 9;
            topMiddle = 9;
            rightTop = 9;
            score2++;
        }
        this.circle.setText(String.valueOf(score1));
        this.f3x.setText(String.valueOf(score2));
    }

    public void clear() {
        this.win.setText(" ");
        this.win.setTextColor(-7829368);
        this.win.setTypeface(null, 0);
        this.img0.setImageResource(C0000R.drawable.ic_launcher);
        this.img1.setImageResource(C0000R.drawable.ic_launcher);
        this.img2.setImageResource(C0000R.drawable.ic_launcher);
        this.img3.setImageResource(C0000R.drawable.ic_launcher);
        this.img4.setImageResource(C0000R.drawable.ic_launcher);
        this.img5.setImageResource(C0000R.drawable.ic_launcher);
        this.img6.setImageResource(C0000R.drawable.ic_launcher);
        this.img7.setImageResource(C0000R.drawable.ic_launcher);
        this.img8.setImageResource(C0000R.drawable.ic_launcher);
        this.img0.setOnClickListener(this);
        this.img1.setOnClickListener(this);
        this.img2.setOnClickListener(this);
        this.img3.setOnClickListener(this);
        this.img4.setOnClickListener(this);
        this.img5.setOnClickListener(this);
        this.img6.setOnClickListener(this);
        this.img7.setOnClickListener(this);
        this.img8.setOnClickListener(this);
        middle = 9;
        topleft = 9;
        downMiddle = 9;
        downRight = 9;
        rightMiddle = 9;
        MiddleLeft = 9;
        downLeft = 9;
        topMiddle = 9;
        rightTop = 9;
    }
}
