/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.camel.model.springboot;
/**
 * Hystrix Circuit Breaker EIP configuration
 * 
 * Generated by camel-package-maven-plugin - do not edit this file!
 */
public class HystrixConfigurationDefinitionCommon {

    /**
     * Sets the group key to use. The default value is CamelHystrix.
     */
    private String groupKey = "CamelHystrix";
    /**
     * Sets the thread pool key to use. Will by default use the same value as
     * groupKey has been configured to use.
     */
    private String threadPoolKey = "CamelHystrix";
    /**
     * Whether to use a HystrixCircuitBreaker or not. If false no
     * circuit-breaker logic will be used and all requests permitted. This is
     * similar in effect to circuitBreakerForceClosed() except that continues
     * tracking metrics and knowing whether it should be open/closed this
     * property results in not even instantiating a circuit-breaker.
     */
    private Boolean circuitBreakerEnabled = true;
    /**
     * Error percentage threshold (as whole number such as 50) at which point
     * the circuit breaker will trip open and reject requests. It will stay
     * tripped for the duration defined in
     * circuitBreakerSleepWindowInMilliseconds; The error percentage this is
     * compared against comes from HystrixCommandMetrics.getHealthCounts().
     */
    private Integer circuitBreakerErrorThresholdPercentage = 50;
    /**
     * If true the HystrixCircuitBreakerallowRequest() will always return true
     * to allow requests regardless of the error percentage from
     * HystrixCommandMetrics.getHealthCounts(). The circuitBreakerForceOpen()
     * property takes precedence so if it set to true this property does
     * nothing.
     */
    private Boolean circuitBreakerForceClosed = true;
    /**
     * If true the HystrixCircuitBreaker.allowRequest() will always return false
     * causing the circuit to be open (tripped) and reject all requests. This
     * property takes precedence over circuitBreakerForceClosed();
     */
    private Boolean circuitBreakerForceOpen = false;
    /**
     * Minimum number of requests in the
     * metricsRollingStatisticalWindowInMilliseconds() that must exist before
     * the HystrixCircuitBreaker will trip. If below this number the circuit
     * will not trip regardless of error percentage.
     */
    private Integer circuitBreakerRequestVolumeThreshold = 20;
    /**
     * The time in milliseconds after a HystrixCircuitBreaker trips open that it
     * should wait before trying requests again.
     */
    private Integer circuitBreakerSleepWindowInMilliseconds = 5000;
    /**
     * Number of concurrent requests permitted to HystrixCommand.run(). Requests
     * beyond the concurrent limit will be rejected. Applicable only when
     * executionIsolationStrategy == SEMAPHORE.
     */
    private Integer executionIsolationSemaphoreMaxConcurrentRequests = 20;
    /**
     * What isolation strategy HystrixCommand.run() will be executed with. If
     * THREAD then it will be executed on a separate thread and concurrent
     * requests limited by the number of threads in the thread-pool. If
     * SEMAPHORE then it will be executed on the calling thread and concurrent
     * requests limited by the semaphore count.
     */
    private String executionIsolationStrategy = "THREAD";
    /**
     * Whether the execution thread should attempt an interrupt (using link
     * Futurecancel) when a thread times out. Applicable only when
     * executionIsolationStrategy() == THREAD.
     */
    private Boolean executionIsolationThreadInterruptOnTimeout = true;
    /**
     * Time in milliseconds at which point the command will timeout and halt
     * execution. If link executionIsolationThreadInterruptOnTimeout == true and
     * the command is thread-isolated the executing thread will be interrupted.
     * If the command is semaphore-isolated and a HystrixObservableCommand that
     * command will get unsubscribed.
     */
    private Integer executionTimeoutInMilliseconds = 1000;
    /**
     * Whether the timeout mechanism is enabled for this command
     */
    private Boolean executionTimeoutEnabled = true;
    /**
     * Number of concurrent requests permitted to HystrixCommand.getFallback().
     * Requests beyond the concurrent limit will fail-fast and not attempt
     * retrieving a fallback.
     */
    private Integer fallbackIsolationSemaphoreMaxConcurrentRequests = 10;
    /**
     * Whether HystrixCommand.getFallback() should be attempted when failure
     * occurs.
     */
    private Boolean fallbackEnabled = true;
    /**
     * Time in milliseconds to wait between allowing health snapshots to be
     * taken that calculate success and error percentages and affect
     * HystrixCircuitBreaker.isOpen() status. On high-volume circuits the
     * continual calculation of error percentage can become CPU intensive thus
     * this controls how often it is calculated.
     */
    private Integer metricsHealthSnapshotIntervalInMilliseconds = 500;
    /**
     * Maximum number of values stored in each bucket of the rolling percentile.
     * This is passed into HystrixRollingPercentile inside
     * HystrixCommandMetrics.
     */
    private Integer metricsRollingPercentileBucketSize = 10;
    /**
     * Whether percentile metrics should be captured using
     * HystrixRollingPercentile inside HystrixCommandMetrics.
     */
    private Boolean metricsRollingPercentileEnabled = true;
    /**
     * Duration of percentile rolling window in milliseconds. This is passed
     * into HystrixRollingPercentile inside HystrixCommandMetrics.
     */
    private Integer metricsRollingPercentileWindowInMilliseconds = 10000;
    /**
     * Number of buckets the rolling percentile window is broken into. This is
     * passed into HystrixRollingPercentile inside HystrixCommandMetrics.
     */
    private Integer metricsRollingPercentileWindowBuckets = 6;
    /**
     * This property sets the duration of the statistical rolling window in
     * milliseconds. This is how long metrics are kept for the thread pool. The
     * window is divided into buckets and rolls by those increments.
     */
    private Integer metricsRollingStatisticalWindowInMilliseconds = 10000;
    /**
     * Number of buckets the rolling statistical window is broken into. This is
     * passed into HystrixRollingNumber inside HystrixCommandMetrics.
     */
    private Integer metricsRollingStatisticalWindowBuckets = 10;
    /**
     * Whether HystrixCommand execution and events should be logged to
     * HystrixRequestLog.
     */
    private Boolean requestLogEnabled = true;
    /**
     * Core thread-pool size that gets passed to link
     * java.util.concurrent.ThreadPoolExecutorsetCorePoolSize(int)
     */
    private Integer corePoolSize = 10;
    /**
     * Maximum thread-pool size that gets passed to link
     * ThreadPoolExecutorsetMaximumPoolSize(int). This is the maximum amount of
     * concurrency that can be supported without starting to reject
     * HystrixCommands. Please note that this setting only takes effect if you
     * also set allowMaximumSizeToDivergeFromCoreSize
     */
    private Integer maximumSize = 10;
    /**
     * Keep-alive time in minutes that gets passed to link
     * ThreadPoolExecutorsetKeepAliveTime(long TimeUnit)
     */
    private Integer keepAliveTime = 1;
    /**
     * Max queue size that gets passed to BlockingQueue in
     * HystrixConcurrencyStrategy.getBlockingQueue(int) This should only affect
     * the instantiation of a threadpool - it is not eliglible to change a queue
     * size on the fly. For that use queueSizeRejectionThreshold().
     */
    private Integer maxQueueSize = -1;
    /**
     * Queue size rejection threshold is an artificial max size at which
     * rejections will occur even if link maxQueueSize has not been reached.
     * This is done because the link maxQueueSize of a BlockingQueue can not be
     * dynamically changed and we want to support dynamically changing the queue
     * size that affects rejections. This is used by HystrixCommand when queuing
     * a thread for execution.
     */
    private Integer queueSizeRejectionThreshold = 5;
    /**
     * Duration of statistical rolling window in milliseconds. This is passed
     * into HystrixRollingNumber inside each HystrixThreadPoolMetrics instance.
     */
    private Integer threadPoolRollingNumberStatisticalWindowInMilliseconds = 10000;
    /**
     * Number of buckets the rolling statistical window is broken into. This is
     * passed into HystrixRollingNumber inside each HystrixThreadPoolMetrics
     * instance.
     */
    private Integer threadPoolRollingNumberStatisticalWindowBuckets = 10;
    /**
     * Allows the configuration for maximumSize to take effect. That value can
     * then be equal to or higher than coreSize
     */
    private Boolean allowMaximumSizeToDivergeFromCoreSize = false;

