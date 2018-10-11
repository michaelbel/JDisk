/*
 * (C) 2015 Yandex LLC (https://yandex.com/)
 *
 * The source code of Java SDK for Yandex.Disk REST API
 * is available to use under terms of Apache License,
 * Version 2.0. See the file LICENSE for the details.
 */

package org.michaelbel.jdisk.rest.json;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import androidx.annotation.NonNull;

/**
 * @see <p>API reference <a href="http://api.yandex.com/disk/api/reference/response-objects.xml#resourcelist">english</a>,
 * <a href="https://tech.yandex.ru/disk/api/reference/response-objects-docpage/#resourcelist">russian</a></p>
 *
 * Список ресурсов, содержащихся в папке. Содержит объекты {@link Resource} и свойства списка.
 */
@SuppressWarnings("all")
public class ResourceList {

    /**
     * Поле, по которому отсортирован список.
     */
    @SerializedName("sort")
    public String sort;

    /**
     * Ключ опубликованной папки, в которой содержатся ресурсы из данного списка.
     */
    @SerializedName("public_key")
    public String publicKey;

    /**
     * Массив ресурсов {@link Resource}, содержащихся в папке.
     * Вне зависимости от запрошенной сортировки, ресурсы в массиве упорядочены по их виду:
     * сначала перечисляются все вложенные папки, затем — вложенные файлы.
     */
    @SerializedName("items")
    public List<Resource> resources;

    /**
     * Путь к папке, чье содержимое описывается в данном объекте {@link ResourceList}.
     * Для публичной папки значение атрибута всегда равно «/».
     */
    @SerializedName("path")
    public String path;

    /**
     * Максимальное количество элементов в массиве {@link resources}, заданное в запросе.
     */
    @SerializedName("limit")
    public int limit;

    /**
     * Смещение начала списка от первого ресурса в папке.
     */
    @SerializedName("offset")
    public int offset;

    /**
     * Общее количество ресурсов в папке.
     */
    @SerializedName("total")
    public int total;

    @NonNull
    @Override
    public String toString() {
        return "ResourceList {" +
                "sort = '" + sort + '\'' +
                ", publicKey = '" + publicKey + '\'' +
                ", items = " + resources +
                ", path = '" + path + '\'' +
                ", limit = " + limit +
                ", offset = " + offset +
                ", total = " + total +
                '}';
    }
}