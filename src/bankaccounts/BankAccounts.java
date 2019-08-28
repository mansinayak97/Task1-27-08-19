
package bankaccounts;

import static java.lang.System.out;


public class BankAccounts {

        private String accNo,accType,name;
        private int balance,withAmt=0,depoAmt=0;
        private static int totalWithdrawl;
        private static int totalDeposit ;
        
        public BankAccounts()
        {
            
        }
        
        public BankAccounts(String aNo,String type,String nme,int bal)
        {
            accNo=aNo;
            accType=type;
            name=nme;
            balance=bal;
        }
        public static void main(String[] args) {
        
            BankAccounts cust1=new BankAccounts();
            BankAccounts cust2=new BankAccounts();
            BankAccounts cust3=new BankAccounts("sbi3","current","xyz",3000);
            
            cust1.setDetails("sbi1", "savings", "abc", 1000);
            cust1.showDetails();
            
            cust2.setDetails("sbi2", "savings", "pqr", 2000);
            cust2.showDetails();
            
            cust1.withdraw(500);
            cust3.deposit(500);
            
            totalTrans();
            
            cust1.accTrans();
            cust2.accTrans();
            cust3.accTrans();
            
            avgBalance(cust1,cust2,cust3);
            
         }
        
        
    
        void setDetails(String aNo,String aType,String nm,int bal)
        {
            accNo=aNo;
            accType=aType;
            name=nm;
            balance=bal;
        }
        
        void showDetails()
        {
            out.println("Customer Details:");
            out.println("Account no="+accNo+ " ,Type="+accType+ " ,Customer Name="+name+" ,balance="+balance);
        }
        
        void withdraw(int wAmt)
        {
            if(wAmt<balance){
            balance=balance-wAmt;
            totalWithdrawl+=wAmt;
            withAmt=withAmt+wAmt;
            out.println("Amount Withdrawn: " +wAmt);
            out.println("Balance after Withdraw: " +balance);
        }
        else
            out.println("Insufficient balance");
        }
        
        void deposit(int dAmt)
        {
            balance=balance+dAmt;
            totalDeposit=totalDeposit+dAmt;
            depoAmt=depoAmt+dAmt;
            out.println("Amount Deposited: " +dAmt);
            out.println("Balance after Deposit: " +balance);
        }
        
        static void totalTrans()
        {
            out.println("Total withdrawl of the day: "+totalWithdrawl);
            out.println("Total deposit of the day: "+totalDeposit);
        }
        
        void accTrans()
        {
            out.println("Total Account Withdrawl for "+name +": "+withAmt);
            out.println("Total Account Deposit for "+name +": "+depoAmt);
        }
        
        static void avgBalance(BankAccounts...ba)
        {
            int sum=0;
            for(BankAccounts b:ba)
            {
                sum+=b.balance;
            }
            float avgBal;
            avgBal=sum/ba.length;
            out.println("Average balance: "+avgBal);
        }
        
}
