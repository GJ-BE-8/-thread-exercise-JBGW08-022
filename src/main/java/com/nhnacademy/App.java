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
        CounterHandler counterHandler = new CounterHandler(10l);
        Thread thread = new Thread(counterHandler);
        log.debug("thread-state:{}",thread.getState());
        thread.setName("my-counter");
        thread.start();
        //thread.join()을 호출 하면 thread가 종료될 때 까지 main thread가 대기하게 됩니다.
        thread.join();

        log.debug("Application exit!");
        log.debug("thread-state:{}",thread.getState());
    }
}