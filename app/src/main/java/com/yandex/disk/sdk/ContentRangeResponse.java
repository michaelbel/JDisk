/*
 * Лицензионное соглашение на использование набора средств разработки
 * «SDK Яндекс.Диска» доступно по адресу: http://legal.yandex.ru/sdk_agreement
 */

package com.yandex.disk.sdk;

public class ContentRangeResponse {

    private final long start, size;

    public ContentRangeResponse(long start, long size) {
        this.start = start;
        this.size = size;
    }

    public long getStart() {
        return start;
    }

    public long getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "ContentRangeResponse{"+
                "start="+start+
                ", size="+size+
                '}';
    }
}