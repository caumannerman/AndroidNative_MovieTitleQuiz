package com.example.sample;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import java.util.*;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class LoginResultActivity extends AppCompatActivity {
    Button button_next, button_check, button_submit;
    TextView textView5, text_iscorrect;
    TextInputEditText textInputEditText;

    TextView text_hintnum, text_hint;
    Button button_hint;

    TextView text_correct;

    Button button_finish;
  //   button_next.setClickable(false);
//     button_next.setEnabled(false);



    String[] quiz = {"말할 수 없는 비밀", "괴물","살아있다","기생충","연애 빠진 로맨스","클래식","유열의 음악앨범","글러브","센과 치히로의 행방불명","하울의 움직이는 성",
    "명량","극한직업","신과 함께","국제시장","어벤져스","겨울왕국","아바타","베테랑","도둑들","7번방의 선물","알라딘","암살","광해","택시운전사","부산행",
    "인터스텔라","변호인","해운대","실미도","국가대표"};
    String[] quiz_cs = {"ㅁㅎ ㅅ ㅇㄴ ㅂㅁ", "ㄱㅁ","ㅅㅇㅇㄷ","ㄱㅅㅊ","ㅇㅇ ㅃㅈ ㄹㅁㅅ","ㅋㄹㅅ","ㅇㅇㅇ ㅇㅇㅇㅂ","ㄱㄹㅂ","ㅅㄱ ㅊㅎㄹㅇ ㅎㅂㅂㅁ","ㅎㅇㅇ ㅇㅈㅇㄴ ㅅ",
    "ㅁㄹ","ㄱㅎㅈㅇ","ㅅㄱ ㅎㄲ","ㄱㅈㅅㅈ","ㅇㅂㅈㅅ","ㄱㅇㅇㄱ","ㅇㅂㅌ","ㅂㅌㄹ","ㄷㄷㄷ","ㅊㅂㅂㅇ ㅅㅁ","ㅇㄹㄷ","ㅇㅅ","ㄱㅎ","ㅌㅅㅇㅈㅅ","ㅂㅅㅎ",
    "ㅇㅌㅅㅌㄹ","ㅂㅎㅇ","ㅎㅇㄷ","ㅅㅁㄷ","ㄱㄱㄷㅍ"};

    String[] chance = {"주걸륜, 계륜미 주연","기생충 감독", "무신사 광고모델,넷플릭스","송강호","전종서 주연","정우성 주연","김고은","야구 영화","2000년대 초 애니메이션 영화","2000년대 일본 애니 영화",
    "한산도 대첩, 노량해전","갈비치킨","주호민,침착맨","한국의 과거","이터널스, 디즈니","snowman","제임스 카메론","어이가 없네?","전지현 주연 영화","예승이 콩 먹자~","I won't be silence","이정재","이병헌","송강호,광주","공유,마동",
    "시간여행","변호사, 송강호","부산","북파 공작","스키점프"};


    int hint_left = 5;
    int cor_num = 0;
    boolean use_hint = false;
    boolean answer_check_tick = false;
    String now_answer = "";

    //전체 문제 수 q_len
    int q_len = quiz.length;
    //시작점을 랜덤 생성
    Random rand = new Random();
    int index = rand.nextInt(30);





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        textView5 = findViewById(R.id.textView5);
        text_iscorrect = findViewById(R.id.text_iscorrect);
        button_next = findViewById(R.id.button_next);
        button_check = findViewById(R.id.button_check);
        button_submit = findViewById(R.id.button_submit);
        textInputEditText = findViewById(R.id.textInputEditText);

        text_hintnum = findViewById(R.id.text_hintnum);
        text_hint = findViewById(R.id.text_hint);
        button_hint = findViewById(R.id.button_hint);

        text_correct = findViewById(R.id.text_correct);

        button_finish = findViewById(R.id.button_finish);

        button_next.setClickable(true);
        button_next.setEnabled(true);
        button_check.setClickable(true);
        button_check.setEnabled(true);
        button_submit.setClickable(true);
        button_submit.setEnabled(true);
        button_hint.setClickable(true);
        button_hint.setEnabled(true);

        Intent intent = getIntent();

        //Bundle bundle = intent.getExtras();
        //String email = bundle.getString("email");
        //String password = bundle.getString("password");

        textView5.setText(quiz_cs[index]);
        text_hintnum.setText("남은 힌트 수: "+Integer.toString(hint_left));
        text_correct.setText("맞춘 문제 수: "+ Integer.toString(cor_num));


        // button_login.setClickable(true);
        button_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answer_check_tick = true;
                text_iscorrect.setText(null);
                textView5.setText(quiz[index]);
            }
        });


        button_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answer_check_tick = false;
                text_hint.setText(null);
                index += 1;
                if(index == q_len){
                    index = 0;
                }

                text_iscorrect.setText(null);
                textInputEditText.setText(null);
                text_hintnum.setText("남은 힌트 수 : " + Integer.toString(hint_left));
                text_correct.setText("맞춘 문제 수 : "+ Integer.toString(cor_num));
                use_hint = false;
                textView5.setText(quiz_cs[index]);
                button_submit.setClickable(true);
                button_submit.setEnabled(true);
                button_check.setClickable(true);
                button_check.setEnabled(true);

            }
        });


        button_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(answer_check_tick == false){
                //정답을 맞춘 경우
                if(now_answer.equals(quiz[index]) ){

                    text_iscorrect.setText("정답!!");
                    textView5.setText(quiz[index]);
                    textInputEditText.setText(null);
                    now_answer = "";
                    //맞춘 문제 수 1 더해서 화면에 표시
                    cor_num += 1;
                    text_correct.setText("맞춘 문제 수 : "+ Integer.toString(cor_num));
                    button_submit.setClickable(false);
                    button_submit.setEnabled(false);
                    button_check.setClickable(false);
                    button_check.setEnabled(false);

                }
                else{
                    textInputEditText.setText(null);
                    text_iscorrect.setText("틀렸습니다!");
                }

                }
                //정답 확인을 해놓고 정답을 제출하는 경우
                else{
                    text_iscorrect.setText("정답을 확인하셨습니다.");
                }



            }
        });

        button_hint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //아직 hint를 해당 문제에서 사용하지 않은 경우
                if(use_hint == false) {
                    if (hint_left > 0) {
                        use_hint = true;
                        hint_left -= 1;
                        text_hintnum.setText("남은 힌트 수 : " + Integer.toString(hint_left));
                        text_hint.setText(chance[index]);

                    } else {
                        text_hintnum.setText("남은 힌트가 없습니다!!");

                    }
                }
                //use_hint == true인 경우에 또 hint를 눌렀을
                else{
                    text_hintnum.setText("이미 이 문제에서 사용했습니다");

                }
            }
        });

        textInputEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //Log.d("Log testing...", s + ","+count);

                if(s != null){
                   now_answer = s.toString();

                }


            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        button_finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(LoginResultActivity.this, FinishActivity.class);
                intent.putExtra("cornum", Integer.toString(cor_num));

                startActivity(intent);
            }
        });

    }








}