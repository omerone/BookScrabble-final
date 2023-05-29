package model.facade;

import bookScrabble.model.logical.Game;
import org.junit.jupiter.api.Test;

import bookScrabble.model.logical.GuestModel;
import bookScrabble.model.logical.HostModel;

public class StreamPlayerToHostServerTest {
    public static void main(String[] args) {
        HostModel hostModel = new HostModel();
        hostModel.startHostServer();
        hostModel.StreamMessage("testConnection");
    }
}
