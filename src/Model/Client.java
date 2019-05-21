package Model;

import Utils.Point;

import java.util.ArrayList;
import java.util.List;

public class Client extends User {
    private Point pos;
    private final List<Rental> pendingRates;

    public Client(Point pos, String email, String passwd, String name, String address, int nif) {
        super(email, name, address, nif, passwd);
        this.pos = pos;
        this.pendingRates = new ArrayList<>();
    }

    Point getPos() {
        return this.pos.clone();
    }

    private Client(Client u) {
        super(u);
        this.pos = u.getPos().clone();
        this.pendingRates = new ArrayList<>(u.pendingRates);
    }

    void addPendingRental(Rental r) {
        this.pendingRates.add(r);
    }

    public void rate(Rental r, int rating) {
        r.rate(rating);
        this.pendingRates.remove(r);
    }

    void setPos(Point pos) {
        this.pos = pos;
    }

    public Client clone() {
        return new Client(this);
    }

}
