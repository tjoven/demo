package com.tjoven.annotation;

/**
 * 通过注释减少重复代码  Annotation
 */
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.lang.reflect.Method;



import com.tjove.ipcdemo.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

@ContextViewInject(R.layout.activity_main)
public class AnnotationDemo extends Activity implements OnClickListener{
	
	@ViewInject(R.id.button01)
	private Button button;
	@ViewInject(R.id.text)
	private TextView textView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
//		setContentView(R.layout.activity_main);
		
		ViewInjectUtils.inject(this);
		textView.setText("Annotation");
		button.setOnClickListener(this);
		
	}
	@Override
	public void onClick(View v) {
		Toast.makeText(AnnotationDemo.this, textView.getText(), Toast.LENGTH_SHORT).show();
		
	}

}

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
 @interface ViewInject{
	int value();
}

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
 @interface ContextViewInject{
	int value();
}
 class ViewInjectUtils{
	 private static final String METHOD_FIND_VIEW_BY_ID="findViewById";
	 private static final String METHOD_SET_CONTENTVIEW = "setContentView";
	static void inject(Activity activity){
		Class<?> class1=activity.getClass();
		injectContextView(activity,class1);
		injectView(activity,class1);
	}

	private static void injectContextView(Activity activity, Class<?> class1) {
		ContextViewInject contextViewInject=class1.getAnnotation(ContextViewInject.class);		
		if (contextViewInject==null) {
			return;
		}
		int viewId=contextViewInject.value();
		if (viewId<0) {
			return;
		}
		try {
			Method method=class1.getMethod(METHOD_SET_CONTENTVIEW, int.class);
			method.setAccessible(true);
			method.invoke(activity, viewId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 注入所有控件
	 * @param activity
	 * @param class1
	 */
	private static void injectView(Activity activity,Class class1) {
		Field[] fields=class1.getDeclaredFields();
		for (Field field : fields) {
			ViewInject viewInject=field.getAnnotation(ViewInject.class);
			if (viewInject!=null) {
				int id=viewInject.value();
				if (id<0) {
					continue;
				}
				try {
					Method method=class1.getMethod(METHOD_FIND_VIEW_BY_ID, int.class);
					Object view=method.invoke(activity, id);
					field.setAccessible(true);
					field.set(activity, view);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
 }