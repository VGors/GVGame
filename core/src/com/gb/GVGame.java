package com.gb;

import com.badlogic.gdx.Game;
import com.gb.screen.MenuScreen;

public class GVGame extends Game {
//    private SpriteBatch batch;
//    private Texture img;

    @Override
    public void create() {
        setScreen(new MenuScreen());
//        batch = new SpriteBatch();
//        img = new Texture("mainBackground.png");
    }

//    @Override
//    public void render() {
//        ScreenUtils.clear(0.3f, 0.45f, 1, 1);
//        batch.begin();
//        batch.draw(img, 0, 0);
//        batch.end();
//    }

}
