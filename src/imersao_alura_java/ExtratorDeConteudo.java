package imersao_alura_java;

import java.util.List;

public interface ExtratorDeConteudo {
	List<Conteudo> extrairConteudo(String json);
}
