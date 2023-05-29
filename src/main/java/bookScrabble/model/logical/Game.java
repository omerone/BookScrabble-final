package bookScrabble.model.logical;

public class Game {
    HostModel hostModel;
    public Game(HostModel hostModel){
        this.hostModel = hostModel;
    }
    public void addPlayer(GuestModel guestModel){
        hostModel.addGuestPlayer(guestModel.getPlayer());
        connectPlayerToHost(guestModel);

    }
    private void connectPlayerToHost(GuestModel guestModel) {
       String ip = hostModel.socket.getLocalAddress().toString();
         int port = hostModel.socket.getLocalPort();
         guestModel.connectToServer("10.160.10.209", 8000);
    }
}
