package com.ann.visualization;

import com.badlogic.gdx.utils.Array;

import java.util.ArrayList;

/**
 * Created by Rafał on 2016-04-22.
 */
public class Map {
    Array<MapObject> mArrayMap=new Array<MapObject>();

    public Map() {

    }
    public Map(Array<MapObject> mapObjects) {
        mArrayMap=mapObjects;
    }
    public void addMapObject(MapObject mapObject) {
        mArrayMap.add(mapObject);
    }
    public boolean removeMapObject(MapObject mapObject) {
        return mArrayMap.removeValue(mapObject,false);
    }
    public void printMap()
    {
        for(MapObject mapObject:mArrayMap) {
            mapObject.printMapObject();
        }
    }

    public Array<MapObject> getArrayMap() {
        return mArrayMap;
    }
    boolean isEmpty() {
        return (mArrayMap.size==0) ? true : false;
    }
}
