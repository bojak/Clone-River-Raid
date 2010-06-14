import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;


class Vidas {
	
	protected int vida, posX, posY;
	Color cor;
	private Font font;
	
	Vidas(){
		this.posX  = 180;
		this.posY  = 420;
		this.vida  = 3;
		this.cor   = new Color(100,0,0);
		this.font = new Font("arial,", 1, 20);
	}
	
	public void desenhaVida(Graphics g){
		g.setColor(this.cor);
		g.setFont(this.font);
		g.drawString(Integer.toString(this.vida), this.posX, this.posY);
	}
	
	public void diminuiVida(){
		this.vida -= 1;
	}
}
