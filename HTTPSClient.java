import java.net.*;
import java.io.*;
import java.security.*;
import javax.net.ssl.*;

public class HTTPSClient {
	public static void main(String[] args) {
		if (args.length == 0) {
			System.out.println("Usage: java HTTPSClient host");
			return;
		}

		int port = 443;
		String host = args[0];

		try{
			Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
			SSLSocketFactory factory = (SSLSocketFactory) SSLSocketFactory.getDefault();

			SSLSocket socket = (SSLSocket) factory.createSocket(host, port);

			Writer out = new OutputStreamWriter(socket.getOutputStream());
			out.write("GET / HTTP/1.0\\n\\n");
			out.write("\\n\\n");
			out.flush();

			BufferedReader in = new BufferedReader(
						new InputStreamReader(socket.getInputStream()));
			int c;
			while ((c = in.read()) != -1) {
				System.out.write(c);
			}

			out.close();
			in.close();
			socket.close();
		}catch (IOException e) {
			System.err.println(e);
		}
	}
}
