package com.unkowngame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

import java.util.Random;

public class Player {

    int x, y; // координаты игрока
    private float timeSinceLastShot = 0f;  // Timer to track reload

    Rectangle hitbox = new Rectangle(x, y, 50, 50);
    Random random = new Random();

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

    public void update(OrthographicCamera camera, float deltaTime){
        controls(camera, deltaTime);
        hitbox.x = x;
        hitbox.y = y;
    } // обновление всех вычислений

    public int getX(){
        return x;
    } // узнать x игрока
    public int getY(){
        return y;
    } // узнать y игрока

    public void controls(OrthographicCamera camera, float deltaTime) {
        // Reset movement delta
        int deltaX = 0;
        int deltaY = 0;

        // Check for movement keys
        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            deltaY++;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            deltaY--;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            deltaX--;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            deltaX++;
        }

        // Update position
        x += deltaX;
        y += deltaY;

        // Update time since last shot
        // Time in seconds for reloading (adjust as needed)
        float reloadTime = random.nextFloat(1.5F, 2);
        if (timeSinceLastShot < reloadTime) {
            timeSinceLastShot += deltaTime;
        }

        // Check for left mouse button click and if weapon has reloaded
        if (Gdx.input.isButtonPressed(Input.Buttons.LEFT) && timeSinceLastShot >= reloadTime) {
            shot(camera);  // Fire the shot
            timeSinceLastShot = 0;  // Reset the reload timer after shooting
            System.out.println("*-> Fire! Reload time is: " + reloadTime);
        }
    } // контроль

    public void shot(OrthographicCamera camera) {
        // Получаем координаты курсора в мировых координатах
        Vector3 target = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
        camera.unproject(target);  // Преобразование в мировые координаты

        // Координаты игрока
        int playerX = getX();
        int playerY = getY();

        // Вычисляем разницу между курсором и игроком
        int deltaX = (int) (target.x - playerX);
        int deltaY = (int) (target.y - playerY);

        // Рассчитываем дистанцию
        float distance = (float) Math.sqrt(deltaX * deltaX + deltaY * deltaY);

        // Скорость пули
        int speed = 12; // Можно увеличить для скорости

        // Вычисляем компоненты скорости
        float speedX = deltaX / distance * speed;
        float speedY = deltaY / distance * speed;

        // Создаём пулю с вычисленной скоростью
        Main.createBullet(speedX, speedY, playerX, playerY);

        System.out.printf("|-> I want target kaboom: \n L targetX: %f, targetY: %f, playerX: %d, playerY: %d, distance: %f \n", target.x, target.y, playerX, playerY, distance);
    }// выстрел
}
