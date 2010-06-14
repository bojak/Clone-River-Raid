import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

class Barco extends Inimigo{
	
	private Image barcoDireita, barcoEsquerda, explosaoBarco;
	
		Barco(int posY, int posX, int velocidade){
			super();
			this.posX              = posX;
			this.posY              = posY;
			this.largura		   = 70;
			this.altura			   = 30; 
			this.velocidade        = velocidade;
			try{
				this.barcoEsquerda = ImageIO.read(new File("BarcoDireita.png"));
				this.barcoDireita = ImageIO.read(new File("BarcoEsquerda.png"));
				this.explosaoBarco = ImageIO.read(new File("explosaoPonte.png"));
			} catch(IOException e){
				e.printStackTrace();
			}
		}

		
		public void desenha_Dir(Graphics d){
			d.drawImage(this.barcoDireita, this.posX, this.posY, this.largura, this.altura, null);
		}

		public void desenha_Esq(Graphics d){
			d.drawImage(this.barcoEsquerda, this.posX, this.posY, this.largura, this.altura, null);
		}
		
		public void desenha_Explosao(Graphics d){
			d.drawImage(this.explosaoBarco, this.posX, this.posY, this.largura, this.altura, null);
			d.drawImage(this.explosaoBarco = null, this.posX, this.posY, this.largura, this.altura, null);
		}
}
