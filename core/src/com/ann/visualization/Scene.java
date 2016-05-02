package com.ann.visualization;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Json;

import sun.rmi.runtime.Log;

/**
 * Created by Rafał on 2016-04-10.
 */
public class Scene {
    private World mWorld;
    private Array<Rectangular> mHurdles=new Array<Rectangular>();
    private Array<Body> mBodies=new Array<Body>();
    private Map mMap;

    public Scene()
    {
        mWorld=new World(new Vector2(0,0),true);
        mMap=new Map();
    }

    public Scene(Map map) {
        mWorld=new World(new Vector2(0,0),true);
        mMap=map;
        createWorldFromMap();
        map.printMap();
    }



    public World getWorld() {
        return mWorld;
    }

    public Map getMap() {
        return mMap;
    }

    public int pointInWhichBody(Vector2 point) {
        for(int i=0; i<mBodies.size;i++) {
            if(mBodies.get(i).getPosition().equals(point)) return i;
        }
       return -1;
    }

    public void addHurdle(Vector2 centre, float width, float height)
    {
        mWorld.getBodies(mBodies);
        int pointInWhichBody=pointInWhichBody(centre);
        if(pointInWhichBody==-1) {
            mHurdles.add(new Rectangular(centre, width, height, mWorld));
            mMap.addMapObject(new MapObject(centre, width, height));
        } else {
            mWorld.destroyBody(mBodies.get(pointInWhichBody));
            mMap.removeMapObject(new MapObject(centre, width, height));
        }
    }

    private void createWorldFromMap() {
        for(MapObject mapObject : mMap.getArrayMap()) {
            mHurdles.add(new Rectangular(mapObject, mWorld));
        }

    }
}
