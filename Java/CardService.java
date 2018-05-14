package CaseStudy;

import java.sql.Connection;
import java.util.ArrayList;

public class CardService {
	Connection con;

	public CardService() {
		super();
	}

	public CardService(Connection con) {
		super();
		this.con = con;
	}
	
	public void add(Card card){
		
	}
	public void deleteById(String cardId){
		
	}
	public ArrayList<Card> getAll(){
		ArrayList<Card> cards = new ArrayList<Card>();
		
		return cards;
	}
	public Card getById(String cardId){
		Card card = new Card();
		
		return card;
	}
	
	public void update(Card card){
		
		
	}

}
