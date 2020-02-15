package com.my.algorithm;

public class RetryDemo {

    //最大延迟时间间隔，单位是毫秒
    private static int MAX_WAIT_INTERVAL = 100*1000;

    //最大重试次数
    private static int MAX_RETRIES = 3;

    public enum Results {
        SUCCESS,
        NOT_READY,
        THROTTLED,
        SERVER_ERROR
    }

    public static void main(String[] args){
        doOperationAndWaitForResult();
    }

    //指数退避算法
    public static void doOperationAndWaitForResult(){
        try{
            int retries = 0;
            boolean retry = false;
            do {
                long waitTime = Math.min(getWaitTimeExp(retries), MAX_WAIT_INTERVAL);
                System.out.print("等待时间：" + waitTime + "  ms \n");

                //Wait for the result
                Thread.sleep(waitTime);

                //Get the result of the asynchronous operation
                Results results = getAsyncOperationResult();
                if (Results.SUCCESS == results){
                    retry = false;
                }else if (Results.NOT_READY == results || Results.THROTTLED == results
                        || Results.SERVER_ERROR == results){
                    retry = true;
                }else {
                    retry = false;
                }
            }while (retry && (retries ++ < MAX_RETRIES));
        }catch (Exception e){
        }
    }

    public static Results getAsyncOperationResult(){
        return Results.SERVER_ERROR;
    }

    /**
     * 根据重试的次数，返回2的指数的等待时间
     * @param retryCount
     * @return
     */
    public static long getWaitTimeExp(int retryCount){
        long waitTime = ((long) Math.pow(2, retryCount) * 100L);
        return waitTime;
    }
}
