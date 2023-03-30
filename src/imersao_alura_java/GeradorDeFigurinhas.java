package imersao_alura_java;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import javax.imageio.ImageIO;

public class GeradorDeFigurinhas {

	public void criar(InputStream inputStream, String fileImage, String textoDaImagem) throws IOException {

		// InputStream inputStream = new FileInputStream(new File("img/imagem.jpg"));
		// InputStream inputStream = new URL(
		// "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies_9.jpg").openStream();
		BufferedImage original = ImageIO.read(inputStream);

		int largura = original.getWidth();// pegando a largura da imagem original
		int altura = original.getHeight();// pegando a altura da imagem original
		int novaAltura = altura + 300;

		BufferedImage newImage = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

		Graphics2D graphics = (Graphics2D) newImage.getGraphics();
		graphics.drawImage(original, 0, 0, null);

		Font fonte = new Font(Font.SANS_SERIF, Font.BOLD, 64);
		graphics.setColor(Color.red);
		graphics.setFont(fonte);
		graphics.drawString(textoDaImagem, 0, novaAltura - 150);

		ImageIO.write(newImage, "png", new File(fileImage));
	}

}
