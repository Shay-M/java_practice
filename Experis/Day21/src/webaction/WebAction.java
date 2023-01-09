package webaction;

import db.CustomerDAO;
import super_simple_web_server.SuperSimpleWebServer.Request;

public interface WebAction {
    String doAction(final Request request, final String untrust_remainingUriParams, final CustomerDAO customerDAO);
}
