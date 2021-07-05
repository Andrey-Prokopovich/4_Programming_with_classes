package by.javatraining.aggregation_composition.task4.logic;

import java.util.Comparator;

import by.javatraining.aggregation_composition.task4.entity.Account;

/*
 * Счета. Клиент может иметь несколько счетов в банке.
 * Учитывать возможность блокировки\разблокировки счета.
 * Реализовать поиск и сортировку счетов.
 * Вычисление общей суммы по счетам. Вычисление суммы по
 * всем счетам, имеющим положительный и отрицательный балансы отдельно.
 */

public class AccountBalanceUpComparator implements Comparator<Account> {

	@Override
	public int compare(Account account1, Account account2) {
		if (account1.getBalance() > account2.getBalance()) {
			return 1;
		} else if (account1.getBalance() < account2.getBalance()) {
			return -1;
		} else {
			return 0;
		}
	}
}
