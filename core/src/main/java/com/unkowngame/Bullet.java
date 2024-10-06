package com.unkowngame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;

public class Bullet {

    float speedX, speedY; // скорость пули
    float x, y; // координаты пули
    float windowWidth = Gdx.graphics.getWidth(); // ширина окна
    float windowHeight = Gdx.graphics.getHeight(); // высота окна
    float leftBorder, bottomBorder; // левая, нижняя границы
    float rightBorder, topBorder; // правая, верхняя границы

    boolean isActive = true; // активна ли пуля

    Rectangle hitbox = new Rectangle(x,y,25,25); // хитбокс


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

        leftBorder = (player.x - (windowWidth / 2));
        bottomBorder = (player.y - (windowHeight / 2));

        rightBorder = (player.x + (windowWidth / 2));
        topBorder = (player.y + (windowHeight / 2));

        draw(shaperenderer);

        if (x < leftBorder || x > rightBorder || y < bottomBorder || y > topBorder) { // условие фиксить нада
            isActive = false;
            System.out.printf("|-> Bullet removed! \n L x: %f, y: %f -- leftBorder: %f, bottomBorder: %f -- rightBorder: %f, topBorder: %f \n",
            x, y, leftBorder, bottomBorder, rightBorder, topBorder);
        } // если пуля не там, где надо - удалить


    } // обновление пули

    public void draw(ShapeRenderer shaperenderer){
        shaperenderer.begin(ShapeRenderer.ShapeType.Filled);

        shaperenderer.setColor(0, 1, 0, 1);
        shaperenderer.rect(x, y, 25, 25);

        shaperenderer.end();
    }
}
