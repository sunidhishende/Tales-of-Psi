package com.sunidhishende.game.Sprites;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.EdgeShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;
import com.sunidhishende.game.MprGame;
import com.sunidhishende.game.Scenes.Hud;
import com.sunidhishende.game.Screens.PlayScreen;

public class Character extends Sprite {
    public World world;
    public Body b2body;
    private boolean  characterIsDead=false;
    private TextureRegion charStand;

    public Character(World world, PlayScreen screen){
        super(screen.getAtlas().findRegion("mpr"));
        this.world=world;
        defineCharacter();
        charStand= new TextureRegion(getTexture(), 0, 0, 16, 16);
        setBounds(0,0,20/ MprGame.PPM, 20/MprGame.PPM);
        setRegion(charStand);

    }

    public void defineCharacter(){
        BodyDef bdef= new BodyDef();
        bdef.position.set(32/ MprGame.PPM,32/MprGame.PPM);
        bdef.type= BodyDef.BodyType.DynamicBody;
        b2body= world.createBody(bdef);

        FixtureDef fdef= new FixtureDef();
        CircleShape shape= new CircleShape();
        shape.setRadius(7/MprGame.PPM);
        fdef.filter.categoryBits=MprGame.CHARACTER_BIT;
        fdef.filter.maskBits= MprGame.DEFAULT|MprGame.PROPERTIES_BIT|MprGame.BRICK_BIT;
        fdef.shape= shape;
        fdef.friction= 300/MprGame.PPM;
        b2body.createFixture(fdef);

        EdgeShape head= new EdgeShape();
        head.set(new Vector2(-2/MprGame.PPM, 7/MprGame.PPM), new Vector2(2/MprGame.PPM, 7/MprGame.PPM));
        fdef.shape=head;
        fdef.isSensor=true;
        b2body.createFixture(fdef).setUserData("head");
    }

    public void update(float dt){
        setPosition(b2body.getPosition().x-getWidth()/2,b2body.getPosition().y-getHeight()/2);
        if (b2body.getPosition().y<0/MprGame.PPM|| Hud.gethealth()<=0)
        {
            characterIsDead=true;
        }


    }

    public void jump(){
        b2body.applyLinearImpulse(new Vector2(0, 4.6f), b2body.getWorldCenter(), true);
    }

    public boolean isDead()
    {
        return characterIsDead;
    }


}
