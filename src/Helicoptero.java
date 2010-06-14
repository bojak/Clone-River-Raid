import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


class Helicoptero extends Inimigo { 
	
	private Image HeliDireita0,HeliEsquerda0,ExplosaoHeli;
		
		Helicoptero(int posY, int posX, int velocidade){
			super();
			this.posX                   = posX;
			this.posY 					= posY;
			this.largura 				= 45;
			this.altura 				= 20;
			this.velocidade			    = velocidade;
			this.flag					= 0;
			try{
				this.HeliEsquerda0 = ImageIO.read(new File("HeliDireita0.png"));
				this.HeliDireita0 = ImageIO.read(new File("HeliEsquerda0.png"));
				this.ExplosaoHeli = ImageIO.read(new File("explosaoHelicopteroAviao.png"));
			} catch(IOException e){
				e.printStackTrace();
			}
		}

		
		public void desenha_Dir(Graphics d){
			d.drawImage(this.HeliDireita0, this.posX, this.posY, this.largura, this.altura, null);
		}

		public void desenha_Esq(Graphics d){
			d.drawImage(this.HeliEsquerda0, this.posX, this.posY, this.largura, this.altura, null);
		}
		
		public void desenha_Explosao(Graphics d){
			d.drawImage(this.ExplosaoHeli, this.posX, this.posY, this.largura, this.altura, null);
			d.drawImage(this.ExplosaoHeli = null, this.posX, this.posY, this.largura, this.altura, null);
		}
}
