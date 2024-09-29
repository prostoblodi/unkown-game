package com.unkowngame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Cursor;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.GL20;

public class Main extends ApplicationAdapter {

    ShapeRenderer shapeRenderer; // класс(переменная) для создания банальных фигур
    OrthographicCamera camera; // камера

    int x, y; // координаты квадрата

    Player player = new Player();

    @Override
    public void create() {
        shapeRenderer = new ShapeRenderer(); //создание рендера базовых фигур

        // Инициализируем камеру
        camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        camera.position.set(x, y, 0);  // Устанавливаем позицию камеры на начальное положение квадрата
        camera.update();

        //присвоение базовых координат
        x = 100;
        y = 100;

        Gdx.graphics.setSystemCursor(Cursor.SystemCursor.Crosshair); // курсор другой
    }

    @Override
    public void render() { // класс рендера
        // очистка экрана
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // Начинаем отрисовку
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);  // Используем заполненный тип для заливки квадрата

        player.update();
        player.draw(camera, shapeRenderer);

        shapeRenderer.setColor(1, 0, 0, 1);
        shapeRenderer.rect(200, 200, 50, 50);

        // Заканчиваем отрисовку
        shapeRenderer.end();
    }

    @Override //велики код
    public void dispose() { // класс для оптимизации(нужно точнее - спрашивать у чат гпт)
        shapeRenderer.dispose();
    }


}
