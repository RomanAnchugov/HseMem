package ru.romansluckycorp.hsemem;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;

import java.util.ArrayList;

import ru.romansluckycorp.hsemem.actors.TwoChairsGameMainActor;

/**
 * Created by romananchugov on 28.10.2017.
 */

public class TwoChairsGame implements Screen {
    public final String TAG = getClass().toString();

    private TextureAtlas atlas;//main sprite sheet for this game

    private MainGameClass game;//just game class
    private Stage gameStage;//stage for game

    private ArrayList<TwoChairsGameMainActor> listOfMemsLogo;//list of game actors

    public TwoChairsGame(MainGameClass game){
        this.game = game;
    }

    @Override
    public void show() {
        atlas = new TextureAtlas(Gdx.files.internal("TwoChairsGameSpriteSheet.txt"));
        gameStage = new Stage();
        //generator of game mem actors
        for(int i = 0; i < 1; i++) {
            final TwoChairsGameMainActor hseMemLogoActor;
            hseMemLogoActor = new TwoChairsGameMainActor(atlas.findRegion("HsememLogoSmall"));
            //TODO change it, depends on generator
            hseMemLogoActor.setPosition(Gdx.graphics.getWidth() * i/10, Gdx.graphics.getHeight() / 2);
            //click listener
            hseMemLogoActor.addListener(new InputListener() {
                @Override
                public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                    hseMemLogoActor.addAction(Actions.fadeOut(1f));//effect of fading out when clicked on it
                    return true;
                }
            });
            //adding generated actor to the game stage
            gameStage.addActor(hseMemLogoActor);
        }

        Gdx.input.setInputProcessor(gameStage);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor( 1, 1, 1, 1 );
        Gdx.gl.glClear( GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT );

        gameStage.act(delta);
        gameStage.draw();
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
