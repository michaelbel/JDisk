/*
 * Лицензионное соглашение на использование набора средств разработки
 * «SDK Яндекс.Диска» доступно по адресу: http://legal.yandex.ru/sdk_agreement
 */

package com.yandex.disk.sdk.exceptions;

public class RangeNotSatisfiableException extends WebdavException {

    public RangeNotSatisfiableException(String msg) {
        super(msg);
    }
}