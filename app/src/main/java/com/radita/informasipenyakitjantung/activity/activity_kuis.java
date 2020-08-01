package com.radita.informasipenyakitjantung.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.radita.informasipenyakitjantung.R;

import java.util.ArrayList;
import java.util.Collections;

public class activity_kuis extends AppCompatActivity {

    int [] questions;
    int[][] answers;
    int queue[]=new int[10];
    int numberofquestioncomplete = 0;
    int answerlog[] = new int[5];
    int anscnt = 0;
    int correct_ans_count;
    int correct_answer[] = new int[50];


    //function for generating unique number
    private int[] random_number_generator(){
        int question_list[] = new int[50];
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i=0; i<50; i++) {
            list.add(new Integer(i));
        }
        Collections.shuffle(list);
        for (int i=0; i<50; i++) {
            question_list[i] = list.get(i);
        }

        //final question list is return
        return question_list;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kuis);

        if (getSupportActionBar() != null){
            getSupportActionBar().setTitle(R.string.kuis);
        }

        //pertanyaan menggunakan array random
        questions= new int[]{
                R.string.soal1, R.string.soal2, R.string.soal3, R.string.soal4, R.string.soal5, R.string.soal6, R.string.soal7, R.string.soal8, R.string.soal9, R.string.soal10,
                R.string.soal1, R.string.soal12, R.string.soal13, R.string.soal14, R.string.soal15, R.string.soal16, R.string.soal17, R.string.soal18, R.string.soal19, R.string.soal20,
                R.string.soal21, R.string.soal22, R.string.soal23, R.string.soal24, R.string.soal25, R.string.soal26, R.string.soal27, R.string.soal28, R.string.soal29, R.string.soal30,
                R.string.soal31, R.string.soal32, R.string.soal33, R.string.soal34, R.string.soal35, R.string.soal36, R.string.soal37, R.string.soal38, R.string.soal39, R.string.soal40,
                R.string.soal41, R.string.soal42, R.string.soal43, R.string.soal44, R.string.soal45, R.string.soal46, R.string.soal47, R.string.soal48, R.string.soal49, R.string.soal50

        };

        //array jawaban
        answers= new int[][] {
                {R.string.jwb1a, R.string.jwb1b, R.string.jwb1c, R.string.jwb1d, R.string.jwb1d},
                {R.string.jwb2a, R.string.jwb2b, R.string.jwb2c, R.string.jwb2d, R.string.jwb2a},
                {R.string.jwb3a, R.string.jwb3b, R.string.jwb3c, R.string.jwb3d, R.string.jwb3b},
                {R.string.jwb4a, R.string.jwb4b, R.string.jwb4c, R.string.jwb4d, R.string.jwb4b},
                {R.string.jwb5a, R.string.jwb5b, R.string.jwb5c, R.string.jwb5d, R.string.jwb5b},
                {R.string.jwb6a, R.string.jwb6b, R.string.jwb6c, R.string.jwb6d, R.string.jwb6c},
                {R.string.jwb7a, R.string.jwb7b, R.string.jwb7c, R.string.jwb7d, R.string.jwb7a},
                {R.string.jwb8a, R.string.jwb8b, R.string.jwb8c, R.string.jwb8d, R.string.jwb8c},
                {R.string.jwb9a, R.string.jwb9b, R.string.jwb9c, R.string.jwb9d, R.string.jwb9d},
                {R.string.jwb10a, R.string.jwb10b, R.string.jwb10c, R.string.jwb10d, R.string.jwb10d},
                {R.string.jwb11a, R.string.jwb11b, R.string.jwb11c, R.string.jwb11d, R.string.jwb11d},
                {R.string.jwb12a, R.string.jwb12b, R.string.jwb12c, R.string.jwb12d, R.string.jwb12b},
                {R.string.jwb13a, R.string.jwb13b, R.string.jwb13c, R.string.jwb13d, R.string.jwb13d},
                {R.string.jwb14a, R.string.jwb14b, R.string.jwb14c, R.string.jwb14d, R.string.jwb14b},
                {R.string.jwb15a, R.string.jwb15b, R.string.jwb15c, R.string.jwb15d, R.string.jwb15c},
                {R.string.jwb16a, R.string.jwb16b, R.string.jwb16c, R.string.jwb16d, R.string.jwb16a},
                {R.string.jwb17a, R.string.jwb17b, R.string.jwb17c, R.string.jwb17d, R.string.jwb17b},
                {R.string.jwb18a, R.string.jwb18b, R.string.jwb18c, R.string.jwb18d, R.string.jwb18d},
                {R.string.jwb19a, R.string.jwb19b, R.string.jwb19c, R.string.jwb19d, R.string.jwb19d},
                {R.string.jwb20a, R.string.jwb20b, R.string.jwb20c, R.string.jwb20d, R.string.jwb20c},
                {R.string.jwb21a, R.string.jwb21b, R.string.jwb21c, R.string.jwb21d, R.string.jwb21d},
                {R.string.jwb22a, R.string.jwb22b, R.string.jwb22c, R.string.jwb22d, R.string.jwb22a},
                {R.string.jwb23a, R.string.jwb23b, R.string.jwb23c, R.string.jwb23d, R.string.jwb23b},
                {R.string.jwb24a, R.string.jwb24b, R.string.jwb24c, R.string.jwb24d, R.string.jwb24b},
                {R.string.jwb25a, R.string.jwb25b, R.string.jwb25c, R.string.jwb25d, R.string.jwb25d},
                {R.string.jwb26a, R.string.jwb26b, R.string.jwb26c, R.string.jwb26d, R.string.jwb26d},
                {R.string.jwb27a, R.string.jwb27b, R.string.jwb27c, R.string.jwb27d, R.string.jwb27c},
                {R.string.jwb28a, R.string.jwb28b, R.string.jwb28c, R.string.jwb28d, R.string.jwb28a},
                {R.string.jwb29a, R.string.jwb29b, R.string.jwb29c, R.string.jwb29d, R.string.jwb29d},
                {R.string.jwb30a, R.string.jwb30b, R.string.jwb30c, R.string.jwb30d, R.string.jwb30c},
                {R.string.jwb31a, R.string.jwb31b, R.string.jwb31c, R.string.jwb31d, R.string.jwb31b},
                {R.string.jwb32a, R.string.jwb32b, R.string.jwb32c, R.string.jwb32d, R.string.jwb32a},
                {R.string.jwb33a, R.string.jwb33b, R.string.jwb33c, R.string.jwb33d, R.string.jwb33d},
                {R.string.jwb34a, R.string.jwb34b, R.string.jwb34c, R.string.jwb34d, R.string.jwb34b},
                {R.string.jwb35a, R.string.jwb35b, R.string.jwb35c, R.string.jwb35d, R.string.jwb35a},
                {R.string.jwb36a, R.string.jwb36b, R.string.jwb36c, R.string.jwb36d, R.string.jwb36d},
                {R.string.jwb37a, R.string.jwb37b, R.string.jwb37c, R.string.jwb37d, R.string.jwb37b},
                {R.string.jwb38a, R.string.jwb38b, R.string.jwb38c, R.string.jwb38d, R.string.jwb38a},
                {R.string.jwb39a, R.string.jwb39b, R.string.jwb39c, R.string.jwb39d, R.string.jwb39c},
                {R.string.jwb40a, R.string.jwb40b, R.string.jwb40c, R.string.jwb40d, R.string.jwb40c},
                {R.string.jwb41a, R.string.jwb41b, R.string.jwb41c, R.string.jwb41d, R.string.jwb41a},
                {R.string.jwb42a, R.string.jwb42b, R.string.jwb42c, R.string.jwb42d, R.string.jwb42a},
                {R.string.jwb43a, R.string.jwb43b, R.string.jwb43c, R.string.jwb43d, R.string.jwb43b},
                {R.string.jwb44a, R.string.jwb44b, R.string.jwb44c, R.string.jwb44d, R.string.jwb44d},
                {R.string.jwb45a, R.string.jwb45b, R.string.jwb45c, R.string.jwb45d, R.string.jwb45d},
                {R.string.jwb46a, R.string.jwb46b, R.string.jwb46c, R.string.jwb46d, R.string.jwb46d},
                {R.string.jwb47a, R.string.jwb47b, R.string.jwb47c, R.string.jwb47d, R.string.jwb47b},
                {R.string.jwb48a, R.string.jwb48b, R.string.jwb48c, R.string.jwb48d, R.string.jwb48d},
                {R.string.jwb49a, R.string.jwb49b, R.string.jwb49c, R.string.jwb49d, R.string.jwb49a},
                {R.string.jwb50a, R.string.jwb50b, R.string.jwb50c, R.string.jwb50d, R.string.jwb50b}

        };
        correct_answer[0] = 3;
        correct_answer[1] = 0;
        correct_answer[2] = 2;
        correct_answer[3] = 1;
        correct_answer[4] = 1;
        correct_answer[5] = 2;
        correct_answer[6] = 0;
        correct_answer[7] = 2;
        correct_answer[8] = 3;
        correct_answer[9] = 3;
        correct_answer[10] = 3;
        correct_answer[11] = 1;
        correct_answer[12] = 3;
        correct_answer[13] = 1;
        correct_answer[14] = 2;
        correct_answer[15] = 0;
        correct_answer[16] = 1;
        correct_answer[17] = 3;
        correct_answer[18] = 3;
        correct_answer[19] = 2;
        correct_answer[20] = 3;
        correct_answer[21] = 0;
        correct_answer[22] = 1;
        correct_answer[23] = 1;
        correct_answer[24] = 3;
        correct_answer[25] = 3;
        correct_answer[26] = 2;
        correct_answer[27] = 0;
        correct_answer[28] = 3;
        correct_answer[29] = 2;
        correct_answer[30] = 1;
        correct_answer[31] = 0;
        correct_answer[32] = 3;
        correct_answer[33] = 1;
        correct_answer[34] = 0;
        correct_answer[35] = 3;
        correct_answer[36] = 1;
        correct_answer[37] = 0;
        correct_answer[38] = 2;
        correct_answer[39] = 2;
        correct_answer[40] = 0;
        correct_answer[42] = 0;
        correct_answer[43] = 3;
        correct_answer[44] = 3;
        correct_answer[45] = 3;
        correct_answer[46] = 1;
        correct_answer[47] = 3;
        correct_answer[48] = 0;
        correct_answer[49] = 1;


        queue = random_number_generator();
        displayquestion();
    }

    private void displayquestion() {
        if(anscnt <=50) {
            TextView ques = (TextView) findViewById(R.id.tv_soal);
            Button jawabanA = (Button) findViewById(R.id.btn_a);
            Button jawabanB = (Button) findViewById(R.id.btn_b);
            Button jawabanC = (Button) findViewById(R.id.btn_c);
            Button jawabanD = (Button) findViewById(R.id.btn_d);

            ques.setText(questions[queue[numberofquestioncomplete]]);
            jawabanA.setText(answers[queue[numberofquestioncomplete]][0]);
            jawabanB.setText(answers[queue[numberofquestioncomplete]][1]);
            jawabanC.setText(answers[queue[numberofquestioncomplete]][2]);
            jawabanD.setText(answers[queue[numberofquestioncomplete]][3]);

            numberofquestioncomplete++;}
    }

    public void onClickBtn(View view) {
        anscnt++;
        if (anscnt >= 50) {
            //Toast.makeText(getApplicationContext(),"Quiz is completed. Thankyou", Toast.LENGTH_LONG).show();

            Intent i = getIntent();
            //here i just want to pass array to next activity
            Intent intd = new Intent(getApplicationContext(), activity_hasil_kuis.class);
            intd.putExtra("total", Integer.toString(correct_ans_count));
            startActivity(intd);
        }

        Button jawabanA = (Button) findViewById(R.id.btn_a);
        Button jawabanB = (Button) findViewById(R.id.btn_b);
        Button jawabanC = (Button) findViewById(R.id.btn_c);
        Button jawabanD = (Button) findViewById(R.id.btn_d);


        if (anscnt < 50) {
            if (jawabanA.isPressed()) {
                if((correct_answer[queue[numberofquestioncomplete-1]] == 0 )){ correct_ans_count++;}
                //ans
            }
            if (jawabanB.isPressed()) {
                if((correct_answer[queue[numberofquestioncomplete-1]] == 1)){ correct_ans_count++;}
                //anscnt++;

            }
            if (jawabanC.isPressed()) {
                if(correct_answer[queue[numberofquestioncomplete-1]] == 2){correct_ans_count++;}
                // anscnt++;
            }
            if (jawabanD.isPressed()) {
                if(correct_answer[queue[numberofquestioncomplete-1]] == 3){correct_ans_count++;}
                //anscnt++;
            }
        }
        if(anscnt < 50)
        {
            displayquestion();
        }

    }
}
