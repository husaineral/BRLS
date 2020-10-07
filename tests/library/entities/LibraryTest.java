package library.entities;

import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {
    private double FINE_PER_DAY=1.0;
    private Date dueDate;

    @Test
void testCalculateOverDueFine()
    {
        double fine = 0.0;
        Date currentDate=Calendar.getInstance().getDate();
        dueDate=new Date ( currentDate.getTime() + TimeUnit.DAYS.toMillis(-1));
        long daysOverDue = Calendar.getInstance().getDaysDifference(dueDate);
        fine = daysOverDue * FINE_PER_DAY;
        assertNotEquals(1,fine);
    }


    @Test
    void testCalculateOverDueFineIsHalf()
    {
        double fine = 0.0;
        Date currentDate=Calendar.getInstance().getDate();
        dueDate=new Date ( currentDate.getTime() + TimeUnit.DAYS.toMillis(-4));
        System.out.println("Current Date :+"+ currentDate);
        System.out.println("Due Date :"+ dueDate);

        long daysOverDue = Calendar.getInstance().getDaysDifference(dueDate);
        fine = daysOverDue * FINE_PER_DAY;
        System.out.println("Expected Fine $4" );
        System.out.println("Actual Fine $  " + fine);
        assertNotEquals(4,fine);
    }
}

