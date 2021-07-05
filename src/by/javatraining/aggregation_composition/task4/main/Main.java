package by.javatraining.aggregation_composition.task4.main;

import by.javatraining.aggregation_composition.task4.entity.Bank;
import by.javatraining.aggregation_composition.task4.exception.NameTakenException;
import by.javatraining.aggregation_composition.task4.logic.BankLogic;

/*
 * Счета. Клиент может иметь несколько счетов в банке.
 * Учитывать возможность блокировки\разблокировки счета.
 * Реализовать поиск и сортировку счетов.
 * Вычисление общей суммы по счетам. Вычисление суммы по
 * всем счетам, имеющим положительный и отрицательный балансы отдельно.
 */

public class Main {

	public static void main(String[] args) {
		BankLogic bankLogic = new BankLogic();

		bankLogic.setBank(new Bank("АСБ-Банк"));

		try {
			bankLogic.addCustomer("Петрович В.А.");
		} catch (NameTakenException e) {
			System.out.println(e.getMessage());
			return;
		}

		bankLogic.getCustomerLogic().setCustomer(bankLogic.findCustomerByFullName("Петрович В.А."));

		try {
			bankLogic.getCustomerLogic().addAccount(148618);
			bankLogic.getCustomerLogic().addAccount(325841);
			bankLogic.getCustomerLogic().addAccount(155634);
		} catch (NameTakenException e) {
			System.out.println(e.getMessage());
			return;
		}

		bankLogic.getCustomerLogic().findAccountByNumber(148618).setLocked(false);
		bankLogic.getCustomerLogic().findAccountByNumber(325841).setLocked(false);
		bankLogic.getCustomerLogic().findAccountByNumber(155634).setLocked(false);

		bankLogic.getCustomerLogic().changeBalance(bankLogic.getCustomerLogic().findAccountByNumber(148618), 100000);
		bankLogic.getCustomerLogic().changeBalance(bankLogic.getCustomerLogic().findAccountByNumber(325841), -9000);
		bankLogic.getCustomerLogic().changeBalance(bankLogic.getCustomerLogic().findAccountByNumber(155634), 50);

		bankLogic.printAllBySort();
	}
}
