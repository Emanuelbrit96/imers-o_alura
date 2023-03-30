package imersao_alura_java;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class ClientHttp {
	String url;

	public String buscaDados(String url) {

		try {
			URI endereco = URI.create(url);
			// Criando o CLiente que vai mandar a requisição
			HttpClient client = HttpClient.newHttpClient();
			// Criando a requisição onde eu digo que va neste endereço e pegue seu conteúdo
			HttpRequest request = HttpRequest.newBuilder(endereco).GET().build();
			// Cliente envie o requerimento que foi criado e o conteúdo dele deve vir como
			// string
			HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
			String body = response.body();// Pegando o conteúdo do corpo da requisição
		} catch (IOException | InterruptedException ex) {
			throw new RuntimeException(ex);
		}

	}
}
