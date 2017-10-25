package ru.romansluckycorp.hsemem.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 * Created by romananchugov on 24.10.2017.
 */

public class ActorsTemplate extends Actor {
    public Sprite sprite;

    public ActorsTemplate(TextureRegion texture){
        texture.getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        sprite = new Sprite(texture);
        setWidth(sprite.getWidth());
        setHeight(sprite.getHeight());
        setPosition(Gdx.graphics.getWidth() /  2 - getWidth() / 2, Gdx.graphics.getHeight() / 2 - getHeight() / 2);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        sprite.draw(batch);
    }

    @Override
    public void act(float delta) {
        sprite.setSize(getWidth(), getHeight());
        sprite.setPosition(this.getX(), this.getY());
    }
}
