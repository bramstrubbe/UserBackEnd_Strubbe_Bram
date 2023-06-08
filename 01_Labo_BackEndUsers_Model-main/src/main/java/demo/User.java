package demo;

import java.util.ArrayList;
import java.util.List;

public class User {

    private String name;
    private int age;
    private String email;
    private String password;

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        User otherUser = (User) obj;
        return name.equals(otherUser.name) &&
               age == otherUser.age &&
               email.equals(otherUser.email);
    }

    public static void main(String[] args) {
        User bert = new User("Bert", 20, "bert@ucll.be", "abc");
        bert.addMembershipYear(2000);
        User bertII = new User("Bert", 20, "bert@ucll.be", "abc");
        bertII.addMembershipYear(2001);
        User bertIII = new User("Bert", 20, "bert@ucll.be", "xyz");
        bertIII.addMembershipYear(2003);
        User chris = new User("Chris", 20, "bert@ucll.be", "abc");
        chris.addMembershipYear(2000);

        System.out.println(bert.equals(bertII));    // returns true
        System.out.println(bert.equals(bertIII));   // returns true
        System.out.println(bert.equals(chris));     // returns false
    }

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
            if (year >= 2000 && year < 3000) {
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