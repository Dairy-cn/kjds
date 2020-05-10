package com.cross.utils;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Calendar;

/*************************************************************
 * Description: 雪花算法实现生成相应的编号
 * CreateTime: 2020/2/26
 * Copyright © 成都通吃岛信息技术有限公司 All right reserved
 * @author drr
 ************************************************************/
@Slf4j
@Component
public class SnowflakeKeyGeneratorUtil {
    
    
    public  final long EPOCH;
    
    private  final long SEQUENCE_BITS = 12L;
    
    private  final long WORKER_ID_BITS = 10L;
    
    private  final long SEQUENCE_MASK = (1 << SEQUENCE_BITS) - 1;
    
    private  final long WORKER_ID_LEFT_SHIFT_BITS = SEQUENCE_BITS;
    
    private  final long TIMESTAMP_LEFT_SHIFT_BITS = WORKER_ID_LEFT_SHIFT_BITS + WORKER_ID_BITS;
    
    private  final long WORKER_ID_MAX_VALUE = 1L << WORKER_ID_BITS;
    
    @Value("${keyGenerator.snowflake.workerId}")
    private  long workerId;
    
    @Value("${keyGenerator.snowflake.maxTolerateTime}")
    private  int maxTolerateTimeDifferenceMilliseconds;
    
     {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2019, Calendar.FEBRUARY, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        EPOCH = calendar.getTimeInMillis();
    }
    
    private  byte sequenceOffset;
    
    private  long sequence;
    
    private  long lastMilliseconds;
    
    /**
     * Set work process id.
     *
     * @param workerId work process id
     */
    public  void setWorkerId(final long workerId) {
        if (workerId < 0L || workerId >= WORKER_ID_MAX_VALUE) {
            throw new IllegalArgumentException();
        }
        this.workerId = workerId;
    }
    
    /**
     * Set max tolerate time difference milliseconds.
     *
     * @param maxTolerateTimeDifferenceMilliseconds max tolerate time difference milliseconds
     */
    public  void setMaxTolerateTimeDifferenceMilliseconds(final int maxTolerateTimeDifferenceMilliseconds) {
        this.maxTolerateTimeDifferenceMilliseconds = maxTolerateTimeDifferenceMilliseconds;
    }
    
    
    
    
    /**
     * Generate key.
     *
     * @return key type is @{@link Long}.
     */
    public  synchronized Long generateKey() {
        long currentMilliseconds = System.currentTimeMillis();
        if (waitTolerateTimeDifferenceIfNeed(currentMilliseconds)) {
            currentMilliseconds = System.currentTimeMillis();
        }
        if (lastMilliseconds == currentMilliseconds) {
            if (0L == (sequence = (sequence + 1) & SEQUENCE_MASK)) {
                currentMilliseconds = waitUntilNextTime(currentMilliseconds);
            }
        } else {
            vibrateSequenceOffset();
            sequence = sequenceOffset;
        }
        lastMilliseconds = currentMilliseconds;
        return ((currentMilliseconds - EPOCH) << TIMESTAMP_LEFT_SHIFT_BITS) | (workerId << WORKER_ID_LEFT_SHIFT_BITS) | sequence;
    }
    
    @SneakyThrows
    private  boolean waitTolerateTimeDifferenceIfNeed(final long currentMilliseconds) {
        if (lastMilliseconds <= currentMilliseconds) {
            return false;
        }
        long timeDifferenceMilliseconds = lastMilliseconds - currentMilliseconds;
        if (timeDifferenceMilliseconds >= maxTolerateTimeDifferenceMilliseconds) {
            log.error(String.format("Clock is moving backwards, last time is %d milliseconds, current time is %d milliseconds", lastMilliseconds, currentMilliseconds));
        }
        Thread.sleep(timeDifferenceMilliseconds);
        return true;
    }
    
    private  long waitUntilNextTime(final long lastTime) {
        long result = System.currentTimeMillis();
        while (result <= lastTime) {
            result = System.currentTimeMillis();
        }
        return result;
    }
    
    private   void vibrateSequenceOffset() {
        sequenceOffset = (byte) (~sequenceOffset & 1);
    }
    
}
