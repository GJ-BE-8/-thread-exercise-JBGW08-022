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

import com.nhnacademy.count.SharedCounter;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

@Slf4j
public class CounterIncreaseHandler implements Runnable {
    private final SharedCounter sharedCounter;

    public CounterIncreaseHandler(SharedCounter sharedCounter) {
        if(Objects.isNull(sharedCounter)){
            throw new IllegalArgumentException();
        }
        this.sharedCounter = sharedCounter;
    }

    @Override
    public void run() {
        while( !Thread.interrupted()  ) {
            try {
                Thread.sleep(1000);
                long count = sharedCounter.increaseAndGet();

                log.debug("thread:{}, count:{}", Thread.currentThread().getName(), count);
            } catch (Exception e) {
                log.debug("{} - interrupt!",Thread.currentThread().getName());
                Thread.currentThread().interrupt();
            }
        }
    }

}
