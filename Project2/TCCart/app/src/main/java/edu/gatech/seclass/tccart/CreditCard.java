package edu.gatech.seclass.tccart;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.SimpleTimeZone;

/**
 * Created by ddersch on 3/24/16.
 */
public class CreditCard {
    // Everett#Scott#4224876949325382#12312015#000


    private String firstName;
    private String lastName;
    private String ccNumber;
    private Date expirationDate;
    private String securityCode;


    public static CreditCard Parse(String ccStr) {

        String[] fields = ccStr.split("#");
        String dateString = fields[3];

        Date expirationDate;

        DateFormat df = new SimpleDateFormat("mmddyyyy");
        try {
            expirationDate = df.parse(dateString);
        } catch (ParseException e) {
            expirationDate = Calendar.getInstance().getTime();
        }


        return new CreditCard(fields[1], fields[0], fields[2], expirationDate, fields[4]);
    }

    private CreditCard(String firstName, String lastName, String ccNumber, Date expirationDate, String securityCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ccNumber = ccNumber;
        this.expirationDate = expirationDate;
        this.securityCode = securityCode;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCcNumber() {
        return ccNumber;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public String getSecurityCode() {
        return securityCode;
    }
}
