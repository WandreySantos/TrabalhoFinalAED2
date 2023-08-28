package all;

public class Palavra {
	String nome;
	int ct;
	
	public Palavra() {
		nome=null;
		ct=0;
	}
	public Palavra(String x) {
		nome=x;
		ct+=1;
	}
	public void Somar1() {
		ct+=1;
	}
	public String getNome() {
        return nome;
    }
}
