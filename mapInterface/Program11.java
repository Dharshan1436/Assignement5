package assignment5.mapInterface;

import java.util.*;
import java.util.concurrent.TimeUnit;

class Policy {
	String policyNumber;
	String policyholderName;
	Date expiryDate;
	String coverageType;
	double premiumAmount;

	public Policy(String policyNumber, String policyholderName, Date expiryDate, String coverageType,
			double premiumAmount) {
		this.policyNumber = policyNumber;
		this.policyholderName = policyholderName;
		this.expiryDate = expiryDate;
		this.coverageType = coverageType;
		this.premiumAmount = premiumAmount;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Policy))
			return false;
		Policy other = (Policy) obj;
		return policyNumber.equals(other.policyNumber);
	}

	@Override
	public int hashCode() {
		return Objects.hash(policyNumber);
	}

	@Override
	public String toString() {
		return "Policy [policyNumber=" + policyNumber + ", policyholderName=" + policyholderName + ", expiryDate="
				+ expiryDate + ", coverageType=" + coverageType + ", premiumAmount=" + premiumAmount + "]";
	}

}

class PolicyManager {
	private Map<String, Policy> hashMap = new HashMap<>();
	private Map<String, Policy> linkedHashMap = new LinkedHashMap<>();
	private Map<String, Policy> treeMap = new TreeMap<>(
			Comparator.comparing(policyNumber -> hashMap.get(policyNumber).expiryDate));

	public void addPolicy(Policy policy) {
		hashMap.put(policy.policyNumber, policy);
		linkedHashMap.put(policy.policyNumber, policy);
		treeMap.put(policy.policyNumber, policy);
	}

	public Policy getPolicyByNumber(String policyNumber) {
		return hashMap.get(policyNumber);
	}

	public List<Policy> getPoliciesExpiringSoon() {
		List<Policy> expiringSoon = new ArrayList<>();
		Date today = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(today);
		cal.add(Calendar.DAY_OF_MONTH, 30);
		Date next30Days = cal.getTime();

		for (Policy policy : treeMap.values()) {
			if (policy.expiryDate.before(next30Days)) {
				expiringSoon.add(policy);
			}
		}
		return expiringSoon;
	}

	public List<Policy> getPoliciesByPolicyholder(String policyholderName) {
		List<Policy> holderPolicies = new ArrayList<>();
		for (Policy policy : linkedHashMap.values()) {
			if (policy.policyholderName.equals(policyholderName)) {
				holderPolicies.add(policy);
			}
		}
		return holderPolicies;
	}

	public void removeExpiredPolicies() {
		Date today = new Date();
		hashMap.values().removeIf(policy -> policy.expiryDate.before(today));
		linkedHashMap.values().removeIf(policy -> policy.expiryDate.before(today));
		treeMap.values().removeIf(policy -> policy.expiryDate.before(today));
	}

	public void comparePerformance() {

		long startTime = System.nanoTime();
		for (int i = 0; i < 10000; i++) {
			addPolicy(new Policy("P" + i, "Holder" + i,
					new Date(System.currentTimeMillis() + TimeUnit.DAYS.toMillis(i)), "Coverage" + i, 100.0));
		}
		long endTime = System.nanoTime();
		System.out.println("Time taken to add policies: " + (endTime - startTime) + " ns");

		startTime = System.nanoTime();
		getPolicyByNumber("P5000");
		endTime = System.nanoTime();
		System.out.println("Time taken to retrieve a policy: " + (endTime - startTime) + " ns");

		startTime = System.nanoTime();
		removeExpiredPolicies();
		endTime = System.nanoTime();
		System.out.println("Time taken to remove expired policies: " + (endTime - startTime) + " ns");
	}
}

public class Program11 {
	public static void main(String[] args) {
		PolicyManager manager = new PolicyManager();

		Calendar cal = Calendar.getInstance();
		cal.set(2024, Calendar.OCTOBER, 1);
		manager.addPolicy(new Policy("P001", "Alice", cal.getTime(), "Health", 500.0));

		cal.set(2024, Calendar.NOVEMBER, 15);
		manager.addPolicy(new Policy("P002", "Bob", cal.getTime(), "Auto", 300.0));

		cal.set(2024, Calendar.SEPTEMBER, 15);
		manager.addPolicy(new Policy("P003", "Alice", cal.getTime(), "Home", 400.0));

		System.out.println("Policy P001: " + manager.getPolicyByNumber("P001"));
		System.out.println("Policies expiring soon: " + manager.getPoliciesExpiringSoon().size());
		System.out.println("Policies for Alice: " + manager.getPoliciesByPolicyholder("Alice").size());

		manager.removeExpiredPolicies();
		System.out.println("Expired policies removed.");

		manager.comparePerformance();
	}
}
