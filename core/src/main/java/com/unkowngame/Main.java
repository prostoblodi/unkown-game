package com.unkowngame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Cursor;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.GL20;

import java.util.ArrayList;

public class Main extends ApplicationAdapter {

    ShapeRenderer shapeRenderer; // класс(переменная) для создания банальных фигур
    OrthographicCamera camera; // камера

    int x, y; // координаты квадрата

    Player player = new Player(); // добавление игрока

    static ArrayList<Bullet> bullets = new ArrayList<>();

    @Override
    public void create() { // класс, который срабатывает при старте игры только один раз
        shapeRenderer = new ShapeRenderer(); //создание рендера базовых фигур

        // Инициализируем камеру
        camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        camera.position.set(x, y, 0);  // Устанавливаем позицию камеры на начальное положение квадрата
        camera.update();

        //присвоение базовых координат
        x = 0;
        y = 0;

        Gdx.graphics.setSystemCursor(Cursor.SystemCursor.Crosshair); // курсор другой
    }

    @Override
    public void render() { // класс, который обновляется каждый кадр

        Gdx.gl.glClearColor(0, 0, 0, 1); // цвет, которым будет очищатся экран
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT); // очистка экрана

        player.update(camera); // обновление игрока

        bulletAndEnemyUpdate();

        // Начинаем отрисовку
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);  // Используем заполненный тип для заливки квадрата
        player.draw(camera, shapeRenderer); // отрисовка игрока
        shapeRenderer.end();
        // Заканчиваем отрисовку
    }

    public void bulletAndEnemyUpdate(){
        if (!bullets.isEmpty()) {
            for (Bullet bullet : new ArrayList<>(bullets)) { // обновление всех пуль

                bullet.update(shapeRenderer, player);

                if(!bullet.isActive()){
                    bullets.remove(bullet);
                    System.out.println("-> removed kaboom((");
                }
            }
        }
    }

    public static void createBullet(float speedX, float speedY, float startX, float startY){
        bullets.add(new Bullet(speedX, speedY, startX, startY));
    }

    public void createEnemies(){

    }

    @Override // хз, лучше не трогать
    public void dispose() { // класс для оптимизации(нужно точнее - спрашивать у чат гпт)
        shapeRenderer.dispose();
    }

}
