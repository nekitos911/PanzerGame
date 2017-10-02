package ru.panzergame.sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import ru.panzergame.Constant;

public class Player implements Moveable {
    private Vector3 pos;
    private Vector3 velocity;
    private Rectangle bounds;
    private Texture playerTexture;
    private Animation playerAnimation;

    public Player(String name,int x,int y) {
        pos = new Vector3(x,0,0);
        velocity = new Vector3(0,0,0);
        playerTexture = new Texture("pla1.bmp");
        playerAnimation = new Animation(new TextureRegion(playerTexture),Constant.PLAYER_FRAMES_COUNT,5);
        bounds = new Rectangle(x,y,playerTexture.getWidth() / Constant.PLAYER_FRAMES_COUNT,playerTexture.getHeight());
    }

    private void handleInput() {
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            velocity.x = 1;
            velocity.y = 0;
        }
        else if(Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            velocity.x = -1;
            velocity.y = 0;
        }
        else if(Gdx.input.isKeyPressed(Input.Keys.UP)) {
            velocity.y = 1;
            velocity.x = 0;
        }
        else if(Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            velocity.y = -1;
            velocity.x = 0;
        }
        else {
            velocity.y = 0;
            velocity.x = 0;
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
        playerAnimation.update(dt);
        move();
        velocity.scl(1 / dt);
        bounds.setPosition(pos.x,pos.y);
    }

    @Override
    public void move() {
        pos.add(velocity.x,velocity.y,0);
    }

    @Override
    public void dispose() {
        playerTexture.dispose();
    }

    public Rectangle getBounds() {
        return bounds;
    }

    public Vector3 getPos() {
        return pos;
    }

    public TextureRegion getPlayerTexture() {
        return playerAnimation.getCurrentFrame();
    }
}
