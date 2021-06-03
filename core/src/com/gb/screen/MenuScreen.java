package com.gb.screen;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;
import com.gb.base.BaseScreen;
import com.gb.math.Rect;
import com.gb.sprite.Background;
import com.gb.sprite.MovingObject;

public class MenuScreen extends BaseScreen {

    private Texture bg;     //Background
    private Texture mO;     //Moving object
    private Background background;
    private MovingObject movingObject;

//    private SpriteBatch batch;
//    private Vector2 movingObjectPosition;
//    private Vector2 movingDirection;
//    private Vector2 targetPoint;
//    private Vector2 tmp;
//    private int movingSpeed;
//    private int maxSpeed;

    @Override
    public void show() {
        super.show();
        bg = new Texture("textures/bg.png");
        mO = new Texture("ladyBird.png");

        background = new Background(bg);
        movingObject = new MovingObject(mO);
    }

    @Override
    public void resize(Rect worldBounds) {
        super.resize(worldBounds);
        background.resize(worldBounds);
        movingObject.resize(worldBounds);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        movingObject.update(delta);
        ScreenUtils.clear(0.33f, 0.45f, 0.68f, 1);
        batch.begin();
        background.draw(batch);
        batch.end();
    }

    @Override
    public void dispose() {
        super.dispose();
        bg.dispose();
        mO.dispose();
    }



    @Override
    public boolean touchDown(Vector2 touch, int pointer, int button) {
        movingObject.touchDown(touch, pointer, button);
        return false;
    }


    @Override
    public boolean scrolled(float amountX, float amountY) {
       /* movingSpeed -= amountY;
        if (movingSpeed > 1 && movingSpeed <= maxSpeed) {
            movingDirection.nor().setLength(movingSpeed);
        } else if (movingSpeed <= 1) {
            movingSpeed = 1;
            movingDirection.nor().setLength(movingSpeed);
        } else {
            movingSpeed = maxSpeed;
            movingDirection.nor().setLength(movingSpeed);
        }*/
        return false;
    }
}
