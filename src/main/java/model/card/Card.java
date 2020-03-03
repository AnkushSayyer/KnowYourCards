package model.card;

public class Card implements Comparable<Card>{
	private CARD_TYPE type;
	private CARD_NUMBER number;
	
	public Card(CARD_TYPE type, CARD_NUMBER number) {
		this.type = type;
		this.number = number;
	}
	
	public CARD_TYPE getCardType() {
		return type;
	}
	
	public CARD_NUMBER getNumber() {
		return number;
	}
	
	@Override
	public String toString() {
		return number + " of " + type;
	}	
	
	@Override
	public boolean equals(Object arg) {
		if (arg == this) { 
            return true; 
        } 
		
		if (!(arg instanceof Card)) { 
            return false; 
        }
		
		Card card = (Card)arg;
		return this.getCardType().getOrd() == card.getCardType().getOrd()
				&& this.getNumber().getOrd() == card.getNumber().getOrd();
	}

	//Compare cards based on number then on basis of house
	@Override
	public int compareTo(Card o) {
		if(o.getNumber().getOrd() - this.getNumber().getOrd()==0)
			return o.getCardType().getOrd() - this.getCardType().getOrd();
		
		return o.getNumber().getOrd() - this.getNumber().getOrd();
	}
}
