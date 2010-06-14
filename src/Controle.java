import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


class Controle {
	
	protected int posX, posY, largura, altura, pontos;
	private Image placar, placar_inicio, placar_game_over, placar_finaliza;

	Controle(){
		this.pontos		= 0;
		this.posX 		= 0;
		this.posY 		= 380;
		this.largura 	= 640;
		this.altura 	= 100;

		try{
			this.placar = ImageIO.read(new File("placar.png"));
			this.placar_inicio = ImageIO.read(new File("placar_inicio_jogo.png"));
			this.placar_finaliza = ImageIO.read(new File("placar_finaliza.png"));
			this.placar_game_over = ImageIO.read(new File("placar_game_over.png"));
		} catch(IOException e){
			e.printStackTrace();
		}
	}
	
	
	public void desenha_placar (Graphics d){
		d.drawImage(this.placar, this.posX, this.posY, this.largura, this.altura, null);		
	}
	
	public void desenha_placar_finaliza (Graphics d){
		d.drawImage(this.placar_finaliza, this.posX, this.posY, this.largura, this.altura, null);		
	}
	
	public void desenha_placar_game_over (Graphics d){
		d.drawImage(this.placar_game_over, this.posX, this.posY, this.largura, this.altura, null);		
	}
	
	public void desenha_placar_inicio (Graphics d){
		d.drawImage(this.placar_inicio, this.posX, this.posY, this.largura, this.altura, null);		
	}
	
}
