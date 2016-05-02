package com.ann.visualization;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

/**
 * Created by Rafał on 2016-04-10.
 */
public class Rectangular
{
    private Body mBody;
    public Rectangular(Vector2 position, float width, float height, World world) {
        BodyDef bodyDef=new BodyDef();
        bodyDef.type= BodyDef.BodyType.StaticBody;
        bodyDef.position.set(position.x, position.y);

        PolygonShape shape=new PolygonShape();
        shape.setAsBox(width/2f,height/2f);

        FixtureDef fixtureDef=new FixtureDef();
        fixtureDef.shape=shape;
        fixtureDef.density=1;
        mBody=world.createBody(bodyDef);
        mBody.createFixture(fixtureDef);
        shape.dispose();
    }

    public Rectangular(MapObject mapObject, World world) {
        BodyDef bodyDef=new BodyDef();
        bodyDef.type= BodyDef.BodyType.StaticBody;
        bodyDef.position.set(mapObject.getCentre());

        PolygonShape shape=new PolygonShape();
        shape.setAsBox(mapObject.getWidth()/2f,mapObject.getHeight()/2f);

        FixtureDef fixtureDef=new FixtureDef();
        fixtureDef.shape=shape;
        fixtureDef.density=1;
        mBody=world.createBody(bodyDef);
        mBody.createFixture(fixtureDef);
        shape.dispose();
    }

    public Body getBody() {
        return mBody;
    }
}
