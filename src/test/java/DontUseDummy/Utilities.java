package DontUseDummy;

public class Utilities {

	public static void utility() {
		System.out.println("utilities");
	}

	private void ressult(String name,String designation) {
//               paithiyam
		switch (name.toUpperCase()) {

		case "MAHATHUVA":
			System.out.println("working in SYNERGY Software as a "+designation);
			break;

		case "GANESH":
			System.out.println("working in WIPRO Limited as a "+designation);
			break;
		default:
			System.out.println("No one working in this name");
			break;

		}

	}
	
	public static void main(String[] args) {
		
		Utilities u = new Utilities();
		
	}

}
