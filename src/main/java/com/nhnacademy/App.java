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

package com.nhnacademy;

import com.nhnacademy.count.SharedCounter;
import com.nhnacademy.thread.CounterIncreaseHandler;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class App 
{

    public static void main( String[] args ) throws InterruptedException
    {

        SharedCounter sharedCounter = new SharedCounter(0);

        CounterIncreaseHandler counterIncreaseHandler = new CounterIncreaseHandler(sharedCounter);

        Thread threadA = new Thread(counterIncreaseHandler);

        threadA.setName("thread-A");
        threadA.start();


        Thread threadB = new Thread(counterIncreaseHandler);
        threadB.setName("thread-B");
        threadB.start();
        Thread.sleep(20000);
        threadA.interrupt();
        threadB.interrupt();

        Thread.yield();

        log.debug("System exit!");
    }
}
