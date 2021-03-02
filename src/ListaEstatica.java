import java.util.Arrays;

public class ListaEstatica {
    private int[] info;
    private int tamanho;

    public ListaEstatica() {
        info = new int[10];
        tamanho = 0; //Empty
    }

    private void redimensionar() {
        int[] oldArr = info;
        info = new int[oldArr.length + 10];
//            if (oldArr.length >= 0) System.arraycopy(oldArr, 0, info, 0, oldArr.length);
        for (int i = 0; i < oldArr.length; i++) {
            info[i] = oldArr[i];
        }
    }

    public void inserir(int value) {
        if (tamanho == info.length) {
            redimensionar();
        }
        //Zero-indexed
        info[tamanho] = value;
        tamanho++;
    }

    public void exibir() {
        System.out.println(Arrays.toString(info));
    }

    public int buscar(int value) {
        return -1;
    }

    public void retirar(int value) {

    }

    public int obterElemento(int position) {
        return -1;
    }

    public boolean estaVazia() {
        return false;
    }

    public int getTamanho() {
        return tamanho;
    }

    @Override
    public String toString() {
        return "";
    }
}
