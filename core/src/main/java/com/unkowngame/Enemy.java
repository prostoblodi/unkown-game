package com.unkowngame;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;

public class Enemy {

    float x, y;
    Rectangle hitbox = new Rectangle(x, y, 50, 50); // создание хитбокса

    public Enemy(float x, float y){
        this.x = x;
        this.y = y;
    }

    public void draw(ShapeRenderer shapeRenderer){
        shapeRenderer.setColor(1, 0, 0, 1);
        shapeRenderer.rect(x, y, 50, 50);
    } // отрисовка врага
    public Rectangle getHitbox() {
        return hitbox;
    } // возвращает хитбокс
}
