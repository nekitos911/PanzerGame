package ru.panzergame.sprites;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;
import ru.panzergame.Constant;

public class Animation {
    public Array<TextureRegion> framesUp,framesDown,framesLeft,framesRight;
    private float maxFrameTime;
    private float currentFrameTime;
    private int frameCount;
    private int currentFrame;
    private boolean isUp,isDown,isLeft,isRight;

    public Animation(TextureRegion region,int frameCount,float cycleTime) {
        //framesUp = new Array<TextureRegion>();
        //framesDown = new Array<TextureRegion>();
        //framesLeft = new Array<TextureRegion>();
        framesRight = new Array<TextureRegion>();
        int frameWidth = region.getRegionWidth() / frameCount;
        for (int i = 0; i < frameCount; i++) {
            framesRight.add(new TextureRegion(region,i * frameWidth,0,frameWidth,region.getRegionHeight()));
        }
        this.frameCount = frameCount;
        maxFrameTime = cycleTime / frameCount;
        currentFrame = 0;
    }

    public void update(float dt) {
        currentFrame += dt;
        if(currentFrameTime > maxFrameTime) {
            currentFrame++;
            currentFrameTime = 0;
        }
        if(currentFrame >= frameCount) currentFrame = 0;
    }

    public TextureRegion getCurrentFrame() {
        return framesRight.get(currentFrame);
    }
}
