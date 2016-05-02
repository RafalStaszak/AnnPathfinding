package com.ann.visualization;

/**
 * Created by Rafał on 2016-04-23.
 */
public class MapSingleton {
    private static MapSingleton instance=null;
    private String jsonMap=null;
    protected MapSingleton() {

    }

    public static MapSingleton getInstance() {
        if(instance==null) instance=new MapSingleton();
        return instance;
    }

    public String getJsonMap() {
        return jsonMap;
    }

    public void setJsonMap(String json) {
        jsonMap=json;
    }
}
