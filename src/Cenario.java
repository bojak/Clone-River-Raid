import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


class Cenario {
	private int velocidade,largura, altura, posX, posY;
	private Image cenario;
	
	Cenario(){
		this.posX = 0;
		this.posY = -18520;
		this.largura = 640;
		this.altura = 20000;
		this.velocidade = 2;
		try{
			this.cenario = ImageIO.read(new File("cenario.png"));
		} catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public void desenha_cenario(Graphics d){
		d.drawImage(this.cenario, this.posX, this.posY, this.largura, this.altura, null);
	}
	
	public void moverCenario(){
		 this.velocidade = 2;
		 this.posY += this.velocidade;
	}
	
	public void moverCenario3x(){
		 this.velocidade = 3;
		 this.posY += this.velocidade;
	}
	
	public void moverCenario1x(){
		 this.velocidade = 1;
		 this.posY += this.velocidade;
	}
	
	public int getVelocidade(){
		return this.velocidade;
	}
	
	public int getPosx(){
		return this.posX;
	}
	
	public int getPosy(){
		return this.posY;
	}
	
	public void setPosy(int pos){
		this.posY = pos;
	}


}	
