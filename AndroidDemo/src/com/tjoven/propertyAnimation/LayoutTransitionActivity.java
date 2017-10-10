package com.tjoven.propertyAnimation;

import android.animation.LayoutTransition;
import android.content.Context;
import android.os.Bundle;
import android.transition.Transition;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.GridLayout;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.tjove.ipcdemo.R;
import com.tjoven.main.BaseActivity;

public class LayoutTransitionActivity extends BaseActivity implements
		OnCheckedChangeListener {
	
	private Context context=LayoutTransitionActivity.this;
	@ViewInject(R.id.button1)
	private Button button;
	@ViewInject(R.id.checkBox1)
	private CheckBox mApperBox;
	@ViewInject(R.id.checkBox2)
	private CheckBox mDisapperBox;
	@ViewInject(R.id.checkBox3)
	private CheckBox mChangeApperBox;
	@ViewInject(R.id.checkBox4)
	private CheckBox mDiaChangeApperBox;
	@ViewInject(R.id.gl)
	private GridLayout gridLayout;

	LayoutTransition layoutTransition;
	int value;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_transition);
		ViewUtils.inject(this);
		bindView();
	}

	private void bindView() {
		mApperBox.setOnCheckedChangeListener(this);
		mDisapperBox.setOnCheckedChangeListener(this);
		mChangeApperBox.setOnCheckedChangeListener(this);
		mDiaChangeApperBox.setOnCheckedChangeListener(this);
		layoutTransition = new LayoutTransition();
		gridLayout.setLayoutTransition(layoutTransition);
	}

	public void startAnimate(final View view) {
		final Button button=new Button(context);
		button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				gridLayout.removeView(button);
				
			}
		});
		button.setText(""+value++);
		gridLayout.addView(button,(gridLayout.getChildCount()<=0)?0:1);

	}
	@Override
	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
		layoutTransition = new LayoutTransition();
		// mApperBox 被选中，
		layoutTransition.setAnimator(
				LayoutTransition.APPEARING,
				(mApperBox.isChecked()) ? layoutTransition.getAnimator(LayoutTransition.APPEARING) : null);
		layoutTransition.setAnimator(
				LayoutTransition.DISAPPEARING,
				(mDisapperBox.isChecked()) ? layoutTransition.getAnimator(LayoutTransition.DISAPPEARING) : null);
		layoutTransition.setAnimator(
				LayoutTransition.CHANGE_APPEARING,
				(mChangeApperBox.isChecked()) ? layoutTransition.getAnimator(LayoutTransition.CHANGE_APPEARING) : null);
		layoutTransition.setAnimator(
				LayoutTransition.CHANGE_DISAPPEARING,
				(mDiaChangeApperBox.isChecked()) ? layoutTransition.getAnimator(LayoutTransition.CHANGE_DISAPPEARING) : null);
		gridLayout.setLayoutTransition(layoutTransition);
	}

}
