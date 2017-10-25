package ru.romansluckycorp.hsemem.actors;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import ru.romansluckycorp.hsemem.utils.ActorsTemplate;

/**
 * Created by romananchugov on 24.10.2017.
 */

public class HseMemLogoActor extends ActorsTemplate {

    private float rotationSpeed = 5;
    private float horizontalSpeed = 1;
    public HseMemLogoActor(TextureRegion texture) {
        super(texture);
        setSize(64f, 64f);
        sprite.setOrigin(getWidth() / 2, getHeight() / 2);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
    }

    @Override
    public void act(float delta) {
        super.act(delta);

        sprite.rotate(-rotationSpeed);
        setPosition(getX() + horizontalSpeed, getY());

    }

    public float getRotationSpeed() {
        return rotationSpeed;
    }

    public void setRotationSpeed(float rotationSpeed) {
        this.rotationSpeed = rotationSpeed;
    }
}
