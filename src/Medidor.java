import java.awt.Color;
import java.awt.Graphics;


class Medidor {
	Color cor;
	private int posX, posY, largura, altura;
	
	Medidor(){
		
		this.posX = 380;
		this.posY = 415;
		this.largura = 5;
		this.altura = 29;
		this.cor = new Color(232,232,074);

	}
	
	public void desenha_combustivel(Graphics d){
		d.setColor(this.cor);
		d.fillRect(this.posX, this.posY, this.largura, this.altura);
	}
	
	public void aumentaCombustivel(){
		if(this.posX < 380)
		   this.posX += 1;
	}
	
	public void diminuirCombustivel(){
		this.posX -= 1;
	}
}
