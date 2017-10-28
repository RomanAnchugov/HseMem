package ru.romansluckycorp.hsemem;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.Stage;

import ru.romansluckycorp.hsemem.actors.HseMemLogoActor;

/**
 * Created by romananchugov on 28.10.2017.
 */

public class TwoChairsGame implements Screen {
    public final String TAG = getClass().toString();

    //TODO: make spite sheet for this game

    private MainGameClass game;
    private Stage gameStage;

    private HseMemLogoActor hseMemLogoActor;

    public TwoChairsGame(MainGameClass game){
        this.game = game;
    }

    @Override
    public void show() {
        gameStage = new Stage();
    }

    @Override
    public void render(float delta) {
        Gdx.app.log(TAG, "render");
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

    }
}
