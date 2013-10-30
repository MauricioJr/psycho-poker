package br.com.amil.models;

public class Suit implements Comparable<Suit>{

	public String value;

	public Suit(String value) {
		super();
		this.value = value;
	}

	public String getValue(){
		return value;
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}

	
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Suit other = (Suit) obj;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}

	
	public int compareTo(Suit suit) {
		return suit.getValue().compareTo(this.getValue());
	}

	@Override
	public String toString() {
		return value.toString();
	}
	
	
}
