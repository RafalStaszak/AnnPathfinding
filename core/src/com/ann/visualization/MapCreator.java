package com.ann.visualization;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.utils.Json;

import static com.ann.visualization.Constants.VIEWPORT_HEIGHT;
import static com.ann.visualization.Constants.VIEWPORT_WIDTH;

/**
 * Created by Rafał on 2016-04-23.
 */
public class MapCreator implements Screen {
    private Scene mScene;
    private OrthographicCamera mCamera;
    Box2DDebugRenderer debug=new Box2DDebugRenderer();
    private Game mGame;
    private Json mMapData;


    public MapCreator(Game game)
    {
        mGame=game;
        mScene=new Scene();
        mMapData=new Json();
        mMapData.setSerializer(Map.class,new MapSerializer());
        mCamera=new OrthographicCamera(VIEWPORT_WIDTH,VIEWPORT_HEIGHT);
        mCamera.position.set(VIEWPORT_WIDTH / 2, VIEWPORT_HEIGHT / 2, 0);
        mCamera.update();
    }

    @Override
    public void show() {

        final Vector3 temp=new Vector3();
        final Vector2 prevCentre=new Vector2();
        Gdx.input.setInputProcessor(new MyInputProcessor() {

            @Override
            public boolean touchDragged(int screenX, int screenY, int pointer) {
                temp.set(screenX, screenY, 0);
                mCamera.unproject(temp);
                Vector2 centre=new Vector2((int)Math.ceil(temp.x)-0.5f,(int)Math.ceil(temp.y)-0.5f);
                if(!centre.equals(prevCentre)) {
                    mScene.addHurdle(centre, 1f, 1f);
                }
                prevCentre.set(centre);
                return false;
            }

            @Override
            public boolean touchDown(int screenX, int screenY, int pointer, int button) {
                temp.set(screenX, screenY, 0);
                mCamera.unproject(temp);
                Vector2 centre=new Vector2((int)Math.ceil(temp.x)-0.5f,(int)Math.ceil(temp.y)-0.5f);
                mScene.addHurdle(centre, 1f, 1f);
                prevCentre.set(centre);
                return false;
            }

            @Override
            public boolean keyDown(int keycode) {
                if(keycode== Input.Keys.BACK) {
                    Map map=mScene.getMap();
                    if(map.isEmpty()) {
                        MapSingleton.getInstance().setJsonMap(null);
                    } else {
                        String json = mMapData.toJson(map);
                        MapSingleton.getInstance().setJsonMap(json);
                    }
                    mGame.setScreen(new MenuScreen(mGame));
                }
                return false;
            }
        });
        Gdx.input.setCatchBackKey(true);
    }

    @Override
    public void render(float delta) {
        mScene.getWorld().step(1/60f,5,3);
        Gdx.gl.glClearColor(0.1f, 0.1f, 0.1f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        debug.render(mScene.getWorld(), mCamera.combined);
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        debug.dispose();
        mGame.dispose();
    }
}
