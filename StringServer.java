import java.io.IOException;
import java.net.URI;

class Handler implements URLHandler {
    private String concatenatedString = "";

    public String handleRequest(URI url) {
        if (url.getPath().equals("/add-message")) {
            String[] parameters = url.getQuery().split("=");
            if (parameters[0].equals("s")) {
                concatenatedString += parameters[1] + "\n";
            }
            return concatenatedString;
        }
        else {
            return "Invalid request";
        }
    }
}

class StringServer {
    public static void main(String[] args) throws IOException {
        if(args.length == 0){
            System.out.println("Missing port number!");
            return;
        }

        int port = Integer.parseInt(args[0]);

        Server.start(port, new Handler());
    }
}