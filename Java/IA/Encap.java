class Encap{

	public static void main(String args[]){

		// Concepto: Encapsulamiento

		Fraccion2 f = new Fraccion2(3,4);

		U.println(f.denominador);
		//U.println(f.numerador);  numerador es private

		// numerador es private
		// no se puede modificar.
		//f.numerador = 0;

		System.out.println(f.aString());

		U.println(f.getNumerador());  //numerador es private

		// numerador es private
		// se puede modificar con un setter
		f.setNumerador(0);

		System.out.println(f.aString());

		//f.setNumerador2(1);
	}
}
