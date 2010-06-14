import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


class Ponte {
	
	private Image ponte, explodePonte;
	private int posX, posY, largura, altura, flagExplode;
	
	
	Ponte(int y, int x, int largura){

		this.posX                   = x;
		this.posY 					= y;
		this.largura 				= largura;
		this.altura 				= 60;
		this.flagExplode			= 0;
		try{
			this.ponte = ImageIO.read(new File("ponte.png"));
			this.explodePonte = ImageIO.read(new File("explosaoPonte.png"));
		} catch(IOException e){
			e.printStackTrace();
		}
	}

	
	public void desenha_Ponte(Graphics d){
		d.drawImage(this.ponte, this.posX, this.posY, this.largura, this.altura, null);
	}

	public void desenha_ExplodePonte(Graphics d){
		d.drawImage(this.explodePonte, this.posX, this.posY, this.largura, this.altura, null);
		d.drawImage(this.explodePonte = null, this.posX, this.posY, this.largura, this.altura, null);
	}
	
	public int[] getCoords(){
		int coords[] = new int[4];
		coords[0] = this.posX;
		coords[2] = this.posY;
		coords[1] = this.posX + this.largura;
		coords[3] = this.posY + this.altura;
		
		return coords;
	}
	
	public void moverPonte(int velocidade){
		this.posY += velocidade;
	}
	
	public int getFlagExplode(){
		return this.flagExplode;
	}
	
	public void setFlagExplode(int flag){
		this.flagExplode = flag;
	}
	
	public void setPosy(int pos){
		this.posY = pos;
	}

}
