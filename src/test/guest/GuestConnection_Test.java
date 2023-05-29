package guest;

import bookScrabble.model.communication.GuestHandler;
import bookScrabble.model.communication.HostServer;
import bookScrabble.model.logical.HostModel;


public class GuestConnection_Test {
    public static void main(String[] args) {
        HostModel m = new HostModel();
        HostServer hostServer = new HostServer(8000, new GuestHandler(m));
        hostServer.start(); // server runing on port 8000 in new thread.

    }
}
