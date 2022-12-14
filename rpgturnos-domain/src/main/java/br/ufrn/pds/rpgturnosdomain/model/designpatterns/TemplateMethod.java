package br.ufrn.pds.rpgturnosdomain.model.designpatterns;

public abstract class TemplateMethod {
	public final void processData() {
		String move = "";

		getMove(move);
		printMap();
	}

	public abstract void getMove(String move);

	public abstract void printMap();
}
