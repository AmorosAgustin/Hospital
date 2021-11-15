package com.solvd.hospital.model.EquipmentAndMachinery;

import com.solvd.hospital.model.Exception.MachineryBrokenException;

public interface Usable {
    public void use() throws MachineryBrokenException;
    public void stopUsing() throws MachineryBrokenException;

}
