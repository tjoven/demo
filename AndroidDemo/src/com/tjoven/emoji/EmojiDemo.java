package com.tjoven.emoji;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.InputType;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ImageSpan;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.tjove.ipcdemo.R;
import com.tjoven.main.BaseActivity;

public class EmojiDemo extends BaseActivity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		final EditText editText = new EditText(this);
		Button button = new Button(this);
		
		LinearLayout layout= new LinearLayout(this);
		LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT);
		layout.setLayoutParams(params);
		
		layout.setOrientation(LinearLayout.VERTICAL);
		layout.addView(editText);
		layout.addView(button);
		
		setContentView(layout);
		editText.setText("人\ud83d\ude0000\ud83d\ude00");
		editText.setInputType(InputType.TYPE_CLASS_PHONE);
		Log.d("tag \ud83d\ude00=:", "nihaijbjasdfZ的人\ud83d\ude0000are他");
		button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String result = editText.getText().toString();
				Log.d("tag", editText.getText().toString());
				
				String Base64result = Base64.encodeToString(result.getBytes(),Base64.DEFAULT);
				Log.d("tag Base64编码", "Base64="+Base64result);
				Log.d("tag Base64解码", "Base64="+	uncode(Base64result));
				
				String utfResult = encodeUTF(result);
				Log.d("tag UTF-8编码:", utfResult);
				Log.d("tag UTF-8解码:", uncodeUTF(utfResult));
				
				Toast.makeText(EmojiDemo.this, editText.getText().toString(), Toast.LENGTH_SHORT).show();
				Toast.makeText(EmojiDemo.this, convertToMsg(editText.getText(), EmojiDemo.this), Toast.LENGTH_SHORT).show();
			}

		});
		
	}
	private String uncodeUTF(String str) {
		// TODO Auto-generated method stub
		String result = null;
		try {
			  result = URLDecoder.decode(str, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	private String encodeUTF(String str) {
		// TODO Auto-generated method stub
		String result = null;
		try {
			result = URLEncoder.encode(str,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	private String uncode(String str) {
		// TODO Auto-generated method stub
		byte[] bytes=Base64.decode(str,Base64.DEFAULT);
		return new String(bytes);
	}
	/**
	 * @desc <pre>表情解析,转成unicode字符</pre>
	 * @author Weiliang Hu
	 * @date 2013-12-17
	 * @param cs
	 * @param mContext
	 * @return
	 */
	public static String convertToMsg(CharSequence cs, Context mContext) {
		SpannableStringBuilder ssb = new SpannableStringBuilder(cs);
		ImageSpan[] spans = ssb.getSpans(0, cs.length(), ImageSpan.class);
		for (int i = 0; i < spans.length; i++) {
			ImageSpan span = spans[i];
			String c = span.getSource();
			int a = ssb.getSpanStart(span);
			int b = ssb.getSpanEnd(span);
			if (c.contains("[")) {
				ssb.replace(a, b, convertUnicode(c));
			}
		}
		ssb.clearSpans();
		return ssb.toString();
	}

	private static String convertUnicode(String emo) {
		emo = emo.substring(1, emo.length() - 1);
		if (emo.length() < 6) {
			return new String(Character.toChars(Integer.parseInt(emo, 16)));
		}
		String[] emos = emo.split("_");
		char[] char0 = Character.toChars(Integer.parseInt(emos[0], 16));
		char[] char1 = Character.toChars(Integer.parseInt(emos[1], 16));
		char[] emoji = new char[char0.length + char1.length];
		for (int i = 0; i < char0.length; i++) {
			emoji[i] = char0[i];
		}
		for (int i = char0.length; i < emoji.length; i++) {
			emoji[i] = char1[i - char0.length];
		}
		return new String(emoji);
	}

}
