package com.ann.visualization;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.Viewport;

import java.awt.Menu;

import static com.ann.visualization.MenuScreenUtils.*;

/**
 * Created by Rafał on 2016-04-21.
 */
public class MenuScreen implements Screen {
    Stage mStage;
    Skin mSkin;
    Game mGame;

    public MenuScreen(Game game) {
        create();
        mGame=game;
    }

    public void create() {
        mStage=new Stage();
        Gdx.input.setInputProcessor(mStage);
        mSkin=new Skin();

        TextButton.TextButtonStyle textButtonStyle=createTextButtonStyle(200, 80, Color.SLATE, mSkin, "color");
        mSkin.add("default", textButtonStyle);

        final TextButton simulateButton=new TextButton("SIMULATE",textButtonStyle);
        simulateButton.setPosition(Gdx.graphics.getWidth() / 2f-100, Gdx.graphics.getHeight() / 2f+60);
        mStage.addActor(simulateButton);

        final TextButton mapButon=new TextButton("CREATE MAP",textButtonStyle);
        mapButon.setPosition(Gdx.graphics.getWidth() / 2f - 100, Gdx.graphics.getHeight() / 2f-40);
        mStage.addActor(mapButon);

        final TextButton quitButon=new TextButton("QUIT",textButtonStyle);
        quitButon.setPosition(Gdx.graphics.getWidth() / 2f - 100, Gdx.graphics.getHeight() / 2f-140);
        mStage.addActor(quitButon);

        simulateButton.addListener(new ChangeListener() {
            public void changed(ChangeEvent event, Actor actor) {
                if (MapSingleton.getInstance().getJsonMap() != null)
                    mGame.setScreen(new Visualization(mGame));

            }
        });

        mapButon.addListener(new ChangeListener() {
            public void changed(ChangeEvent event, Actor actor) {
                mGame.setScreen(new MapCreator(mGame));

            }
        });

        quitButon.addListener(new ChangeListener() {
            public void changed(ChangeEvent event, Actor actor) {
                Gdx.app.exit();

            }
        });
    }

    @Override
    public void show() {
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0f, 0.03f, 0f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        mStage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
        mStage.draw();
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
        mStage.dispose();
        mSkin.dispose();

    }
}
