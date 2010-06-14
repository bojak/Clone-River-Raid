import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


class PlayerAviao {
	private int velocidade,combustivel, diametro, posX, posY, vida;
	private Image aviao, aviao_esq, aviao_dir, aviao_explode;
	private int coords[] = new int[4];
	
	PlayerAviao(){
		this.posX = 320;
		this.posY = 320;
		this.diametro = 35;
		this.velocidade = 2;
		this.combustivel = 90;
		this.vida		= 3;
		coords[0] = this.posX;
		coords[1] = this.posX + this.diametro;
		coords[2] = this.posY;
		coords[3] = this.posY + this.diametro;
		try{
			this.aviao = ImageIO.read(new File("aviao.png"));
			this.aviao_esq = ImageIO.read(new File("aviao_esq.png"));
			this.aviao_dir = ImageIO.read(new File("aviao_dir.png"));
			this.aviao_explode = ImageIO.read(new File("explosaoHelicopteroAviao.png"));
		} catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public void desenha_aviao(Graphics d){
		d.drawImage(this.aviao, this.posX, this.posY, this.diametro, this.diametro, null);
	}
	
	public void desenha_aviao_dir(Graphics d){
		d.drawImage(this.aviao_dir, this.posX, this.posY, this.diametro, this.diametro, null);
	}

	public void desenha_aviao_esq(Graphics d){
		d.drawImage(this.aviao_esq, this.posX, this.posY, this.diametro, this.diametro, null);
	}

	public void desenha_aviao_explosao(Graphics d){
		d.drawImage(this.aviao_explode, this.posX, this.posY, this.diametro, this.diametro, null);
	}
	
	public void moverDir(){
		this.posX += this.velocidade;
	}
	
	public void moverEsq(){
		this.posX -= this.velocidade;
	}
	
	public void getVida(int vida){
		this.vida -= 1;
	}
	public int posBala(){
		int coord[];
		coord = this.obtemQuadrado();
		return ((int)(this.diametro / 2) + coord[0]) -1;
	}
	
	
	public void diminuirCombustivel(){
		this.combustivel -= 1;
	}
	
	public void aumentarCombustivel(){
		if(this.combustivel < 90){
			this.combustivel += 1;
		}
		
	}
	
	public int getCombustivel(){
		return this.combustivel;
	}
	
	public int[] obtemQuadrado(){
		coords[0] = this.posX;
		coords[1] = this.posX + this.diametro;
		coords[2] = this.posY;
		coords[3] = this.posY + this.diametro;
		
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
