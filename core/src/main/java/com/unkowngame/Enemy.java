package com.unkowngame;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;

public class Enemy {

    Rectangle hitbox = new Rectangle(200, 200, 50, 50);

    public void draw(ShapeRenderer shapeRenderer){
        shapeRenderer.setColor(1, 0, 0, 1);
        shapeRenderer.rect(200, 200, 50, 50);
    }

    public Rectangle getHitbox() {
        return hitbox;
    }
}
