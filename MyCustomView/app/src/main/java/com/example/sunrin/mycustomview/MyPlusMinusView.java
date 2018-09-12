package com.example.sunrin.mycustomview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class MyPlusMinusView extends View {

    Context context;
    int value; // 증감값
    Bitmap plusBitmap, minusBitmap; // 화면 출력 이미지
    Rect plusDst, minusDst; // 이미지가 화면에 출력되는 좌표


    public MyPlusMinusView(Context context) {
        super(context);
        this.context = context;
        init(); // 초기화
    }

    public MyPlusMinusView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        init(); // 초기화
    }

    // 생성자의 공통 코드(초기화)
    private void init(){
        value = 0;
        // 이미지 획득(리소스)
        plusBitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.plus);
        minusBitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.minus);

        // 이미지 출력 사각형 좌표 정보 설정
        plusDst = new Rect(10, 10, 210, 210);
        minusDst = new Rect(400, 10, 600, 210);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        // xml 속성이 wrap_content, match_parent, 숫자값(400dp)
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);

        // xml에서 정해준 사이즈
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        int width = 0;
        int height = 0;

        if(widthMode == MeasureSpec.AT_MOST){
            width = 600;
        }
        else if(widthMode == MeasureSpec.EXACTLY){
            width = widthSize;
        }

        if(heightMode == MeasureSpec.AT_MOST){
            height = 250;
        }
        else if(heightMode == MeasureSpec.EXACTLY){
            height = heightSize;
        }

        setMeasuredDimension(width, height); // Pixel
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Paint paint = new Paint();

        // 이미지의 크기 정보 가져오기
        Rect plusSrc = new Rect(0, 0, plusBitmap.getWidth(), plusBitmap.getHeight());
        Rect minusSrc = new Rect(0, 0, minusBitmap.getWidth(), minusBitmap.getHeight());

        // plus 이미지 그리기
        canvas.drawBitmap(plusBitmap, plusSrc, plusDst, null);

        // 텍스트(value) 그리기
        paint.setTextSize(80);
        paint.setColor(Color.BLUE);
        canvas.drawText(String.valueOf(value), 260, 150, paint);

        // minus 이미지 그리기
        canvas.drawBitmap(minusBitmap, minusSrc, minusDst, null);
    }

    // 이벤트 처리

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // 터치된 곳의 x, y 좌표
        int x = (int)event.getX();
        int y = (int)event.getY();

        // 플러스 이미지 영역에 터치되면...
        if(plusDst.contains(x, y) && event.getAction() == MotionEvent.ACTION_DOWN){
            value++;
            invalidate();
        }

        return true;
    }
}
