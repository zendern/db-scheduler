package com.github.kagkarlsson.scheduler;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ThreadLength {

    ExecutorService executorService = Executors.newFixedThreadPool(10, r -> {
        final Thread thread = new Thread(r);
        thread.setName(RandomStringUtils.randomAlphabetic(150));
        return thread;
    });

    private static final Logger log = LoggerFactory.getLogger(ThreadLength.class);

    @Test
    public void testThreadNameLength(){
        executorService.execute(() -> log.error("DO IT>>>"));
        executorService.execute(() -> log.error("DO IT>>>"));
        executorService.execute(() -> log.error("DO IT>>>"));
    }
}
