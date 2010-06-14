

class Inimigo{
	
	protected int velocidade, posX, posY, largura, altura;
	protected int coords[] = new int[4];
	protected int flag = 0;
		
	public Inimigo(){
	}
	
	
	public void moverDireita(){
		this.posX += this.velocidade;
	}
	
	public void moverEsquerda(){
		this.posX -= this.velocidade;
	}
	
	public void setFlag(int g){
		this.flag = g;
	}
	
	public int getFlag(){
		return this.flag;
	}
	
	public void moverPosy(int pos){
		this.posY +=  pos;
	}
	
	public void moverNaTela(int velocidade){
		this.posY += velocidade;
		
	}
	
	public int[] getCoords(){
		coords[0] = this.posX;
		coords[2] = this.posY;
		coords[1] = this.posX + this.largura;
		coords[3] = this.posY + this.altura;
		
		return coords;
	}
	
	public  boolean detectaColisao(int coords[]){
		this.getCoords();
		int x1 = this.coords[0];
		int x2 = this.coords[1];
		int y1 = this.coords[2];
		int y2 = this.coords[3];
		
		int x1b = coords[0];
		int x2b = coords[1];
		int y1b = coords[2];
		int y2b = coords[3];
		
		if(x2 >= x1b && x1 <= x2b && y2 >= y1b && y1 <= y2b)
			return true;
		else
			return false;
	}
}