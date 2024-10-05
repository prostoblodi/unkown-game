package com.unkowngame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;

public class Bullet {

    float speedX, speedY; // скорость пули
    float x, y; // координаты пули
    float windowWidth = Gdx.graphics.getWidth();
    float windowHeight = Gdx.graphics.getHeight();

    boolean isActive = true; // активна ли пуля

    Rectangle hitbox = new Rectangle(x,y,25,25);


    public Bullet(float speedX, float speedY, float startX, float startY){ // класс, который вызывается при создании пули один раз(я надеюсь)

        this.speedX = speedX;
        this.speedY = speedY;

        this.x = startX;
        this.y = startY;

    } // класс конструктор

    public void update(ShapeRenderer shaperenderer, Player player){
        x += speedX;
        y += speedY;

        hitbox.x = x;
        hitbox.y = y;

        draw(shaperenderer);

        if (x < -windowWidth || x > windowWidth || y < -windowHeight || y > windowHeight) {
            isActive = false;
            System.out.println("KABOOM IS BAD!");
        }

    } // обновление пули

    public void draw(ShapeRenderer shaperenderer){
        shaperenderer.begin(ShapeRenderer.ShapeType.Filled);

        shaperenderer.setColor(0, 1, 0, 1);
        shaperenderer.rect(x, y, 25, 25);

        shaperenderer.end();
    }

    public boolean isActive() {
        return isActive;
    } // активна ли пуля

    public Rectangle getHitbox() {
        return hitbox;
    }
}
