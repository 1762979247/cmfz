package com.baizhi.cmfz.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SnowUtil {
	
	/**
	 * Twitter_Snowflake<br>
	 * SnowFlake�Ľṹ����(ÿ������-�ֿ�):<br>
	 * 0 - 0000000000 0000000000 0000000000 0000000000 0 - 00000 - 00000 - 000000000000 <br>
	 * 1λ��ʶ������long����������Java���Ǵ����ŵģ����λ�Ƿ���λ��������0��������1������idһ�������������λ��0<br>
	 * 41λʱ���(���뼶)��ע�⣬41λʱ��ز��Ǵ洢��ǰʱ���ʱ��أ����Ǵ洢ʱ��صĲ�ֵ����ǰʱ��� - ��ʼʱ���)
	 * �õ���ֵ��������ĵĿ�ʼʱ��أ�һ�������ǵ�id��������ʼʹ�õ�ʱ�䣬�����ǳ�����ָ���ģ������������IdWorker���startTime���ԣ���41λ��ʱ��أ�����ʹ��69�꣬��T = (1L << 41) / (1000L * 60 * 60 * 24 * 365) = 69<br>
	 * 10λ�����ݻ���λ�����Բ�����1024���ڵ㣬����5λdatacenterId��5λworkerId<br>
	 * 12λ���У������ڵļ�����12λ�ļ���˳���֧��ÿ���ڵ�ÿ����(ͬһ������ͬһʱ���)����4096��ID���<br>
	 * �������պ�64λ��Ϊһ��Long�͡�<br>
	 * SnowFlake���ŵ��ǣ������ϰ���ʱ���������򣬲��������ֲ�ʽϵͳ�ڲ������ID��ײ(����������ID�ͻ���ID������)������Ч�ʽϸߣ������ԣ�SnowFlakeÿ���ܹ�����26��ID���ҡ�
	 */

	    // ==============================Fields===========================================
	    /** ��ʼʱ��� (2018-01-01) */
	    private final long twepoch = 1527211233000L;

	    /** ����id��ռ��λ�� */
	    private final long workerIdBits = 5L;

	    /** ���ݱ�ʶid��ռ��λ�� */
	    private final long datacenterIdBits = 5L;

	    /** ֧�ֵ�������id�������31 (�����λ�㷨���Ժܿ�ļ������λ�����������ܱ�ʾ�����ʮ������) */
	    private final long maxWorkerId = -1L ^ (-1L << workerIdBits);

	    /** ֧�ֵ�������ݱ�ʶid�������31 */
	    private final long maxDatacenterId = -1L ^ (-1L << datacenterIdBits);

	    /** ������id��ռ��λ�� */
	    private final long sequenceBits = 12L;

	    /** ����ID������12λ */
	    private final long workerIdShift = sequenceBits;

	    /** ���ݱ�ʶid������17λ(12+5) */
	    private final long datacenterIdShift = sequenceBits + workerIdBits;

	    /** ʱ���������22λ(5+5+12) */
	    private final long timestampLeftShift = sequenceBits + workerIdBits + datacenterIdBits;

	    /** �������е����룬����Ϊ4095 (0b111111111111=0xfff=4095) */
	    private final long sequenceMask = -1L ^ (-1L << sequenceBits);

	    /** ��������ID(0~31) */
	    private long workerId;

	    /** ��������ID(0~31) */
	    private long datacenterId;

	    /** ����������(0~4095) */
	    private long sequence = 0L;

	    /** �ϴ�����ID��ʱ��� */
	    private long lastTimestamp = -1L;

	    //==============================Constructors=====================================
	    /**
	     * ���캯��
	     * @param workerId ����ID (0~31)
	     * @param datacenterId ��������ID (0~31)
	     */
	    public SnowUtil(long workerId, long datacenterId) {
	        if (workerId > maxWorkerId || workerId < 0) {
	            throw new IllegalArgumentException(String.format("worker Id can't be greater than %d or less than 0", maxWorkerId));
	        }
	        if (datacenterId > maxDatacenterId || datacenterId < 0) {
	            throw new IllegalArgumentException(String.format("datacenter Id can't be greater than %d or less than 0", maxDatacenterId));
	        }
	        this.workerId = workerId;
	        this.datacenterId = datacenterId;
	    }

	    // ==============================Methods==========================================
	    /**
	     * �����һ��ID (�÷������̰߳�ȫ��)
	     * @return SnowflakeId
	     */
	    public synchronized long nextId() {
	        long timestamp = timeGen();

	        //�����ǰʱ��С����һ��ID���ɵ�ʱ�����˵��ϵͳʱ�ӻ��˹����ʱ��Ӧ���׳��쳣
	        if (timestamp < lastTimestamp) {
	            throw new RuntimeException(
	                    String.format("Clock moved backwards.  Refusing to generate id for %d milliseconds", lastTimestamp - timestamp));
	        }

	        //�����ͬһʱ�����ɵģ�����к���������
	        if (lastTimestamp == timestamp) {
	            sequence = (sequence + 1) & sequenceMask;
	            //�������������
	            if (sequence == 0) {
	                //��������һ������,����µ�ʱ���
	                timestamp = tilNextMillis(lastTimestamp);
	            }
	        }
	        //ʱ����ı䣬��������������
	        else {
	            sequence = 0L;
	        }

	        //�ϴ�����ID��ʱ���
	        lastTimestamp = timestamp;

	        //��λ��ͨ��������ƴ��һ�����64λ��ID
	        return ((timestamp - twepoch) << timestampLeftShift) //
	                | (datacenterId << datacenterIdShift) //
	                | (workerId << workerIdShift) //
	                | sequence;
	    }

	    /**
	     * ��������һ�����룬ֱ������µ�ʱ���
	     * @param lastTimestamp �ϴ�����ID��ʱ���
	     * @return ��ǰʱ���
	     */
	    protected long tilNextMillis(long lastTimestamp) {
	        long timestamp = timeGen();
	        while (timestamp <= lastTimestamp) {
	            timestamp = timeGen();
	        }
	        return timestamp;
	    }

	    /**
	     * �����Ժ���Ϊ��λ�ĵ�ǰʱ��
	     * @return ��ǰʱ��(����)
	     */
	    protected long timeGen() {
	        return System.currentTimeMillis();
	    }

	    //==============================Test=============================================
	    /** ���� 
	     * @throws ParseException */
	    public static void main(String[] args) throws ParseException {
	    	String res;
	    	String s = "2018-01-01 00:00:00";
	        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	        Date date = simpleDateFormat.parse(s);
	        long ts = date.getTime();
	        res = String.valueOf(ts);
	       /* System.out.println(res);*/
	        SnowUtil idWorker = new SnowUtil(0, 0);
	        for (int i = 0; i < 100; i++) {
	            long id = idWorker.nextId();
	            /*System.out.println(Long.toBinaryString(id));*/
	            System.out.println(id);
	        }
	    }
	}

