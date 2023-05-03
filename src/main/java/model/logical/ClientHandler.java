package model.logical;

import java.io.InputStream;
import java.io.OutputStream;

public interface ClientHandler {
	void handleClient();

	void handleClient(InputStream inFromclient, OutputStream outToClient);
	void close();
}
