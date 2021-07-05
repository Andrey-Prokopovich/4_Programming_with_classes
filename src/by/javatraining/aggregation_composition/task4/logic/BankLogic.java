package by.javatraining.aggregation_composition.task4.logic;

import by.javatraining.aggregation_composition.task4.entity.Bank;
import by.javatraining.aggregation_composition.task4.entity.Customer;
import by.javatraining.aggregation_composition.task4.exception.NameTakenException;

/*
 * Счета. Клиент может иметь несколько счетов в банке.
 * Учитывать возможность блокировки\разблокировки счета.
 * Реализовать поиск и сортировку счетов.
 * Вычисление общей суммы по счетам. Вычисление суммы по
 * всем счетам, имеющим положительный и отрицательный балансы отдельно.
 */

public class BankLogic {

	private final CustomerLogic customerLogic;

	private Bank bank;

	public BankLogic() {
		customerLogic = new CustomerLogic();
	}

	public void setBank(Bank bank) {
		if (bank == null) {
			this.bank = new Bank();
		} else {
			this.bank = bank;
		}
	}

	public CustomerLogic getCustomerLogic() {
		return customerLogic;
	}

	public Customer findCustomerByFullName(String fullName) {
		for (Customer customer : bank.getCustomerList()) {
			if (customer.getFullName().equals(fullName)) {
				return customer;
			}
		}

		return null;
	}

	public void addCustomer(String fullName) throws NameTakenException {
		if (findCustomerByFullName(fullName) != null) {
			throw new NameTakenException("Клиент с этим именем уже есть.");
		} else {
			bank.getCustomerList().add(new Customer(fullName));
		}
	}

	public void removeCustomer(String fullName) {
		Customer forRemoval;

		forRemoval = findCustomerByFullName(fullName);

		if (forRemoval == null) {
			System.out.println("Клиент с этим именем отсутствует.");
		} else {
			customerLogic.setCustomer(forRemoval);
			customerLogic.removeAllAccounts();
			bank.getCustomerList().remove(forRemoval);
		}
	}

	public void removeAllCustomers() {
		for (Customer customer : bank.getCustomerList()) {
			customerLogic.setCustomer(customer);
			customerLogic.removeAllAccounts();
		}

		bank.getCustomerList().clear();
	}

	public double getSum(byte mode) throws Exception {
		double result = 0.0;

		for (Customer customer : bank.getCustomerList()) {
			customerLogic.setCustomer(customer);
			result += customerLogic.getSum(mode);
		}

		return result;
	}

	public String printAllBySort() {
		StringBuilder strCustomerList = new StringBuilder();

		strCustomerList.append("Список клиентов:\n");
		for (Customer customer : bank.getCustomerList()) {
			strCustomerList.append("Счета " + customer.getFullName() + ":\n");
			customerLogic.setCustomer(customer);
			strCustomerList.append(customerLogic.printAllBySort() + "\n");
		}

		return strCustomerList.toString();
	}
}
