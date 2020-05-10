package com.cross.utils;

import com.cross.enumtype.CycleType;

/*************************************************************
 * Description: 
 * Author: Dairy
 * CreateTime: 2019/8/2
 ************************************************************/


public class CycleTypeTODayUtil {


    public static Integer CycleTypeTODay(CycleType cycleType) {
        Integer day = null;

        switch (cycleType) {
            case DAY:
                day = 1;
                break;
            case WEEK:
                day = 7;
                break;
            case YEAR:
                day = 365;
                break;
            case MONTH:
                day = 30;
                break;
            case HALF_YEAR:
                day = 182;
                break;
            case HALF_MONTH:
                day = 15;
                break;
        }
        return day;


    }
}
