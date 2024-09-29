package com.unkowngame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Player {

    int x, y; // координаты квадрата

    public void draw(OrthographicCamera camera, ShapeRenderer shapeRenderer){ // отрисовка
        // Обновляем позицию камеры, чтобы она следовала за квадратом
        camera.position.set(x, y, 0);
        camera.update();

        // Применяем камеру для рендера
        shapeRenderer.setProjectionMatrix(camera.combined);

        shapeRenderer.setColor(1, 1, 1, 1);
        shapeRenderer.rect(x, y, 50, 50);
    }

    public void update(){ // обновление, проверка всего
        controls();
    }

    public void controls(){ // управление

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
    }
}
