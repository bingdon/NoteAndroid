package com.bing.bingnote;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.EditText;

public class BingEditText extends EditText {

	public BingEditText(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		paint = new Paint();
		paint.setColor(Color.GREEN);
	}

	private Paint paint;

	@SuppressLint("NewApi")
	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub

		int width = canvas.getWidth();
		int height = canvas.getHeight();

		float mheight = this.getLineHeight();
		int lines = (int) (height / mheight);
		int m = this.getExtendedPaddingTop();
		for (int i = 0; i < lines; i++) {
			canvas.drawLine(0, m, width, m, paint);
			m = (int) (m + this.getLineHeight() + this.getLineSpacingExtra());

		}

		super.onDraw(canvas);
	}

	@Override
	public float getTextSize() {
		// TODO Auto-generated method stub
		return super.getTextSize();
	}

	@Override
	public int getCompoundPaddingTop() {
		// TODO Auto-generated method stub
		return super.getCompoundPaddingTop();
	}

	@Override
	public int getCompoundPaddingBottom() {
		// TODO Auto-generated method stub
		return super.getCompoundPaddingBottom();
	}

}
