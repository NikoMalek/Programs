import java.io.*;

class Fraccion{
	// Definición de campos y funciones:

	// CAMPOS:
	int numerador;
	int denominador;

	// CONSTRUCTOR:
	public Fraccion(int n, int d){
		this.numerador = n;
		denominador = d;	// puede omitirse "this"
	}

	// valorReal: void -> double
	// entrega el resultado de numerador / denominador
	public double valorReal(){
		return (double)numerador / denominador; 
	}

	// alCuadrado: double -> double
	// entrega el real e elevado a dos
	public static double alCuadrado(double e){
		return e*e;
	}

	// alCuadrado: void -> double
	// calcula el cuadrado de numerador / denominador
	// ej: si f = Fraccion(3,4)
	// f.alCuadrado() entrega (0.75)^2
	public double alCuadrado(){
		//double aux = (double)numerador / this.denominador;
		double aux = valorReal();
		return aux * aux;
	}

	// castea: void -> String
	// retorna un String de la forma "n/d"
	public String castea(){
		return ""+numerador+"/"+denominador;
	}

	public int castea(int tipo){
		if (Integer.class.isInstance(tipo)){
			return numerador/denominador;
		}
		return -10000000;
	}

	public double castea(double tipo){
		if (! Integer.class.isInstance(tipo)){
			// A transformar tipos se le
			// denomina "casting".
			return (double)numerador/denominador;
		}
		return -100000000000000000000.0;
	}  


	public boolean esIgual(Fraccion f){

		return f.numerador == this.numerador && f.denominador == this.denominador;
	}

	// sumar: Fraccion -> Fraccion
	public Fraccion sumar(Fraccion f){
		// f.numerador y f.denominador
		// this.numerador y this.denominador

		int num = this.numerador * f.denominador + this.denominador * f.numerador;
		int den = this.denominador * f.denominador;

		Fraccion aux = new Fraccion(num, den);
		return aux;
	}
	public String aString(){
		return ""+this.numerador+"/"+this.denominador;
	}

	// MAIN:
	public static void main(String args[]) throws IOException{

		Fraccion f;
		f = new Fraccion(3,4);
		
		// valorReal no es "static"
		// pues se usa de la forma
		// <objeto>.<funcion>(<params>)
		U.println(f.valorReal());


		// uso de funcion estatica:
		// <CLASE>.<metodo>(<params>)
		U.println(Fraccion.alCuadrado(5));
	

		U.println(f.alCuadrado());
		U.println(f.castea());

		// POLIMORFISMO:
		// Java sabe a cual de los metodos
		// castea llamar, dependiendo del
		// tipo de parametro que recibe.
		U.println(f.castea(1));

		U.println(f.castea(1.0));	

		// Concepto: REFERENCIA

		int a = 1;
		int b = 5;
		int c = 1;
		
		if (a == c) 
			U.println("Son iguales!");
		else
			U.println("Son distintos!");

		// Concepto: tipado dinamico
		Fraccion f1 = new Fraccion(1,2);
		Fraccion f2 = new Fraccion(3,4);
		Fraccion f3 = new Fraccion(1,2);

		// variable de entorno: CLASSPATH
		U.println("---------------------------");

		//if (f1 == f3)

		if (f1.esIgual( f3)) 
			U.println("Son iguales!");
		else
			U.println("Son distintos!");

		
		// ejemplo: suma de objetos de tipo Fraccion

		U.println("---------------------------");

		f = f1.sumar(f2);
	
		System.out.println(f.aString());
		
	}
}


