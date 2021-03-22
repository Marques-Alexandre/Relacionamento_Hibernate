package or.libertas.rest;

import java.io.BufferedOutputStream;
import java.io.IOException;

import com.sun.net.httpserver.HttpExchange;

public class RequisicaoHttp {
	
	public void enviaGet(HttpExchange t, String response) throws IOException {
		t.getResponseHeaders().set("Content-Type", "text/html; charset=UTF-8");
		t.sendResponseHeaders(200, 0);
		BufferedOutputStream out = new BufferedOutputStream(t.getResponseBody());
		out.write(response.getBytes("UTF-8"));
		out.close();
	}

}