    public String getGroupKey() {
        return groupKey;
    }

    public void setGroupKey(String groupKey) {
        this.groupKey = groupKey;
    }

    public String getThreadPoolKey() {
        return threadPoolKey;
    }

    public void setThreadPoolKey(String threadPoolKey) {
        this.threadPoolKey = threadPoolKey;
    }

    public Boolean getCircuitBreakerEnabled() {
        return circuitBreakerEnabled;
    }

    public void setCircuitBreakerEnabled(Boolean circuitBreakerEnabled) {
        this.circuitBreakerEnabled = circuitBreakerEnabled;
    }

    public Integer getCircuitBreakerErrorThresholdPercentage() {
        return circuitBreakerErrorThresholdPercentage;
    }

    public void setCircuitBreakerErrorThresholdPercentage(
            Integer circuitBreakerErrorThresholdPercentage) {
        this.circuitBreakerErrorThresholdPercentage = circuitBreakerErrorThresholdPercentage;
    }

    public Boolean getCircuitBreakerForceClosed() {
        return circuitBreakerForceClosed;
    }

    public void setCircuitBreakerForceClosed(Boolean circuitBreakerForceClosed) {
        this.circuitBreakerForceClosed = circuitBreakerForceClosed;
    }

    public Boolean getCircuitBreakerForceOpen() {
        return circuitBreakerForceOpen;
    }

