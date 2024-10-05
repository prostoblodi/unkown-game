package com.unkowngame;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;

public class Enemy {

    float x, y;
    boolean isActive = true;

    Rectangle hitbox; // создание хитбокса

    public Enemy(float x, float y){
        this.x = x;
        this.y = y;

        hitbox = new Rectangle(x, y, 50, 50);
    } // класс-конструктор

    public void draw(ShapeRenderer shapeRenderer){
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);

        shapeRenderer.setColor(1, 0, 0, 1);
        shapeRenderer.rect(x, y, 50, 50);

        shapeRenderer.end();
    } // отрисовка врага
}
