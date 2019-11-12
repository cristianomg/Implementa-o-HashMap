package estrutura;

import java.util.Iterator;

import estrutura.Interfaces.IHash;
import estrutura.ListaDuplamenteEncadeada.classes.ListaDuplamenteEncadeada;

public class HashMap<K, V> implements IHash<K, V>{
	
	private ListaDuplamenteEncadeada<Elemento> elementos[];
	private int itensAdicionados = 0;
	private int tamanhoVetor;
	
	

	public HashMap() {
		super();
		tamanhoVetor = 10;
		elementos = new ListaDuplamenteEncadeada[tamanhoVetor];
		for(int i = 0; i< elementos.length; i++) {
			elementos[i] = new ListaDuplamenteEncadeada<Elemento>();
		}
	}

	@Override
	public Iterator<V> iterator() {
		return null;
	}

	@Override
	public void inserir(K chave, V valor) {
		realocarMaior();
		int hashKey = chave.hashCode()%tamanhoVetor;
		elementos[hashKey].adicionar(new Elemento<K, V>(chave, valor));
		itensAdicionados++;
	}

	@Override
	public V obter(K chave) {
		int hashKey = chave.hashCode()%tamanhoVetor;
		ListaDuplamenteEncadeada<Elemento> item = elementos[hashKey];
		if (item.tamanho() > 0){
			for(Elemento elemento : elementos[hashKey]) {
				if (elemento.getKey().equals(chave)) return (V) elemento.getValue();
			}
		}
		return null;
	}

	@Override
	public V remover(K chave) {
		int hashKey = chave.hashCode()%tamanhoVetor;
		ListaDuplamenteEncadeada<Elemento> item = elementos[hashKey];
		V element = null;
		if (item.tamanho() > 0){
			for(Elemento elemento : elementos[hashKey]) {
				if (elemento.getKey() == chave) {
					element = (V) elemento.getValue();
					elementos[hashKey] = new ListaDuplamenteEncadeada<Elemento>();
					itensAdicionados --;
					return element;
				}
			}
		}
		return null;
	}

	@Override
	public boolean existe(K chave) {
		int hashKey = chave.hashCode()%tamanhoVetor;
		ListaDuplamenteEncadeada<Elemento> item = elementos[hashKey];
		if (item.tamanho() > 0){
			for(Elemento elemento : elementos[hashKey]) {
				if (elemento.getKey().equals(chave)) return true;
			}
		}
		return false;
	}

	@Override
	public boolean contem(V valor) {
		for(int i = 0 ; i< elementos.length; i++) {
			if(elementos[i].tamanho() > 0) {
				for(Elemento x : elementos[i]) {
					if (x.getValue().equals(valor)) return true;
					
				}
			}
		}
		return false;
	}

	@Override
	public int tamanho() {
		return itensAdicionados;
	}

	@Override
	public void limpar() {
		tamanhoVetor = 10;
		this.elementos = new ListaDuplamenteEncadeada[tamanhoVetor];
		for (int i=0; i< elementos.length; i++) {
			elementos[i] = new ListaDuplamenteEncadeada<Elemento>();
		}
		itensAdicionados = 0;
	}
	private void realocarMaior() {
		if ((float) itensAdicionados/tamanhoVetor >= 0.65) {
			tamanhoVetor *= 2;
			ListaDuplamenteEncadeada varElementos[] = new ListaDuplamenteEncadeada[tamanhoVetor];
			for (int i = 0; i< varElementos.length; i++) {
				varElementos[i] = new ListaDuplamenteEncadeada<Elemento>();
			}
			for (int i = 0; i< elementos.length; i++) {
				if(elementos[i].tamanho() > 0) {
					for (Elemento x : elementos[i]) {
						int hashKey = x.getKey().hashCode()%tamanhoVetor;
						varElementos[hashKey].adicionar(x);
					}
				}
			}
		}
	}
	
	
}
