package DamBank;

/**
 * This program is was made for a school project. This is what the exercise asks us to do with this class (is in Spanish because my classes are given in Spanish):
 * 
 * Una cuenta bancaria tiene como datos asociados el iban (international bank acount number, formado por dos letras y 22 números), el titular (un
 * nombre completo), el saldo (dinero en euros) y los movimientos (histórico de los movimientos realizados en la cuenta, un máximo de 100
 * (para simplificar).
 *
 *  All attributes are private because we don't want other to be able to access this information, it would be a breach in security.
 * We are going to save the movements of the account in an array. The ideal solution would be to have a DBS, but as this is an small exercise
 * we will save them in an array.
 * As the balance is going to be saved in a double variable, the array must be the same kind of primitive data (at least is the ideal). 
 *
 * IBAN number is a final variable  because unique and cannot be changed.
 * There are exceptions, like changing offices or banks merging, but as a general rule, it cannot be changed.
 * In fact, at least in some banks, when this happens they create a new account that inherits the information from the older one, 
 * but it is not the same one. 
 * It might have the same benefits, but you even need to sign new bank agreements and authorizations to be able to pay something 
 * in instalments, for example. 
 * 
 * The holder could technically change, but the exercise tells implicitly tells us it can't change. So it's going to be final too.
 * "Cuando se crea una cuenta es obligatorio que tenga un iban y un titular (que no podrán cambiar nunca).
 *
 * El saldo será de 0 euros y la cuenta no tendrá movimientos asociados.
 * (histórico de los movimientos realizados en la cuenta, un máximo de 100.
 * As we want our code to be as clean and efficient as possible, we're going to create a constant MAX_MOVEMENTS that is going to delimit our array.
 * It's always better to create constants that we have to change only once than hard coding the variables and the going one by one modifying them.
 * That's why variables and constants are called that way, each one has it's own purpose.
 * 
 */

/**
 * @author Jennifer T. Sama
 * @version 1.0.0
 * 
 * @param iban String variable, saves IBAN number.
 * @param holderName String variable, saves holder name.
 * @param holderSurname String variable, saves holder surname.
 * @param balance Double variable, saves balance. If there was withdraws or deposits, the balance will be shown updated.
 * @param movements[] Double variable, the quantity given by the user in each operation.
 * @param nMovements Int variable, how many times the user made a withdraw or a deposit.
 * @param validAccount Boolean variable, returns if the account is valid (true) or not (false).
 * @param MAX_MOVEMENTS Int constant, the maximum movements is at 100 at the moment.
 * @param MIN_BALANCE Double constant, the minimum balance allowed. If the balances is going to be smaller, it will show this message: "AVISO: Saldo negativo"
 * @param WARNING_HPA Double constant, if the amount is bigger that this constant, it will who this message: "AVISO: Notificar a Hacienda".
 * 
 * 
 * @return CuentaBancaria, returns is the account is valid (true) or not (false).
 * @return getIban, getHolderName, getHolderSurname, getBalance, getValidAccount, each one returns the value of the original value in the variable, so the rest of 
 * the methods can operate them.
 * @return operations returns true when the operation finalizes.
 * @return deposit if the conditions are within parameters, returns true and gives "operation" the variable "quantity" that is going to use to operate.
 * If the return negative, it won't do anything.
 * @return withdraw if the conditions are within parameters, returns true and gives "operation" the variable "quantity" in negative numbers, that is going to use 
 * to operate. If the return negative, it won't do anything.
 * @return print shows IBAN, holder's full name, balance, number of movements, and the amount in the movement.
 * @return printData shows IBAN, holder's full name, and balance.
 * @return printMovements shows the number of movements, and the amount in the movement.
 * 
 */


import static java.lang.Math.abs;

public class CuentaBancaria {

	// They are all private because we do not want them to be accessible from the outside.
	// Main variables. They cannot change, so they are always final.
	private final String iban;
	private final String holderName;
	private final String holderSurname;
	
	// Secondary variables, used for the other methods (withdraw, deposit, etc).
	private double balance;
	private double[] movements;
	private int nMovements;
	private boolean validAccount;
	
	// They are static, because the are constants for the whole class.
	private static final int MAX_MOVEMENTS = 100;
	private static final double MIN_BALANCE = -50.0;
	private static final double WARNING_HPA = 3000.0;
	
	// Constructor
	public CuentaBancaria(String iban, String holderName, String holderSurname) {
		this.iban = iban;
		this.holderName = holderName;
		this.holderSurname = holderSurname;
		
		this.balance = 0.0;
		this.movements = new double[MAX_MOVEMENTS];
		
		// Check if account is valid.
		// ! <-- this symbol before iban.matches means "if not".
		if (!iban.matches("^[A-Z]{2}\\d{22}")) {
			System.err.println("ERROR: El IBAN introducido no es corrento");
			this.validAccount = false;
		}
		else {
			this.validAccount = true;
		}
	}
	
	// As our variables are private, we need to call setters and getters to be able to use them in the main class.
	// Getters
	public String getIban() {
		return iban;
	}
	
	public String getHolderName() {
		return holderName;
	}
	
	public String getHolderSurname() {
		return holderSurname;
	}
	
	public double getBalance() {
		return balance;
	}

	public boolean getValidAccount() {
		return validAccount;
	}
	
	// Operations you want to do on the account: deposit money, or withdraw money.
	// returns true if it's possible, false if it isn't.
	// The min amount you can have in your account it's -50.0. This means that if you have a balance of 100€, and you had a payments of 120€, 
	// the payment can be made, leaving the account in negative numbers. 
	// We create a constant MIN_BALANCE = -50.0	
	// Method operations is going to show the number of operations and give the result of the operation itself.
	private boolean operations(double quantity) {
		
		balance = balance + quantity;
		movements[nMovements] = quantity * (+1);
		nMovements++;
		
		return true;
		
	}
	
	// Allows depositing money.
	public boolean deposit(double quantity) {
		if(nMovements >= MAX_MOVEMENTS) { //We had a max of 100 movements in each account
			return false;
		}
		if (abs(quantity) > WARNING_HPA) {
			System.err.println("AVISO: Notificar a hacienda");
		}
		if (quantity <= 0 ) {
			return false;
		}

		return operations(quantity);
	}
	
	// Allows withdrawing money.
	public boolean withdraw(double quantity) {
		if(nMovements >= MAX_MOVEMENTS){ //We had a max of 100 movements in each account
			return false;
		}
		if (abs(quantity)> WARNING_HPA) {
			System.err.println("AVISO: Notificar a hacienda");
		}
		
		if (quantity <= 0) {
			return false;
		}
		else {
			if (balance - quantity >= 0) {
			}
			
			else if (balance - quantity < 0 && balance - quantity > MIN_BALANCE) {
				System.err.println("AVISO: Saldo negativo");
			}
			else if (balance - quantity < MIN_BALANCE) {
				return false;				
			}
		}
		
		return operations(-quantity);
	}
	
	// Prints complete data.
	public void print() {
		printData();
		printMovements();
	}

	// Prints only account and holder data.
	public void printData() {
		System.out.println("IBAN: " + getIban() + " - Titular: " + getHolderName() + " " + getHolderSurname() + " - Saldo: " + getBalance());
	}
	
	// Prints movements.
	public void printMovements() {
		System.out.println("Movements: " + nMovements);
		for (int i = 0; i < nMovements; i++) {
			System.out.println("#" + (i + 1) + ": " + movements[i]);
		}
	}
	
}
