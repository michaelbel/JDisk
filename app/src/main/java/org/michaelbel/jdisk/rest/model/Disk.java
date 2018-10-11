package org.michaelbel.jdisk.rest.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Disk {

    @SerializedName("trash_size")
    public int trashSize;

    @SerializedName("total_space")
    public int totalSpace;

    @SerializedName("used_space")
    public int usedSpace;

    @SerializedName("system_folders")
    public List<String> systemFolders;
}