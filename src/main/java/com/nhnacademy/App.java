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

import com.nhnacademy.thread.CounterHandler;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class App
{
    public static void main( String[] args ) throws InterruptedException
    {
        CounterHandler counterHandlerA = new CounterHandler(10);
        Thread threadA = new Thread(counterHandlerA);
        threadA.setName("my-counter-A");

        log.debug("threadA-state:{}",threadA.getState());

        CounterHandler counterHandlerB = new CounterHandler(10);
        Thread threadB = new Thread(counterHandlerB);
        threadB.setName("my-counter-B");

        log.debug("threadB-state:{}",threadB.getState());
        threadA.start();
        threadA.join();
        log.debug("threadA-state:{}",threadA.getState());

        threadB.start();
        threadB.join();
        log.debug("threadB-state:{}",threadB.getState());
        
        log.debug("Application exit!");

    }
}