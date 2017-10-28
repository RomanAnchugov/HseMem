package ru.romansluckycorp.hsemem.actors;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import ru.romansluckycorp.hsemem.utils.ActorsTemplate;

/**
 * Created by romananchugov on 24.10.2017.
 */

//HseMem logo for "Two chairs game"

public class TwoChairsGameMainActor extends ActorsTemplate {

    //TODO make two mem logos generator

    private float verticalSpeed;
    private int difficulty;//depends on level
    public TwoChairsGameMainActor(TextureRegion texture) {
        super(texture);
        verticalSpeed = 2f;
        difficulty = 1;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        Color color = getColor();
        sprite.setColor(color.r, color.g, color.b, color.a * parentAlpha);//this line changing sprite color6 when fadeout
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        setY(getY() - verticalSpeed);//moving
    }

    public float getVerticalSpeed() {
        return verticalSpeed;
    }

    public void setVerticalSpeed(float verticalSpeed) {
        this.verticalSpeed = verticalSpeed;
    }

    public int getDifficulty() {
        return difficulty;
    }

    //changing difficulty and the speed depends on difficulty
    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
        verticalSpeed *= difficulty;
    }
}
