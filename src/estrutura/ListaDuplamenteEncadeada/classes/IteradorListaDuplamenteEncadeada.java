package estrutura.ListaDuplamenteEncadeada.classes;

import java.util.Iterator;

/**
 *
 * @author cristiano pc
 * @param <T>
 */
public class IteradorListaDuplamenteEncadeada<T> implements Iterator<T>{
    private NoDuplo<T> atual;

    public IteradorListaDuplamenteEncadeada(NoDuplo<T> inicio) {
        this.atual = inicio;
    }

    @Override
    public boolean hasNext() {
    	try {
    		return atual.getElemento() != null;    		
    	}catch (NullPointerException e) {
    		return false;
    	}
    }

    @Override
    public T next() {
        T retorno = this.atual.getElemento();
        this.atual = this.atual.getProximo();
        
        return retorno;
    }
}
