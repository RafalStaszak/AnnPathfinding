package com.ann.visualization;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonValue;

/**
 * Created by Rafał on 2016-04-22.
 */
public class MapSerializer implements Json.Serializer<Map> {
    @Override
    public void write(Json json, Map object, Class knownType) {
        Array<MapObject> mapObjects=object.getArrayMap();
        json.writeObjectStart();
        json.writeFields(object);
        json.writeObjectEnd();
    }

    @Override
    public Map read(Json json, JsonValue jsonData, Class type) {
        Map map;
        Array<MapObject> mapObjects=new Array<MapObject>();
        float x, y, height, width;
        for(JsonValue value : jsonData.child.iterator()) {
            x=value.child.child.asFloat();
            y=value.child.child.next.asFloat();
            height=value.child.next.asFloat();
            width=value.child.next.next.asFloat();
            mapObjects.add(new MapObject(new Vector2(x,y),width,height));
        }
        map=new Map(mapObjects);
            return map;
    }
}
