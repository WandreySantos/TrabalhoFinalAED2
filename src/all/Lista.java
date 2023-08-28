package all;

public class Lista {
    Celula inicio, fim;

    public Lista() {
        inicio = null;
        fim = null;
    }

    public void inserirLista(No raiz) {
        inserirRecursivo(raiz);
    }

    private void inserirRecursivo(No atual) {
        if (atual != null) {
            inserirRecursivo(atual.esq);
            adicionar(atual.x);
            inserirRecursivo(atual.dir);
        }
    }

    public void adicionar(Palavra nome) {
        Celula novaCelula = new Celula(nome, fim);
        if (inicio == null) {
            inicio = novaCelula;
            fim = novaCelula;
        } else {
            fim.prox = novaCelula;
            fim = novaCelula;
        }
    }

    public void mostrarLista() {
        Celula temp = inicio;
        System.out.println("\nLista ordenada a-z");
        while (temp != null) {
            System.out.print(temp.x.nome + " :" + temp.x.ct + "x\n");
            temp = temp.prox;
        }
    }

    public void Frequentes() {
        if (inicio == null) {
            System.out.println("Lista vazia.");
            return;
        }

        // Converter a lista em um array para facilitar a ordenação
        int tamanho = contarElementos();
        Palavra[] array = new Palavra[contarElementos()];
        Celula temp = inicio;
        int i = 0;
        while (temp != null) {
            array[i] = temp.x;
            temp = temp.prox;
            i++;
        }
        //BubbleSort
        for (int j =0; j < tamanho-1; j++) {
            for (int k =0; k < tamanho-j-1; k++) {
            	// Se o elemento a frente for maior ,a uma troca
                if (array[k].ct < array[k+1].ct) {
                    Palavra tempPalavra =array[k];
                    array[k] = array[k +1];
                    array[k +1] = tempPalavra;
                }
            }
        }

        // Exibir as palavras frequentes
        System.out.println("Palavras mais frequentes:");
        for (Palavra palavra : array) {
            System.out.println(palavra.nome + " :" + palavra.ct + "x");
        }
    }
    
    //CONTA QUANTOS ELEMENTOS TEM NA LISTA
    private int contarElementos() {
        int CT = 0;
        Celula aux = inicio;
        while (aux != null) {
        	CT++;
            aux = aux.prox;
        }
        return CT;
    }
}
