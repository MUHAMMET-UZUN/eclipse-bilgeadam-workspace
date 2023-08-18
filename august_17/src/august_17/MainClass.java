package august_17;

import DependencyInj.Actor;
import DependencyInj.Comedy;
import DependencyInj.Horror;
import DependencyInj.Script;

public class MainClass {

	public static void main(String[] args) {
		ornek4();

	}

	private static void ornek4() {
		// dependency injection
		Actor act = new Actor();
		act.act(new Horror());
		act.act(new Comedy());

		act.act(new Script() {

			@Override
			public void act() {
				System.out.println("Hülooooo");

			}

		});
	}

}
