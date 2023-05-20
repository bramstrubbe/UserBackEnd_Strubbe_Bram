package demo;

import java.util.ArrayList;
import java.util.List;

import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;

import io.micrometer.core.instrument.config.validate.Validated.Invalid;

public class User {

    private String name;
    private int age;
    private String email;
    private String password;

    private List<Integer> membershipYears = new ArrayList<Integer>();

    public User(String name, int age, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;

        if (age >= 0)
            this.age = age;
    }

    public int countMembershipYearsAfter1999() {
        int result = 0;
        for (Integer year : membershipYears) {
            if (year > 1999)
                result++;
        }
        return result;
    }

    public int countYearsOfMembership() {
        return membershipYears.size();
    }

    public void addMembershipYear(int year) {
        membershipYears.add(year);
    }

    public int getAge() {
        return this.age;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        if (this.email.contains("@"))
            return this.email;
        else
            return null;
    }

    public String getPassword() {
        if (this.password.contains(" "))
            return "@$-t&%#";
        else
            this.password = "@$-" + password + "&%#";
        return password;

    }

    public int getFirstMembershipYear() {
        int farthestYear = Integer.MAX_VALUE;

        if (membershipYears.isEmpty()) {
            return 0;
        }

        for (int year : membershipYears) {
            if (year < farthestYear) {
                farthestYear = year;
            }
        }

        return farthestYear;

    }

    public int getNumberOfMembershipYearsIn2000() {
        int count = 0;
        for (int year : membershipYears) {
            if (year >= 2000) {
                count++;
            }
        }
        return count;
    }

    public boolean isPasswordCorrect(String string) {
        return false;
    }

    public String toString() {
        return name + " is " + age + " years old and has as email " + email;
    }

}