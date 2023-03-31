package imersao_alura_java;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class App {
	public static void main(String[] args) throws IOException, InterruptedException {
		String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
		ExtratorDeConteudo extrator = new ExtratorDeConteudoImdb();

		// String url =
		// "https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY&start_date=2022-06-12&end_date=2022-06-14";
		// ExtratorDeConteudo extrator = new ExtratorDeConteudosDaNasa();

		ClientHttp http = new ClientHttp();
		String json = http.buscaDados(url);

		List<Conteudo> listaDeConteudos = extrator.extrairConteudo(json);

		// System.out.println(listaDeFilmes.size());
		// System.out.println(listaDeFilmes.get(0));

		File diretorio = new File("figurinhas/");
		diretorio.mkdir();// Criando a pasta(Diretorio) caso não exista

		for (Conteudo conteudo : listaDeConteudos) {

//			InputStream inputStream = new URL(map.get("image")).openStream();
			InputStream inputStream = new URL(conteudo.getUrlImage()).openStream();
			String titleImage = conteudo.getTitle();
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
