package com.danieme.blog.android.customfonts;



import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

/**
 * 
 * @author danielme.com
 * 
 */
public class MainActivity extends Activity
{

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		/*Typeface typefaceRegular = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Regular.ttf");
		Typeface typefaceItalic = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Italic.ttf");
		Typeface typefaceBold = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Bold.ttf");
		
		((TextView) findViewById(R.id.textViewRoboto)).setTypeface(typefaceRegular);
		((TextView) findViewById(R.id.textViewRobotoItalic)).setTypeface(typefaceItalic);
		((TextView) findViewById(R.id.textViewRobotoBold)).setTypeface(typefaceBold);*/

	}


}