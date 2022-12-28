package webaction;

import super_simple_web_server.Status;
import super_simple_web_server.SuperSimpleWebServer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Favicon {


    public static final void getFavicon(final SuperSimpleWebServer.Request request) throws IOException {
        final String untrust_uri = request.getUri();
        if (untrust_uri.equals("/favicon.ico")) {
            final Path iconPath = Path.of("src/favicon.ico");
            // request.getWriter(Status.OK).write(Files.readAllBytes(iconPath), Files.readAllBytes(iconPath).length);
            request.getBinaryWriter("image/x-icon").write(Files.readAllBytes(iconPath), Files.readAllBytes(iconPath).length);
//            getBinaryWriter("image/x-icon")
        }
    }
}
