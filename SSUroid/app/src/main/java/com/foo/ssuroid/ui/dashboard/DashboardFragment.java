package com.foo.ssuroid.ui.dashboard;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.content.res.TypedArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.foo.ssuroid.Favorite;
import com.foo.ssuroid.MainActivity;
import com.foo.ssuroid.MapsActivity;
import com.foo.ssuroid.R;
import com.foo.ssuroid.ui.dashboard.CustomDTO;

import java.util.ArrayList;
import java.util.List;

public class DashboardFragment extends Fragment {

    private Button btn_Googlemap;
    private Button btn_favorite;
    private CustomAdapter adapter;
    private ListView listView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);

        adapter = new CustomAdapter();
        listView = (ListView) root.findViewById(R.id.place);

        setData();

        listView.setAdapter(adapter);

        Button btn_Googlemap = (Button) root.findViewById(R.id.btn_Googlemap);
        btn_Googlemap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), MapsActivity.class);
                startActivity(intent); //구글맵 액티비티로 이동시켜주는 구문
            }
        });

        return root;
    }

    // 보통 ListView는 통신을 통해 가져온 데이터를 보여줍니다.
    // arrResId, titles, contents를 서버에서 가져온 데이터라고 생각하시면 됩니다.
    private void setData() {
        TypedArray arrResId = getResources().obtainTypedArray(R.array.resId);
        String[] titles = getResources().getStringArray(R.array.title);
        String[] contents = getResources().getStringArray(R.array.content);

        for (int i = 0; i < arrResId.length(); i++) {
            CustomDTO dto = new CustomDTO();
            dto.setResId(arrResId.getResourceId(i, 0));
            dto.setTitle(titles[i]);
            dto.setContent(contents[i]);

            adapter.addItem(dto);
        }
    }
}