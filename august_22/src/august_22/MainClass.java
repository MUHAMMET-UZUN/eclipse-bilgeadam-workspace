package august_22;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class MainClass {
	public static void main(String[] args) throws Exception {
		// ornek1();
		// ornek2();
		// ornek3(BufferedReader.class);
		ornek4(Person.class);
	}

	private static void ornek4(Class<?> type) throws Exception {
		// Person p = new Person();
		// p.setYas(123);
		// p.setIsim("numan");
		// System.out.println(p.getIsim() + " - " + p.getYas());
		Constructor<?> cstr = type.getDeclaredConstructors()[0];
		Object p = cstr.newInstance();

		for (Method m : type.getDeclaredMethods()) {
			if (m.getName().equals("setYas")) {
				m.invoke(p, 123);
				break;
				// System.out.println("Bu sınıfta setYas metodu vardır");
			}
		}

		for (Method m : type.getDeclaredMethods()) {
			if (m.getName().equals("getYas")) {
				if (Modifier.isPrivate(m.getModifiers())) {
					m.setAccessible(true);
					System.out.println(m.invoke(p));
				}
				break;
				// System.out.println("Bu sınıfta setYas metodu vardır");
			}
		}
	}

	private static void ornek3(Class<?> type) {
		System.out.println(type.getName());
		System.out.println(type.getDeclaredConstructors().length);
		System.out.println(type.getDeclaredMethods().length);
	}

	private static void ornek2() {
		Person p = new Person(12, "asd"); // uncomment this constructor from Person class
		System.out.println(p.getIsim() + " - " + p.getYas());

		for (Annotation a : p.getClass().getAnnotations()) {
			if (a.annotationType() == CustomLog.class) {
				System.out.print("Bu sınıfın tepesinde @CustomLog yazıyor");
				System.out.println(" level = " + p.getClass().getDeclaredAnnotation(CustomLog.class).level());
			}
		}

		for (Method m : p.getClass().getDeclaredMethods()) {
			for (Annotation a : m.getAnnotations()) {
				if (a.annotationType() == CustomLog.class) {
					System.out.print(m.getName() + " metodu @CustomLog içeriyor");
					System.out.println(" level = " + m.getDeclaredAnnotation(CustomLog.class).level());
				}
			}
		}

		for (Field f : p.getClass().getDeclaredFields()) {
			if (f.getAnnotation(CustomLog.class) != null) {
				System.out.print(f.getName() + " field'ı @CustomLog içeriyor");
				System.out.println(" level = " + f.getDeclaredAnnotation(CustomLog.class).level());
			}
		}
	}

	private static void ornek1() {
		MyList list = new MyList();
		list.add(1123);
	}
}
