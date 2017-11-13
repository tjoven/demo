package com.tjoven.singleSelectList;

import java.util.ArrayList;

import com.tjove.ipcdemo.R;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class SingleSelectList extends Activity{

	ListView listView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.single_select_list);
		listView = (ListView)findViewById(R.id.list);
		ItemAdapter adapter = new ItemAdapter(this);
		ArrayList<String> arrayList = new ArrayList<String>();
		for(int i = 0;i<5;i++){
			arrayList.add("a\nc");
			arrayList.add("b");
		}
		adapter.setData(arrayList);
		listView.setAdapter(adapter);
//		adapter.notifyDataSetChanged();
		adapter.notifyDataSetInvalidated();
	}
}
