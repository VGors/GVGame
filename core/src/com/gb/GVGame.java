package com.gb;

import com.badlogic.gdx.Game;
import com.gb.screens.MenuScreen;

public class GVGame extends Game {

    @Override
    public void create() {
        setScreen(new MenuScreen());
    }
}