    public void setCircuitBreakerForceOpen(Boolean circuitBreakerForceOpen) {
        this.circuitBreakerForceOpen = circuitBreakerForceOpen;
    }

    public Integer getCircuitBreakerRequestVolumeThreshold() {
        return circuitBreakerRequestVolumeThreshold;
    }

    public void setCircuitBreakerRequestVolumeThreshold(
            Integer circuitBreakerRequestVolumeThreshold) {
        this.circuitBreakerRequestVolumeThreshold = circuitBreakerRequestVolumeThreshold;
    }

    public Integer getCircuitBreakerSleepWindowInMilliseconds() {
        return circuitBreakerSleepWindowInMilliseconds;
    }

    public void setCircuitBreakerSleepWindowInMilliseconds(
            Integer circuitBreakerSleepWindowInMilliseconds) {
        this.circuitBreakerSleepWindowInMilliseconds = circuitBreakerSleepWindowInMilliseconds;
    }

    public Integer getExecutionIsolationSemaphoreMaxConcurrentRequests() {
        return executionIsolationSemaphoreMaxConcurrentRequests;
    }

    public void setExecutionIsolationSemaphoreMaxConcurrentRequests(
            Integer executionIsolationSemaphoreMaxConcurrentRequests) {
        this.executionIsolationSemaphoreMaxConcurrentRequests = executionIsolationSemaphoreMaxConcurrentRequests;
    }

    public String getExecutionIsolationStrategy() {
        return executionIsolationStrategy;
    }

    public void setExecutionIsolationStrategy(String executionIsolationStrategy) {
        this.executionIsolationStrategy = executionIsolationStrategy;
    }

    public Boolean getExecutionIsolationThreadInterruptOnTimeout() {
        return executionIsolationThreadInterruptOnTimeout;
    }

    public void setExecutionIsolationThreadInterruptOnTimeout(
            Boolean executionIsolationThreadInterruptOnTimeout) {
        this.executionIsolationThreadInterruptOnTimeout = executionIsolationThreadInterruptOnTimeout;
    }

    public Integer getExecutionTimeoutInMilliseconds() {
        return executionTimeoutInMilliseconds;
    }

    public void setExecutionTimeoutInMilliseconds(
            Integer executionTimeoutInMilliseconds) {
        this.executionTimeoutInMilliseconds = executionTimeoutInMilliseconds;
    }

    public Boolean getExecutionTimeoutEnabled() {
        return executionTimeoutEnabled;
    }

    public void setExecutionTimeoutEnabled(Boolean executionTimeoutEnabled) {
        this.executionTimeoutEnabled = executionTimeoutEnabled;
    }

    public Integer getFallbackIsolationSemaphoreMaxConcurrentRequests() {
        return fallbackIsolationSemaphoreMaxConcurrentRequests;
    }

    public void setFallbackIsolationSemaphoreMaxConcurrentRequests(
            Integer fallbackIsolationSemaphoreMaxConcurrentRequests) {
        this.fallbackIsolationSemaphoreMaxConcurrentRequests = fallbackIsolationSemaphoreMaxConcurrentRequests;
    }

    public Boolean getFallbackEnabled() {
        return fallbackEnabled;
    }

    public void setFallbackEnabled(Boolean fallbackEnabled) {
        this.fallbackEnabled = fallbackEnabled;
    }

    public Integer getMetricsHealthSnapshotIntervalInMilliseconds() {
        return metricsHealthSnapshotIntervalInMilliseconds;
    }

    public void setMetricsHealthSnapshotIntervalInMilliseconds(
            Integer metricsHealthSnapshotIntervalInMilliseconds) {
        this.metricsHealthSnapshotIntervalInMilliseconds = metricsHealthSnapshotIntervalInMilliseconds;
    }

    public Integer getMetricsRollingPercentileBucketSize() {
        return metricsRollingPercentileBucketSize;
    }

    public void setMetricsRollingPercentileBucketSize(
            Integer metricsRollingPercentileBucketSize) {
        this.metricsRollingPercentileBucketSize = metricsRollingPercentileBucketSize;
    }

