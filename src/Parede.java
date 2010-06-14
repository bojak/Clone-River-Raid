import java.awt.Color;
import java.awt.Graphics;


class Parede {
	
	int largura, altura, posX, posY;
	Color cor;
	
	Parede(int x,int y,int larg,int alt){
		this.posX    = x;
		this.posY    = y;
		this.largura = larg;
		this.altura  = alt;
		this.cor = new Color(110,156,66);
	}

	public void desenhaTela(Graphics x){
		x.setColor(this.cor);
		x.fillRect( this.posX, this.posY, this.largura, this.altura);		
	}
	
	public int[] getCoords(){
		int coords[] = new int[4];
		coords[0] = this.posX;
		coords[2] = this.posY;
		coords[1] = this.posX + this.largura;
		coords[3] = this.posY + this.altura;
		
		return coords;
	}
	
	public void setPosy(int velo){
		this.posY += velo;
	}
	
}
