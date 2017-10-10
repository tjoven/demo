package com.tjoven.loader;

import java.util.zip.Inflater;

import junit.framework.Test;

import com.tjove.ipcdemo.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager.LoaderCallbacks;
import android.support.v4.content.Loader;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class NetWorkLoaderFragment extends Fragment{
	TextView textView ;
	private void attach() {
		// TODO Auto-generated method stub
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = LayoutInflater.from(getActivity()).inflate(R.layout.network_loader_activity, container);
		textView = (TextView) view.findViewById(R.id.tv);
		return super.onCreateView(inflater, container, savedInstanceState);
	}
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		getLoaderManager().initLoader(0, null, new LoaderCallbacks<String>() {

			@Override
			public Loader<String> onCreateLoader(int arg0, Bundle arg1) {
				// TODO Auto-generated method stub
				return new NetWorkLoader(getActivity());
			}

			@Override
			public void onLoadFinished(Loader<String> arg0, String arg1) {
				// TODO Auto-generated method stub
				textView.setText(arg1);
			}

			@Override
			public void onLoaderReset(Loader<String> arg0) {
				// TODO Auto-generated method stub
				
			}
		});
	}

}
