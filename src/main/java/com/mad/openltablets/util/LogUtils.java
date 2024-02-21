package com.mad.openltablets.util;


import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.apache.logging.log4j.Level;
import org.slf4j.MDC;

/**
 * Description : This class {@link LogUtils} use for logging It is expected that logging takes place
 * through centralized logging.
 *
 * <h3>Typical usage pattern:</h3>
 *
 * <pre>
 *       LogUtils.INFO(this.getClass(), "methodName", "This is sample log message");
 *   </pre>
 */
@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LogUtils {

    private static final int MAX_LOG_TAG_LENGTH = 500;

    /**
     * Gets the Level associated with the Logger.
     *
     * @return the Level associate with the Logger.
     */
    public static Level getLevel() {
        if (isTraceEnabled()) return Level.TRACE;
        if (isDebugEnabled()) return Level.DEBUG;
        if (isInfoEnabled()) return Level.INFO;
        if (isWarnEnabled()) return Level.WARN;
        if (isErrorEnabled()) return Level.ERROR;
        return Level.OFF;
    }

    /**
     * Is the logger instance enabled for the TRACE level?
     *
     * @return True if this Logger is enabled for the TRACE level, false otherwise.
     */
    public static boolean isTraceEnabled() {
        return log.isTraceEnabled();
    }

    /**
     * Is the logger instance enabled for the DEBUG level?
     *
     * @return True if this Logger is enabled for the DEBUG level, false otherwise.
     */
    public static boolean isDebugEnabled() {
        return log.isDebugEnabled();
    }

    /**
     * Is the logger instance enabled for the INFO level?
     *
     * @return True if this Logger is enabled for the INFO level, false otherwise.
     */
    public static boolean isInfoEnabled() {
        return log.isInfoEnabled();
    }

    /**
     * Is the logger instance enabled for the WARN level?
     *
     * @return True if this Logger is enabled for the WARN level, false otherwise.
     */
    public static boolean isWarnEnabled() {
        return log.isWarnEnabled();
    }

    /**
     * Is the logger instance enabled for the ERROR level?
     *
     * @return True if this Logger is enabled for the ERROR level, false otherwise.
     */
    public static boolean isErrorEnabled() {
        return log.isErrorEnabled();
    }

    /**
     * Log a message at the DEBUG level.
     *
     * @param cls the cls
     * @param methodName the method name
     * @param message the message string to be logged
     */
    public static void DEBUG(final Class<?> cls, final String methodName, String message) {
        final var tag = makeLogTag(cls, methodName, "{}");
        log.debug(tag, message);
    }

    /**
     * Don't use this when obfuscating class names! @param cls the cls
     *
     * @param cls the cls
     * @param methodName the method name
     * @param amendments the amendments
     * @return the string
     */
    protected static String makeLogTag(Class<?> cls, String methodName, String amendments) {
        return makeLogTag(cls.getCanonicalName(), methodName, amendments);
    }

    /**
     * Make log tag string.
     *
     * @param canonicalName the canonical name
     * @param methodName the method name
     * @param amendments the amendments
     * @return the string
     */
    public static String makeLogTag(String canonicalName, String methodName, String amendments) {
        val format = canonicalName + "." + methodName + "() " + amendments;
        return format.length() > MAX_LOG_TAG_LENGTH
                ? canonicalName.substring(0, MAX_LOG_TAG_LENGTH - 1)
                : format;
    }

    /**
     * Log a message at the DEBUG level according to the specified format and argument..
     *
     * @param cls the cls
     * @param methodName the method name
     * @param message the message string to be logged
     * @param cause the cause
     */
    public static void DEBUG(
            final Class<?> cls, final String methodName, String message, Throwable cause) {
        final var tag = makeLogTag(cls, methodName, "{}{}");
        log.debug(tag, message, cause);
    }

    /**
     * Log a message at the TRACE level.
     *
     * @param cls the cls
     * @param methodName the method name
     * @param message the message string to be logged
     */
    public static void TRACE(final Class<?> cls, final String methodName, String message) {
        final var tag = makeLogTag(cls, methodName, "{}");
        log.trace(tag, message);
    }

    /**
     * Log a message at the TRACE level according to the specified format and argument.
     *
     * @param cls the cls
     * @param methodName the method name
     * @param message the message string to be logged
     * @param cause the cause
     */
    public static void TRACE(
            final Class<?> cls, final String methodName, String message, Throwable cause) {
        final var tag = makeLogTag(cls, methodName, "{}{}");
        log.trace(tag, message, cause);
    }

    /**
     * Log a message at the INFO level.
     *
     * @param cls the cls
     * @param methodName the method name
     * @param message the message string to be logged
     */
    public static void INFO(final Class<?> cls, final String methodName, String message) {
        final var tag = makeLogTag(cls, methodName, "{}");
        log.info(tag, message);
    }

    /**
     * Log a message at the INFO level according to the specified format and argument.
     *
     * @param cls the cls
     * @param methodName the method name
     * @param message the message string to be logged
     * @param cause the cause
     */
    public static void INFO(
            final Class<?> cls, final String methodName, String message, Throwable cause) {
        final var tag = makeLogTag(cls, methodName, "{}{}");
        log.info(tag, message, cause);
    }

    /**
     * Log a message at the WARN level.
     *
     * @param cls the cls
     * @param methodName the method name
     * @param message the message string to be logged
     */
    public static void WARN(final Class<?> cls, final String methodName, String message) {
        final var tag = makeLogTag(cls, methodName, "{}");
        log.warn(tag, message);
    }

    /**
     * Log a message at the WARN level according to the specified format and argument.
     *
     * @param cls the cls
     * @param methodName the method name
     * @param message the message string to be logged
     * @param cause the cause
     */
    public static void WARN(
            final Class<?> cls, final String methodName, String message, Throwable cause) {
        final var tag = makeLogTag(cls, methodName, "{}{}");
        log.warn(tag, message, cause);
    }

    /**
     * Log a message at the ERROR level.
     *
     * @param cls the cls
     * @param methodName the method name
     * @param message the message string to be logged
     */
    public static void ERROR(final Class<?> cls, final String methodName, String message) {
        final var tag = makeLogTag(cls, methodName, "{}");
        log.error(tag, message);
    }

    /**
     * Log a message at the ERROR level according to the specified format and arguments.
     *
     * @param cls the cls
     * @param methodName the method name
     * @param message the message string to be logged
     * @param cause the cause
     */
    public static void ERROR(
            final Class<?> cls, final String methodName, String message, Throwable cause) {
        final var tag = makeLogTag(cls, methodName, "{}{}");
        log.error(tag, message, cause);
    }

    /**
     * Set [Organization][Department][User] by MDC
     *
     * @param organizationCode organization code
     * @param departmentCode department code
     * @param userName user name
     * @param details details
     */
    public static void setUserMDC(
            String organizationCode, String departmentCode, String userName, String details) {

        String stringBuilder = "[organizationCode:%s][departmentCode:%s][userName:%s]".formatted(organizationCode, departmentCode, userName);

        MDC.put("mdc_key", stringBuilder);
        log.info(details);
    }
}
