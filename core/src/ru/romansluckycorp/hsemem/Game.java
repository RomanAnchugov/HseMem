package ru.romansluckycorp.hsemem;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;

import ru.romansluckycorp.hsemem.actors.HseMemLogoActor;

public class Game extends ApplicationAdapter {
    SpriteBatch batch;
	private TextureAtlas atlas;
    private Texture logoTexture;
    private Texture wallTexture;

    Stage stage;
	
	@Override
	public void create () {
		atlas = new TextureAtlas("starterSprites.txt");
        batch = new SpriteBatch();

        stage = new Stage();
        stage.addActor(new HseMemLogoActor(atlas.findRegion("hseMemLogo")));
        stage.setDebugAll(true);

        stage.addListener(new InputListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                Gdx.app.log("YEAH", "tuchDown");
                return true;
            }
        });

        Gdx.input.setInputProcessor(stage);

	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

//		batch.begin();
//		batch.draw(logoTexture, 0, 0);
//		batch.end();

        stage.act();
        stage.draw();
	}
	
	@Override
	public void dispose () {
		batch.dispose();

	}
}
