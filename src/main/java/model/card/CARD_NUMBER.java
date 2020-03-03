package model.card;

import java.util.HashMap;
import java.util.Map;

public enum CARD_NUMBER {
	TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), 
	NINE(9), TEN(10), JACK(11), QUEEN(12), KING(13), ACE(14);

	private int ord;
	private Map<Integer, CARD_NUMBER> map = new HashMap<>();
	private CARD_NUMBER(int i){
		this.ord = i;
		map.put(i, this);
	}
	
	public int getOrd(){
		return ord;
    }
	
	public CARD_NUMBER getNumberFromValue(int i) {
		return map.get(i);
	}
}
