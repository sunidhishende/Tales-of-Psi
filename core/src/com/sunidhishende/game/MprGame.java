package com.sunidhishende.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.sunidhishende.game.Screens.PlayScreen;

public class MprGame extends Game {
	public static final int V_WIDTH=400;
	public static final int V_HEIGHT=208;
	public SpriteBatch batch;
	public static final float PPM= 100;
	public static final short DEFAULT=1;
	public static final short CHARACTER_BIT=2;
	public static final short BRICK_BIT=4;
	public static final short PROPERTIES_BIT=4;
	public static final short MCQ_BIT=4;
	public static final short DESTROYED_BIT=16;


	
	@Override
	public void create () {
		batch = new SpriteBatch();
		setScreen(new PlayScreen(this));
	}

	@Override
	public void render () {
		super.render();
	}
	

}