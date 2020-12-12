package com.foo.ssuroid.ui.notifications;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.foo.ssuroid.MainActivity;
import com.foo.ssuroid.R;

import java.util.ArrayList;

public class NotificationsFragment extends Fragment {


    ListView listview = null;
    private AdapterView.OnItemClickListener listener;
    final int NEW_REST = 22;
    ArrayList<ListViewItem> list = new ArrayList<ListViewItem>();
    ListViewAdapter adapter;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_notifications, container, false);

        //fragment_notifications
        //super.onCreate(savedInstanceState);
        //setTitle("과목 검색");
        //root.setContentView(R.layout.activity_book_tab);


        // Adapter 생성
        adapter = new ListViewAdapter();

        // 리스트뷰 참조 및 Adapter달기
        listview = (ListView) root.findViewById(R.id.listview);
        listview.setAdapter(adapter);

        final AlertDialog.Builder builder = new AlertDialog.Builder(getContext());


        //Intent intent1 = getIntent();
        //String title1 = intent1.getStringExtra("title");
        //String desc1 = intent1.getStringExtra("desc");

        //adapter.addItem(ContextCompat.getDrawable(this, R.drawable.white), title1, desc1);
        //adapter.notifyDataSetChanged();


        Button plus_btn = (Button) root.findViewById(R.id.plus_btn);
        plus_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), SearchCourse.class);
                startActivityForResult(intent, NEW_REST);
            }
        });

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, final View view, int position, long id) {
                ListViewItem dto = (ListViewItem) adapter.getItem(position);
                final Toast toast = Toast.makeText(getContext(), dto.getTitle() + "\n과목이 추가되었습니다.", Toast.LENGTH_SHORT);

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

                builder.setTitle("교재 구매\n");
                builder.setMessage("\n" + dto.getTitle() + "\n교재를 구매하시겠습니까?\n");
                builder.setPositiveButton("네", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //Intent mIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/"));
                        //startActivity(mIntent);

                        String srchString = "쉽게 배우는 알고리즘";
                        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com/search?q="+srchString));
                        startActivity(browserIntent);

                        //Intent intent = new Intent(Intent.ACTION_VIEW);
                        //Uri uri = Uri.parse("http://www.naver.com");
                        //intent.setData(uri);
                        //startActivity(intent);

                        //Intent intent = new Intent(Intent.ACTION_VIEW);
                        //Uri uri = Uri.parse("http://www.naver.com");
                        //intent.setData(uri);
                        //startActivity(intent);

                        //Intent intent = new Intent();
                        //intent.setAction(Intent.ACTION_VIEW);
                        //intent.setData(Uri.parse("http://m.naver.com"));
                        //startActivity(intent);

                    }
                });

                builder.setNegativeButton("아니요", null);
                builder.create().show();

            }
        });
        return root;

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if(requestCode == NEW_REST)
        {
            if(resultCode == Activity.RESULT_OK)
            {
                //adapter = new ListViewAdapter();
                //listview = (ListView) findViewById(R.id.listview);
                //Intent intent1 = getIntent();
                String title1 = data.getStringExtra("title");
                String desc1 = data.getStringExtra("desc");
                //list.add("title",title1);

                adapter.addItem(ContextCompat.getDrawable(getContext(), R.drawable.white), title1, desc1);
                adapter.notifyDataSetChanged();

            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}