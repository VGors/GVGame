package com.gb;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.ScreenUtils;

public class GVGame extends ApplicationAdapter {
    private SpriteBatch batch;
    private Texture mainBackground;

    @Override
    public void create() {
        batch = new SpriteBatch();
        mainBackground = new Texture("mainBackground.png");
    }

    @Override
    public void render() {
        ScreenUtils.clear(0.3f, 0.45f, 1, 1);
        batch.begin();
        batch.draw(mainBackground, 0, 0);
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        mainBackground.dispose();
    }
}
