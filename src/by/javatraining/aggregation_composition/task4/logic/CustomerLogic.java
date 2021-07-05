package by.javatraining.aggregation_composition.task4.logic;

import java.util.List;

import by.javatraining.aggregation_composition.task4.entity.Account;
import by.javatraining.aggregation_composition.task4.entity.Customer;
import by.javatraining.aggregation_composition.task4.exception.InvalidValueException;
import by.javatraining.aggregation_composition.task4.exception.NameTakenException;

/*
 * Счета. Клиент может иметь несколько счетов в банке.
 * Учитывать возможность блокировки\разблокировки счета.
 * Реализовать поиск и сортировку счетов.
 * Вычисление общей суммы по счетам. Вычисление суммы по
 * всем счетам, имеющим положительный и отрицательный балансы отдельно.
 */

public class CustomerLogic {

	private static final byte SORT_NUMBER = 0;
	private static final byte SORT_BALANCE_DOWN = 1;
	private static final byte SORT_BALANCE_UP = 2;

	private Customer customer;
	private final AccountNumberComparator numberComparator;
	private final AccountBalanceDownComparator balanceDownComparator;
	private final AccountBalanceUpComparator balanceUpComparator;

	private byte sortMode;

	public CustomerLogic() {
		sortMode = SORT_NUMBER;

		numberComparator = new AccountNumberComparator();
		balanceDownComparator = new AccountBalanceDownComparator();
		balanceUpComparator = new AccountBalanceUpComparator();
	}

	public void setCustomer(Customer customer) {
		if (customer == null) {
			this.customer = new Customer();
		} else {
			this.customer = customer;
		}
	}

	public Account findAccountByNumber(long number) {
		for (Account account : customer.getAccountList()) {
			if (account.getNumber() == number) {
				return account;
			}
		}

		return null;
	}

	private void listInsert(Account accountLink) {
		List<Account> accountList = customer.getAccountList();

		int listSize = accountList.size();
		for (int i = 0; i < listSize; i++) {
			switch (sortMode) {
			case SORT_NUMBER:
				if (accountList.get(i).getNumber() > accountLink.getNumber()) {
					accountList.add(i, accountLink);

					return;
				}
				break;
			case SORT_BALANCE_DOWN:
				if (accountList.get(i).getBalance() < accountLink.getBalance()) {
					accountList.add(i, accountLink);

					return;
				}
				break;
			case SORT_BALANCE_UP:
				if (accountList.get(i).getBalance() > accountLink.getBalance()) {
					accountList.add(i, accountLink);

					return;
				}
				break;
			}
		}

		accountList.add(accountLink);
	}

	public void addAccount(long number) throws NameTakenException {
		if (findAccountByNumber(number) != null) {
			throw new NameTakenException("Счет с таким номером уже существует.");
		} else {
			listInsert(new Account(number));
		}
	}

	public void removeAccount(long number) {
		Account forRemoval;

		forRemoval = findAccountByNumber(number);

		if (forRemoval != null) {
			customer.getAccountList().remove(forRemoval);
		}
	}

	public void removeAllAccounts() {
		customer.getAccountList().clear();
	}

	public void sortByNumber() {
		customer.getAccountList().sort(numberComparator);
	}

	public void sortDownByBalance() {
		customer.getAccountList().sort(balanceDownComparator);
	}

	public void sortUpByBalance() {
		customer.getAccountList().sort(balanceUpComparator);
	}

	public void sortSetMode(byte bMode) throws InvalidValueException {
		if (sortMode == bMode) {
			return;
		}

		switch (bMode) {
		case SORT_NUMBER:
			sortByNumber();
			break;
		case SORT_BALANCE_DOWN:
			sortUpByBalance();
			break;
		case SORT_BALANCE_UP:
			sortUpByBalance();
			break;
		default:
			throw new InvalidValueException("Неизвестное значение режима сортировки.");
		}

		sortMode = bMode;
	}
	
	public void changeBalance(Account account, double changeValue) {
		account.setBalance(account.getBalance() + changeValue);
	}

	public double getSum(byte mode) throws InvalidValueException {
		double result = 0;

		for (Account account : customer.getAccountList()) {
			double tmpD = account.getBalance();
			switch (mode) {
			case 0:
				result += tmpD;
				break;
			case 1:
				if (tmpD > 0)
					result += tmpD;
				break;
			case 2:
				if (tmpD < 0)
					result += tmpD;
				break;
			default:
				throw new InvalidValueException("Неизвестное значение параметра mode.");
			}
		}

		return result;
	}

	public String printAllBySort() {
		StringBuilder strAccountList = new StringBuilder();

		for (Account account : customer.getAccountList()) {
			strAccountList.append("Счет №" + account.getNumber() + " баланс: " + account.getBalance() + "\n");
		}

		return strAccountList.toString();
	}
}
