import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

class Aviao extends Inimigo{
	
	private Image aviaoDireita, aviaoEsquerda, explosaoAviao;
	

	
	public Aviao(int posY, int posX, int velocidade, int DirOrEsq){
		super();
		this.posX       	  = posX;
		this.posY       	  = posY;
		this.velocidade       = velocidade;
		this.largura    	  = 40;
		this.altura      	  = 20;
		this.flag			  = DirOrEsq;
		try{
			this.aviaoEsquerda = ImageIO.read(new File("AviaoEsquerda.png"));
			this.aviaoDireita = ImageIO.read(new File("AviaoDireita.png"));
			this.explosaoAviao = ImageIO.read(new File("explosaoHelicopteroAviao.png"));
		} catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public void desenha_Dir(Graphics d){
		d.drawImage(this.aviaoDireita, this.posX, this.posY, this.largura, this.altura, null);
	}

	public void desenha_Esq(Graphics d){
		d.drawImage(this.aviaoEsquerda, this.posX, this.posY, this.largura, this.altura, null);
	}

	public void desenha_Explosao(Graphics d){
		d.drawImage(this.explosaoAviao, this.posX, this.posY, this.largura, this.altura, null);
		d.drawImage(this.explosaoAviao = null, this.posX, this.posY, this.largura, this.altura, null);
	}
	

	
}