    public Boolean getMetricsRollingPercentileEnabled() {
        return metricsRollingPercentileEnabled;
    }

    public void setMetricsRollingPercentileEnabled(
            Boolean metricsRollingPercentileEnabled) {
        this.metricsRollingPercentileEnabled = metricsRollingPercentileEnabled;
    }

    public Integer getMetricsRollingPercentileWindowInMilliseconds() {
        return metricsRollingPercentileWindowInMilliseconds;
    }

    public void setMetricsRollingPercentileWindowInMilliseconds(
            Integer metricsRollingPercentileWindowInMilliseconds) {
        this.metricsRollingPercentileWindowInMilliseconds = metricsRollingPercentileWindowInMilliseconds;
    }

    public Integer getMetricsRollingPercentileWindowBuckets() {
        return metricsRollingPercentileWindowBuckets;
    }

    public void setMetricsRollingPercentileWindowBuckets(
            Integer metricsRollingPercentileWindowBuckets) {
        this.metricsRollingPercentileWindowBuckets = metricsRollingPercentileWindowBuckets;
    }

    public Integer getMetricsRollingStatisticalWindowInMilliseconds() {
        return metricsRollingStatisticalWindowInMilliseconds;
    }

    public void setMetricsRollingStatisticalWindowInMilliseconds(
            Integer metricsRollingStatisticalWindowInMilliseconds) {
        this.metricsRollingStatisticalWindowInMilliseconds = metricsRollingStatisticalWindowInMilliseconds;
    }

    public Integer getMetricsRollingStatisticalWindowBuckets() {
        return metricsRollingStatisticalWindowBuckets;
    }

    public void setMetricsRollingStatisticalWindowBuckets(
            Integer metricsRollingStatisticalWindowBuckets) {
        this.metricsRollingStatisticalWindowBuckets = metricsRollingStatisticalWindowBuckets;
    }

    public Boolean getRequestLogEnabled() {
        return requestLogEnabled;
    }

    public void setRequestLogEnabled(Boolean requestLogEnabled) {
        this.requestLogEnabled = requestLogEnabled;
    }

    public Integer getCorePoolSize() {
        return corePoolSize;
    }

    public void setCorePoolSize(Integer corePoolSize) {
        this.corePoolSize = corePoolSize;
    }

    public Integer getMaximumSize() {
        return maximumSize;
    }

    public void setMaximumSize(Integer maximumSize) {
        this.maximumSize = maximumSize;
    }

    public Integer getKeepAliveTime() {
        return keepAliveTime;
    }

    public void setKeepAliveTime(Integer keepAliveTime) {
        this.keepAliveTime = keepAliveTime;
    }

    public Integer getMaxQueueSize() {
        return maxQueueSize;
    }

    public void setMaxQueueSize(Integer maxQueueSize) {
        this.maxQueueSize = maxQueueSize;
    }

    public Integer getQueueSizeRejectionThreshold() {
        return queueSizeRejectionThreshold;
    }

    public void setQueueSizeRejectionThreshold(
            Integer queueSizeRejectionThreshold) {
        this.queueSizeRejectionThreshold = queueSizeRejectionThreshold;
    }

    public Integer getThreadPoolRollingNumberStatisticalWindowInMilliseconds() {
        return threadPoolRollingNumberStatisticalWindowInMilliseconds;
    }

    public void setThreadPoolRollingNumberStatisticalWindowInMilliseconds(
            Integer threadPoolRollingNumberStatisticalWindowInMilliseconds) {
        this.threadPoolRollingNumberStatisticalWindowInMilliseconds = threadPoolRollingNumberStatisticalWindowInMilliseconds;
    }

    public Integer getThreadPoolRollingNumberStatisticalWindowBuckets() {
        return threadPoolRollingNumberStatisticalWindowBuckets;
    }

    public void setThreadPoolRollingNumberStatisticalWindowBuckets(
            Integer threadPoolRollingNumberStatisticalWindowBuckets) {
        this.threadPoolRollingNumberStatisticalWindowBuckets = threadPoolRollingNumberStatisticalWindowBuckets;
    }

    public Boolean getAllowMaximumSizeToDivergeFromCoreSize() {
        return allowMaximumSizeToDivergeFromCoreSize;
    }

    public void setAllowMaximumSizeToDivergeFromCoreSize(
            Boolean allowMaximumSizeToDivergeFromCoreSize) {
        this.allowMaximumSizeToDivergeFromCoreSize = allowMaximumSizeToDivergeFromCoreSize;
    }
}