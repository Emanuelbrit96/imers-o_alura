package imersao_alura_java;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
	public static void main(String[] args) throws IOException, InterruptedException {
//		String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
		String url = "https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY&start_date=2022-06-12&end_date=2022-06-14";

		
		// System.out.println(body);

		JsonParser parser = new JsonParser();

		List<Map<String, String>> listaDeConteudos = parser.parse(body);
		// System.out.println(listaDeFilmes.size());
		// System.out.println(listaDeFilmes.get(0));

		File diretorio = new File("figurinhas/");
		diretorio.mkdir();// Criando a pasta(Diretorio) caso não exista

		for (Map<String, String> conteudo : listaDeConteudos) {

//			InputStream inputStream = new URL(map.get("image")).openStream();
			InputStream inputStream = new URL(conteudo.get("url")).openStream();
			String titleImage = conteudo.get("title");
			String txtImage = titleImage.replaceAll("[-+^_:']", "");
			String txtConcatImage = "figurinhas/" + txtImage + ".png";
//			double rating = Double.parseDouble(map.get("imDbRating"));
//			int ratingStar = (int) rating;

			GeradorDeFigurinhas gerador = new GeradorDeFigurinhas();
			gerador.criar(inputStream, txtConcatImage, txtImage);

			// System.out.println("\u001b[37m \u001b[44m \u001b[1m " + txtImage + "
			// \u001b[m");
			// System.out.print(map.get("imDbRating") + " ");
//			for (int n = 1; n <= ratingStar; n++) {
//				// System.out.println((rating >= 9) ? " \u2B50\u2B50" : " \u2B50");
//				System.out.print(" \u2B50");
//			}
			System.out.println(txtImage);
			System.out.println(inputStream);
			System.out.println(
					"----------------------------------------------------------------------------------------");
		}
	}
}
