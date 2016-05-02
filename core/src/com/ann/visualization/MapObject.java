package com.ann.visualization;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

import java.util.*;

/**
 * Created by Rafał on 2016-04-22.
 */
public class MapObject {
    private static String TAG="MapObject";
    float mWidth, mHeight;
    Vector2 mCentre;


    public MapObject(Vector2 centre, float width, float height) {
        mCentre = centre;
        mWidth = width;
        mHeight = height;
    }

    void printMapObject()
    {
        Gdx.app.log(TAG,"centre:"+mCentre.x+" "+mCentre.y+ " width: " + mWidth + " height: " + mHeight);
    }

    @Override
    public boolean equals(Object obj) {
        if ( obj == null || obj == this || !(obj instanceof MapObject) )
            return false;

        MapObject otherMapObject = (MapObject) obj;

        if (!otherMapObject.mCentre.equals(this.mCentre)) return false;
        if (otherMapObject.mHeight!=this.mHeight) return false;
        if (otherMapObject.getWidth()!=this.mWidth) return false;
        return true;
    }

    public float getWidth() {
        return mWidth;
    }

    public void setWidth(float width) {
        mWidth = width;
    }

    public float getHeight() {
        return mHeight;
    }

    public void setHeight(float height) {
        mHeight = height;
    }

    public Vector2 getCentre() {
        return mCentre;
    }

    public void setCentre(Vector2 centre) {
        mCentre = centre;
    }


}
