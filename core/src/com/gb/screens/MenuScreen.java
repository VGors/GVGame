package com.gb.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;
import com.gb.base.BaseScreen;

public class MenuScreen extends BaseScreen implements InputProcessor {
    private SpriteBatch batch;
    private Texture background;
    private Texture movingObject;
    private Vector2 movingObjectPosition;
    private Vector2 movingDirection;
    private Vector2 targetPoint;
    private int movingSpeed;
    private float distance, lastDistance;

    @Override
    public void show() {
        background = new Texture("mainBackground.png");
        movingObject = new Texture("ladyBird.png");
        movingObjectPosition = new Vector2(17, 28);
        targetPoint = new Vector2(17, 28);
        movingDirection = new Vector2(0, 0);
        movingSpeed = 3;
        distance = 0;
        lastDistance = 0;
        batch = new SpriteBatch();
        Gdx.input.setInputProcessor(this);
    }

    @Override
    public void render(float delta) {
        batch.begin();
        distance = targetPoint.cpy().sub(movingObjectPosition).len();
        if (lastDistance > distance){
            distance = 1;
        }
        batch.draw(background, 0, 0);
        if (distance > 5) {
            movingObjectPosition.add(movingDirection);
            batch.draw(movingObject, movingObjectPosition.x, movingObjectPosition.y);
        } else {
            batch.draw(movingObject, movingObjectPosition.x, movingObjectPosition.y);
        }
        lastDistance = distance;
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        background.dispose();
        movingObject.dispose();
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        targetPoint.x = screenX - movingObject.getWidth() / 2;
        targetPoint.y = Gdx.graphics.getHeight() - screenY - movingObject.getHeight() / 2;
        movingDirection = targetPoint.cpy().sub(movingObjectPosition);
        movingDirection.nor().scl(movingSpeed);
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(float amountX, float amountY) {
//        movingSpeed -= amountY;
        if (movingSpeed > 1 && movingSpeed <= 5){
            movingSpeed -= amountY;
            movingDirection.nor().scl(movingSpeed);
        } else if (movingSpeed <= 1){
            movingSpeed = 2;
            movingDirection.nor().scl(movingSpeed);
        } else {
            movingSpeed = 5;
            movingDirection.nor().scl(movingSpeed);
        }
        return false;
    }
}
