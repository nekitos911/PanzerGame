package ru.panzergame.states;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import ru.panzergame.Constant;
import ru.panzergame.sprites.Player;

public class PlayState extends State {
    private Player player;
    private Texture background;

    protected PlayState(GameStateManager gsm) {
        super(gsm);
        player = new Player("player1",50,50);
    }

    @Override
    public void handleInput() {
    }

    @Override
    public void update(float dt) {
        player.update(dt);
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.begin();
        batch.draw(player.getPlayerTexture(),player.getPos().x,player.getPos().y);
        batch.end();
    }

    @Override
    public void dispose() {
        player.dispose();
    }
}
