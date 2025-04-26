package edu.pitt.cs;
import java.util.ArrayList;

public class Bus {
	private ArrayList<Passenger> passengers = new ArrayList<Passenger>();
	private int money = 0;

	public void stop(int lineLength) {
		final int busCapacity = 4;

		// Getting off
		ArrayList<Passenger> toRemove = new ArrayList<Passenger>();
		for (Passenger p : passengers) {
			if (p.isGettingOff()) {
				toRemove.add(p);
			}
		}
		passengers.removeAll(toRemove);

		// Getting on
		for (int i = 0; i < lineLength; i++) {
			if (passengers.size() < busCapacity) {
				passengers.add(new Passenger());
				money++;
			}
		}
	}

	public void trip() {
		for (int i = 0; i < 5; i++) {
			stop(i);
		}
	}

	public int getPassengerNum() { return passengers.size(); }
	public int getMoney() { return money; }
}