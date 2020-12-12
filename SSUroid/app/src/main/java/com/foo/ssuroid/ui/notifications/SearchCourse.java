package com.foo.ssuroid.ui.notifications;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.foo.ssuroid.MainActivity;
import com.foo.ssuroid.R;

import java.util.ArrayList;

public class SearchCourse extends AppCompatActivity {

    ListView listview = null ;
    private AdapterView.OnItemClickListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_course);

        ArrayList<ListViewItem> list;

        final ListViewAdapter adapter;

        Point size;

        LayoutInflater inflater;
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        //final AlertDialog dialog = builder.create();

        // Adapter 생성
        adapter = new ListViewAdapter();

        // 리스트뷰 참조 및 Adapter달기
        listview = (ListView) findViewById(R.id.listview1);
        listview.setAdapter(adapter);
        //listview.setOnItemClickListener(listener);


        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.plus),
                "사용자인터페이스및실습 (가반) 최지웅", "목 02:00-03:50 금 10:00-11:50 정보과학관 21205\r\n주교재/깡쌤의 안드로이드 프로그래밍/강성윤/루비페이퍼/2019/3쇄/지정도서\r\n주교재/이것이 안드로이드다. 박성근의 안드로이드 앱 프로그래밍/박성근/한빛미디어 /2014/지정도서\n") ;
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.plus),
                "사용자인터페이스및실습 (나반) 최지웅", "목 02:00-03:50 금 10:00-11:50 정보과학관 21205\r\n주교재/깡쌤의 안드로이드 프로그래밍/강성윤/루비페이퍼/2019/3쇄/지정도서\r\n주교재/이것이 안드로이드다. 박성근의 안드로이드 앱 프로그래밍/박성근/한빛미디어 /2014/지정도서\n") ;

        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.plus),
                "알고리즘 (가반) 최재영", "월 20:00-21:00 정보과학관 21201\r\n주교재/쉽게 배우는 알고리즘/문병로/한빛아카데미/2020/개정판/지정도서") ;
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.plus),
                "알고리즘 (나반) 최재영", "월 20:00-21:00 정보과학관 21201\r\n주교재/쉽게 배우는 알고리즘/문병로/한빛아카데미/2020/개정판/지정도서") ;
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.plus),
                "알고리즘 (다반) 최재영", "월 20:00-21:00 정보과학관 21201\r\n주교재/쉽게 배우는 알고리즘/문병로/한빛아카데미/2020/개정판/지정도서") ;
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.plus),
                "알고리즘 (공통반) 최재영", "월 20:00-21:00 정보과학관 21201\r\n주교재/쉽게 배우는 알고리즘/문병로/한빛아카데미/2020/개정판/지정도서") ;

        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.plus),
                "오픈소스기반기초설계 김익수", "수 10:30-13:15 정보과학관 21205\r\n참고교재/Pro Git/박창우, 이성환, 최용재 역/인사이트/2016/2\r\n참고교재/팀 개발을 위한 Git, GitHub 시작하기/정호영, 진유림/한빛미디어/2020") ;

        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.plus),
                "컴퓨터구조 (가반) 장훈", "주교재/Computer Organization and Design/Patterson, Hennessy/Morgan Kaufmann/2014/5th ed/지정도서\r\n주교재/컴퓨터 구조 및 설계/박명순, 김병기, 하순회, 장훈/비제이퍼블릭/2015/5판/지정도서\n" +
                        "참고교재/프로세서를 지탱하는 기술/안도 히사/제이펍/2011\n") ;
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.plus),
                "컴퓨터구조 (나반) 장훈", "주교재/Computer Organization and Design/Patterson, Hennessy/Morgan Kaufmann/2014/5th ed/지정도서\r\n주교재/컴퓨터 구조 및 설계/박명순, 김병기, 하순회, 장훈/비제이퍼블릭/2015/5판/지정도서\n" +
                        "참고교재/프로세서를 지탱하는 기술/안도 히사/제이펍/2011\n") ;
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.plus),
                "컴퓨터구조 (다반) 김병기", "주교재/Computer Organization and Design/Patterson, Hennessy/Morgan Kaufmann/2014/5th ed/지정도서\r\n주교재/컴퓨터 구조 및 설계/박명순, 김병기, 하순회, 장훈/비제이퍼블릭/2015/5판/지정도서\r\n") ;
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.plus),
                "컴퓨터구조 (라반) 김병기", "주교재/Computer Organization and Design/Patterson, Hennessy/Morgan Kaufmann/2014/5th ed/지정도서\r\n주교재/컴퓨터 구조 및 설계/박명순, 김병기, 하순회, 장훈/비제이퍼블릭/2015/5판/지정도서\r\n") ;

        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.plus),
                "컴퓨터네트워크 (가반) 신용태", "월 15:00-16:15  수 15:00-16:15 정보과학관 21201\r\n주교재/Computer Networking, Top Down Approach,7th ed/Jim Krose/Pearson/2017/지정도서") ;
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.plus),
                "컴퓨터네트워크 (나반) 신용태", "월 15:00-16:15  수 15:00-16:15 정보과학관 21201\r\n주교재/Computer Networking, Top Down Approach,7th ed/Jim Krose/Pearson/2017/지정도서") ;

        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.plus),
                "통계및실습 (가반) 강소영", "참고교재/통계학/강근석 외 6인 공저/자유아카데미/1993") ;
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.plus),
                "통계및실습 (가반) 강소영", "참고교재/통계학/강근석 외 6인 공저/자유아카데미/1993") ;

        //listview.setOnClickListener(new AdapterView.OnItemClickListener(){

        //  @Override
        // public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //   AlertDialog.Builder builder = new AlertDialog.Builder();
        // builder.setTitle("알림");
        //builder.setMessage("정말 종료 하시겠습니까?");
        //builder.setPositiveButton("OK", dialogListener);
        //builder.setNegativeButton("NO", null);
        //}
        //});


        EditText editTextFilter = (EditText)findViewById(R.id.editTextFilter) ;
        editTextFilter.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable edit) {
                String filterText = edit.toString();
                ((ListViewAdapter) listview.getAdapter()).getFilter().filter(filterText);
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            private void showToast(String message) {
            }
        });



        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ListViewItem dto = (ListViewItem) adapter.getItem(position);
                final Toast toast = Toast.makeText(SearchCourse.this,  dto.getTitle() + "\n과목이 추가되었습니다.", Toast.LENGTH_SHORT);

                final String title = dto.getTitle();
                final String desc = dto.getDesc();
                //Toast.makeText(MainActivity.this, "선택 : " + position + "\n이름 : " + dto.getTitle()
                //                        + "\n세부사항 : " + dto.getDesc(), Toast.LENGTH_SHORT);


                DialogInterface.OnClickListener dialogListener = new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        toast.show();


                    }
                };

                builder.setTitle("과목 추가\n");
                builder.setMessage("\n" + dto.getTitle()+"\n과목을 추가하시겠습니까?\n");
                builder.setPositiveButton("네", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(SearchCourse.this, NotificationsFragment.class);
                        intent.putExtra("title", title);
                        intent.putExtra("desc", desc);
                        //setResult(RESULT_OK,intent);
                        setResult(RESULT_OK,intent);
                        finish();
                        toast.show();
                    }
                });

                builder.setNegativeButton("아니요",null);
                builder.create().show();

            }
        });
    }
}