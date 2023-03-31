package imersao_alura_java;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtratorDeConteudosDaNasa implements ExtratorDeConteudo {

	public List<Conteudo> extrairConteudo(String json) {
		JsonParser parser = new JsonParser();
		// JsonParser tem a função de pegaro json e separa-lo de acordo com padrões que
		// nos ditamos
		// Ex: ao },{ quer dizer que uma lista acabou e outra começou
		// Lista chave valor/ ex: "title":"Star-Wars"
		List<Map<String, String>> listaAtributos = parser.parse(json);

		List<Conteudo> conteudos = new ArrayList<>();

		// Populando list
		for (Map<String, String> atributo : listaAtributos) {
			String title = atributo.get("title");
			String urlImg = atributo.get("url");
			var conteudo = new Conteudo(title, urlImg);

			conteudos.add(conteudo);
		}
		return conteudos;

	}
}
