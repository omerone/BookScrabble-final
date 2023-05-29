package guest;

import bookScrabble.model.communication.GuestHandler;
import bookScrabble.model.communication.HostServer;
import bookScrabble.model.logical.GuestModel;
import bookScrabble.model.logical.HostModel;


public class GuestConnection_Test {
    public static void main(String[] args) {
        HostModel m = new HostModel();
        GuestModel guestModel = new GuestModel();
        m.startHostServer();
        guestModel.connectToServer();
        m.closeHostServer();


    }
}
