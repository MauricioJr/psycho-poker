package br.com.amil.constants;

public enum Value {
	K("K", 13), Q("Q", 12), J("J", 11), T("T", 10), NINE("NINE", 9), 
	EIGTH("EIGTH", 8), SEVEN("SEVEN", 7), SIX("SIX", 6), FIVE("FIVE", 5), 
	FOUR("FOUR", 4), THREE("THREE", 3), TWO("TWO", 2), A("A", 1);

		private Integer intValue;
		private String 	specialCard;
		
		public Integer getIntValue() {
			return intValue;
		}
		
		public String getSpecialCard() {
			return specialCard;
		}

		private Value(String specialCard, Integer intValue) {
			this.intValue = intValue;
			this.specialCard = specialCard;
		}

	}