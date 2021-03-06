package com.gb.sprite;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.gb.base.Sprite;
import com.gb.math.Rect;

public class MovingObject extends Sprite {

    private static final float V_LEN = 0.01f;
    private Vector2 touch;
    private Vector2 v;
    private Vector2 tmp;


    public MovingObject(Texture texture) {
        super(new TextureRegion(texture));
        touch = new Vector2();
        v = new Vector2();
        tmp = new Vector2();

    }

    @Override
    public void update(float delta) {
        super.update(delta);
        tmp.set(touch);
        if (tmp.sub(pos).len() <= V_LEN) {
            pos.set(touch);
        } else {
            pos.add(v);
        }
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer, int button) {
        this.touch.set(touch);
        v.set(touch.cpy().sub(pos)).setLength(V_LEN);
        return false;
    }

    @Override
    public void resize(Rect worldBounds) {
        super.resize(worldBounds);
        setHeightProportion(0.1f);
    }
}
