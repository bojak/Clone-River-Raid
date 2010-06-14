import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


class Placar extends Controle{
	
	private Image Painel;
	
	Placar(){
		super();
		this.posX = 285;
		this.posY = 415;
		this.largura = 100;
		this.altura = 30;
		try{
			this.Painel = ImageIO.read(new File("combustivel.png"));
		} catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public void desenha_combustivel(Graphics d){
		d.drawImage(this.Painel, this.posX, this.posY, this.largura, this.altura, null);
	}
}
