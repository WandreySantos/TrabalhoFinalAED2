package all;

public class No {
	public Palavra x;
	public No esq,dir;
	public int altura=0;
	
	public No() {
		x=null;
		esq=null; dir=null;
	}
	public No(String string) {
		Palavra aux=new Palavra(string);
		x=aux;
		altura+=1;
	}
}
