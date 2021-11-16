package com.solvd.hospital.model.equipmentAndMachinery;

import com.solvd.hospital.model.exception.MachineryBrokenException;

public interface Usable {
    public void use() throws MachineryBrokenException;
    public void stopUsing() throws MachineryBrokenException;

}
