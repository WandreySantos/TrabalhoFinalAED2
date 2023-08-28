package all;

public class Arvore {
    public No raiz;
    public Lista list;
    
    public Arvore() {
        raiz = null;
    }

    void inserir(String string) {
        raiz = inserirRecursivo(raiz, string);
    }
    private No inserirRecursivo(No atual, String string) {
        if (atual == null) {
            return new No(string);
        }

        if (string.compareTo(atual.x.nome) < 0) {
            atual.esq = inserirRecursivo(atual.esq, string);
        } else if (string.compareTo(atual.x.nome) > 0) {
            atual.dir = inserirRecursivo(atual.dir, string);
        } else {
            atual.x.Somar1();
        }
        
        atual.altura = 1 + Math.max(altura(atual.esq), altura(atual.dir));
        int Fb = fatorBalanceamento(atual);
        
        // Verificar se é necessário realizar rotações
        if (Fb > 1) {
            if (string.compareTo(atual.esq.x.nome) < 0) {
                // Caso LL: Rotação simples à direita
                return rotacaoDireita(atual);
            } else {
                // Caso LR: Rotação dupla à direita
                atual.esq = rotacaoEsquerda(atual.esq);
                return rotacaoDireita(atual);
            }
        } else if (Fb < -1) {
            if (string.compareTo(atual.dir.x.nome) > 0) {
                // Caso RR: Rotação simples à esquerda
                return rotacaoEsquerda(atual);
            } else {
                // Caso RL: Rotação dupla à esquerda
                atual.dir = rotacaoDireita(atual.dir);
                return rotacaoEsquerda(atual);
            }
        }

        return atual;
    }
    
    private No rotacaoEsquerda(No no) {
        No aux = no.dir;
        No novaSubArvoreEsquerda = aux.esq;

        aux.esq = no;
        no.dir = novaSubArvoreEsquerda;

        // Atualizar alturas
        no.altura = 1 + Math.max(altura(no.esq), altura(no.dir));
        aux.altura = 1 + Math.max(altura(aux.esq), altura(aux.dir));

        return aux;
    }

    private No rotacaoDireita(No no) {
        No aux = no.esq;
        No novaSubArvoreDireita = aux.dir;

        aux.dir = no;
        no.esq = novaSubArvoreDireita;

        // Atualizar alturas
        no.altura = 1 + Math.max(altura(no.esq), altura(no.dir));
        aux.altura = 1 + Math.max(altura(aux.esq), altura(aux.dir));

        return aux;
    }

	private int fatorBalanceamento(No no) {
        return altura(no.esq) - altura(no.dir);
    }
    private int altura(No no) {
        if (no == null) return 0;
        return no.altura;
    }
    
    public void mostrarArv() {
    	percorrer2(raiz);
    }
    
    private void percorrer2(No raiz) {
        System.out.println("--------------");
        if (raiz != null) {
            System.out.println("No: " + raiz.x.nome);

            if (raiz.esq != null || raiz.dir != null) {
                System.out.println("filhos: ");
                if (raiz.esq != null) {
                    System.out.println(raiz.esq.x.nome);
                }
                if (raiz.dir != null) {
                    System.out.println(raiz.dir.x.nome);
                }
            }

            if (raiz.esq != null) {
                percorrer2(raiz.esq);
            }
            if (raiz.dir != null) {
                percorrer2(raiz.dir);
            }
        }
        System.out.println("-----------FIM");
    }
    
    public void inserirLista() {
    	list=new Lista();
    	list.inserirLista(raiz);
    }

	public void mostrarLista() {
		peroccorer(raiz);
	}
	private void peroccorer(No atual) {
        	list.mostrarLista();
    }

	public void MaiorMenor() {
		// TODO Auto-generated method stub
		list.Frequentes();
	}

}
