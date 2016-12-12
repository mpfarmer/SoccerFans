package com.soccerfans.view;

import android.content.Context;
import android.graphics.*;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;

public class RoundImageView extends ImageView {

	public RoundImageView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	
	public RoundImageView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
	}


	public RoundImageView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}


	@Override
	public void draw(Canvas canvas) {
		// ��ȡ��ǰ�ؼ��� drawable
		Drawable drawable = getDrawable();

		if (drawable == null) {
			return;
		}

		// ���� get �����Ŀ�Ⱥ͸߶��ǵ�ǰ�ؼ����Ӧ�Ŀ�Ⱥ͸߶ȣ��� xml ���ã�
		if (getWidth() == 0 || getHeight() == 0) {
			return;
		}

		// ����
		Paint paint = new Paint();
		// ��ɫ����
		paint.setColor(0xff424242);
		// �����
		paint.setAntiAlias(true);
		// Paint �� Xfermode��PorterDuff.Mode.SRC_IN ȡ����ͼ��Ľ�������, ֻ��ʾ�ϲ�ͼ��
		PorterDuffXfermode xfermode = new PorterDuffXfermode(
				PorterDuff.Mode.SRC_IN);
		// ��ȡ bitmap�������� imageview �� bitmap
		Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();

		// ��־
		int saveFlags = Canvas.MATRIX_SAVE_FLAG | Canvas.CLIP_SAVE_FLAG
				| Canvas.HAS_ALPHA_LAYER_SAVE_FLAG
				| Canvas.FULL_COLOR_LAYER_SAVE_FLAG
				| Canvas.CLIP_TO_LAYER_SAVE_FLAG;
		canvas.saveLayer(0, 0, getWidth(), getHeight(), null, saveFlags);

		// �����֣�����������һ���Ϳռ��С��ƥ���Բ
		canvas.drawCircle(getWidth() / 2, getHeight() / 2, getWidth() / 2,
				paint);
		paint.setXfermode(xfermode);

		// �ռ�Ĵ�С /bitmap �Ĵ�С =bitmap ���ŵı���
		float scaleWidth = ((float) getWidth()) / bitmap.getWidth();
		float scaleHeight = ((float) getHeight()) / bitmap.getHeight();

		Matrix matrix = new Matrix();
		matrix.postScale(scaleWidth, scaleHeight);

		// bitmap ����
		bitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(),
				bitmap.getHeight(), matrix, true);

		// draw ��ȥ
		canvas.drawBitmap(bitmap, 0, 0, paint);
		// paint.setXfermode(null);
		canvas.restore();

	}

}
