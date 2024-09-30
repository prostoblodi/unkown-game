package com.unkowngame;

import com.badlogic.gdx.math.Rectangle;

public class Bullet {

    float speedX, speedY, x, y; // присвоение координат и скорость пули

    Rectangle hitbox = new Rectangle(x,y,25,25);


    public Bullet(float speedX, float speedY){
        this.speedX = speedX;
        this.speedY = speedY;
    } // класс конструктор

    public void update(Rectangle enemyHitbox){
        x += speedX;
        y += speedY;
    } // обновление пули
}
