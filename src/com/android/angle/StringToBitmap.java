/*
 * @(#)StringToBitmap.java		       Project: AngleGame
 * Date: 2014-5-29
 *
 * Copyright (c) 2014 CFuture09, Institute of Software, 
 * Guangdong Ocean University, Zhanjiang, GuangDong, China.
 * All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.android.angle;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.TextUtils;

/**
 * Code from: http://blog.csdn.net/foruok/article/details/8863986
 */
public class StringToBitmap {
    public static Bitmap getBitmapFromSingleLineString(String text, int textColor,
            int backgroundColor, String fontType, int fontSize, int bitmapWidth, int bitmapHeight,
            Paint.Align align) {
        Bitmap bitmap = Bitmap.createBitmap(bitmapWidth, bitmapHeight, Bitmap.Config.ARGB_4444);
        Canvas canvas = new Canvas(bitmap);
        // 背景颜色
        canvas.drawColor(backgroundColor);
        TextPaint paint = new TextPaint();

        Typeface typeface = Typeface.create(fontType, Typeface.NORMAL);
        // 消除锯齿
        paint.setAntiAlias(true);
        // 字体为红色
        paint.setColor(textColor);
        paint.setTypeface(typeface);
        paint.setTextSize(fontSize);
        paint.setTextAlign(align);

        CharSequence truncateText = TextUtils.ellipsize(text, paint, bitmapWidth,
                TextUtils.TruncateAt.END);
        // 绘制字体
        canvas.drawText(truncateText, 0, truncateText.length(), 0, bitmapHeight - 1, paint);
        return bitmap;
    }
}
