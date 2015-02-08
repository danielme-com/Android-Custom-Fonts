package com.danieme.blog.android.customfonts;

import java.io.IOException;
import java.util.HashMap;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.TextView;

/**
 * TextView que utiliza el tipo de letra indicado por el atributo "font" (ver
 * fichero /res/values/attrs.xml). El tipo de letra debe estar en el directorio
 * assets siguiendo la convención <nombre atributo
 * font>-<[Bold][Italic][Regular]>.ttf
 * 
 * @author danielme.com
 * 
 */
public class CustomTextView extends TextView
{
	/**
	 * Se guarda la tipografía en atributos estáticos para evitar el coste de
	 * obtenerlas siempre que se necesitan desde assets.
	 */
	private static HashMap<String, Typeface> tipografias;

	/**
	 * Estilo de letra (bold, italic...)
	 *  @see android.graphics.Typeface 
	 */
	private int fontStyle;

	//contructor necesario en Android 5
	@TargetApi(Build.VERSION_CODES.LOLLIPOP)
	public CustomTextView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes)
	{
		super(context, attrs, defStyleAttr, defStyleRes);
		setFont(attrs);
	}

	public CustomTextView(Context context, AttributeSet attrs, int defStyleAttr)
	{
		super(context, attrs, defStyleAttr);
		setFont(attrs);
	}

	public CustomTextView(Context context, AttributeSet attrs)
	{
		super(context, attrs);
		setFont(attrs);
	}

	private void setFont(AttributeSet attrs)
	{
		// se obtiene el valor del atributo "font" que será el tipo de letra
		String font = attrs.getAttributeValue("http://schemas.android.com/apk/res/com.danieme.blog.android.customfonts", "font");
		if (font != null)
		{
			// se obtienen automáticamente todas los tipos de letras existentes
			// la primera vez. Se ubicarán en /assets/fonts
			if (tipografias == null)
			{
				tipografias = new HashMap<String, Typeface>();
				String[] ttfs = null;
				try
				{
					ttfs = getContext().getAssets().list("fonts");
				}
				catch (IOException e)
				{
					Log.e("CustomFonts", "error al leerse los assets", e);
				}
				if (ttfs != null)
				{
					for (String file : ttfs)
					{
						tipografias.put(file, Typeface.createFromAsset(getContext().getAssets(), "fonts/" + file));
					}
				}

			}
			Typeface typeface = null;
			if (fontStyle == Typeface.BOLD)
			{
				typeface = tipografias.get(font + "-Bold.ttf");
			}

			else if (fontStyle == Typeface.ITALIC)
			{
				typeface = tipografias.get(font + "-Italic.ttf");
			}
			else
			{
				typeface = tipografias.get(font + "-Regular.ttf");
			}
			//si no se ha encontrado se deja el valor por omisión establecido por TextView
			if (typeface != null)
			{
				super.setTypeface(typeface);
			}
		}

	}

	//se sobreescribe este método para guardar el valor de style
	@Override
	public void setTypeface(Typeface tf, int style)
	{
		super.setTypeface(tf, style);
		fontStyle = style;
	}

}
