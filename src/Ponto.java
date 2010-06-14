import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;


class Ponto extends Controle {
	private Color cor;
	private int ponto;
	private Font font;
	
	Ponto(){
		super();
		this.ponto 		= 0;
		this.posX 		= 100;
		this.posY		= 450;
		this.cor        = new Color(0,0,0);
		this.font = new Font("arial,", 1, 20);
	}
	
	public void desenha_ponto(Graphics d){
		d.setColor(this.cor);
	    d.setFont(this.font);	
		d.drawString(Integer.toString(this.ponto), this.posX, this.posY);
	}
	
	public void aumentaPonto(int ponto){
		   this.ponto += ponto;
	}
	

}
