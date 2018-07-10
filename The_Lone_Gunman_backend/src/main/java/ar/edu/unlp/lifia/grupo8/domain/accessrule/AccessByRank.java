package ar.edu.unlp.lifia.grupo8.domain.accessrule;

import ar.edu.unlp.lifia.grupo8.domain.rank.Rank;


public class AccessByRank extends AccessRule {

	private Rank rank;
	
	public AccessByRank() {}
	
	public AccessByRank(Rank rank) {
		this.setRank(rank);
	}

	public Rank getRank() {
		return rank;
	}

	public void setRank(Rank rank) {
		this.rank = rank;
	}
}
