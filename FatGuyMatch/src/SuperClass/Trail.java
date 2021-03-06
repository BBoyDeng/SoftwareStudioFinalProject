package SuperClass;

import Client.Client;
import processing.core.PApplet;
import processing.core.PImage;

public class Trail extends Skill {
	
	private int frame;
	private int CharacterID;
	//private PImage image;
	
	// Transperancy
	private float alpha = 255f;
	
	public Trail(int x, int y, int width, int height, Type type, boolean solid, Handler handler) {
		super(x, y, width, height, type, solid, handler);
	}

	public void display(PApplet parent) 
	{
		if(used == true)
		{
			//System.out.println("FIND unused");
			parent.tint(255, alpha);
			parent.image(Client.player[CharacterID][frame].getImage(), getX(), getY(), this.getWidth(), this.getHeight());
			parent.noTint();
		}
	}

	@Override
	public void update() 
	{
		
		if(used == true)
		{
			alpha = (alpha - 2.5f < 0.0f) ? 0.0f : alpha - 2.5f; // If alpha < 0 ----> error
			
			// Done ? 
			if(alpha <= 0.0f)
			{
				this.die();
			}
		}
	}
	
	public void setAlpha(float f){ this.alpha = f; }
	public void setFrame(int i){ this.frame = i; }
	public void setCharacterID(int characterID) {CharacterID = characterID;}
	//public void setImage(PImage p){ this.image = p; }
	
	public int getFrame() { return this.frame; }
	public float getAlpha() { return this.alpha; }
	public int getCharacterID() {return CharacterID; }


}
