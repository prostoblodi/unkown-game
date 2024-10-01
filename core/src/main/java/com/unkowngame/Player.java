package com.unkowngame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;

public class Player {

    int x, y; // координаты игрока

    Rectangle hitbox = new Rectangle(x, y, 50, 50);

    public void draw(OrthographicCamera camera, ShapeRenderer shapeRenderer){
        // обновление камеры
        camera.position.set(x, y, 0);
        camera.update();

        // сомещение рендерера и камеры
        shapeRenderer.setProjectionMatrix(camera.combined);

        // создание квадрата и заполнение его цветом
        shapeRenderer.setColor(1, 1, 1, 1);
        shapeRenderer.rect(x, y, 50, 50);
    } // отрисковка

    public void update(){
        controls();
        hitbox.x = x;
        hitbox.y = y;
    } // обновление всех вычислений

    public int getX(){
        return x;
    } // узнать x игрока
    public int getY(){
        return y;
    } // узнать y игрока

    public void controls(){

        // Проверяем нажатие W и D для движения по диагонали вверх-вправо
        if (Gdx.input.isKeyPressed(Input.Keys.W) && Gdx.input.isKeyPressed(Input.Keys.D)) {
            y ++;
            x ++;
        }
        // Проверяем нажатие W и A для движения по диагонали вверх-влево
        else if (Gdx.input.isKeyPressed(Input.Keys.W) && Gdx.input.isKeyPressed(Input.Keys.A)) {
            y ++;
            x --;
        }
        // Проверяем нажатие S и D для движения по диагонали вниз-вправо
        else if (Gdx.input.isKeyPressed(Input.Keys.S) && Gdx.input.isKeyPressed(Input.Keys.D)) {
            y --;
            x ++;
        }
        // Проверяем нажатие S и A для движения по диагонали вниз-влево
        else if (Gdx.input.isKeyPressed(Input.Keys.S) && Gdx.input.isKeyPressed(Input.Keys.A)) {
            y --;
            x --;
        }
        // Движение строго вверх (W)
        else if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            y ++;
        }
        // Движение строго вниз (S)
        else if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            y --;
        }
        // Движение строго влево (A)
        else if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            x --;
        }
        // Движение строго вправо (D)
        else if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            x ++;
        }
        // Нажата ли ЛКМ
        else if (Gdx.input.isButtonPressed(Input.Buttons.LEFT)){
           shot();
        }
    } // управление
    public void shot(){
        int targetX = Gdx.input.getX();
        int targetY = Gdx.input.getY();

        int playerX = getX();
        int playerY = getY();

        int deltaX = targetX - playerX;
        int deltaY = targetY - playerY;

        float distance = (float) Math.sqrt(deltaX * deltaX + deltaY * deltaY);

        int speed = 200; // Bullet speed

        float speedX = deltaX / distance * speed;
        float speedY = deltaY / distance * speed;

        Main.createBullet(speedX, speedY, playerX, playerY);
    } // выстрел
}
