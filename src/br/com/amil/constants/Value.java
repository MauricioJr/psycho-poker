package br.com.amil.constants;

public enum Value {
		A("A",1), TWO("TWO",2), THREE("THREE",3), FOUR("FOUR",4), FIVE("FIVE",5), SIX("SIX",6), SEVEN("SEVEN",7), 
		EIGTH("EIGTH",8), NINE("NINE",9), T("T",10), J("J",11), Q("Q",12), K("K",13);

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