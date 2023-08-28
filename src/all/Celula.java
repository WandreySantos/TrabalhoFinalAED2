package all;

public class Celula {
	Palavra x;
	Celula prox,ant;
	
	public Celula() {
		x=null;
		prox=null;
	}
	public Celula(Palavra nova) {
		x=nova;
		prox=null;
	}
	public Celula(Palavra nova, Celula anterior) {
	    x = nova;
	    prox = null;
	    ant = anterior;
	}
}
