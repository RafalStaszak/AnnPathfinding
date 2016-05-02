package com.ann.visualization;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

/**
 * Created by Rafał on 2016-04-24.
 */
public class ShapeRendererUtils {
    public static void drawMap(Map map, ShapeRenderer shapeRenderer, Camera camera)
    {
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(Color.PURPLE);
        shapeRenderer.setProjectionMatrix(camera.combined);
        for(MapObject mapObject : map.getArrayMap()) {
            shapeRenderer.rect(mapObject.getCentre().x-mapObject.getWidth()/2f,mapObject.getCentre().y-mapObject.getHeight()/2f,mapObject.getWidth(),mapObject.getHeight());
        }
        shapeRenderer.end();
    }
}
