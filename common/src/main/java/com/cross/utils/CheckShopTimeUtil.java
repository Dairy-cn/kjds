package com.cross.utils;

/*************************************************************
 * Description: 验证营业时间
 * Author: Dairy
 * CreateTime: 2019/6/13
 ************************************************************/
public class CheckShopTimeUtil {


    /**
     * 验证startShopTime是否小于endShopTime 格式:04:52-12:00
     * @param startShopTime
     * @param endShopTime
     * @return
     */
    public static boolean checkShopTime(String startShopTime, String endShopTime) {


        String startHoursShopTime = startShopTime.substring(0, startShopTime.lastIndexOf(":"));


        String endHoursShopTime = endShopTime.substring(0, endShopTime.lastIndexOf(":"));

        String startMinuteShopTime = startShopTime.substring(startShopTime.lastIndexOf(":")+1, startShopTime.length());
        String endMinuteShopTime = endShopTime.substring(endShopTime.lastIndexOf(":")+1, endShopTime.length());
        if (Integer.valueOf(startHoursShopTime) > Integer.valueOf(endHoursShopTime)) {
            return false;
        } else if (Integer.valueOf(startHoursShopTime).equals(Integer.valueOf(endHoursShopTime))) {
            if (Integer.valueOf(startMinuteShopTime) >= Integer.valueOf(endMinuteShopTime)) {
                return false;
            }
        }
        return true;

    }


    /**
     *  验证多个时间段之间是否有包含关系：如 ：9:00-12:30, 8:00-9:00 具有包含关系，不正确
     * @param arrStr
     * @return
     */
    public static Boolean checkTimeContain(String[] arrStr){
        for(int i= 0; i< arrStr.length-1;i ++){
            String timeString = arrStr[i];
            String startShopTime = timeString.substring(0, timeString.lastIndexOf("-"));
            String endShopTime = timeString.substring(timeString.lastIndexOf("-") + 1, timeString.length());
            Long startHoursShopTime = Long.parseLong(startShopTime.substring(0, startShopTime.lastIndexOf(":")));
            Long endHoursShopTime = Long.parseLong(endShopTime.substring(0, endShopTime.lastIndexOf(":")));
            Long startMinuteShopTime = Long.parseLong(startShopTime.substring(startShopTime.lastIndexOf(":")+1, startShopTime.length()));
            Long endMinuteShopTime = Long.parseLong(endShopTime.substring(endShopTime.lastIndexOf(":")+1, endShopTime.length()));

            for (int j = i+1;j<arrStr.length;j++){
                String next = arrStr[j];
                String nextStartShopTime = next.substring(0, next.lastIndexOf("-"));
                String nextEndShopTime = next.substring(next.lastIndexOf("-") + 1, next.length());
                Long nextStartHoursShopTime = Long.parseLong(nextStartShopTime.substring(0, nextStartShopTime.lastIndexOf(":")));
                Long nextEndHoursShopTime = Long.parseLong(nextEndShopTime.substring(0, nextEndShopTime.lastIndexOf(":")));
                Long nextStartMinuteShopTime = Long.parseLong(nextStartShopTime.substring(nextStartShopTime.lastIndexOf(":")+1, nextStartShopTime.length()));
                Long nextEndMinuteShopTime = Long.parseLong(nextEndShopTime.substring(nextEndShopTime.lastIndexOf(":")+1, nextEndShopTime.length()));

                if (nextStartHoursShopTime < startHoursShopTime || nextStartHoursShopTime.equals(startHoursShopTime)){
                    if (nextEndHoursShopTime > startHoursShopTime){
                        return Boolean.TRUE;
                    }else if (nextEndHoursShopTime.equals(startHoursShopTime)){
                        if (nextEndMinuteShopTime > startMinuteShopTime){
                            return Boolean.TRUE;
                        }
                    }
                }else{
                    if (nextStartHoursShopTime < endHoursShopTime){
                        return Boolean.TRUE;
                    }else if (nextStartHoursShopTime.equals(endHoursShopTime)){
                        if (nextStartMinuteShopTime < endMinuteShopTime){
                            return Boolean.TRUE;
                        }
                    }
                }

            }
        }
        return Boolean.FALSE;
    }
}
