package com.unkowngame;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;

public class Bullet {

    float speedX, speedY; // скорость пули
    float x, y; // координаты пули

    boolean isActive; // активна ли пуля

    Rectangle hitbox = new Rectangle(x,y,25,25);


    public Bullet(float speedX, float speedY, float startX, float startY){ // класс, который вызывается при создании пули один раз(я надеюсь)

        this.speedX = speedX;
        this.speedY = speedY;

        this.x = startX;
        this.y = startY;

    } // класс конструктор

    public void update(Rectangle enemyHitbox, ShapeRenderer shaperenderer){
        x += speedX;
        y += speedY;

        draw(shaperenderer);

        if(hitbox.overlaps(enemyHitbox)){
            isActive = false;
        }

    } // обновление пули

    public void draw(ShapeRenderer shaperenderer){
        shaperenderer.setColor(0, 1, 0, 1);
        shaperenderer.rect(x, y, 25, 25);
    }

    public boolean isActive() {
        return isActive;
    } // активна ли пуля

}
