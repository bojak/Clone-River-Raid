import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


class Posto extends Controle{
	
	private int posX, posY, largura, altura, colisao;
	private Image posto, explosaoPosto;
	private int coords[] = new int[4];
	
	Posto(int posY,int posX){
		super();
		this.colisao 	= 0;
		this.posX       = posX;
		this.posY       = posY;
		this.largura    = 30;
		this.altura     = 50;

		
		try{
			this.posto = ImageIO.read(new File("posto.png"));
			this.explosaoPosto = ImageIO.read(new File ("explosaoPosto.png"));
		} catch(IOException e){
			e.printStackTrace();
		} 
	}
	
	public void desenhaPosto(Graphics g){
		g.drawImage(this.posto, this.posX, this.posY, this.largura, this.altura, null);
	}
	
	public void desenhaPostoExplosao(Graphics g){
		g.drawImage(this.explosaoPosto, this.posX, this.posY, this.largura, this.altura, null);
		g.drawImage(this.explosaoPosto = null, this.posX, this.posY, this.largura, this.altura, null);
	}
	


	public void setPosy(int velocidade){
		this.posY += velocidade;
	}

	public int getColisao(){
		return this.colisao;
	}

	public void setColisao(int colidi){
		this.colisao = colidi;
	}

	
	
	public int[] obtemQuadrado(){
		coords[0] = this.posX;
		coords[1] = this.posX + this.largura;
		coords[2] = this.posY;
		coords[3] = this.posY + this.altura;
		
		return coords;
	}
	
	public  boolean detectaColisao(int coords[]){
		this.obtemQuadrado();
		int x1 = this.coords[0];
		int x2 = this.coords[1];
		int y1 = this.coords[2];
		int y2 = this.coords[3];
		
		int x1b = coords[0];
		int x2b = coords[1];
		int y1b = coords[2];
		int y2b = coords[3];
		
		if(x2 >= x1b && x1 <= x2b && y2 >= y1b && y1 <= y2b)
			return true;
		else
			return false;
	
    }

}