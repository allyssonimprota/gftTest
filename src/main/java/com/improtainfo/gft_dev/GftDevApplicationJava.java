package com.improtainfo.gft_dev;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GftDevApplicationJava {
	
	private static List<ItemVO> lista ;
	private static String output = "";
	
	private static void preencherLista(String t ,String n , String turno) {
		ItemVO itemLista = new ItemVO(t ,n , turno );
		lista.add(itemLista);
	}

	public static void main(String[] args) {
		String linha = null;
		List<ItemVO> outputList = new ArrayList<>();
		ccargaDadosLista();
		
		/** 
		 * Entrada de Dados.
		 */
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			linha = br.readLine();
		} catch (IOException ioe) {
			System.out.println("IO erro tentando ler a entrada!");
			System.exit(1);
		}
		
		/**
		 * Identificação do Turno e criando lista de tipos.
		 */
		String[] valores = linha.split(",");
		String turno = valores[0];
		valores[0] = null;
		List<String> valoresList = Arrays.asList(valores);
		
		/**
		 * Organizando a lista de Itens com os itens do turno.
		 */
		for (String string : valoresList) {	
			if (string != null) {	
				for (ItemVO temp : lista) {
					if (temp.getTurno().equals(turno) && temp.getTipo().trim().equals(string.trim())) {
						outputList.add(temp);
					}
				}
			}
		}
		
		ordenacaoMontagemOutput(outputList);
		System.out.println(output);
		System.exit(1);
	}

	private static void ordenacaoMontagemOutput(List<ItemVO> outputList) {
		Collections.sort(outputList);
		
		/**
		 * Map para filtrar a quantidade de cada Item.
		 */
		Map<String, Integer> map = new HashMap<>();
		for (ItemVO itemVO : outputList) {
			if (itemVO.getNome() != null) {				
				Integer test = map.get(itemVO.getNome());
				if (test != null) {
					test ++;
				} else {
					test = 1;
				}			
				map.put(itemVO.getNome(), test);
			} else {
				map.put("error", 1);
			}
		}
		
		/**
		 * Montagem da String de output.
		 */
		for (String key : map.keySet()) {
			if (key != null) {
				if (map.get(key) == 1) {
					output += key;
				} else {
					output += key + "(x" + map.get(key) + ")";
				}
			} else {
				output += "error";
			}
			output += ", ";
		}
		
		/**
		 * Remoção da virgula depois do ultimo item.
		 */
		if (output.length() > 2) {
			output = output.substring(0, output.length() -2);
		}
	}

	private static void ccargaDadosLista() {
		lista = new ArrayList<>();
		preencherLista("1","eggs","morning");
		preencherLista("2","Toast","morning");
		preencherLista("3","coffee","morning");
		preencherLista("4",null,"morning");
		preencherLista("1","steak","night");
		preencherLista("2","potato","night");
		preencherLista("3","wine","night");
		preencherLista("4","cake","night");
	} 
}

/**
 						Praticante de desenvolvedor
 						
Instruções:
Por favor, leia atentamente as informações abaixo. Siga as instruções para concluir seu código usando o idioma de sua escolha.
Depois de concluir este estágio, você deve publicar seu código no GitHub e enviar o link para o GFT Recruiter.

O estágio do desenvolvedor é avaliado em:
1. Projeto Orientado a Objetos
2. Legibilidade
3. Manutenção
4. Testabilidade

Requerimentos técnicos:
1. Crie esta solução como um aplicativo de console
2. A solução deve ter testes unitários
3. A solução deve ter um script de construção que possa compilar e testar a solução a partir da linha de comando
4. Coloque sua solução em um repositório GitHub e nos envie um link quando terminar

Regras:
1. Você deve inserir a hora do dia como "manhã" ou "noite"
2. Você deve inserir uma lista delimitada por vírgulas de tipos de pratos com pelo menos uma seleção
3. A saída deve imprimir comida na seguinte ordem: entrada, lado, bebida, sobremesa
4. Não há sobremesa para as refeições da manhã
5. A entrada não diferencia maiúsculas de minúsculas
6. Se uma seleção inválida for encontrada, exiba seleções válidas até o erro e, em seguida, imprima o erro
7. De manhã, você pode pedir várias xícaras de café
8. À noite, você pode ter várias ordens de batatas
9. Exceto pelas regras acima, você só pode pedir 1 de cada tipo de prato

Pratos para cada hora do dia

*/
