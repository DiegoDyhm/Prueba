public class Main{
	public static void main(String[] args){
		int opcion,band = 0;
		double nuevoSaldo, actualSaldo,cantidad;
		Ventanas ven = new Ventanas();
		cliente user = new cliente();
		
		do{
			String[] opciones = {"1.- Ver Saldo", "2.- Depositar una cantidad", "3.- Retirar una cantidad","4.- Salir"};
			opcion = ven.Opciones(opciones,"Que desea realizar","Cajero ATM");
			if(opcion == 0){
				actualSaldo = user.getMonto();
				if(actualSaldo < 1000){
					if(band == 0){
						band = 1;
						ven.Mensaje("Se han cobrado $30.50 por manejo de cuenta","Manejo de cuenta");
						nuevoSaldo = actualSaldo - 30.50;
						user.setMontoRet(nuevoSaldo);
						actualSaldo = user.getMonto();
					}
				}
				else{
					band =0;
				}
				ven.Men(actualSaldo,"Saldo actual");
			}
			else if(opcion == 1){
				actualSaldo = user.getMonto();
				cantidad = ven.Entrada("Que cantidad desea ingresar: ");
				if(cantidad < 0){
					ven.MensajeError("No puede ingresar cantidades negativas","ERROR");
				}
				else{
					nuevoSaldo = cantidad + actualSaldo;
					user.setMontoRet(nuevoSaldo);
				}
			}
			else if(opcion == 2){
				actualSaldo = user.getMonto();
				cantidad = ven.Entrada("Que cantidad desea retirar: ");
				if(cantidad > actualSaldo)
					ven.MensajeError("La cantidad que desea es retirar es mayor al que tiene en su cuenta","ERROR");
				else if(cantidad < 0){
					ven.MensajeError("No puede ingresar cantidades negativas","ERROR");
				}
				else{
					nuevoSaldo = actualSaldo - cantidad;
					user.setMontoRet(nuevoSaldo);
				}
			}
			
			
		}while(opcion != 3);
		
	}
}