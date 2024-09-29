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

    Player player = new Player(); // добавление игрока
    Enemy enemy = new Enemy(); // Добавление врага

    @Override
    public void create() { // класс, который срабатывает при старте игры только один раз
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
    public void render() { // класс, который обновляется каждый кадр

        Gdx.gl.glClearColor(0, 0, 0, 1); // цвет, которым будет очищатся экран
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT); // очистка экрана

        player.update(); // обновление игрока

        // Начинаем отрисовку
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);  // Используем заполненный тип для заливки квадрата

        player.draw(camera, shapeRenderer); // отрисовка игрока
        enemy.draw(shapeRenderer); // отрисовка врага

        shapeRenderer.end();
        // Заканчиваем отрисовку
    }

    @Override // хз, лучше не трогать
    public void dispose() { // класс для оптимизации(нужно точнее - спрашивать у чат гпт)
        shapeRenderer.dispose();
    }

}
