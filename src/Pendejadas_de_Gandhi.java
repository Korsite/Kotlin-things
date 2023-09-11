import java.sql.SQLOutput;
import java.text.Format;
import java.text.NumberFormat;
import java.time.Period;
import java.util.Scanner;

public class Pendejadas_de_Gandhi {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        double principal = 0;
        float annual = 0F;
        int period = 0;

        while(true){
            System.out.print("Principal ($1K - $1M): ");
            principal = scanner.nextInt();

            if (principal >= 1_000 && principal <=1_000_000)
                break;
            System.out.println("Enter a number between 1,000 and 1,000,000");
        }

        while(true){
            System.out.print("Annual Interest Rate: ");
            annual = scanner.nextFloat();

            if(annual > 0 && annual <=30)
                break;

            System.out.print("Enter a value more than 0 or less than or equal to 30.\n");
        }

        while(true){
            System.out.print("Period (years): ");
            period = scanner.nextInt();
            if (period > 0 && period <=30)
                break;

            System.out.println("Enter a valur between 1 and 30");
        }

        float annual_month = annual / 12 / 100;
        int period_month = period / 12;

        double mortgage = principal * ((annual_month * (Math.pow((1 + annual_month), period_month)))/
                                        (Math.pow((1 + annual_month), period_month) - 1));
        NumberFormat currency =  NumberFormat.getCurrencyInstance();
        System.out.println("Mortage: " + currency.format(mortgage));


    }
}
