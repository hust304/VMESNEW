package com.yvan.druid;

import com.alibaba.druid.filter.FilterEventAdapter;
import com.alibaba.druid.proxy.jdbc.StatementProxy;
import com.codahale.metrics.Counter;
import com.codahale.metrics.Meter;
import com.codahale.metrics.Timer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class JdbcMetric extends FilterEventAdapter implements ApplicationContextAware {

    private static final Logger LOGGER = LoggerFactory.getLogger(JdbcMetric.class);

    private static boolean isInited = false;
    private static Counter jdbcCount;
    private static Timer jdbcExecuteTime;
    private static Meter jdbc;
    private static Counter jdbcConcurrency;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        jdbcCount = applicationContext.getBean("jdbcCount", Counter.class);
        //metricsResponseSizes = applicationContext.getBean("metricsResponseSizes", Histogram.class);
        jdbcExecuteTime = applicationContext.getBean("jdbcExecuteTime", Timer.class);
        jdbc = applicationContext.getBean("jdbc", Meter.class);
        jdbcConcurrency = applicationContext.getBean("jdbcConcurrency", Counter.class);

        isInited = true;
    }

    @Override
    protected void statementExecuteBefore(StatementProxy statement, String sql) {
        if (isInited) {
            jdbc.mark();
            jdbcConcurrency.inc();
            jdbcCount.inc();
        }
        super.statementExecuteBefore(statement, sql);
    }

    @Override
    protected void statementExecuteAfter(StatementProxy statement, String sql, boolean result) {
        super.statementExecuteAfter(statement, sql, result);
        if (isInited) {
            statement.setLastExecuteTimeNano();
            jdbcExecuteTime.update(new Double(statement.getLastExecuteTimeNano()).longValue(), TimeUnit.NANOSECONDS);
            jdbcConcurrency.dec();
        }
    }
}
