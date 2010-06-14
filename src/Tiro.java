import java.awt.Color;
import java.awt.Graphics;


class Tiro {
	private int velocidade, altura, largura, posX, posY, tiro_off;
	private Color cor;
	private int coords[] = new int[4];
	
	Tiro(int posPlayer){
		this.tiro_off = 0;
		this.posX = posPlayer;
		this.posY = 322;
		this.altura = 10;
		this.largura = 4;
		this.velocidade = 10;
		this.cor = new Color(232,232,074);
		coords[0] = this.posX;
		coords[1] = this.posX + this.largura;
		coords[2] = this.posY;
		coords[3] = this.posY + this.altura;
	}
	
	
	public void moverCima(){
		this.posY -= this.velocidade;
	}
	
	public void setPosx(int pos){
		this.posX = pos;
	}
	
	public int getPosy(){
		return this.posY;
	}
	
	public void setPosy(int pos){
		this.posY = pos;
	}
	
	public int gettiro_off(){
		return this.tiro_off;
	}
	
	public void settiro_off(int tiro){
		this.tiro_off = tiro;
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
	
	public void desenhar (Graphics pincel){
		pincel.setColor(this.cor);
		pincel.fillRect(this.posX, this.posY, this.largura, this.altura);
		
	}	
	
	

}
