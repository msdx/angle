/*
 * @(#)AngleBitmapTexture.java		       Project: ANGLE
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

/**
 * From: http://blog.csdn.net/foruok/article/details/8863986 
 */
public class AngleBitmapTexture extends AngleTexture {
    protected Bitmap mBitmap;

    public AngleBitmapTexture(AngleTextureEngine textureEngine, Bitmap bmp) {
        super(textureEngine);
        mBitmap = bmp;
    }

    @Override
    public Bitmap create() {
        return mBitmap;
    }

    void setBitmap(Bitmap bitmap) {
        mBitmap = bitmap;
        mTextureEngine.deleteTexture(this);
    }

}