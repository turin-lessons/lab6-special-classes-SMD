package org.example.task12

class DiskFull(val freeMb: Int) :
    IoError("Disk full, only $freeMb MB free")