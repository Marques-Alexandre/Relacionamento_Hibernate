package or.libertas.rest;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

public class MainTeste {
	public static void main(String[] args) {
		try {
			System.out.println("Iniciando o serviço na porta 8000");
			HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
			//server.createContext("/pessoas", new PessoasHandler());
			server.createContext("/", new IndexHandler());
			server.setExecutor(null);
			server.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	static class IndexHandler implements HttpHandler {

		@Override
		public void handle(HttpExchange t) throws IOException {
			String response = "<html>"
							+ "<head><title>Olá Mundo </title>"
							+ "<body>"
							+ "<h1>Exemplo de Micro Serviço Java</h1>"
							+ "</body>"
							+ "</html>";
			
			RequisicaoHttp req = new RequisicaoHttp();
			req.enviaGet(t, response);
			
		}
		
	}

}

