package com.tjoven.listfragment;

import com.tjove.ipcdemo.R;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ConcreteListFragment extends ListFragment{
	TranslateContentListener translateContentListener;
	String[] cities={ 
			 "Shenzhen",
	         "Beijing",
	         "Shanghai",
	         "Guangzhou",
	         "Wuhan",
	         "Tianjing",
	         "Changsha",
	         "Xi'an",
	         "Chongqing",
	         "Guilin",
	    };
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		translateContentListener=(TranslateContentListener) activity;
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view=inflater.inflate(R.layout.list_fragment, null);
		return view;
	}
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setListAdapter(new ArrayAdapter<String>(getActivity(),
				android.R.layout.simple_list_item_1, cities));
	}
	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		 Toast.makeText(getActivity(), 
	                "You have selected " + cities[position],
	                Toast.LENGTH_SHORT).show();
		 showSelectedDetails(cities[position]);
	}
	private void showSelectedDetails(String city) {
		translateContentListener.translate(city);

	}
}
