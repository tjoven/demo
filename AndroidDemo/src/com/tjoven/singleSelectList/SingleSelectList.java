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
		for(int i = 0;i<20;i++){
			arrayList.add("a");
			arrayList.add("a");
			arrayList.add("a");
		}
		arrayList.addAll(collection)
		adapter.setData(arrayList);
		listView.setAdapter(adapter);
		adapter.notifyDataSetChanged();
	}
}
