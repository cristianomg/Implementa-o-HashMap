package estrutura.Interfaces;

public interface IHash<K, V> extends Iterable<V>{
    public void inserir(K chave, V valor);
    public V obter(K chave);
    public V remover(K chave);
    public boolean existe(K chave);
    public boolean contem(V valor);
    public int tamanho();
    public void limpar();
}
