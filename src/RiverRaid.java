import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class RiverRaid extends Frame implements WindowListener, Runnable,KeyListener {
	private int posX, posY, largura, altura, aumentar_combustivel,diminuir_combustivel, estado_atual = 1;
	private boolean explode_aviao, te, td, ta, tb, tiro = false, jogo = true, controle_vida = true, controle_inicio = false;
	private PlayerAviao aviao_player;
	private Cenario cenario;
	private Controle controle;
	private Medidor medidor;
	private Placar placar;
	private Tiro atira;
	private Helicoptero heli[];
	private Barco barco[];
	private Posto posto[];
	private Aviao aviao[];
	private Ponte ponte[];
	private Ponto ponto;
	private Vidas vida;
	private Parede parede[],ilha[];

	RiverRaid() {
		super("River Raid");
		this.vida = new Vidas();
	    this.ponto = new Ponto();
		check1();
		this.setBounds(this.posX, this.posY, this.largura, this.altura);
		this.setVisible(true);
	}
	
	public void inimigos(){
		this.heli = new Helicoptero[23];
		this.heli[0] = new Helicoptero(-50,50,2);
		this.heli[1] = new Helicoptero(-516,320,2);
		this.heli[2] = new Helicoptero(-723,300,2);
		this.heli[3] = new Helicoptero(-1845,400,2);
		this.heli[4] = new Helicoptero(-3318,150,2);
		this.heli[5] = new Helicoptero(-4290,320,2);
		this.heli[6] = new Helicoptero(-4857,300,2);
		this.heli[7] = new Helicoptero(-5997,495,2);
		this.heli[8] = new Helicoptero(-6426,135,2);
		this.heli[9] = new Helicoptero(-6699,495,2);
		this.heli[10] = new Helicoptero(-7530,250,2);
		this.heli[11] = new Helicoptero(-8454,280,2);
		this.heli[12] = new Helicoptero(-10242,200,2);
		this.heli[13] = new Helicoptero(-11070,320,2);
		this.heli[14] = new Helicoptero(-11565,400,2);
		this.heli[15] = new Helicoptero(-12588,150,2);
		this.heli[16] = new Helicoptero(-13050,150,2);
		this.heli[17] = new Helicoptero(-13314,150,2);
		this.heli[18] = new Helicoptero(-14622,400,2);
		this.heli[19] = new Helicoptero(-15699,300,2);
		this.heli[20] = new Helicoptero(-16731,300,2);
		this.heli[21] = new Helicoptero(-18081,364,2);
		this.heli[22] = new Helicoptero(-18160,180,2);
		
		this.barco = new Barco[28];
		this.barco[0] = new Barco(-882,400,2);
		this.barco[1] = new Barco(-1224,200,2);
		this.barco[2] = new Barco(-2253,350,2);
		this.barco[3] = new Barco(-2502,140,2);
		this.barco[4] = new Barco(-3162,140,2);
		this.barco[5] = new Barco(-3387,155,2);
		this.barco[6] = new Barco(-3603,250,2);
		this.barco[7] = new Barco(-3834,240,2);
		this.barco[8] = new Barco(-4497,280,2);
		this.barco[9] = new Barco(-4665,350,2);
		this.barco[10] = new Barco(-5355,108,2);
		this.barco[11] = new Barco(-5793,108,2);
		this.barco[12] = new Barco(-6912,108,2);
		this.barco[13] = new Barco(-7065,138,2);
		this.barco[14] = new Barco(-7845,180,2);
		this.barco[15] = new Barco(-8232,300,2);
		this.barco[16] = new Barco(-8727,350,2);
		this.barco[17] = new Barco(-8934,420,2);
		this.barco[18] = new Barco(-9299,250,2);
		this.barco[19] = new Barco(-9783,380,2);
		this.barco[20] = new Barco(-9999,410,2);
		this.barco[21] = new Barco(-10491,250,2);
		this.barco[22] = new Barco(-12351,120,2);
		this.barco[23] = new Barco(-12807,120,2);
		this.barco[24] = new Barco(-14376,300,2);
		this.barco[25] = new Barco(-15204,300,2);
		this.barco[26] = new Barco(-15477,310,2);
		this.barco[27] = new Barco(-17043,310,2);
		
		this.aviao = new Aviao[16];
		this.aviao[0] = new Aviao(-1602,-40,4,1);
		this.aviao[1] = new Aviao(-2640,650,4,0);
		this.aviao[2] = new Aviao(-3483,-40,4,1);
		this.aviao[3] = new Aviao(-5094,650,4,0);
		this.aviao[4] = new Aviao(-5232,-40,4,1);
		this.aviao[5] = new Aviao(-6174,650,4,0);
		this.aviao[6] = new Aviao(-8076,-40,4,1);
		this.aviao[7] = new Aviao(-9176,650,4,0);
		this.aviao[7] = new Aviao(-11805,-40,4,1);
		this.aviao[8] = new Aviao(-11886,650,4,0);
		this.aviao[9] = new Aviao(-13827,-40,4,1);
		this.aviao[10] = new Aviao(-14070,650,4,0);
		this.aviao[11] = new Aviao(-14868,-40,4,1);
		this.aviao[12] = new Aviao(-16014,650,4,0);
		this.aviao[13] = new Aviao(-16446,-40,4,1);
		this.aviao[14] = new Aviao(-17310,650,4,0);
		this.aviao[15] = new Aviao(-17832,-40,4,1);
	}

	public void check1(){
		
		this.posX = 0;
		this.posX = 0;
		this.largura = 640;
		this.altura = 480;
		this.addKeyListener(this);
		this.addWindowListener(this);
		this.cenario = new Cenario();
		this.controle = new Controle();
		this.medidor = new Medidor();
		this.placar = new Placar();
		this.aviao_player = new PlayerAviao();
		this.ponte = new Ponte[1];
		this.ponte[0] = new Ponte(-3700, 220, 220);
		this.atira = new Tiro(this.aviao_player.posBala());
		this.posto = new Posto[14];
		this.posto[0] = new Posto(-1386,200);
		this.posto[1] = new Posto(-2754,158);
		this.posto[2] = new Posto(-2889,158);
		this.posto[3] = new Posto(-4104,350);
		this.posto[4] = new Posto(-5448,490);
		this.posto[5] = new Posto(-5628,140);
		this.posto[6] = new Posto(-7305,320);
		this.posto[7] = new Posto(-8355,250);
		this.posto[8] = new Posto(-10746,300);
		this.posto[9] = new Posto(-12009,140);
		this.posto[10] = new Posto(-13581,160);
		this.posto[11] = new Posto(-15012,320);
		this.posto[12] = new Posto(-16212,350);
		this.posto[13] = new Posto(-17598,364);
		this.parede = new Parede[14];
		this.parede[0] = new Parede(0, -19620, 100, 20000);
		this.parede[1] = new Parede(540, -19620, 100, 20000);
		this.parede[2] = new Parede(0, 180, 220, 200);
		this.parede[3] = new Parede(440, 180, 220, 200);
		this.parede[4] = new Parede(100, -800, 100, 200);
		this.parede[5] = new Parede(440, -800, 100, 200);
		this.parede[6] = new Parede(100, -4400, 120, 1000);
		this.parede[7] = new Parede(440, -4400, 120, 1000);
		this.ilha = new Parede[3];
		this.ilha[0] = new Parede(220, -3200, 200, 800);
		this.ilha[1] = new Parede(180, -6900, 300, 1800);
		this.ilha[2] = new Parede(200, -13800, 380, 2000);

		this.parede[8] = new Parede(100, -8300, 100, 300);
		this.parede[9] = new Parede(440, -8300, 100, 300);

		this.parede[10] = new Parede(100, -11000, 120, 600);
		this.parede[11] = new Parede(440, -11000, 120, 600);

		this.parede[12] = new Parede(100, -18000, 200, 3000);
		this.parede[13] = new Parede(440, -18000, 200, 3000);

		
		
		this.te = false;
		this.td = false;
		this.ta = false;
		this.tb = false;
		this.explode_aviao = false;
		this.inimigos();
	}
	
	public void update(Graphics pincel) {
		Image imageOff = this.createImage(640, 480);
		Graphics graphOff = imageOff.getGraphics();
		int cont;
		this.cenario.desenha_cenario(graphOff);
		
		for(cont = 0; cont < 1; cont++){
			if (this.ponte[cont].getFlagExplode() == 0) {
				this.ponte[cont].desenha_Ponte(graphOff);
			} else {
				this.ponte[cont].desenha_ExplodePonte(graphOff);
			}
		}

		for(cont = 0; cont < 14; cont++){
			this.parede[cont].desenhaTela(graphOff);
		}
		
		for(cont = 0; cont < 3; cont++){
			this.ilha[cont].desenhaTela(graphOff);
		}

		for(cont = 0; cont < 23; cont++){
			if (this.heli[cont].flag == 1)
				this.heli[cont].desenha_Dir(graphOff);
			else if (this.heli[cont].flag == 0)
				this.heli[cont].desenha_Esq(graphOff);
			else if (this.heli[cont].flag == 2)
				this.heli[cont].desenha_Explosao(graphOff);
		}
		
		for(cont = 0; cont < 28; cont++){
			if (this.barco[cont].flag == 1)
				this.barco[cont].desenha_Dir(graphOff);
			else if (this.barco[cont].flag == 0)
				this.barco[cont].desenha_Esq(graphOff);
			else if (this.barco[cont].flag == 2)
				this.barco[cont].desenha_Explosao(graphOff);
		}
		
		for(cont = 0; cont < 16; cont++){
			if (this.aviao[cont].flag == 1)
				this.aviao[cont].desenha_Dir(graphOff);
			else if (this.aviao[cont].flag == 0)
				this.aviao[cont].desenha_Esq(graphOff);
			else if (this.aviao[cont].flag == 2)
				this.aviao[cont].desenha_Explosao(graphOff);
		}
		
		if(this.atira.gettiro_off() == 1){
			this.atira.desenhar(graphOff);
		}
		
		for(cont = 0; cont < 14; cont++){
			if (this.posto[cont].getColisao() == 0) {
				this.posto[cont].desenhaPosto(graphOff);
			} else if (this.posto[cont].getColisao() == 1) {
				this.posto[cont].desenhaPostoExplosao(graphOff);
			}
		}
		
		if (this.explode_aviao) {
			this.aviao_player.desenha_aviao_explosao(graphOff);
		} else {
			if (this.te) {
				this.aviao_player.desenha_aviao_esq(graphOff);
			} else if (this.td) {
				this.aviao_player.desenha_aviao_dir(graphOff);
			} else {
				this.aviao_player.desenha_aviao(graphOff);
			}
		}
		

		if(this.estado_atual == 0){
			this.controle.desenha_placar(graphOff);
			this.medidor.desenha_combustivel(graphOff);
			this.placar.desenha_combustivel(graphOff);
			this.ponto.desenha_ponto(graphOff);
			this.vida.desenhaVida(graphOff);
		}else if(this.estado_atual == 1){
			this.controle.desenha_placar_inicio(graphOff);
		}else if(this.estado_atual == 2){
			this.controle.desenha_placar_game_over(graphOff);
		}else if(this.estado_atual == 3){
			this.controle.desenha_placar_finaliza(graphOff);
		}


		pincel.drawImage(imageOff, this.posX, this.posY, this.largura, this.altura, this);
	}

	public static void main(String args[]) {
		Thread t = new Thread(new RiverRaid());
		t.start();
	}
	


	@Override
	public void run() {
		int cont;
		this.repaint(); if(this.controle_vida);
		while (jogo) {
			if(this.controle_inicio){
				
			
			
				if(!this.controle_vida){
					this.check1();
					this.controle_vida = true;
					this.estado_atual = 0;
					this.controle_inicio = false;
				}
				
				if(this.vida.vida == 0){
					this.vida = new Vidas();
				    this.ponto = new Ponto();
				    this.estado_atual = 2;
				    this.controle_inicio = false;
				}
				
				if(this.cenario.getPosy() >= 150){
					this.vida = new Vidas();
				    this.ponto = new Ponto();
				    this.estado_atual = 3;
				    this.controle_inicio = false;
				    this.controle_vida = false;
				}
	
				for(cont = 0; cont < 1; cont++){
					this.ponte[cont].moverPonte(this.cenario.getVelocidade());
				}
				for(cont = 0; cont < 23; cont++){
					this.heli[cont].moverNaTela(this.cenario.getVelocidade());
				}
				
				for(cont = 0; cont < 28; cont++){
					this.barco[cont].moverNaTela(this.cenario.getVelocidade());
				}
				
				for(cont = 0; cont < 16; cont++){
					this.aviao[cont].moverNaTela(this.cenario.getVelocidade());
				}
				
				for(cont = 0; cont < 14; cont++){
					this.posto[cont].setPosy(this.cenario.getVelocidade());
				}
		        this.MoverParedes();
				
				this.diminuir_combustivel += 10;
				if (this.diminuir_combustivel == 300) {
					this.medidor.diminuirCombustivel();
					this.aviao_player.diminuirCombustivel();
					this.diminuir_combustivel = 0;
				}
				
				for(cont = 0; cont < 14; cont++){
					if (this.aviao_player.detectaColisao(this.posto[cont].obtemQuadrado()) && (this.posto[cont].getColisao() != 1)){
						this.aumentar_combustivel += 100;
						if (this.aumentar_combustivel >= 300) {
							this.medidor.aumentaCombustivel();
							this.aviao_player.aumentarCombustivel();
							this.aumentar_combustivel = 0;
						}
		
					}
				}
	
				if (this.te) {
					this.aviao_player.moverEsq();
					this.atira.setPosx(this.aviao_player.posBala());
				}
				if (this.td) {
					this.aviao_player.moverDir();
					this.atira.setPosx(this.aviao_player.posBala());
				}
	
	
				if (this.ta) {
					this.cenario.moverCenario3x();
				} else if (this.tb) {
					this.cenario.moverCenario1x();
				} else{
					this.cenario.moverCenario();
				}
				
				if (this.tiro) {
					if (this.atira.getPosy() > 0) {
						this.atira.moverCima();
					} else {
						this.tiro = false;
						this.atira.settiro_off(0);
						this.atira.setPosy(325);
					}
	
				}
	
				for(cont = 0; cont < 23; cont++){
					if (this.atira.detectaColisao(this.heli[cont].getCoords())&& this.heli[cont].getFlag() != 2) {
						this.tiro = false;
						this.atira.setPosy(325);
						this.heli[cont].setFlag(2);
						this.ponto.aumentaPonto(50);
						this.atira.settiro_off(0);
					}
				}
				
				for(cont = 0; cont < 28; cont++){
					if (this.atira.detectaColisao(this.barco[cont].getCoords())&& this.barco[cont].getFlag() != 2) {
						this.tiro = false;
						this.atira.setPosy(325);
						this.barco[cont].setFlag(2);
						this.ponto.aumentaPonto(50);
						this.atira.settiro_off(0);
					}
				}
				
				for(cont = 0; cont < 16; cont++){
					if (this.atira.detectaColisao(this.aviao[cont].getCoords())&& this.aviao[cont].getFlag() != 2) {
						this.tiro = false;
						this.atira.setPosy(325);
						this.aviao[cont].setFlag(2);
						this.ponto.aumentaPonto(50);
						this.atira.settiro_off(0);
					}
				}
	
				for(cont = 0; cont < 1; cont++){
					if (this.atira.detectaColisao(this.ponte[cont].getCoords()) && (this.atira.gettiro_off() == 1)){
						if(this.ponte[cont].getFlagExplode() == 0){
							this.tiro = false;
							this.atira.setPosy(325);
							this.ponte[cont].setFlagExplode(1);
							this.ponto.aumentaPonto(50);
						}
						this.ponte[cont].setFlagExplode(1);
						this.atira.settiro_off(0);
	
					}
				}
				
				//Sistema de colis�o com tiro voltando a sua posi��o original
				for(cont = 0; cont < 14; cont++){
					if (this.atira.detectaColisao(this.posto[cont].obtemQuadrado()) && (this.atira.gettiro_off() == 1)){
						if(this.posto[cont].getColisao() == 0){
							this.tiro = false;
							this.atira.setPosy(325);
							this.ponto.aumentaPonto(50);
						}
						this.posto[cont].setColisao(1);
						this.atira.settiro_off(0);
					}
				}
				
	
				this.colisaoInimigoParede();
				this.playerColideParede();
				this.tiroColideParede();
				
				for(cont = 0; cont < 16; cont++){
					if(this.aviao[cont].getCoords()[2] > 150 && this.aviao[cont].getFlag() == 1){
						this.aviao[cont].moverDireita();
					}else if(this.aviao[cont].getCoords()[2] > 150 && this.aviao[cont].getFlag() == 0){
						this.aviao[cont].moverEsquerda();
					}
				}
				
				for(cont = 0; cont < 23; cont++){
					if (this.aviao_player.detectaColisao(this.heli[cont].getCoords()) && (this.heli[cont].getFlag() != 2)) {
						this.vida.diminuiVida();
						this.explode_aviao = true;
						this.tiro = false;
						this.atira.settiro_off(0);
						this.atira.setPosy(325);
						this.controle_vida = false;
					}
				}
				
				for(cont = 0; cont < 28; cont++){
					if (this.aviao_player.detectaColisao(this.barco[cont].getCoords()) && (this.barco[cont].getFlag() != 2)) {
						this.vida.diminuiVida();
						this.explode_aviao = true;
						this.tiro = false;
						this.atira.settiro_off(0);
						this.atira.setPosy(325);
						this.controle_vida = false;
					}
				}
				
				for(cont = 0; cont < 16; cont++){
					if (this.aviao_player.detectaColisao(this.aviao[cont].getCoords()) && (this.aviao[cont].getFlag() != 2)) {
						this.vida.diminuiVida();
						this.explode_aviao = true;
						this.tiro = false;
						this.atira.settiro_off(0);
						this.atira.setPosy(325);
						this.controle_vida = false;
					}
				}
	
	
	
				if (this.aviao_player.getCombustivel() == 0) {
					this.explode_aviao = true;
					this.jogo = false;
				}
	
				try {
					Thread.sleep(15);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				this.repaint(); if (this.controle_vida);
			}
		}
	}
	
	public void colisaoInimigoParede(){
		//começo parede[0]/parede[1]
		
		//helicoptero
		if(this.heli[0].getFlag() == 0){
			if(this.heli[0].detectaColisao(this.parede[1].getCoords()))
			{
				this.heli[0].setFlag(1);
			}else{
			    this.heli[0].moverDireita();
			}
		}else if(this.heli[0].getFlag() == 1){
			if(this.heli[0].detectaColisao(this.parede[0].getCoords())){this.heli[0].setFlag(0);}
			  this.heli[0].moverEsquerda();
		}
		
		if(this.heli[1].getFlag() == 0){
			if(this.heli[1].detectaColisao(this.parede[1].getCoords()))
			{
				this.heli[1].setFlag(1);
			}else{
			    this.heli[1].moverDireita();
			}
		}else if(this.heli[1].getFlag() == 1){
			if(this.heli[1].detectaColisao(this.parede[0].getCoords())){this.heli[1].setFlag(0);}
			  this.heli[1].moverEsquerda();
		}
		
		if(this.heli[3].getFlag() == 0){
			if(this.heli[3].detectaColisao(this.parede[1].getCoords()))
			{
				this.heli[3].setFlag(1);
			}else{
			    this.heli[3].moverDireita();
			}
		}else if(this.heli[3].getFlag() == 1){
			if(this.heli[3].detectaColisao(this.parede[0].getCoords())){this.heli[3].setFlag(0);}
			  this.heli[3].moverEsquerda();
		}
		
		if(this.heli[4].getFlag() == 0){
			if(this.heli[4].detectaColisao(this.parede[1].getCoords()))
			{
				this.heli[4].setFlag(1);
			}else{
			    this.heli[4].moverDireita();
			}
		}else if(this.heli[4].getFlag() == 1){
			if(this.heli[4].detectaColisao(this.parede[0].getCoords())){this.heli[4].setFlag(0);}
			  this.heli[4].moverEsquerda();
		}
		
		if(this.heli[6].getFlag() == 0){
			if(this.heli[6].detectaColisao(this.parede[1].getCoords()))
			{
				this.heli[6].setFlag(1);
			}else{
			    this.heli[6].moverDireita();
			}
		}else if(this.heli[6].getFlag() == 1){
			if(this.heli[6].detectaColisao(this.parede[0].getCoords())){this.heli[6].setFlag(0);}
			  this.heli[6].moverEsquerda();
		}
		
		if(this.heli[10].getFlag() == 0){
			if(this.heli[10].detectaColisao(this.parede[1].getCoords()))
			{
				this.heli[10].setFlag(1);
			}else{
			    this.heli[10].moverDireita();
			}
		}else if(this.heli[10].getFlag() == 1){
			if(this.heli[10].detectaColisao(this.parede[0].getCoords())){this.heli[10].setFlag(0);}
			  this.heli[10].moverEsquerda();
		}
		
		if(this.heli[11].getFlag() == 0){
			if(this.heli[11].detectaColisao(this.parede[1].getCoords()))
			{
				this.heli[11].setFlag(1);
			}else{
			    this.heli[11].moverDireita();
			}
		}else if(this.heli[11].getFlag() == 1){
			if(this.heli[11].detectaColisao(this.parede[0].getCoords())){this.heli[11].setFlag(0);}
			  this.heli[11].moverEsquerda();
		}
		
		if(this.heli[12].getFlag() == 0){
			if(this.heli[12].detectaColisao(this.parede[1].getCoords()))
			{
				this.heli[12].setFlag(1);
			}else{
			    this.heli[12].moverDireita();
			}
		}else if(this.heli[12].getFlag() == 1){
			if(this.heli[12].detectaColisao(this.parede[0].getCoords())){this.heli[12].setFlag(0);}
			  this.heli[12].moverEsquerda();
		}
		
		if(this.heli[13].getFlag() == 0){
			if(this.heli[13].detectaColisao(this.parede[1].getCoords()))
			{
				this.heli[13].setFlag(1);
			}else{
			    this.heli[13].moverDireita();
			}
		}else if(this.heli[13].getFlag() == 1){
			if(this.heli[13].detectaColisao(this.parede[0].getCoords())){this.heli[13].setFlag(0);}
			  this.heli[13].moverEsquerda();
		}
		
		if(this.heli[14].getFlag() == 0){
			if(this.heli[14].detectaColisao(this.parede[1].getCoords()))
			{
				this.heli[14].setFlag(1);
			}else{
			    this.heli[14].moverDireita();
			}
		}else if(this.heli[14].getFlag() == 1){
			if(this.heli[14].detectaColisao(this.parede[0].getCoords())){this.heli[14].setFlag(0);}
			  this.heli[14].moverEsquerda();
		}
		
		if(this.heli[18].getFlag() == 0){
			if(this.heli[18].detectaColisao(this.parede[1].getCoords()))
			{
				this.heli[18].setFlag(1);
			}else{
			    this.heli[18].moverDireita();
			}
		}else if(this.heli[18].getFlag() == 1){
			if(this.heli[18].detectaColisao(this.parede[0].getCoords())){this.heli[18].setFlag(0);}
			  this.heli[18].moverEsquerda();
		}
		
		if(this.heli[21].getFlag() == 0){
			if(this.heli[21].detectaColisao(this.parede[1].getCoords()))
			{
				this.heli[21].setFlag(1);
			}else{
			    this.heli[21].moverDireita();
			}
		}else if(this.heli[21].getFlag() == 1){
			if(this.heli[21].detectaColisao(this.parede[0].getCoords())){this.heli[21].setFlag(0);}
			  this.heli[21].moverEsquerda();
		}
		
		if(this.heli[22].getFlag() == 0){
			if(this.heli[22].detectaColisao(this.parede[1].getCoords()))
			{
				this.heli[22].setFlag(1);
			}else{
			    this.heli[22].moverDireita();
			}
		}else if(this.heli[22].getFlag() == 1){
			if(this.heli[22].detectaColisao(this.parede[0].getCoords())){this.heli[22].setFlag(0);}
			  this.heli[22].moverEsquerda();
		}
		
		//Barco
		
		if(this.barco[0].getFlag() == 0){
			if(this.barco[0].detectaColisao(this.parede[1].getCoords()))
			{
				this.barco[0].setFlag(1);
			}else{
			    this.barco[0].moverDireita();
			}
		}else if(this.barco[0].getFlag() == 1){
			if(this.barco[0].detectaColisao(this.parede[0].getCoords())){this.barco[0].setFlag(0);}
			  this.barco[0].moverEsquerda();
		}
		
		if(this.barco[1].getFlag() == 0){
			if(this.barco[1].detectaColisao(this.parede[1].getCoords()))
			{
				this.barco[1].setFlag(1);
			}else{
			    this.barco[1].moverDireita();
			}
		}else if(this.barco[1].getFlag() == 1){
			if(this.barco[1].detectaColisao(this.parede[0].getCoords())){this.barco[1].setFlag(0);}
			  this.barco[1].moverEsquerda();
		}
		
		if(this.barco[2].getFlag() == 0){
			if(this.barco[2].detectaColisao(this.parede[1].getCoords()))
			{
				this.barco[2].setFlag(1);
			}else{
			    this.barco[2].moverDireita();
			}
		}else if(this.barco[2].getFlag() == 1){
			if(this.barco[2].detectaColisao(this.parede[0].getCoords())){this.barco[2].setFlag(0);}
			  this.barco[2].moverEsquerda();
		}
		
		if(this.barco[5].getFlag() == 0){
			if(this.barco[5].detectaColisao(this.parede[1].getCoords()))
			{
				this.barco[5].setFlag(1);
			}else{
			    this.barco[5].moverDireita();
			}
		}else if(this.barco[5].getFlag() == 1){
			if(this.barco[5].detectaColisao(this.parede[0].getCoords())){this.barco[5].setFlag(0);}
			  this.barco[5].moverEsquerda();
		}
		
		if(this.barco[8].getFlag() == 0){
			if(this.barco[8].detectaColisao(this.parede[1].getCoords()))
			{
				this.barco[8].setFlag(1);
			}else{
			    this.barco[8].moverDireita();
			}
		}else if(this.barco[8].getFlag() == 1){
			if(this.barco[8].detectaColisao(this.parede[0].getCoords())){this.barco[8].setFlag(0);}
			  this.barco[8].moverEsquerda();
		}
		
		if(this.barco[9].getFlag() == 0){
			if(this.barco[9].detectaColisao(this.parede[1].getCoords()))
			{
				this.barco[9].setFlag(1);
			}else{
			    this.barco[9].moverDireita();
			}
		}else if(this.barco[9].getFlag() == 1){
			if(this.barco[9].detectaColisao(this.parede[0].getCoords())){this.barco[9].setFlag(0);}
			  this.barco[9].moverEsquerda();
		}
		
		if(this.barco[13].getFlag() == 0){
			if(this.barco[13].detectaColisao(this.parede[1].getCoords()))
			{
				this.barco[13].setFlag(1);
			}else{
			    this.barco[13].moverDireita();
			}
		}else if(this.barco[13].getFlag() == 1){
			if(this.barco[13].detectaColisao(this.parede[0].getCoords())){this.barco[13].setFlag(0);}
			  this.barco[13].moverEsquerda();
		}
		
		if(this.barco[14].getFlag() == 0){
			if(this.barco[14].detectaColisao(this.parede[1].getCoords()))
			{
				this.barco[14].setFlag(1);
			}else{
			    this.barco[14].moverDireita();
			}
		}else if(this.barco[14].getFlag() == 1){
			if(this.barco[14].detectaColisao(this.parede[0].getCoords())){this.barco[14].setFlag(0);}
			  this.barco[14].moverEsquerda();
		}
		
		if(this.barco[16].getFlag() == 0){
			if(this.barco[16].detectaColisao(this.parede[1].getCoords()))
			{
				this.barco[16].setFlag(1);
			}else{
			    this.barco[16].moverDireita();
			}
		}else if(this.barco[16].getFlag() == 1){
			if(this.barco[16].detectaColisao(this.parede[0].getCoords())){this.barco[16].setFlag(0);}
			  this.barco[16].moverEsquerda();
		}
		
		if(this.barco[17].getFlag() == 0){
			if(this.barco[17].detectaColisao(this.parede[1].getCoords()))
			{
				this.barco[17].setFlag(1);
			}else{
			    this.barco[17].moverDireita();
			}
		}else if(this.barco[17].getFlag() == 1){
			if(this.barco[17].detectaColisao(this.parede[0].getCoords())){this.barco[17].setFlag(0);}
			  this.barco[17].moverEsquerda();
		}
		
		if(this.barco[18].getFlag() == 0){
			if(this.barco[18].detectaColisao(this.parede[1].getCoords()))
			{
				this.barco[18].setFlag(1);
			}else{
			    this.barco[18].moverDireita();
			}
		}else if(this.barco[18].getFlag() == 1){
			if(this.barco[18].detectaColisao(this.parede[0].getCoords())){this.barco[18].setFlag(0);}
			  this.barco[18].moverEsquerda();
		}
		
		if(this.barco[19].getFlag() == 0){
			if(this.barco[19].detectaColisao(this.parede[1].getCoords()))
			{
				this.barco[19].setFlag(1);
			}else{
			    this.barco[19].moverDireita();
			}
		}else if(this.barco[19].getFlag() == 1){
			if(this.barco[19].detectaColisao(this.parede[0].getCoords())){this.barco[19].setFlag(0);}
			  this.barco[19].moverEsquerda();
		}
		
		if(this.barco[20].getFlag() == 0){
			if(this.barco[20].detectaColisao(this.parede[1].getCoords()))
			{
				this.barco[20].setFlag(1);
			}else{
			    this.barco[20].moverDireita();
			}
		}else if(this.barco[20].getFlag() == 1){
			if(this.barco[20].detectaColisao(this.parede[0].getCoords())){this.barco[20].setFlag(0);}
			  this.barco[20].moverEsquerda();
		}
		
		if(this.barco[24].getFlag() == 0){
			if(this.barco[24].detectaColisao(this.parede[1].getCoords()))
			{
				this.barco[24].setFlag(1);
			}else{
			    this.barco[24].moverDireita();
			}
		}else if(this.barco[24].getFlag() == 1){
			if(this.barco[24].detectaColisao(this.parede[0].getCoords())){this.barco[24].setFlag(0);}
			  this.barco[24].moverEsquerda();
		}
		
		//fim parede[0]/parede[1]
		

		
		//começo parede[0]/ilha[0]

		//Barco
		if(this.barco[3].getFlag() == 0){
			if(this.barco[3].detectaColisao(this.ilha[0].getCoords()))
			{
				this.barco[3].setFlag(1);
			}else{
			    this.barco[3].moverDireita();
			}
		}else if(this.barco[3].getFlag() == 1){
			if(this.barco[3].detectaColisao(this.parede[0].getCoords())){this.barco[3].setFlag(0);}
			  this.barco[3].moverEsquerda();
		}
		
		if(this.barco[4].getFlag() == 0){
			if(this.barco[4].detectaColisao(this.ilha[0].getCoords()))
			{
				this.barco[4].setFlag(1);
			}else{
			    this.barco[4].moverDireita();
			}
		}else if(this.barco[4].getFlag() == 1){
			if(this.barco[4].detectaColisao(this.parede[0].getCoords())){this.barco[4].setFlag(0);}
			  this.barco[4].moverEsquerda();
		}
		
		//fim parede[0]/ilha[0]
		
		//começo parede[4]/parede[5]
		
		if(this.heli[2].getFlag() == 0){
			if(this.heli[2].detectaColisao(this.parede[5].getCoords()))
			{
				this.heli[2].setFlag(1);
			}else{
			    this.heli[2].moverDireita();
			}
		}else if(this.heli[2].getFlag() == 1){
			if(this.heli[2].detectaColisao(this.parede[4].getCoords())){this.heli[2].setFlag(0);}
			  this.heli[2].moverEsquerda();
		}
		
		//fim parede[4]/parede[5]
		
		//começo parede[6]/parede[7]
		
		// Helicoptero
		if(this.heli[5].getFlag() == 0){
			if(this.heli[5].detectaColisao(this.parede[7].getCoords()))
			{
				this.heli[5].setFlag(1);
			}else{
			    this.heli[5].moverDireita();
			}
		}else if(this.heli[5].getFlag() == 1){
			if(this.heli[5].detectaColisao(this.parede[6].getCoords())){this.heli[5].setFlag(0);}
			  this.heli[5].moverEsquerda();
		}
		
		//Barco
		
		if(this.barco[6].getFlag() == 0){
			if(this.barco[6].detectaColisao(this.parede[7].getCoords()))
			{
				this.barco[6].setFlag(1);
			}else{
			    this.barco[6].moverDireita();
			}
		}else if(this.barco[6].getFlag() == 1){
			if(this.barco[6].detectaColisao(this.parede[6].getCoords())){this.barco[6].setFlag(0);}
			  this.barco[6].moverEsquerda();
		}

		if(this.barco[7].getFlag() == 0){
			if(this.barco[7].detectaColisao(this.parede[7].getCoords()))
			{
				this.barco[7].setFlag(1);
			}else{
			    this.barco[7].moverDireita();
			}
		}else if(this.barco[7].getFlag() == 1){
			if(this.barco[7].detectaColisao(this.parede[6].getCoords())){this.barco[7].setFlag(0);}
			  this.barco[7].moverEsquerda();
		}
		
		//fim parede[6]/parede[7]
		
		//começo parede[8]/parede[9]
		
		//barco
		if(this.barco[15].getFlag() == 0){
			if(this.barco[15].detectaColisao(this.parede[9].getCoords()))
			{
				this.barco[15].setFlag(1);
			}else{
			    this.barco[15].moverDireita();
			}
		}else if(this.barco[15].getFlag() == 1){
			if(this.barco[15].detectaColisao(this.parede[8].getCoords())){this.barco[15].setFlag(0);}
			  this.barco[15].moverEsquerda();
		}
		
		//fim parede[8]/parede[9]

		//começo ilha[1]/parede[1]
	
		//Helicoptero
		
		if(this.heli[7].getFlag() == 0){
			if(this.heli[7].detectaColisao(this.parede[1].getCoords()))
			{
				this.heli[7].setFlag(1);
			}else{
			    this.heli[7].moverDireita();
			}
		}else if(this.heli[7].getFlag() == 1){
			if(this.heli[7].detectaColisao(this.ilha[1].getCoords())){this.heli[7].setFlag(0);}
			  this.heli[7].moverEsquerda();
		}
		
		if(this.heli[9].getFlag() == 0){
			if(this.heli[9].detectaColisao(this.parede[1].getCoords()))
			{
				this.heli[9].setFlag(1);
			}else{
			    this.heli[9].moverDireita();
			}
		}else if(this.heli[9].getFlag() == 1){
			if(this.heli[9].detectaColisao(this.ilha[1].getCoords())){this.heli[9].setFlag(0);}
			  this.heli[9].moverEsquerda();
		}
		
		//fim ilha[2]/parede[1]
		
		//começo parede[0]/ilha[1]

		// Helicoptero
		
		if(this.heli[8].getFlag() == 0){
			if(this.heli[8].detectaColisao(this.ilha[1].getCoords()))
			{
				this.heli[8].setFlag(1);
			}else{
			    this.heli[8].moverDireita();
			}
		}else if(this.heli[8].getFlag() == 1){
			if(this.heli[8].detectaColisao(this.parede[0].getCoords())){this.heli[8].setFlag(0);}
			  this.heli[8].moverEsquerda();
		}
		
		//Barco
		
		if(this.barco[10].getFlag() == 0){
			if(this.barco[10].detectaColisao(this.ilha[1].getCoords()))
			{
				this.barco[10].setFlag(1);
			}else{
			    this.barco[10].moverDireita();
			}
		}else if(this.barco[10].getFlag() == 1){
			if(this.barco[10].detectaColisao(this.parede[0].getCoords())){this.barco[10].setFlag(0);}
			  this.barco[10].moverEsquerda();
		}
		
		if(this.barco[11].getFlag() == 0){
			if(this.barco[11].detectaColisao(this.ilha[1].getCoords()))
			{
				this.barco[11].setFlag(1);
			}else{
			    this.barco[11].moverDireita();
			}
		}else if(this.barco[11].getFlag() == 1){
			if(this.barco[11].detectaColisao(this.parede[0].getCoords())){this.barco[11].setFlag(0);}
			  this.barco[11].moverEsquerda();
		}

		if(this.barco[12].getFlag() == 0){
			if(this.barco[12].detectaColisao(this.ilha[1].getCoords()))
			{
				this.barco[12].setFlag(1);
			}else{
			    this.barco[12].moverDireita();
			}
		}else if(this.barco[12].getFlag() == 1){
			if(this.barco[12].detectaColisao(this.parede[0].getCoords())){this.barco[12].setFlag(0);}
			  this.barco[12].moverEsquerda();
		}
		
		//fim parede[0]/ilha[1]
		
		//começo parede[0]/ilha[2]
		
		//Helicoptero
		
		if(this.heli[15].getFlag() == 0){
			if(this.heli[15].detectaColisao(this.ilha[2].getCoords()))
			{
				this.heli[15].setFlag(1);
			}else{
			    this.heli[15].moverDireita();
			}
		}else if(this.heli[15].getFlag() == 1){
			if(this.heli[15].detectaColisao(this.parede[0].getCoords())){this.heli[15].setFlag(0);}
			  this.heli[15].moverEsquerda();
		}
		
		if(this.heli[16].getFlag() == 0){
			if(this.heli[16].detectaColisao(this.ilha[2].getCoords()))
			{
				this.heli[16].setFlag(1);
			}else{
			    this.heli[16].moverDireita();
			}
		}else if(this.heli[16].getFlag() == 1){
			if(this.heli[16].detectaColisao(this.parede[0].getCoords())){this.heli[16].setFlag(0);}
			  this.heli[16].moverEsquerda();
		}

		if(this.heli[17].getFlag() == 0){
			if(this.heli[17].detectaColisao(this.ilha[2].getCoords()))
			{
				this.heli[17].setFlag(1);
			}else{
			    this.heli[17].moverDireita();
			}
		}else if(this.heli[17].getFlag() == 1){
			if(this.heli[17].detectaColisao(this.parede[0].getCoords())){this.heli[17].setFlag(0);}
			  this.heli[17].moverEsquerda();
		}
		
		//Barco
		
		if(this.barco[22].getFlag() == 0){
			if(this.barco[22].detectaColisao(this.ilha[2].getCoords()))
			{
				this.barco[22].setFlag(1);
			}else{
			    this.barco[22].moverDireita();
			}
		}else if(this.barco[22].getFlag() == 1){
			if(this.barco[22].detectaColisao(this.parede[0].getCoords())){this.barco[22].setFlag(0);}
			  this.barco[22].moverEsquerda();
		}
		
		if(this.barco[23].getFlag() == 0){
			if(this.barco[23].detectaColisao(this.ilha[2].getCoords()))
			{
				this.barco[23].setFlag(1);
			}else{
			    this.barco[23].moverDireita();
			}
		}else if(this.barco[23].getFlag() == 1){
			if(this.barco[23].detectaColisao(this.parede[0].getCoords())){this.barco[23].setFlag(0);}
			  this.barco[23].moverEsquerda();
		}

		//fim parede[0]/ilha[2]
		
		//começo parede[12]/parede[13]
		
		//Helicoptero
		
		if(this.heli[19].getFlag() == 0){
			if(this.heli[19].detectaColisao(this.parede[13].getCoords()))
			{
				this.heli[19].setFlag(1);
			}else{
			    this.heli[19].moverDireita();
			}
		}else if(this.heli[19].getFlag() == 1){
			if(this.heli[19].detectaColisao(this.parede[12].getCoords())){this.heli[19].setFlag(0);}
			  this.heli[19].moverEsquerda();
		}
		
		if(this.heli[20].getFlag() == 0){
			if(this.heli[20].detectaColisao(this.parede[13].getCoords()))
			{
				this.heli[20].setFlag(1);
			}else{
			    this.heli[20].moverDireita();
			}
		}else if(this.heli[20].getFlag() == 1){
			if(this.heli[20].detectaColisao(this.parede[12].getCoords())){this.heli[20].setFlag(0);}
			  this.heli[20].moverEsquerda();
		}
		
		//Barco
		
		if(this.barco[25].getFlag() == 0){
			if(this.barco[25].detectaColisao(this.parede[13].getCoords()))
			{
				this.barco[25].setFlag(1);
			}else{
			    this.barco[25].moverDireita();
			}
		}else if(this.barco[25].getFlag() == 1){
			if(this.barco[25].detectaColisao(this.parede[12].getCoords())){this.barco[25].setFlag(0);}
			  this.barco[25].moverEsquerda();
		}
	
		if(this.barco[26].getFlag() == 0){
			if(this.barco[26].detectaColisao(this.parede[13].getCoords()))
			{
				this.barco[26].setFlag(1);
			}else{
			    this.barco[26].moverDireita();
			}
		}else if(this.barco[26].getFlag() == 1){
			if(this.barco[26].detectaColisao(this.parede[12].getCoords())){this.barco[26].setFlag(0);}
			  this.barco[26].moverEsquerda();
		}
		
		if(this.barco[27].getFlag() == 0){
			if(this.barco[27].detectaColisao(this.parede[13].getCoords()))
			{
				this.barco[27].setFlag(1);
			}else{
			    this.barco[27].moverDireita();
			}
		}else if(this.barco[27].getFlag() == 1){
			if(this.barco[27].detectaColisao(this.parede[12].getCoords())){this.barco[27].setFlag(0);}
			  this.barco[27].moverEsquerda();
		}
		//fim parede[12]/parede[13]
		
		
	}
	
	public void MoverParedes(){
		int cont;
		for(cont = 0; cont < 14; cont++){
			this.parede[cont].setPosy(this.cenario.getVelocidade());
		}
		
		for(cont = 0; cont < 3; cont++){
			this.ilha[cont].setPosy(this.cenario.getVelocidade());
		}

	}

	public void tiroColideParede() {
		int cont;
		
		for(cont = 2; cont < 14; cont++){
			if (this.atira.detectaColisao(this.parede[cont].getCoords())) {
				this.tiro = false;
				this.atira.settiro_off(0);
				this.atira.setPosy(325);
			}
		}

		for(cont = 0; cont < 3; cont++){
			if (this.atira.detectaColisao(this.ilha[cont].getCoords())) {
				this.tiro = false;
				this.atira.settiro_off(0);
				this.atira.setPosy(325);
			}
		}

	}

	public void playerColideParede() {
		int cont;
		
		for(cont = 0; cont < 14; cont++){
			if (this.aviao_player.detectaColisao(this.parede[cont].getCoords())) {
				this.explode_aviao = true;
				this.vida.diminuiVida();
				this.tiro = false;
				this.atira.settiro_off(0);
				this.atira.setPosy(325);
				this.controle_vida = false;
			}
		}
		
		for(cont =0; cont < 3; cont++){
			if (this.aviao_player.detectaColisao(this.ilha[cont].getCoords())) {
				this.explode_aviao = true;
				this.vida.diminuiVida();
				this.tiro = false;
				this.atira.settiro_off(0);
				this.atira.setPosy(325);
				this.controle_vida = false;

			}
		}

	}

	// TODO Auto-generated method stub

	@Override
	public void keyPressed(KeyEvent tecla) {
		int t = tecla.getKeyCode();
		if (t == KeyEvent.VK_1) {
			this.jogo = true;
		}

		switch (t) {
		case KeyEvent.VK_LEFT:
			this.te = true;
			break;
		case KeyEvent.VK_RIGHT:
			this.td = true;
			break;
		case KeyEvent.VK_UP:
			this.ta = true;
			break;
		case KeyEvent.VK_DOWN:
			this.tb = true;
			break;
		case KeyEvent.VK_A:
			this.tiro = true;
			this.atira.settiro_off(1);
			this.controle_inicio = true;
			this.estado_atual = 0;
		default:
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent tecla) {
		int t = tecla.getKeyCode();

		switch (t) {
		case KeyEvent.VK_LEFT:
			this.te = false;
			break;
		case KeyEvent.VK_RIGHT:
			this.td = false;
			break;
		case KeyEvent.VK_UP:
			this.ta = false;
			break;
		case KeyEvent.VK_DOWN:
			this.tb = false;
			break;
		default:
			break;
		}
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		// TODO Auto-generated method stub
		System.exit(0);

	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

}