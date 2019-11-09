package eni.formation.bll;

public class JeuManagerFact {
	public static JeuManager getInstance() {
		return new JeuManagerImpl();
	}
}
