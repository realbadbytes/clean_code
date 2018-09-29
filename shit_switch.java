/* the shit switch looks ok at first 
 * this function will need to change if new employee type is added
 * if this design is followed, isPayday(), deliveryPay(), etc will ALL need to be updated
 */

public Money calculatePay(Employee e) throws InvalidEmployeeType {
	switch (e.type) {
		case COMMISSIONED:
			return calculateCommissionedPay(e);
		case HOURLY:
			return calculateHourlyPay(e);
		case SALARIED:
			return calculateSalariedPay(e);
		default:
			throw new InvalidEmployeeType(e.type);
	}
}

/* improve upon the shit by burying the switch case somewhere else 
 * using an abstract factory is a better option
 * factory will create appropriate instances of Employee derivatives as needed
 * this is a good use of polymorphism, allows calculatePay() etc to be called on any Employee
 */

public abstract class Employe {
	public abstract boolean isPayDay();
	public abstract Money calculatePay();
	public abstract void deliveryPay(Money pay);
}
public interface EmployeeFactory {
	public Employee makeEmployee(EmployeeRecord r) throws InvalidEmployeeType;
}
public class EmployeeFactoryImpl implements EmployeeFactory {
	public Employee makeEmployee(EmployeeRecord r) throws InvalidEmployeeType {
		switch (r.type) {
			case COMMISSIONED:
				return new CommissionEmployee(r);
			case HOURLY:
				return new HourlyEmployee(r);
			case SALARIED:
				return new SalariedEmployee(r);
			default:
				throw new InvalidEmployeeType(r.type);
		}
	}
}
