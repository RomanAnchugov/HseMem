package ru.romansluckycorp.hsemem.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;

import java.util.Random;

import ru.romansluckycorp.hsemem.utils.ActorsTemplate;

/**
 * Created by romananchugov on 26.10.2017.
 */

public class BackgroundMenuActor extends ActorsTemplate {
    private float verticalSpeed;//random speed of falling elements

    public BackgroundMenuActor(TextureRegion region){
        super(region);
        //set random starter position
        setPosition(new Random().nextInt(Gdx.graphics.getWidth() + 100) - 100, Gdx.graphics.getHeight() + new Random().nextInt(500));
        //set random starter vertical speed
        verticalSpeed = new Random().nextFloat() + 0.5f;
        //set random starter alpha
        sprite.setAlpha(MathUtils.clamp(new Random().nextFloat(), .2f, 1f));
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);

    }

    @Override
    public void act(float delta) {
        super.act(delta);
        //moving
        this.setPosition(getX(), getY() - verticalSpeed);
        //checking bottom bound
        if(getY() < -100){
            setPosition(new Random().nextInt(Gdx.graphics.getWidth() + 100) - 100, Gdx.graphics.getHeight() + new Random().nextInt(500));
        }
    }
}
