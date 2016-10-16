package lambda_function;

import java.util.Arrays;
import java.util.Currency;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

class Transaction {

    private Currency currency;
    private double amount;
    private String bankName;
    private String bankCode;

    public Transaction(Currency currency, double amount, String bankName, String bankCode) {
        this.currency = currency;
        this.amount = amount;
        this.bankName = bankName;
        this.bankCode = bankCode;
    }

    public Currency getCurrency() {
        return currency;
    }

    public double getAmount() {
        return amount;
    }

    public String getBankName() {
        return bankName;
    }

    public String getBankCode() {
        return bankCode;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "currency='" + currency + '\'' +
                ", amount=" + amount +
                ", bankName='" + bankName + '\'' +
                ", bankCode='" + bankCode + '\'' +
                '}';
    }

}

public class LambdaFunction {

    public static void main(String[] args) {
        LambdaFunction lambdaFunction = new LambdaFunction();
        lambdaFunction.testStreamAPI();
        lambdaFunction.testParallelStreamAPI();
    }

    public void testStreamAPI() {
        List<Transaction> transactionList = getTransactionList();
        Map<Currency, List<Transaction>> transactionByCurrencies = transactionList.stream()
                .filter(transaction -> transaction.getAmount() < 1000)
                .collect(groupingBy(Transaction::getCurrency));
        System.out.println("LambdaFunction.testStreamAPI::"+transactionByCurrencies.keySet()+"="+transactionByCurrencies.values());

    }

    public void testParallelStreamAPI() {
        List<Transaction> transactionList = getTransactionList();
        Map<Currency, List<Transaction>> transactionByCurrencies = transactionList.parallelStream()
                .filter(transaction -> transaction.getAmount() < 1000)
                .collect(groupingBy(Transaction::getCurrency));
        System.out.println("LambdaFunction.testParallelStreamAPI::"+transactionByCurrencies.keySet()+"="+transactionByCurrencies.values());

    }

    public void testFilterAPI() {
        List<Transaction> transactionList = getTransactionList();


    }


    public  static List<Transaction> getTransactionList() {
        Transaction hsbcTransaction = new Transaction(Currency.getInstance("GBP"), 2000.00, "HSBC", "HS56785");
        Transaction santanderTransaction = new Transaction(Currency.getInstance("GBP"), 4500.00, "SANTANDER", "ST56785");
        Transaction lyodsTransaction = new Transaction(Currency.getInstance("AUD"), 500.00, "LYODS", "LT56785");
        Transaction hotelTransaction = new Transaction(Currency.getInstance("USD"), 50.00, "HOTEL", "HT56785");
        return Arrays.asList(hsbcTransaction,santanderTransaction,lyodsTransaction,hotelTransaction);


    }
}

