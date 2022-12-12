import java.util.Calendar;

public class AdventCalendar {
    public String[] adventCalendar;
    Calendar cal = Calendar.getInstance();
    int firstDay = cal.get(Calendar.DAY_OF_MONTH);
    static String[] sweets = new String[24];
    static String[] save = new String[24];

    public static void main(String[] args) {
        AdventCalendar c = new AdventCalendar(sweets);
        for (int i = 0; i < 24; i++) {
            save[i] = sweets[i];
        }
        AdventCalendar n = new AdventCalendar(sweets);
        System.out.println(n.openDoor(6));
        System.out.println(n.openDoor(8));
        System.out.println(n.numbersOfUnopenedDoors());
        n.toString();
    }

    /**
     * This constructor distribute different sweets to each day.
     * 
     * @param sweets
     */
    public AdventCalendar(String[] sweets) {
        String[] adventCalendar = new String[24];
        for (int i = 0; i < 24; i++) {
            adventCalendar[i] = "[" + sweets[i] + "]";
        }
        this.adventCalendar = adventCalendar;
    }

    /**
     * This method get today's date.
     * If the date is more than 24, it will return 0.
     * If this month isn't December , it will return 0.
     * 
     * @return Today's date.
     */
    public int getDay() {
        int month = cal.get(Calendar.MONTH) + 1;
        if (month != 12) {
            return 0;
        } else {
            if (this.firstDay <= 24) {
                return this.firstDay;
            } else {
                return 0;
            }
        }
    }

    /**
     * This method returns the result, whether the day can be added.
     * 
     * @return
     */
    public boolean nextDay() {
        int nextDay = getDay() + 1;
        if (nextDay > 24) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * This method returns the result, whether the following days are still before
     * 12.24 .
     * 
     * @param days
     * @return
     */
    public boolean nextDays(int days) {
        int nextDays = getDay() + days;
        if (nextDays > 24) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * This method reset the String sweet.
     */
    public void reset() {
        for (int i = 0; i < 24; i++) {
            sweets[i] = save[i];
        }
    }

    /**
     * This method check whether the door at number can be open or not.
     * If the door can be open, the sweet inside will be returned.
     * Otherwise will "null" be returned.
     * 
     * @param number
     * @return
     */
    public String openDoor(int number) {
        AdventCalendar c = new AdventCalendar(sweets);
        if (number - 1 > getDay() || number - 1 <= 0) {
            return "null";
        } else {
            if (c.adventCalendar[number - 1].equals("[ ]")) {
                return "null";
            } else {
                c.adventCalendar[number - 1] = "[ ]";
                String re = sweets[number - 1];
                sweets[number - 1] = " ";
                return re;
            }
        }
    }

    /**
     * This Method returns the ammount of unopened doors.
     * 
     * @return
     */
    public int numbersOfUnopenedDoors() {
        AdventCalendar c = new AdventCalendar(sweets);
        int k = 0;
        for (int i = 0; i < 24; i++) {
            if (c.adventCalendar[i].equals("[ ]")) {
            } else {
                k++;
            }
        }
        return k;
    }

    /**
     * This method returns the calendar as a String.
     * It also print out the actual calendar.
     */
    public String toString() {
        AdventCalendar c = new AdventCalendar(sweets);
        String out = "";
        for (int i = 0; i < 24; i++) {
            out += c.adventCalendar[i];
        }
        for (int k = 0; k < 24; k++) {
            System.out.print(c.adventCalendar[k]);
            if (k % 4 == 3) {
                System.out.println();
            }
        }
        return out;
    }
}