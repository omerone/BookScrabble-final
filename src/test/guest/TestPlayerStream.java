package guest;

import bookScrabble.model.logical.GuestModel;
import bookScrabble.model.logical.HostModel;

public class TestPlayerStream {
    public static void main(String[] args) {
        HostModel hostModel = new HostModel();
        hostModel.startHostServer();
         hostModel.streamPlayer();
        GuestModel guestModel = new GuestModel();
        guestModel.connectToServer();
        guestModel.streamPlayer();
        System.out.println(hostModel.getConnectedPlayersNumber());
        hostModel.closeHostServer();
    }
}
