package com.ann.visualization;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

/**
 * Created by Rafał on 2016-04-21.
 */
public class MenuScreenUtils {
    public static TextButton.TextButtonStyle createTextButtonStyle(int width, int height, Color color, Skin skin, String key){
        BitmapFont bfont=new BitmapFont();
        skin.add("default",bfont);
        
        Pixmap pixmap= new Pixmap(width,height, Pixmap.Format.RGBA8888);
        pixmap.setColor(color);
        pixmap.fill();
        skin.add(key, new Texture(pixmap));


        TextButton.TextButtonStyle textButtonStyle = new TextButton.TextButtonStyle();
        textButtonStyle.up = skin.newDrawable(key, Color.DARK_GRAY);
        textButtonStyle.down = skin.newDrawable(key, Color.DARK_GRAY);
        textButtonStyle.checked = skin.newDrawable(key, Color.BLUE);
        textButtonStyle.over = skin.newDrawable(key, Color.LIGHT_GRAY);

        textButtonStyle.font = skin.getFont("default");

        return textButtonStyle;
    }
}
