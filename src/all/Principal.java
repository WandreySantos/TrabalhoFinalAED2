package all;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;

public class Principal {

	public static void main(String[] args) {
	    Path caminho = Paths.get("C:\\Users\\Wandrey\\Desktop\\MILAGRE\\texto.txt");
	    String[] vetString = null;
	    try {
	        byte[] texto = Files.readAllBytes(caminho);
	        String ler = new String(texto);
	        
	        String[] palavras = ler.split("\\P{L}+"); // Separar por caracteres que não são letras
	        
	        vetString = new String[palavras.length]; // Inicializar o vetor com o tamanho correto
	        
	        for (int i = 0; i < palavras.length; i++) {
	            vetString[i] = palavras[i].toLowerCase(); // Armazenar cada palavra em minúsculas no vetor
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
        
        Arvore arv= new Arvore();
       
        /*metodos que inserer na arvores AVL
        arv.inserir(" "); */
        
       //Insere o txt ja tratado em um vetor 
       for (int i = 0; i <vetString.length ; i++) {
            arv.inserir(vetString[i]);
        }
       
        arv.mostrarArv();
        arv.inserirLista();
        arv.mostrarLista();
        arv.MaiorMenor();
        
    }
}
