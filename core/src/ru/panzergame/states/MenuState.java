package ru.panzergame.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;


import ru.panzergame.Constant;

public class MenuState extends State {
    private enum STATE {PLAYING, ISWAITING, GAME_OVER}

    private Texture background;  //background img;
    private int buttonNumber;
    private Texture[] buttons;
    private ShapeRenderer rectangle;

    public MenuState(GameStateManager gsm) {
        super(gsm);
        buttonNumber = 0;
        rectangle = new ShapeRenderer();
        buttons = new Texture[2];
        buttons[0] = new Texture(Gdx.files.internal("playgame.png"));
        background = new Texture(Gdx.files.internal("i_background.jpg"));
        buttons[1] = new Texture(Gdx.files.internal("exit.png"));
    }

    @Override
    public void handleInput() {
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            if (buttonNumber != 1) {
                buttonNumber++;
            } else {
                buttonNumber = 1;
            }
        }
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            if (buttonNumber != 0) {
                buttonNumber--;
            } else {
                buttonNumber = 0;
            }
        }

        switch (buttonNumber) {
            case 0:
                if (Gdx.input.isKeyPressed(Input.Keys.ENTER))
                gsm.set(new PlayState(gsm));
                    break;
            case 1:
                if (Gdx.input.isKeyPressed(Input.Keys.ENTER))
//                leaveGame();
                    break;
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.begin();
        batch.draw(background, 0, 0);
        for (int i = 0; i < buttons.length; i++) {
            batch.draw(buttons[i], Constant.WIDTH / 2 - buttons[i].getWidth() / 2, Constant.HEIGHT / 2 - buttons[i].getHeight() / 2 - i * Constant.MENU_BOTTON_OFFSET_Y);
        }
        batch.end();
        drawRectangle();
    }

    private void drawRectangle() {
        rectangle.begin(ShapeRenderer.ShapeType.Line);
        rectangle.setColor(0, 0, 0, 1);
        rectangle.rect(Constant.WIDTH / 2 - buttons[buttonNumber].getWidth() / 2 - Constant.MENU_RECTANGLE_OFFSET, Constant.HEIGHT / 2 - buttons[buttonNumber].getHeight() / 2 - Constant.MENU_RECTANGLE_OFFSET - buttonNumber * Constant.MENU_BOTTON_OFFSET_Y, buttons[buttonNumber].getWidth() + Constant.MENU_RECTANGLE_OFFSET * 2, buttons[buttonNumber].getHeight() + Constant.MENU_RECTANGLE_OFFSET * 2);
        rectangle.end();
    }


    @Override
    public void dispose() {
        background.dispose();
    }

    private STATE state = STATE.PLAYING;
}
