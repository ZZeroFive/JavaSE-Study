package ml.java.se.oob;

import java.text.MessageFormat;
import java.util.Locale;

public class JavaMessageFormatDemo {

    public static void main(String[] args) {

        String fmt = "hello {0}, I am {1}";
        MessageFormat mf = new MessageFormat(fmt, Locale.SIMPLIFIED_CHINESE);

        String [] args0 = new String[]{"bob", "jery"};
        System.out.println(mf.format(args0));
    }
}
