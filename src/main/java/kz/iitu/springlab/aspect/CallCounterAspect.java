package kz.iitu.springlab.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Aspect
@Component
public class CallCounterAspect {

    private final Map<String, Long> methodCallCounts = new ConcurrentHashMap<>();

    @Before("kz.iitu.springlab.aspect.Pointcuts.serviceOperation()")
    public void countCall(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().toShortString();
        methodCallCounts.merge(methodName, 1L, Long::sum);
    }

    public Map<String, Long> getStatistics() {
        return Collections.unmodifiableMap(methodCallCounts);
    }
}