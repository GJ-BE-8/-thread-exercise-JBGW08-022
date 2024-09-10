/*
 * +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
 * + Copyright 2024. NHN Academy Corp. All rights reserved.
 * + * While every precaution has been taken in the preparation of this resource,  assumes no
 * + responsibility for errors or omissions, or for damages resulting from the use of the information
 * + contained herein
 * + No part of this resource may be reproduced, stored in a retrieval system, or transmitted, in any
 * + form or by any means, electronic, mechanical, photocopying, recording, or otherwise, without the
 * + prior written permission.
 * +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
 */

package com.nhnacademy.thread;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Counter {
    private final long countMaxSize;
    private long count;

    public Counter(long countMaxSize) {
        if(countMaxSize < 0){
            throw new IllegalArgumentException();
        }

        this.countMaxSize = 0;

        this.count = 0;

    }

    public void run() throws InterruptedException {

        do {

            /*
              Thread.sleep method를 사용하세요.
              https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/lang/Thread.html#sleep(java.time.Duration)
            */
            Thread.sleep(1000);

            count++;

            /*
                name:{Thread name}, count:{count 변수}
                Thread name : Thread.currentThread().getName();
                ex) name:my-thread, count:1
             */

            log.info("name:{}, count:{}", Thread.currentThread().getName(), this.count);

        }while (count<countMaxSize);
    }
}
