package com.wiley.beginning.spring.ch2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccountDaoInMemoryImpl implements AccountDao {

	private Map<Long, Account> accountsMap = new HashMap<>();
	
	{
		Account account1 = new Account();
		account1.setId(1L);
		account1.setOwnerName("John");
		account1.setBalance(10.0);
		Account account2 = new Account();
		account2.setId(2L);
		account2.setOwnerName("Mary");
		account2.setBalance(20.0);
		accountsMap.put(account1.getId(), account1);
		accountsMap.put(account2.getId(), account2);
	}

	public void insert(Account account) {
		accountsMap.put(account.getId(), account);
	}

	public void update(Account account) {
		accountsMap.put(account.getId(), account);
	}

	public void update(List<Account> accounts) {
		accounts.forEach(account -> {
			update(account);
		});
	}

	public void delete(long accountId) {
		accountsMap.remove(accountId);
	}

	public Account find(long accountId) {
		return accountsMap.get(accountId);
	}

	public List<Account> find(List<Long> accountIds) {
		List<Account> accounts = new ArrayList<>();
		accountIds.forEach(id -> {
			find(id);
		});
		return accounts;
	}

	public List<Account> find(String ownerName) {
		List<Account> accounts = new ArrayList<>();
		
		accountsMap.forEach((k,v) -> {
			if (v.getOwnerName().equals(ownerName)) {
				accounts.add(v);
			}
		});
		
		return accounts;
	}

	public List<Account> find(boolean locked) {
		List<Account> accounts = new ArrayList<>();
		
		accountsMap.forEach((k,v) -> {
			if (locked == v.isLocked()) {
				accounts.add(v);
			}
		});
		
		return accounts;
	}

}
