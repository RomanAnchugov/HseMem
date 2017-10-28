package ru.romansluckycorp.hsemem;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

import java.util.Random;

import ru.romansluckycorp.hsemem.actors.BackgroundMenuActor;

/**
 * Created by romananchugov on 25.10.2017.
 */

public class Menu implements Screen {

    private static final String TAG = "Menu.class";

    private MainGameClass game;//game class

    private int backgroundElementsCount = 300;

    private Stage stage;//ui stage
    private Stage backgroundStage;//falling elements stage on background
    private Table table;//ui table for elements

    public Menu(MainGameClass game){
        this.game = game;
    }


    @Override
    public void show() {
        backgroundStage = new Stage();
        stage = new Stage();
        table = new Table();

        TextureAtlas atlas = new TextureAtlas(Gdx.files.internal("MenuSpriteSheet.txt"));//main atlas for menu
        Skin menuSkin = new Skin(atlas);

        //menu header
        Label.LabelStyle labelStyle = new Label.LabelStyle();
        labelStyle.fontColor = Color.WHITE;
        labelStyle.font = new BitmapFont(Gdx.files.internal("fonts/MenuHeaderFont.fnt"));
        Label testLabel = new Label("Menu", labelStyle);

        //first menu button
        Button.ButtonStyle firstMenuButtonStyle = new Button.ButtonStyle();
        firstMenuButtonStyle.checked = menuSkin.getDrawable("MenuButton1");
        firstMenuButtonStyle.over = menuSkin.getDrawable("MenuButton1");
        firstMenuButtonStyle.up = menuSkin.getDrawable("MenuButton1");
        Button firstMenuButton = new Button(firstMenuButtonStyle);
        firstMenuButton.addListener(new InputListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                Gdx.app.log(TAG, "TouchDown");
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                Gdx.app.log(TAG, "TouchUp");
                game.setScreen(new TwoChairsGame(game));
            }
        });

        //formation of table and adding ui's actors
        table.add(testLabel);//header
        table.setPosition(Gdx.graphics.getWidth() / 2 - table.getWidth() / 2, Gdx.graphics.getHeight() / 2 - table.getHeight() / 2);
        table.center();
        table.row();
        table.add(firstMenuButton).width(Gdx.graphics.getWidth()).height(150);//first button
        table.debugAll();

        stage.addActor(table);//adding menu ui table

        //generating of backgrounds actors
        for(int i = 0; i < backgroundElementsCount; i++){
            if(new Random().nextBoolean()){
                backgroundStage.addActor(new BackgroundMenuActor(atlas.findRegion("HsememLogoSmall")));
            }else {
                backgroundStage.addActor(new BackgroundMenuActor(atlas.findRegion("MgumemLogoSmall")));
            }
        }

        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor( 1, 1, 1, 1 );
        Gdx.gl.glClear( GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT );
        backgroundStage.draw();
        backgroundStage.act();
        stage.act();
        stage.draw();
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
        backgroundStage.dispose();
        stage.dispose();
    }
}
