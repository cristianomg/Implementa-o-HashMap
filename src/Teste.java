import java.util.Scanner;

import estrutura.HashMap;

public class Teste {
	public static void main(String[] args) {
		HashMap<String, String> map = new HashMap<String, String>();
		Scanner sc = new Scanner(System.in);
		System.out.println("key");
		String key = sc.next();
		System.out.println("value");
		//String value = sc.next();
		map.inserir(key, "3232");
		System.out.println(map.obter("323232"));
		System.out.println("323232".hashCode());
	}

}

