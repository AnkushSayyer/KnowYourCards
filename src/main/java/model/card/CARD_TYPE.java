package model.card;

public enum CARD_TYPE {
	SPADES(4), HEART(3), CLUB(2), DIAMONDS(1);
	
	private int ord;
	CARD_TYPE(int ord) {
		this.ord = ord;
	}
	
	public int getOrd() {
		return ord;
	}
}
