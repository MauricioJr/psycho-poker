package br.com.amil.models;

public class Player {

	Hand hand;
	
	public Hand getHand() {
		if(hand == null){
			hand = new Hand();
		}
		return hand;
	}

	public void setHand(Hand hand) {
		this.hand = hand;
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((hand == null) ? 0 : hand.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Player other = (Player) obj;
		if (hand == null) {
			if (other.hand != null)
				return false;
		} else if (!hand.equals(other.hand))
			return false;
		return true;
	}
	
	
}
